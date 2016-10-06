package soapUtil;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;

import java.io.Reader;
import java.io.StringWriter;
import java.io.InputStreamReader;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.beans.XMLDecoder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

import org.apache.catalina.util.Base64; // from Tomcat distribution

public class DBAuthService {
/**
  * (1) DBAuthService accepts socket connections, reads HTTP SOAP off them,
  * interprets the results as database queries, and sends the answers
  * back down the socket. It is a bean built by an XMLDecoder.
  * (2) As an extension, it can be used for REST actions: GET,PUT,DELETE.
  * (3) As a further extension, GET can be used to invoke actions; see text.
**/
protected ServerSocket serverSocket=null;

protected String dbURL="jdbc:odbc:wsbkdb";
  public void setDbURL(String S){dbURL=S;}
  public String getDbURL(){return dbURL;}
protected String dbDriver="sun.jdbc.odbc.JdbcOdbcDriver";
  public void setDbDriver(String S){dbDriver=S;}
  public String getDbDriver(){return dbDriver;}
protected String dbUser="";
  public void setDbUser(String S){dbUser=S;}
  public String getDbUser(){return dbUser;}
protected String dbPwd="";
 public void setDbPwd(String S){dbPwd=S;}
 public String getDbPwd(){return dbPwd;}

protected String readRequestURL="ok"; // if non-null, GET may invoke actions.
 public void setReadRequestURL(String S){readRequestURL=S;}
 public String getReadRequestURL(){return readRequestURL;}

protected Properties userPwd=new Properties();
protected Properties userGroup=new Properties();
public void addAuthorization(String userID,String pwd,String group){
  if(userID==null)return;
  userPwd.setProperty(userID,pwd);
  userGroup.setProperty(userID,group);
}

/**
  * SimpleDateFormat simpleDateFormat "yyyy-MM-dd HH:mm:ss" for database dates
  * SimpleDateFormat rfc1123DateFormat "EEE, d MMM y k:m:s 'GMT'"; 
  *    e.g. Fri, 24 Nov 2000 15:48:31 GMT
  *    for HTTP dates. These can be overridden in the configuration file.
**/

protected String simpleDateFormatString="yyyy-MM-dd HH:mm:ss";
protected SimpleDateFormat simpleDateFormat=null;

  public void setSimpleDateFormat(String S){
    simpleDateFormatString=S;
    simpleDateFormat=null;
  }
  public SimpleDateFormat getSimpleDateFormat(){
    if(simpleDateFormat==null){
      simpleDateFormat=new SimpleDateFormat(simpleDateFormatString);
      simpleDateFormat.setTimeZone(new java.util.SimpleTimeZone(0,"GMT")); 
      }
    return simpleDateFormat;
  }

protected String rfc1123DateFormatString="EEE, d MMM y k:m:s 'GMT'";
protected SimpleDateFormat rfc1123DateFormat=null;

  public void setRfc1123DateFormat(String S){
    rfc1123DateFormatString=S;
    rfc1123DateFormat=null;
  }
  public SimpleDateFormat getRfc1123DateFormat(){
    if(rfc1123DateFormat==null){
      rfc1123DateFormat=new SimpleDateFormat(rfc1123DateFormatString);
      rfc1123DateFormat.setTimeZone(new java.util.SimpleTimeZone(0,"GMT")); 
      }
    return rfc1123DateFormat;
  }


DocumentBuilderFactory dbf=null;
  public DocumentBuilderFactory getDBF(){
    if(dbf!=null)return dbf;
    dbf=DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);
    dbf.setValidating(false);
    return dbf;
  }

/**
  * Default constructor
 */
public DBAuthService(){}

protected Hashtable queryHashtable=new Hashtable();

/******* DATABASE FUNCTIONALITY SECTION **********/

/**
  * getDBConnection() may make a database connection or get from pool
 */
protected Connection getDBConnection()throws Exception{
  Class.forName(getDbDriver());
  return DriverManager.getConnection(getDbURL(),getDbUser(),getDbPwd());
}

/**
  * freeDBConnection() may return a connection to a pool; may do nothing
 */
protected void freeDBConnection(Connection con){
}

/**
  * doSQL([cmd,param1,param2,..paramN], Hashtable, out) finds the PreparedStatement
  * and types corresponding to cmd, fills in the params, writes res to out
 */
protected void doSQL(ArrayList nameParams,Hashtable ht,PrintWriter out)
   throws Exception{
  PreparedStatement pS=null;
  String qName=((String)nameParams.get(0)).toUpperCase();
  DBAuthQueryData dbqd=(DBAuthQueryData)queryHashtable.get(qName);
  if(dbqd==null)throw new Exception("ERR NO SUCH QUERY AS "+qName+"");
  String qAuth=dbqd.getQAuth();
  String userGroup=(String)ht.get("userGroup");
  if("admin".equals(qAuth) && !"admin".equals(userGroup))
    throw new Exception("Authorization: admin privileges needed for "+qName);
  if("member".equals(qAuth) && (null==userGroup || userGroup.length()==0))
    throw new Exception("Authorization: member privileges needed for "+qName);
  String[]qTypes=dbqd.getQTypeArray();
  String[]qVals=dbqd.getQValArray();
  int paramCount=dbqd.getParamCount();
  if(paramCount!=nameParams.size()-1)
    throw new Exception("Query ["+qName+"] expects "+paramCount+
                        " params, not "+(nameParams.size()-1));
  Connection con=getDBConnection();
  try{
    pS=con.prepareStatement(dbqd.getQStr());
    int i=0; int j=0;
    for(;i<qTypes.length;i++){
      String val=qVals[i];
      if(val.equals("")){j++; val=(String)nameParams.get(j);}
      else { // fill in value from hashtable and nameParams.
        java.util.StringTokenizer st=new java.util.StringTokenizer(val,"+");
        StringBuffer sB=new StringBuffer();
        for(; st.hasMoreTokens();){
           String label=st.nextToken();
           if(label.startsWith("$")){
             int N=Integer.parseInt(label.substring(1));
             sB.append((String)nameParams.get(N));
           }else {
             String valPart=(String)ht.get(label);
             if(valPart==null)
                sB.append(label);
             else sB.append(valPart);
           }
        }
        val=sB.toString();
      }
      setParamStr(pS,i+1,val,qTypes[i]);
      }
    if(pS.execute()) writeResultSet(pS.getResultSet(),out);
    else writeResultCount(pS.getUpdateCount(),out);
  } catch(Exception ex){
    throw new Exception("ERR doSQL("+qName+","+ex+")\n");}
  finally{
     if(pS!=null)try{pS.close();}catch(Exception ex){}
     pS=null;
    freeDBConnection(con);
   }
}

/**
  * doSQL([cmd,p1,p2..pN]) finds the PreparedStatement and types of cmd,
  * fills them in and returns the result
 */
protected String doSQL(ArrayList nameParams,Hashtable ht)throws Exception{
  StringWriter sW=new StringWriter();
  PrintWriter pW=new PrintWriter(sW,true);
  doSQL(nameParams,ht,pW);
  return sW.toString();
}

/**
  * writeResultCount(count,out) dumps count to out as an XHTML span
 */
protected void writeResultCount(int count,PrintWriter out)throws Exception{
  out.println("<span class='updateCount'>"+count+"</span>\n");
}
/**
  * writeResultSet(res,out) dumps resultset to out as an XHTML table
 */
protected void writeResultSet(ResultSet res,PrintWriter out)throws Exception{
  try{
    out.println("<table border='1'>");
    ResultSetMetaData rsmd=res.getMetaData();
    int colCount=rsmd.getColumnCount();
    out.println("<tr>");
    for(int i=0;i<colCount;i++)
    out.println("<th>"+rsmd.getColumnName(i+1)+"</th>");
    out.println("</tr>\n");
    while(res.next()){
      out.println("<tr>");
      for(int i=0;i<colCount;i++)
        out.println("<td>"+xmlEncode(res.getString(i+1))+"</td>");
      out.println("</tr>\n");
      }
    out.println("</table>\n");
  }finally {
    if(res!=null)try{res.close();}catch(Exception ex){}
  }
}
public static String xmlEncode(String S){
  if(S==null)return S;
  int N=S.length();
  StringBuffer sB=new StringBuffer(N);
  for(int i=0;i<N;i++){
    char c=S.charAt(i);
    if(c=='&')sB.append("&amp;");
    else if(c=='<')sB.append("&lt;");
    else if(c=='>')sB.append("&gt;");
    else if(c=='\'')sB.append("&apos;");
    else if(c=='"')sB.append("&quot;");
    else sB.append(c);
    }
  return sB.toString();
}
public  void setParamStr(PreparedStatement pStmnt, int i,String pVal,String pType)throws Exception{
System.out.println("setParamStr("+i+"="+pVal+":"+pType+")");
    String t=pType;
      try{
    if(t==null || t.length()==0 ||"text".equalsIgnoreCase(t)
     ||"varchar".equalsIgnoreCase(t) || "string".equalsIgnoreCase(t))
      pStmnt.setString(i,pVal);
    else if("longtext".equalsIgnoreCase(t)||"longvarchar".equalsIgnoreCase(t))
      pStmnt.setObject(i,pVal,java.sql.Types.LONGVARCHAR); // allow for MS Access limitations
    else if(t.equalsIgnoreCase("date")){
      java.util.Date d=null;
      try{d=getSimpleDateFormat().parse(pVal);
      }catch(Exception ex){d=getRfc1123DateFormat().parse(pVal);}
      java.sql.Date dbdate=new java.sql.Date(d.getTime());
      pStmnt.setDate(i,dbdate);
      }
    else if( t.equalsIgnoreCase("datetime")
            || t.equalsIgnoreCase("timestamp")){
      java.util.Date d=null;
      try{d=getSimpleDateFormat().parse(pVal);
      }catch(Exception ex){d=getRfc1123DateFormat().parse(pVal);}
      java.sql.Timestamp dbdate=new java.sql.Timestamp(d.getTime());
      pStmnt.setTimestamp(i,dbdate);
      }
    else if(t.equalsIgnoreCase("time")){
      java.util.Date d=null;
      try{d=getSimpleDateFormat().parse(pVal);
      }catch(Exception ex){d=getRfc1123DateFormat().parse(pVal);}
      java.sql.Time dbdate=new java.sql.Time(d.getTime());
      pStmnt.setTime(i,dbdate);
      }
    else if(t.equalsIgnoreCase("int") || t.equalsIgnoreCase("long")){
      int intVal=Integer.parseInt(pVal);
      pStmnt.setInt(i,intVal);
      }
    else pStmnt.setString(i,pVal);
   }catch(java.text.ParseException e){
     throw new SQLException("setParamStr failed to parse ["+pVal+"] as ["+t+":"+e);
   }catch(java.lang.NumberFormatException e){
     throw new SQLException("setParamStr failed to parse ["+pVal+"] as ["+t+":"+e);
   }catch(Exception e){
     throw new SQLException("setParamStr failed to set param "+i+", ["+pVal+"] as ["+t+":"+e);
   }
  }

/******* END OF DATABASE FUNCTIONALITY SECTION **********/
/******* DOM FUNCTIONALITY SECTION **********/

/**
  * parseURL gets the Document at a particular URL, or blows up
**/
public Document parseURL(String url)throws Exception{
 DocumentBuilder db=getDBF().newDocumentBuilder();
 Document doc=db.parse(url);
 return doc;
}
public Document readDocument(String str)throws Exception{
try{
  Document doc=getDBF().newDocumentBuilder()
                  .parse(new InputSource(new StringReader(str)));
  return doc;
}catch(Throwable ex){System.out.println("readDocument failure:"+ex);return null;}
}

/******* END OF DOM FUNCTIONALITY SECTION **********/

protected String configFileName="DBAuthServiceConfig.xml";
  public void setConfigFileName(String S){configFileName=S;}
  public String getConfigFileName(){return configFileName;}

/******* PORTS AND SOCKETS FUNCTIONALITY SECTION **********/

protected int portNumber=56789;
  public void setPortNumber(int N){portNumber=N;}
  public int getPortNumber(){return portNumber;}

protected void initSocket()throws Exception{
  try{
    serverSocket=new ServerSocket(getPortNumber());
  }catch(Exception ex){
    System.out.println("DBAuthService failed to listen on "+getPortNumber());
    System.exit(1);
  }
}
// int nnn=1;
/**
  * badSocket can test the client.getInetAddress() to see if, for example,
  * it is 127.0.0.1, or whatever we want to allow to connect.
**/
protected boolean badSocket(Socket client){
  return false;
//return 0==(nnn=(1-nnn));
}
protected void closeSocket(Socket client){
  try{System.out.println("closing socket from: "+client.getInetAddress());
  OutputStream os = client.getOutputStream();
  PrintWriter pW=new PrintWriter(new OutputStreamWriter(os,"utf-8"),true);
  String msg="We do not like you, "+client.getInetAddress();
  sendExceptionFault(new Exception(msg),pW);
  client.close();
  }catch(Exception ex){}
}
protected void listenOnPort()throws Exception{
  if(serverSocket==null)initSocket();
  Socket clientSocket=null;
  try{
    while(true){
      try{clientSocket=serverSocket.accept();
          if(badSocket(clientSocket)){ 
             closeSocket(clientSocket);
             continue;}
System.out.println("got a client from "+clientSocket.getInetAddress()+"to "+clientSocket.getLocalAddress()+" on "+getPortNumber());
      }catch(Exception ex){
        System.out.println("DBAuthService failed to accept on "+getPortNumber()+": "+ex);
        System.exit(1);
      }
      doHttpTransaction(clientSocket);
      }
    }catch(IOException e){e.printStackTrace();}
}

public void doHttpTransaction(Socket clientSocket)
    throws Exception{
  OutputStream os=null;
  BufferedOutputStream bos=null;
  PrintWriter pW=null;
  try{
    InputStream is=clientSocket.getInputStream();
    BufferedInputStream bis = new BufferedInputStream(is);
    InputStreamReader reader=new InputStreamReader(bis,"utf-8");
    os=clientSocket.getOutputStream();
    bos = new BufferedOutputStream(os);
    pW=new PrintWriter(new OutputStreamWriter(bos,"utf-8"),true);
    Hashtable httpData=readHttpData(reader);
    if(!authorized(httpData))
      throw new Exception("Authorization failure:\n"+httpData);
    System.out.println("httpData="+httpData);
    String cmd=(String)httpData.get("METHOD");
    if("POST".equals(cmd))doPost(httpData,pW);
    else if("GET".equals(cmd))doGet(httpData,pW);
    else if("PUT".equals(cmd))doPut(httpData,pW);
    else if("DELETE".equals(cmd))doDelete(httpData,pW);
    else throw new Exception("unknown command ["+cmd+"]; POST,GET,PUT,DELETE okay");
    reader.close(); bis.close();  is.close();
    pW.close(); pW=null; bos.close(); os.close();
  }catch(Exception ex){
    if(pW!=null){
      sendExceptionFault(ex,pW);
      pW.close();bos.close();os.close();
    }
  }
}

/******* END OF PORTS AND SOCKETS FUNCTIONALITY SECTION **********/
/******* HTTP FUNCTIONALITY SECTION **********/

/**
  * sendExceptionFault(exception,printwriter) assumes that no output has yet
  * been sent; it sends a SOAPFault element 
**/
 
protected void sendExceptionFault(Exception ex,PrintWriter pW){
String message=ex.getMessage();
if(message!=null && 0<=message.indexOf("Authorization")){
  sendAuthorizationException(ex,pW);
  return;
}
StringBuffer sB=new StringBuffer();
sB.append("<?xml version='1.0' encoding='UTF-8'?>\n")
  .append("<SOAP-ENV:Envelope \n")
// REMOVAL Aug 9  .append("   SOAP-ENV:encodingStyle='http://xml.apache.org/xml-soap/literalxml'\n")
  .append("   xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/'\n")
  .append("   xmlns:xsd='http://www.w3.org/2001/XMLSchema'\n")
  .append("   xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n")
  .append(" <SOAP-ENV:Body>\n")
  .append("   <SOAP-ENV:Fault>\n")
  .append("     <SOAP-ENV:faultcode>").append(42).append("</SOAP-ENV:faultcode>\n")
  .append("     <SOAP-ENV:faultstring>internal error</SOAP-ENV:faultstring>\n")
  .append("     <SOAP-ENV:detail>\n").append(ex.toString()).append("</SOAP-ENV:detail>\n")
  .append("   </SOAP-ENV:Fault>\n")
  .append(" </SOAP-ENV:Body>\n")
  .append("</SOAP-ENV:Envelope>\n");
  String msg=sB.toString();
  pW.print("HTTP/1.0 500 Very Extremely Bad\r\n");
  pW.print("Content-Type: text/xml; charset=utf-8\r\n");
  pW.print("Content-Length: "+msg.length()+"\r\n\r\n");
  pW.print(msg);
  pW.flush();
}
public void sendAuthorizationException(Exception ex,PrintWriter pW){
StringBuffer sB=new StringBuffer();
sB.append("<p>Security Error:"+ex+"</p>\n");
  String msg=sB.toString();		
  pW.print("HTTP/1.0 401 Unauthorized\r\n");
  pW.print("WWW-Authenticate: Basic realm=\"DBAuthServer Data\"\r\n");
  pW.print("Content-Type: text/html; charset=utf-8\r\n");
  pW.print("Content-Length: "+msg.length()+"\r\n\r\n");
  pW.print(msg);
  pW.flush();
}
public String readLine(Reader reader)throws Exception{
  StringBuffer sB=new StringBuffer();
  int ch;
  for(ch=reader.read();ch>=0 && ch!='\r';ch=reader.read())sB.append((char)ch);
  if(ch<0)return sB.toString();
  ch=reader.read();
  if(ch!='\n')
    throw new Exception("line ["+sB.toString()+"] lacks \\n");
  return sB.toString();
}
/**
  * Hashtable readHttpData(Reader) reads METHOD URL HTTP/1.1, headers, value
  * result.get("METHOD"),...get("URL"),"HTTP",..."Content-Length"), "HTTP_BODY";
  * decodes " Authorization: Basic cGvcmU6cGRcmU= "
**/
public Hashtable readHttpData(Reader reader)throws Exception{
  Hashtable hashtable=new Hashtable();
  hashtable.put("CONTENT-LENGTH","0"); // default
  String cmdLine=readLine(reader);
  int firstBlank=cmdLine.indexOf(' ');
  int lastBlank=cmdLine.lastIndexOf(' ');
  if(firstBlank < 0 || firstBlank == lastBlank)
    throw new Exception("Invalid HTTP method line ["+cmdLine+"]");
  hashtable.put("METHOD",cmdLine.substring(0,firstBlank));
  hashtable.put("URL",cmdLine.substring(1+firstBlank,lastBlank));
  hashtable.put("HTTP",cmdLine.substring(1+lastBlank));;
  String hdr=readLine(reader);
  while(hdr.length()>0){  
    String[]nameVal=hdr.split(": ",2);
    if(nameVal.length > 1)hashtable.put(nameVal[0].toUpperCase(),nameVal[1]);
//    int n=hdr.indexOf(':');
//    if(n>=0)hashtable.put(hdr.substring(0,n),hdr.substring(n+1).trim());
    hdr=readLine(reader);
    }
System.out.println("Content-Length=["+hashtable.get("CONTENT-LENGTH")+"]");
  int len=Integer.parseInt((String)hashtable.get("CONTENT-LENGTH"));
  hashtable.put("HTTP_BODY",readUpToLength(reader,len));
  if(null!=readRequestURL)
    addURLArgs(hashtable,(String)hashtable.get("URL"));
System.out.println("URLDecoded=["+new java.net.URLDecoder().decode((String)hashtable.get("URL"),"utf-8")+"]");
  return hashtable;
}

public static void addURLArgs(Hashtable hT,String url)throws Exception{
  int qLoc=url.indexOf('?');
  if(qLoc<0)return;
  URLDecoder decoder=new URLDecoder();
  String[]nVs=url.substring(1+qLoc).split("[&=]");
  hT.put("URL",url.substring(0,qLoc));
  for(int i=1;i<nVs.length;i+=2)
    hT.put(nVs[i-1],decoder.decode(nVs[i],"utf-8"));
}

public String readUpToLength(Reader isr, int len)throws Exception{
  StringWriter sw=new StringWriter();
try{ int ch;
  while(len-- > 0 && 0 < (ch=isr.read())){
    sw.write((char)ch); 
  }
  return sw.toString();
 }catch(Exception ex){ex.printStackTrace();System.out.println("**[\n"+sw.toString()+"\n]**");throw(ex);}
}


public boolean authorized(Hashtable httpData)throws Exception{
  httpData.put("Now",getRfc1123DateFormat().format(new java.util.Date()));
  httpData.put("userGroup","");
  String auth=(String)httpData.get("AUTHORIZATION");
  if(auth==null || !auth.startsWith("Basic "))return true; // okay for GET queries
             //     public static byte[] decode( byte[] base64Data )
  auth=new String(Base64.decode(auth.substring(6).getBytes()));
  int colLoc=auth.indexOf(':');
  if(colLoc<0)throw new Exception("invalid Basic Authorization: '"+auth+"'");
  String userID=auth.substring(0,colLoc);
  String pwd=auth.substring(colLoc+1);
  
  if(!pwd.equals(userPwd.getProperty(userID)))
     throw new Exception("invalid Authorization: userID/pwd='"+userID+"'/'"+pwd+"'");
  httpData.put("userID",userID);
  httpData.put("pwd",pwd);
  httpData.put("userGroup",userGroup.getProperty(userID));
  return true;}

public void doPost(Hashtable httpData,PrintWriter pW)throws Exception{
  String soapAction=(String)httpData.get("SOAPACTION");
  if(soapAction==null)doREST("INS",httpData,pW);
  else if("DBServerCall".equals(pruneQuotes(soapAction)))
    doDBServerCall(httpData,pW);
  else throw new Exception("POST with unknown SOAPAction:["+soapAction+"]");
}
protected static String pruneQuotes(String S){ // ADDITION aug 9, for axis quoted soapactions.
  if(S==null)return S;
  if(!S.startsWith("\"") || !S.endsWith("\""))return S;
  return S.substring(1,S.length()-1);
}

public void doDBServerCall(Hashtable httpData,PrintWriter pW)throws Exception{
  String docString=(String)httpData.get("HTTP_BODY");
  if(null==docString || docString.length()==0)
    throw new Exception("no body to HTTP request");
  Document doc=readDocument(docString); 
  ArrayList arrayList=getSOAPParams(doc);
System.out.println("\ngot SOAP params: "+arrayList.size());
  for(int i=0;i<arrayList.size();i++)
    System.out.print(","+arrayList.get(i));
  String soapRes=doSQL(arrayList,httpData);
// System.out.println("soapRes="+soapRes);
  writeSOAPResult(soapRes,pW);
}

public ArrayList getSOAPParams(Document doc){ 
  NodeList nodeList=doc.getElementsByTagName("dbParam");
  ArrayList arrayList=new ArrayList();
  for(int i=0;i<nodeList.getLength();i++){
   Node child=nodeList.item(i).getFirstChild();
   String param=child!=null?child.getNodeValue():"";
   System.out.println("param("+i+")="+param);
   arrayList.add(param);
   }
  return arrayList;
}

/* REST-only methods */
public void doREST(String method,Hashtable httpData,PrintWriter pW)
  throws Exception{
  ArrayList paramList=getRESTParams(method,httpData);
  String sqlResult=doSQL(paramList,httpData);
  String xslt=(String)httpData.get("xslt");
  if(xslt!=null)writeXHTMLPage(sqlResult,pW,xslt); // option for chapter 6
  else writeXHTMLPage(sqlResult,pW);
}
public void doGet(Hashtable httpData,PrintWriter pW)throws Exception{
  doREST("GET",httpData,pW);
}
public void doPut(Hashtable httpData,PrintWriter pW)throws Exception{
  ArrayList deletionParams=getRESTParams("DELETE",httpData);
  doSQL(deletionParams,httpData);
  doREST("INS",httpData,pW);
}
public void doDelete(Hashtable httpData,PrintWriter pW)throws Exception{
  doREST("DELETE",httpData,pW);
}
/* end REST-only methods */

protected void writeXMLPage(String data,PrintWriter pW){
StringBuffer sB=new StringBuffer();
sB.append("<?xml version='1.0' encoding='UTF-8'?>\n")
  .append("<SOAP-ENV:Envelope \n")
// REMOVAL Aug 9  .append("   SOAP-ENV:encodingStyle='http://xml.apache.org/xml-soap/literalxml'\n")
  .append("   xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/'\n")
  .append("   xmlns:xsd='http://www.w3.org/2001/XMLSchema'\n")
  .append("   xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n")
  .append(" <SOAP-ENV:Body>\n")
  .append(data)
  .append(" </SOAP-ENV:Body>\n")
  .append("</SOAP-ENV:Envelope>\n");
  String msg=sB.toString();
  pW.print("HTTP/1.0 200 OK\r\n");
  pW.print("Content-Type: text/xml; charset=utf-8\r\n");
  pW.print("Content-Length: "+msg.length()+"\r\n\r\n");
  pW.print(msg);
  pW.flush();
}
protected void writeXHTMLPage(String data,PrintWriter pW){
StringBuffer sB=new StringBuffer();
sB.append("<html><head><title>DBAuthService Result</title></head><body>\n")
  .append(data)
  .append("</body></html>");
  String msg=sB.toString();
  pW.print("HTTP/1.0 200 OK\r\n");
  pW.print("Content-Type: text/html; charset=utf-8\r\n");
  pW.print("Content-Length: "+msg.length()+"\r\n\r\n");
  pW.print(msg);
  pW.flush();
}

protected void writeXHTMLPage(String data,PrintWriter pW,String xslt){
  try{
  Document doc=readDocument(data);
  xslt="xslt/"+xslt; //should check for http: prefix or ".." hacks
  if(!new File(xslt).exists())throw new Exception("no file "+xslt);

  TransformerFactory tFactory = TransformerFactory.newInstance();
  Transformer transformer = tFactory.newTransformer(new StreamSource(xslt));
  StringWriter outStrW=new StringWriter();
  transformer.transform(new DOMSource(doc), new StreamResult(outStrW));
  String msg=outStrW.toString();

  pW.print("HTTP/1.0 200 OK\r\n");
  pW.print("Content-Type: text/html; charset=utf-8\r\n");
  pW.print("Content-Length: "+msg.length()+"\r\n\r\n");
  pW.print(msg);
  pW.flush();
  }catch(Exception ex){sendExceptionFault(ex,pW);}
}

public void writeSOAPResult(String soapRes,PrintWriter pW)throws Exception{
StringBuffer sB=new StringBuffer();
sB.append("<?xml version='1.0' encoding='UTF-8'?>\n")
  .append("<SOAP-ENV:Envelope \n")
// REMOVAL AUg 9  .append("   SOAP-ENV:encodingStyle='http://xml.apache.org/xml-soap/literalxml'\n")
  .append("   xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/'\n")
  .append("   xmlns:xsd='http://www.w3.org/2001/XMLSchema'\n")
  .append("   xmlns:nns='http://n-topus.com/DBS'\n")
  .append("   xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n")
  .append(" <SOAP-ENV:Body>\n")
  .append("  <nns:doSQLResponse>\n")
  .append(soapRes)       
  .append("  </nns:doSQLResponse>\n")
  .append(" </SOAP-ENV:Body>\n")
  .append("</SOAP-ENV:Envelope>\n");
soapRes=sB.toString();  
System.out.println("SOAPRES=\n"+soapRes+"END SOAPRES");
  pW.print("HTTP/1.0 200 OK\r\n");                           // ADDED / Aug 9
  pW.print("Content-Type: text/xml; charset=utf-8\r\n");
  pW.print("Content-Length: "+soapRes.length()+"\r\n");
  pW.print("Date: "+getRfc1123DateFormat().format(new java.util.Date())+"\r\n");
//  pW.print("Date: Sun, 10 Feb 2002 22:19:37 GMT\r\n");

  pW.print("Server: DBAuthService 0.11\r\n\r\n"); // blank line
  pW.print(soapRes);
  pW.flush();
}


/******* END OF HTTP FUNCTIONALITY SECTION **********/
/******* REST FUNCTIONALITY SECTION **********/


/**
  * getRESTParams assumes URL is of form /AmaAuth/345; table/key;
  * we expect to support GET,PUT, DELETE
  * thus GET /AmaAuth/345 will produce the one-row table added by
  *      PUT /AmaAuth/345 where PUT has a doc with dbParam values
  *        providing the columns except for that key.
  * GET gets a representation of what PUT provides, but not the same XML;
  * the GET result normally includes the key value.
  * If the key is empty, we assume GETALL; 
**/

protected ArrayList getRESTParams(String method,Hashtable hashtable)throws Exception{
  if("POST".equals(method))method="INS";
  String url=(String)hashtable.get("URL");
  String[]methodKey=url.substring(1).split("/");
  ArrayList arrayList=new ArrayList();
  if(methodKey.length<2 || methodKey[1].trim().length()==0)
    arrayList.add(method+"all_"+methodKey[0]);
  else{
    arrayList.add(method+"_"+methodKey[0]); // e.g., GET_AmaAuth;
    arrayList.add(methodKey[1]);            // Asin, always the key value here.
  }
  if(!"INS".equalsIgnoreCase(method))return arrayList; // called within PUT.
  String docString=(String)hashtable.get("HTTP_BODY");
  if(null==docString || docString.length()==0)
    throw new Exception("no body to HTTP request");
  Document doc=readDocument(docString);
  NodeList nodeList=doc.getElementsByTagName("dbParam");
  for(int i=0;i<nodeList.getLength();i++){
   Node child=nodeList.item(i).getFirstChild();
   String param=child!=null?child.getNodeValue():"";
   System.out.println("param("+(1+i)+")="+param);
   arrayList.add(param);
   }
  return arrayList;
}
/******* END OF REST FUNCTIONALITY SECTION **********/

/******* MISCELLANY FUNCTIONALITY SECTION **********/

public ArrayList queryStrings=null;

public void setQueryStrings(ArrayList SS){
   queryStrings=SS;
   queryHashtable=new Hashtable();
   if(SS==null)return;
   for(int i=0;i<queryStrings.size();i++){
     DBAuthQueryData dbqd=(DBAuthQueryData)(SS.get(i));
     queryHashtable.put(dbqd.getQID().toUpperCase(),dbqd);
   }
}
public ArrayList getQueryStrings(){return queryStrings;}

public String toString(){ // for debugging or logging
  String S= "dbURL="+dbURL;
  S+="\ndbDriver="+dbDriver;
  S+="\ndbUser="+dbUser;
  S+="\ndbPwd="+dbPwd;
  S+="\nportNumber="+portNumber;
  S+="\nqueryStrings=";
  if(queryStrings==null)return S+"null";
  S+="\n [";
  if(queryStrings.size()==0)return S+"]";
  S+="\n  "+queryStrings.get(0);
  for(int i=1;i<queryStrings.size();i++)S+=",\n  "+queryStrings.get(i);
  return S+"\n ]";
}

public static byte[] md5Digest(String x) throws Exception {
  java.security.MessageDigest d 
     = java.security.MessageDigest.getInstance("MD5"); 
  d.reset();
  d.update(x.getBytes("utf-8"));
  return d.digest();
}

/******* END OF MISCELLANY FUNCTIONALITY SECTION **********/

public static void main(String[]args)throws Exception{
/*
System.out.println(new String(Base64.encode("tjm:tjm".getBytes())));
System.out.println(new String(Base64.encode("adn:adn".getBytes())));
System.out.println(new String(Base64.encode("tjm:adn".getBytes())));
System.out.println(new String(Base64.encode("joe:joe".getBytes())));
dGptOnRqbQ==
YWRuOmFkbg==
dGptOmFkbg==
am9lOmpvZQ==
*/
//System.out.println(new String(Base64.encode(md5Digest("tjm:tjm"))));
  String fileName=(args.length > 0)?args[0]:"DBAuthServiceConfig.xml";
  XMLDecoder xmlDecoder=new XMLDecoder(new FileInputStream(fileName));
  DBAuthService dbService=(DBAuthService)xmlDecoder.readObject();
  System.out.println(dbService.toString());
  if(args.length > 1){
    ArrayList aL=new ArrayList();
    for(int i=1;i<args.length;i++)aL.add(args[i]);
    dbService.doSQL(aL,new Hashtable(),new PrintWriter(System.out,true));
    }
  dbService.listenOnPort();
} // end of main()

}

