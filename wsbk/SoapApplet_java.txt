package soapUtil;
import java.security.*; 

public class SoapApplet extends java.applet.Applet{

 public String version(){return "v.01";}

class Soaper implements PrivilegedAction {
  String urlString;String soapAction;String payload;
  public Soaper(String u,String a,String p){
    urlString=u;soapAction=a;payload=p;
  }
  public Object run(){
    try{return XmlHttp.sendSoap(urlString,soapAction,payload);
    } catch(Exception e) {e.printStackTrace(); return ""+e; }
  }
  public String sendSoap(){
    return (String)AccessController.doPrivileged(this);
  }
}

public String sendSoap(String url,String act,String env){
  return new Soaper(url,act,env).sendSoap();
}

}


