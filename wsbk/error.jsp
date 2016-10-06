<%@ page isErrorPage="true" import="java.io.*" %>
<html><head><title>ErrorPage</title></head>
<body>

Problem: <%= exception.getMessage() %>
<% 
%>
<form><textarea rows="25" cols="100">
<% 
  // some exception classes have "getException" methods; this loop simply
  // brings the innermost exception, e.g. SAXParseException, to the surface.
   exception.printStackTrace(new PrintWriter(out));
%>

--------------------------------

<%
   try{
    Exception e=(Exception)exception,sub=null;
    java.lang.reflect.Method method=null;
    Object[]noOb=new Object[]{}; Class[]noClass=new Class[]{};
    for(int i=0;;i++){ 
      try{method=null;
         method=e.getClass().getMethod("getException",noClass);
      }catch(Exception exc){out.write("can't get getException method");}
      if(null==method)break;
      sub=(Exception)method.invoke(e,noOb);
      if(null==sub)break;
      out.write(" "+i+": "+e.toString()+"\n");
      e=sub;
      }
  if(e instanceof org.xml.sax.SAXParseException){
    org.xml.sax.SAXParseException spe=(org.xml.sax.SAXParseException)e;
    out.write("\nsrc="+spe.getSystemId()+":"+spe.getPublicId()+" at "+
                spe.getLineNumber()+":"+spe.getColumnNumber()+"\n\n");
    }
  e.printStackTrace(new PrintWriter(out)); 
  }catch(Exception ee){ee.printStackTrace(new PrintWriter(out));}
%>
</textarea>
</form>
Something went wrong. We're very sorry.
</body>
</html>
