<%
  String path=application.getRealPath("");
%>
 <%= path.substring(0,path.lastIndexOf("webapps")) %>


