<%@ page 
  import="java.io.PrintWriter,
          java.io.BufferedWriter,
          java.io.FileWriter,
          javax.servlet.http.HttpUtils"
   %><% 
String delim="0123456789*9876543210";
String url=request.getParameter("url");
String title=request.getParameter("title");
  if(title==null)title="";

String description=request.getParameter("description");
  if(description==null)description=""; 

boolean addDate=true;
  if("no".equals(request.getParameter("useDate")))addDate=false;
  if(addDate)description=""+new java.util.Date()+": "+description;
boolean gotData=(url!=null);
if(gotData){
 synchronized(application){
  boolean app=true;
  String fN=application.getRealPath("rss.txt");
  PrintWriter pW=new PrintWriter(new BufferedWriter(new FileWriter(fN,app)));
  pW.println(title);
  pW.println(url);
  pW.println(description);
  pW.println(delim);
  pW.flush();
  pW.close();
  %>
  <html><head><title>RSS added</title></head><body>
  We have successfully added 
  <table border="1">
  <tr><td>title</td><td><%= title %> </td></tr>
  <tr><td>url</td><td><%= url %> </td></tr>
  <tr><td>description</td><td><%= description %> </td></tr>
  </table>
  to the list of RSS items. Thank you, and have a happy day.<br/>
  </body></html>
<% }}else { // no data
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

