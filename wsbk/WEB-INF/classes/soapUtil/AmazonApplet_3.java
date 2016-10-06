package soapUtil;

// we do NOT need to import the security classes here.

public class AmazonApplet_3 extends SoapApplet{
 public String version(){return "AmazonApplet_3.01";}

public String doAmazonKeywordSearch(String token,String keyword){
  return sendSoap("http://soap.amazon.com/onca/soap",
                    "KeywordSearchRequest",
                    XmlHttp.doAmazonKeywordSearchEnvelope(token,keyword)
                    );

}


}


