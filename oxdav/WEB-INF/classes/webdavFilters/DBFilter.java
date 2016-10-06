package webdavFilters;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.tidy.Tidy;
import org.w3c.tidy.OutImpl;
import org.w3c.tidy.Configuration;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.dom.DOMResult;
          
import java.sql.*;

public class DBFilter implements Filter {
  private boolean trace=true;
  private ServletContext ctx;
  private String srcPrefix,targetPrefix,localRefPrefix=null;
  private final String oxdav="oxdav"; // name as webapp.
  private String xslUri;
  protected boolean debugging=true;
  Connection conn=null;
  Statement stmt=null;
  PreparedStatement addTopicPS=null;
  PreparedStatement addPartPS=null;

public void setConnection()throws Exception{
  Class.forName("com.mysql.jdbc.Driver").newInstance();
  conn = DriverManager.getConnection(
		"jdbc:mysql://localhost/wsbkdb?user=tjm&password=tjm");  
  stmt=conn.createStatement();
  addTopicPS=conn.prepareStatement("INSERT INTO topics VALUES(?,?,?)");
  addPartPS=conn.prepareStatement("INSERT INTO parts VALUES(?,?,?)");
}
public void addDocTopic(String topicID, String header,String fullValue){
  if(trace)ctx.log("addDocTopic('"+topicID+"','"+header+"')");
  try{
   addTopicPS.setString(1,topicID);
   addTopicPS.setString(2,header);
   addTopicPS.setString(3,fullValue);
   addTopicPS.executeUpdate();
  }catch(Exception ex){ctx.log("insert of "+topicID+" failed",ex);}
}

public void addTopicPart(String topicID,String partType,String value){
  if(trace)ctx.log("addTopicPart('"+topicID+"','"+partType+"','"+value+"')");
  try{
   addPartPS.setString(1,topicID);
   addPartPS.setString(2,partType);
   addPartPS.setString(3,value);
   addPartPS.executeUpdate();
  }catch(Exception ex){ctx.log("insert failed",ex);}
}

public void closeConnection(){
  try{if(stmt!=null)stmt.close();}catch(Exception ex){}
  stmt=null;
  try{if(addTopicPS!=null)addTopicPS.close();}catch(Exception ex){}
  addTopicPS=null;
  try{if(addPartPS!=null)addPartPS.close();}catch(Exception ex){}
  addPartPS=null;
  try{if(conn!=null)conn.close();}catch(Exception ex){}
  conn=null;
}
public void init(FilterConfig filterConfig)throws ServletException{
  try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
}catch(Exception ex){ex.printStackTrace();}

  ctx=filterConfig.getServletContext();
  srcPrefix = filterConfig.getInitParameter("srcPrefix"); 
  targetPrefix = filterConfig.getInitParameter("targetPrefix"); 
  xslUri=ctx.getRealPath(filterConfig.getInitParameter("xslUri"));
  if(debugging)ctx.log("Filter "+filterConfig.getFilterName()+
        ";\n map webapps/"+srcPrefix+"\n to "+ctx.getRealPath(targetPrefix)+
        "\n with "+xslUri);
}

public static String httpReqLine(HttpServletRequest req){
  StringBuffer ret = req.getRequestURL();
  String query = req.getQueryString();
  if(query != null) ret.append("?").append(query);
  return ret.toString();
}

public void doFilter(javax.servlet.ServletRequest servletRequest,
          javax.servlet.ServletResponse servletResponse,
          javax.servlet.FilterChain filterChain)
  throws java.io.IOException, javax.servlet.ServletException {
  try{setConnection();}
  catch(Exception ex){
    ctx.log("doFilter: ",ex);
    throw new javax.servlet.ServletException(ex);
   }
  HttpServletRequest hsr=(HttpServletRequest)servletRequest;
if(localRefPrefix==null){
   localRefPrefix=hsr.getRequestURL().toString();
   int oxdavLoc=localRefPrefix.indexOf(oxdav);
   localRefPrefix=localRefPrefix.substring(0,oxdav.length()+oxdavLoc);
ctx.log("localRefPrefix set to "+localRefPrefix);
   }
  String strReq=httpReqLine(hsr)+" "+hsr.getMethod();
  if(debugging)ctx.log("Accessing filter for "+strReq);
  filterChain.doFilter(servletRequest,servletResponse); // just passes it through
  if("PUT".equals(hsr.getMethod().toString())){
     String url=hsr.getRequestURL().toString();
     if(url.endsWith(".htm") || url.endsWith(".html")){
       int prefixLoc=url.lastIndexOf(srcPrefix);
       if(prefixLoc >= 0){
         url=url.substring(prefixLoc+srcPrefix.length());
         if(debugging)ctx.log("PUT url="+url);
         cleanUpFile(url,ctx.getRealPath(url),ctx.getRealPath(targetPrefix+url));
         }
       }
    }
  closeConnection();
  if(debugging)ctx.log("Finished with filter for "+strReq);
}

public String cleanUpFile(String url,String srcFileName,String targetFileName){
if(debugging)ctx.log("tidying "+srcFileName+" into "+targetFileName);
try{
  Tidy tidy=new Tidy(); 
  Configuration configuration=tidy.getConfiguration();
  String cfgFile=new File(ctx.getRealPath("TIDY/tidy.cfg")).toString();
if(debugging)ctx.log(cfgFile);

tidy.setMakeClean(true); tidy.setXmlTags(false);
tidy.setConfigurationFromFile(cfgFile);
configuration.adjust();
  Document tidyOut=
  tidy.parseDOM(new FileInputStream(srcFileName),
      new FileOutputStream(new File(ctx.getRealPath("tmp.xml")).toString()));
  transform(tidyOut,xslUri,targetFileName,url);
return "";
}catch(Exception ex){ctx.log("cleanUpFile error: ",ex); return "error: "+ex;}
}

public void destroy(){ ctx.log("Destroying filter..."); }

public void transform(Document doc,String xslUri,
                      String outFileName,String url)
    throws Exception{
  TransformerFactory tFactory = TransformerFactory.newInstance();
  Transformer transformer =
    tFactory.newTransformer(new StreamSource(xslUri));
  Document resultDoc=generateDOMResultDocument();
  transformer.transform(new DOMSource(doc), new DOMResult(resultDoc));
  Transformer serializer = tFactory.newTransformer();
  serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,"yes");
  serializer.setOutputProperty(OutputKeys.METHOD,"text");
  putTopicsInDB(url, resultDoc,serializer);
  serializer.setOutputProperty(OutputKeys.METHOD,"html");
  serializer.transform(new DOMSource(resultDoc),
                       new StreamResult(outFileName));
}

public void putTopicsInDB(String url, Document doc,
                          Transformer serializer)throws Exception{
  stmt.executeUpdate("DELETE FROM topics WHERE topicID LIKE '"+url+"%'");
  stmt.executeUpdate("DELETE FROM parts WHERE topicID LIKE '"+url+"%'");
  Element docElt = doc.getDocumentElement();
  NodeList divs = docElt.getElementsByTagName("div");
  if(divs.getLength()==0){ctx.log("No top-level found in "+url); return;}
  for(int i=0;i<divs.getLength();i++)
    putTopicInDB(url, (Element)(divs.item(i)),serializer);
}
/**
  * putTopicInDB is applied to each div, ignores divs not generated by xslt;
  * associates header ID with header content, looks for anchors and tables
  * within the textCollection span.
**/
protected void putTopicInDB(String url, Element div,
                            Transformer serializer)throws Exception{
  String path=div.getAttribute("id");
  String className=div.getAttribute("class");
  if(path==null || !(path.startsWith("divs")) 
     || className==null || !(className.startsWith("div_")))
     return;
  url+="#"+path.substring(3);
  Element header=firstEltChild(div,null);
  if(header==null)return;
  String hVal=node2String(header,serializer);
  Element textCollection=nextEltSibling(header,null);
  String fullVal=hVal;
  if(textCollection!=null)
    fullVal+="\n"+node2String(textCollection,serializer);
  addDocTopic(url,hVal,fullVal);
  if(textCollection==null)return;
  NodeList anchors=textCollection.getElementsByTagName("a");
  NodeList tables=textCollection.getElementsByTagName("table");
  for(int i=0;i<anchors.getLength();i++)
    putAnchorInDB(url,(Element)anchors.item(i),serializer);
  for(int i=0;i<tables.getLength();i++)
    putTableInDB(url,(Element)tables.item(i),serializer); 
}
/**
  * If the href is #... or it's just a named anchor, we ignore it;
  * if the link is relative, we fix it to be absolute;
  * if it's a link to something local, addTopicPart locallink, else link
**/
protected void putAnchorInDB(String url,Element anchor,
                             Transformer serializer)throws Exception{
  String href=anchor.getAttribute("href");
  if(href==null || href.length()==0 || href.startsWith("#"))return;
  if(!href.startsWith("http"))
    href=fixHref(localRefPrefix+"/"+targetPrefix,url,href,anchor); 
  if(href.startsWith(localRefPrefix))
    addTopicPart(url,"localLink",href);
  else addTopicPart(url,"link",href);
}
/**
  * putTableInDB(url,tableElt,trans) checks that tableElt is a
  * 2-column table with headers Name,Value;  
  * if it is, then addTopicPart(url,name,value) for each row.
**/
protected void putTableInDB(String url,Element tableElt,
                             Transformer trans)throws Exception{
  NodeList rows=tableElt.getElementsByTagName("tr");
  if(rows.getLength()<2) return;
  NodeList headers=rows.item(0).getChildNodes();
  if(headers.getLength()!=2)return;
  String nameHeader=node2String(headers.item(0),trans);
  String valueHeader=node2String(headers.item(1),trans);
  if("Name".equalsIgnoreCase(nameHeader )
     && "Value".equalsIgnoreCase(valueHeader ) )
    for(int i=1;i<rows.getLength();i++){
      Element row=(Element)rows.item(i);
      NodeList def=row.getElementsByTagName("td");
      if(def.getLength()!=2)ctx.log("**ERR: bad def "+i+" in "+node2String(tableElt,trans));
      else addTopicPart(url,node2String(def.item(0),trans),node2String(def.item(1),trans));
    }
}
protected Element firstEltChild(Element elt,String tag){
  if(elt==null) return null;
  else return firstEltSibling(elt.getFirstChild(),tag);
}
protected Element firstEltSibling(Node nd,String tag){
  for(;;){
    if(nd==null)return null;
    else if(!(nd instanceof Element))nd=nd.getNextSibling();
    else if(tag==null || tag.equals(nd.getNodeName()))return (Element)nd;
    else nd=nd.getNextSibling();
    }  
}
protected Element nextEltSibling(Node nd,String tag){
  if(nd==null)return null;
  return firstEltSibling(nd.getNextSibling(),tag);
}

//close stmt, conn.
public String node2String(Node node,Transformer trans)throws Exception{
 try{
  StringWriter sW=new StringWriter();
  trans.transform(new DOMSource(node),new StreamResult(sW));
  return sW.toString();
 }catch(Exception ex){ctx.log("node2String error",ex); return "";}
}

public String fixHref(String prefix,String url,String href,Element anchor){
// should only be called if href is a relative url; we need to replace it
// with an absolute value, based on the prefix and url values.
if(trace)ctx.log("fixHref('"+prefix+"','"+url+"','"+href+"',...)");
  href=href.replace('\\','/');
  href=absoluteUrl(prefix,url,href); 
  anchor.setAttribute("href",href);
if(trace)ctx.log("fixHref = "+href);
  return href;
}
public String absoluteUrl(String prefix,String url,String href){
  if(href.startsWith("/"))return prefix+href;
  if(!prefix.endsWith("/"))prefix+="/";
  if(url.startsWith("/"))url=url.substring(1);
  url=dropLast(url,"#");
  prefix=dropLast(prefix+url,"/");
  while(href.startsWith("."))
    if(href.startsWith("../")){
      prefix=dropLast(prefix,"/");
      href=href.substring(3);
     }else if (href.startsWith("./"))href=href.substring(2);
  return prefix+"/"+href;
}
public String dropLast(String prefix,String marker){
  int n=prefix.lastIndexOf(marker);
  if(n<0)return prefix;
  return prefix.substring(0,n);
}


public static Document generateDOMResultDocument()throws Exception{
      DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
      dfactory.setNamespaceAware(true);
      DocumentBuilder docBuilder = dfactory.newDocumentBuilder();
      Document outNode = docBuilder.newDocument();
      return outNode;
}


public static void main(String[]args){

}



/*
 stmt.executeUpdate(
     "INSERT INTO topics VALUES('About',NULL,'Assoc',NULL,'ref','http://localhost:8080/openXML/defs#About')");
// stmt.executeUpdate(
//     "INSERT INTO parts VALUES('About','Course','Subject')");

 stmt.executeUpdate(
     "INSERT INTO topics VALUES('Anthropology',NULL,'Subject',NULL,NULL,NULL)");
 stmt.executeUpdate(
     "INSERT INTO topics VALUES('PhysicalAnthropology',NULL,'Subject',NULL,NULL,NULL)");
 stmt.executeUpdate(
     "INSERT INTO topics VALUES('CulturalAnthropology',NULL,'Subject',NULL,NULL,NULL)");
 stmt.executeUpdate(
     "INSERT INTO topics VALUES('IsSubClass',NULL,'Assoc',NULL,'ref','http://localhost:8080/openXML/defs#IsSubClass')");
 stmt.executeUpdate(
     "INSERT INTO topics VALUES('pi',NULL,'Number',NULL,'value','3.14159...')");
 stmt.executeUpdate(
     "INSERT INTO associations VALUES('IsSubClass','PhysicalAnthropology','Anthropology')");


*/
}
  
