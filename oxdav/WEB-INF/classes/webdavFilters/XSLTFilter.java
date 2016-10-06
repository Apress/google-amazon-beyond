package webdavFilters;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import org.w3c.tidy.Tidy;
import org.w3c.tidy.OutImpl;
import org.w3c.tidy.Configuration;
import javax.xml.transform.dom.DOMSource;
          

public class XSLTFilter implements Filter {
  private ServletContext ctx;
  private String srcPrefix,targetPrefix;
  private String xslUri;

public void init(FilterConfig filterConfig)throws ServletException{
  ctx=filterConfig.getServletContext();
  srcPrefix = filterConfig.getInitParameter("srcPrefix"); 
  targetPrefix = filterConfig.getInitParameter("targetPrefix"); 
  xslUri=ctx.getRealPath(filterConfig.getInitParameter("xslUri"));
  ctx.log("Filter "+filterConfig.getFilterName()
          +"; map webapps/"+srcPrefix+" to "+ctx.getRealPath(targetPrefix));
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
  HttpServletRequest hsr=(HttpServletRequest)servletRequest;
  final HttpServletResponse resp = (HttpServletResponse)servletResponse;
  String strReq=httpReqLine(hsr)+" "+hsr.getMethod();
  ctx.log("Accessing filter for "+strReq);
  HttpServletResponse wrappedResp=new HttpServletResponseWrapper(resp);
  filterChain.doFilter(servletRequest,wrappedResp); // just passes it through
  if("PUT".equals(hsr.getMethod().toString())){
     String url=hsr.getRequestURL().toString();
     if(url.endsWith(".htm") || url.endsWith(".html")){
       int prefixLoc=url.lastIndexOf(srcPrefix);
       if(prefixLoc >= 0){
         url=url.substring(prefixLoc+srcPrefix.length());
         ctx.log("PUT url="+url);
         cleanUpFile(ctx.getRealPath(url),ctx.getRealPath(targetPrefix+url));
         }
       }
    }
  ctx.log("Finished with filter for "+strReq);
}

public String cleanUpFile(String srcFileName,String targetFileName){
  ctx.log("tidying "+srcFileName+" into "+targetFileName);
  try{
    Tidy tidy=new Tidy(); 
    Configuration configuration=tidy.getConfiguration();
    String cfgFile=new File(ctx.getRealPath("TIDY/tidy.cfg")).toString();
    tidy.setMakeClean(true); tidy.setXmlTags(false);
    tidy.setConfigurationFromFile(cfgFile);
    configuration.adjust();
    org.w3c.dom.Document tidyOut=
      tidy.parseDOM(new FileInputStream(srcFileName),
        new FileOutputStream(
          new File(ctx.getRealPath("tmp.xml")).toString()));
    transform(tidyOut,xslUri,targetFileName);
    return "";
  }catch(Exception ex){ctx.log("cleanUpFile error: ",ex); return "err: "+ex;}
}

public void destroy(){ ctx.log("Destroying filter..."); }

public void transform(org.w3c.dom.Document doc,
                       String xslUri,String outFileName)
    throws Exception{
  TransformerFactory tFactory = TransformerFactory.newInstance();
  Transformer transformer = tFactory.newTransformer(new StreamSource(xslUri));
  transformer.transform(new DOMSource(doc), new StreamResult(outFileName));
}
}
  
