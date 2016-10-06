package soapUtil;

import java.net.URL;
import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.StringWriter;
import java.io.InputStreamReader;
import java.io.IOException;


public class XmlHttp {

/* the idea is to receive URL and envelope as strings,
   then do SOAP call, e.g. 

POST /axis/PrimeFactorsString.jws HTTP/1.0
Content-Length: 402
Host: localhost
Content-Type: text/xml; charset=utf-8
SOAPAction: ""

<?xml version="1.0" encoding="UTF-8"?>
<SOAP-ENV:Envelope 
   SOAP-ENV:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"
   xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
   xmlns:xsd="http://www.w3.org/2001/XMLSchema"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
 <SOAP-ENV:Body>
  <factors>
   <arg0 xsi:type="xsd:int">36</arg0>
  </factors>
 </SOAP-ENV:Body>
</SOAP-ENV:Envelope>

and pass the response back to the user.
*/
public static String sendSoap(String urlString, String soapAction,
                           String payload)throws IOException{
  URL url=new URL(urlString);
  int timeout=20000;
  int port= url.getPort(); if(port<0)port=80;
  Socket s = new Socket(url.getHost(),port);
  s.setSoTimeout(timeout);
  OutputStream outStream = s.getOutputStream ();
  InputStream inStream = s.getInputStream ();

  StringBuffer headerbuf = new StringBuffer();
  headerbuf.append("POST ")
              .append(url.getFile()).append(" HTTP/1.0\r\n")
          .append("Host: ")
             .append(url.getHost()).append(':').append(port).append("\r\n")
          .append("Content-Type: text/xml; charset=utf-8\r\n")
          .append("Content-Length: ")
             .append(payload.length()).append("\r\n")
          .append("SOAPAction: \"").append(soapAction).append("\"\r\n")
          .append("\r\n");
                                     /* Send headerbuf and payload. */
      BufferedOutputStream bOutStream = new BufferedOutputStream(outStream);
      bOutStream.write(headerbuf.toString().getBytes("utf-8"));
      bOutStream.write(payload.getBytes("utf-8"));
      bOutStream.flush(); outStream.flush();

      BufferedInputStream bInStream = new BufferedInputStream(inStream);
      InputStreamReader reader=new InputStreamReader(bInStream,"utf-8");
      
      StringWriter sw=new java.io.StringWriter();
      for(int ch=reader.read();ch>=0;ch=reader.read())sw.write((char)ch);
      String resString=sw.toString();
      int endHeaderPos=resString.indexOf("\r\n\r\n");
      if(endHeaderPos>=0)resString=resString.substring(endHeaderPos+4);

      bOutStream.close(); outStream.close();
      bInStream.close();  inStream.close();
      s.close();
      return resString;
}

public static String doAmazonKeywordSearchEnvelope(String token,String keyword){
  String S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+="<SOAP-ENV:Envelope";
  S+="   xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/'";
  S+="   xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/'";
  S+="   xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'";
  S+="   xmlns:xsd='http://www.w3.org/2001/XMLSchema'";
  S+="   SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <namesp1:KeywordSearchRequest xmlns:namesp1='urn:PI/DevCentral/SoapService'>";
  S+="      <KeywordSearchRequest xsi:type='namesp1:KeywordRequest'>";
  S+="        <keyword >"+keyword+"</keyword>";
  S+="        <page >1</page>";
  S+="        <mode >books</mode>";
  S+="        <tag >webservices-20</tag>";
  S+="        <type >lite</type>";
  S+="        <devtag >"+token+"</devtag>";
  S+="        <format >xml</format>";
  S+="        <version >1.0</version>";
  S+="      </KeywordSearchRequest>";
  S+="    </namesp1:KeywordSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
public static String doAmazonKeywordSearch(String token,String keyword)throws IOException{
  return sendSoap("http://soap.amazon.com/onca/soap",
                    "KeywordSearchRequest",
                  doAmazonKeywordSearchEnvelope(token,keyword));

}

public static void main(String[]args)throws IOException{
  if(args.length==0){
    System.out.println("usage: java XmlHttp keywordForAmazonTestSearch");
    return;
    }
  String token="D2Y0P98RA19J1K";
  System.out.println(doAmazonKeywordSearch(token,args[0]));
}

}
