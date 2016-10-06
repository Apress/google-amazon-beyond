<%@ page errorPage="error.jsp" 
    import="javax.xml.transform.TransformerFactory,
            javax.xml.transform.Transformer,
            javax.xml.transform.stream.StreamSource,
            javax.xml.transform.stream.StreamResult,
            java.io.File"
   %><% 
  String xml=application.getRealPath(request.getParameter("xmlUri"));
  String xsl=application.getRealPath(request.getParameter("xslUri"));
  if(!new File(xml).exists())throw new Exception("no file "+xml);
  if(!new File(xsl).exists())throw new Exception("no file "+xsl);

  TransformerFactory tFactory = TransformerFactory.newInstance();
  Transformer transformer = tFactory.newTransformer(new StreamSource(xsl));
  transformer.transform(new StreamSource(xml), new StreamResult(out));
 %>


