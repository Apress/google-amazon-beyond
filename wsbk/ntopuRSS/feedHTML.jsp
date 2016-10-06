<%@ page contentType="text/html"
  import="java.io.BufferedReader,
          java.io.FileReader,
          javax.servlet.http.HttpUtils"
   %><html><head><title>BLOGTITLE</title></head><body>
<div>
Blog Description; 
Link:<a href="<%= HttpUtils.getRequestURL(request) %>">this file</a>
<em>Copyright 2003 Alexander D. Nakhimovsky</em>
<h3><%= new java.util.Date() %></h3>
<a href="mailto:sasha@mail.colgate.edu">managingEditor</a>, and 
<a href="mailto:sasha@mail.colgate.edu">webMaster</a>.
<br>
<table>
<% 
String delim="0123456789*9876543210";
BufferedReader bR=null;
try{
  String fileName=application.getRealPath("rss.txt");
  bR=new BufferedReader(new FileReader(fileName));
  String title=bR.readLine();
  while(title!=null){
    String link=bR.readLine();
%><tr><td><a href="<%= link %>"><%= title %></a></td><td>
<%      String desc=bR.readLine();
        while(desc!=null && !delim.equals(desc)){
          out.println(desc);
          desc=bR.readLine();
          }
   %></td></tr>
     <% title=bR.readLine();
     } 
}catch(Exception ex){};
if(bR!=null)bR.close();
%>
</table></body></html>
<%!
public static String fixLine(String line){
  if(line==null)return "";
  if(0<line.indexOf('&') && 0 < line.indexOf('<') && 0 < line.indexOf('>')) return line;
  StringBuffer sb=new StringBuffer(2*line.length());
  for(int i=0;i<line.length();i++){
   char c=line.charAt(i);
   if(c=='&')sb.append("&amp;");
   else if(c=='<')sb.append("&lt;");
   else if(c=='>')sb.append("&gt;");
   else sb.append(c);
   }
  return sb.toString();
}
  
%>

