<%@ page 
  import="java.io.PrintWriter,
          java.io.BufferedWriter,
          java.io.FileWriter,
          java.io.File,
          java.io.IOException,
          javax.servlet.http.HttpUtils"
   %><%!
public boolean userPwdOkay(String usr,String pwd){
  return ("adn".equals(usr) && "eci1A".equals(pwd)
         || "tjm".equals(usr) && "TAG-DRUM".equals(pwd));
}
public void writeToFile(String fN,String val,boolean app)throws IOException{
  PrintWriter pW=new PrintWriter(new BufferedWriter(new FileWriter(fN,app)));
  pW.println(val);
  pW.flush();
  pW.close();
}
%><% 
String delim="0123456789*9876543210";
String user=request.getParameter("user");
String pw=request.getParameter("pw");
if(!userPwdOkay(user,pw)){
%> <jsp:forward page="badSignIn.html"/><%
}
String url="/ntopuRSS/rssData/"+user+"/";
String myURI=HttpUtils.getRequestURL(request).toString();
myURI=myURI.substring(0,myURI.lastIndexOf('/'));
myURI=myURI.substring(0,myURI.lastIndexOf('/'));


String filePath=application.getRealPath("");
out.println("url="+url+"; filePath="+filePath);
java.util.Date date=new java.util.Date();
url+=date.getYear()+"_"+(1+date.getMonth())+"_"+(date.getDate());
String bodyHTML=request.getParameter("ta");
  if(bodyHTML==null)bodyHTML="";
String title=request.getParameter("title");
  if(title==null)title="";
String pageHTML="<html><head><title>"+title+"</title></head><body>"+bodyHTML+"</body></html>\n";

String description=request.getParameter("description");
  if(description==null)description=""; 

boolean addDate=true;
  if("no".equals(request.getParameter("useDate")))addDate=false;
  if(addDate)description=""+new java.util.Date()+": "+description;
boolean gotData=(url!=null);
if(gotData){
 synchronized(application){
   filePath+=url;
 int fileNum=1;
 File file=new File(filePath+"_"+fileNum+".html");
 while(file.exists())file=new File(filePath+"_"+(++fileNum)+".html");
 url+="_"+fileNum+".html";
 filePath+="_"+fileNum+".html";
 StringBuffer sB=new StringBuffer();
 sB.append(title).append("\n").append(myURI+url).append("\n").append(description).append("\n").append(delim);
 writeToFile(application.getRealPath("rss.txt"),sB.toString(),true);
 writeToFile(filePath,pageHTML,false);
 }
  %>
  <html><head><title>RSS added</title></head><body>
  We have successfully added 
  <table border="1">
  <tr><td>title</td><td><%= title %> </td></tr>
  <tr><td>url</td><td><%= myURI+url %> </td></tr>
  <tr><td>description</td><td><%= description %> </td></tr>
  </table>
  to the list of RSS items. You can now check 
  <a href="<%= myURI+"/ntopuRSS/feed.jsp"%>">the XML feed<a>
or
  <a href="<%= myURI+"/ntopuRSS/feedHTML.jsp"%>">an HTML view of it.<a>
Thank you, and have a happy day.<br/>
  </body></html>
<% }else { // no data
%>
<html> <head><title> no RSS added</title></head><body>
Sorry, no data. we need a url, and a title, which we'll be
happy to get from your current page; just bookmark this javascript url,
by dragging it to your Favorites list in IE or simply to the toolbar in
Mozilla.
<%
 String appLoc="'"+HttpUtils.getRequestURL(request).toString()+"'";
                 // e.g., "'http://localhost:8080/wsbk/rss/addItem.jsp'";
 String winLoc="window.location";
 String docTitle="document.title";
 String descrIE="document.selection.createRange().text";
 String descrMoz="window.getSelection()";
if(true)descrMoz="new XMLSerializer().serializeToString("+descrMoz+".getRangeAt(0).startContainer)";
 String desc="(document.all?" +descrIE+ ":" +descrMoz + ")";
 String args= "+'?url='+escape("         +winLoc
            + ")+'&title='+escape("       +docTitle
            + ")+'&description='+escape(" +desc+")";
 String loc= appLoc+args;
%>
<a href="javascript:location=<%= loc %>  ">addToRSS</a>
</body></html>
<% } 
%>

