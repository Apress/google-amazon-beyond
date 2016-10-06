package soapUtil;
import java.security.*; // see SECURITY note below

public class AmazonApplet_1 extends java.applet.Applet{

  public String version(){return "AmazonApplet_1.01";}

  public String doAmazonKeywordSearch(String token,String keyword){
    PrivilegedAction pA=new AmazonKeywordSearch(token,keyword);
    return (String) AccessController.doPrivileged(pA);
  }
} // end of AmazonApplet_1


class AmazonKeywordSearch implements PrivilegedAction {
  private String token;
  private String keyword;
  public AmazonKeywordSearch(String t,String k){token=t; keyword=k;}
  public Object run(){
    try{return XmlHttp.doAmazonKeywordSearch(token,keyword);
    } catch(Exception e) {e.printStackTrace(); return ""+e; }
  }
}


/* 
SECURITY note: what we really want to say is very simple -- 

public String doAmazonKeywordSearch(String token,String keyword){
  try{return XmlHttp.doAmazonKeywordSearch(token,keyword);
  }catch(Exception ex){ex.printStackTrace(); return ""+ex;}
}
That's all. 
However, this involves a security check: it is not safe in general
for applets to go all over the net, because then somebody could put
an applet on a web page which would connect you with the world in
ways you wouldn't know about. So, we can learn all about signing
applets, or we can learn all about the policy tools, or we can cheat.
We're going to cheat: we're going to compile this soapUtil code via
  javac soapUtil/*.java
  jar -cf SoapApplet.jar soapUtil/*.class
and then move that jar to our JAVA_HOME's jre/lib/ext directory.
(If we have two, we'll put it in both just to save on thinking.)
That way, by default it has AllPermissions. As explained at
 http://java.sun.com/docs/books/tutorial/ext/security/policy.html
we can now run it by putting the dangerous code in the "run()"
method of a PrivilegedAction object, which we define as a
class.
*/


