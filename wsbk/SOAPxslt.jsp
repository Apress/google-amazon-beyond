<%@ page import=
  "soapUtil.XmlHttp,
  java.io.StringReader,java.io.StringWriter,java.io.PrintWriter,
  javax.xml.transform.TransformerFactory,
  javax.xml.transform.Transformer,
  javax.xml.transform.TransformerException,
  javax.xml.transform.stream.StreamSource,
  javax.xml.transform.stream.StreamResult,
  org.xml.sax.SAXException,
  org.xml.sax.SAXParseException"
   %><%
  try{
    String xslt=request.getParameter("xslt");
    String soapAction=request.getParameter("SOAPAction");
    String url=request.getParameter("url");
    String payload=request.getParameter("payload");
    String soapResult=XmlHttp.sendSoap(url,soapAction,payload);

    if(xslt==null || xslt.length() == 0) {
      response.setContentType("text/xml"); 
      out.println(soapResult);
    }else {
      String outStr=transform(xslt,soapResult);
      out.println(outStr);
    }
  }catch(Throwable t){showThrowable(t,new PrintWriter(out));}
%><%!

public static String transform(String xslt,String soapResult)throws Throwable{
   Transformer transformer=null;
    TransformerFactory tFactory = TransformerFactory.newInstance();
    StreamSource xsltSrc = new StreamSource(xslt);
    transformer = tFactory.newTransformer(xsltSrc); 
    StreamSource sS = new StreamSource(new StringReader(soapResult));
    StringWriter outStrW=new StringWriter();
    transformer.transform(sS, new StreamResult(outStrW));
    return outStrW.toString();
}

public static void showThrowable(Throwable t,PrintWriter out){
  // if the problem is just a SAXParseException of one of the
  // StreamSources, show that; otherwise show the top throwable.
  Throwable th=t;
  while(t!=null){
    if(t instanceof TransformerException)
      t=((TransformerException)t).getException();
    if(t instanceof SAXParseException)break;
    if(t instanceof SAXException)
      t=((SAXException)t).getException();
  }
  SAXParseException spe=(SAXParseException)t;
  if(spe!=null){
    out.println(""+spe+"\n"+
                "publicID="+spe.getPublicId()+";systemId="+spe.getSystemId()+
                "; line:col="+spe.getLineNumber()+":"+spe.getColumnNumber());
    spe.printStackTrace(out);
  }else th.printStackTrace(out);
}


%>
