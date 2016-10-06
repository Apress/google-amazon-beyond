<%@ page contentType="text/xml"
  import="java.io.BufferedReader,
          java.io.FileReader"
   %><?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE rss PUBLIC "-//Netscape Communications//DTD RSS 0.91//EN" "http://www.scripting.com/dtd/rss-0_91.dtd">
<rss version="0.91">
<channel>
<title>Exposure Hotline</title>
<description>A collaborative newslist of public-health chemical exposure data.</description>
<link>http://www.protectingourhealth.org</link>
<language>en-us</language>
<copyright>Copyright 2003 J.P.Myers</copyright>
<pubDate><%= new java.util.Date() %></pubDate>
<managingEditor>jpmyers@protectingourhealth.org</managingEditor>
<webMaster>jpmyers@protectingourhealth.org</webMaster>
<% 
String delim="0123456789*9876543210";
BufferedReader bR=null;
try{
  String fileName=application.getRealPath("rss.txt");
  bR=new BufferedReader(new FileReader(fileName));
  String title=bR.readLine();
  while(title!=null){
    %>
   <item>
     <title><%= fixLine(title) %></title>
     <link><%= fixLine(bR.readLine()) %></link>
     <description><% 
        String desc=bR.readLine();
        while(desc!=null && !delim.equals(desc)){
          out.println(fixLine(desc));
          desc=bR.readLine();
          }
   %></description>
   </item>
     <% title=bR.readLine();
     } 
}catch(Exception ex){};
if(bR!=null)bR.close();
%>
</channel>
</rss><%!
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

