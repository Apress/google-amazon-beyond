package soapUtil;
import java.security.*; 

public class AmazonApplet_2 extends java.applet.Applet{
 public String version(){return "AmazonApplet_2.01";}

public String doAmazonKeywordSearch(final String token,final String keyword){
  PrivilegedAction pA= new PrivilegedAction(){
    public Object run() {
      try{return XmlHttp.doAmazonKeywordSearch(token,keyword);
      } catch(Exception e) {e.printStackTrace(); return ""+e; }
      }
    };
  return (String)AccessController.doPrivileged(pA);
  }


}


