import localhost.axis.Factorial_jws.*;
import java.net.URL;

public class FactorialClient {

public static void main(String[]args){
  if(args.length==0){
    System.out.println("usage: FactorialClient N [ http://... ]");
    return;
    }
  int N=Integer.parseInt(args[0]);
  String uriStr="http://localhost:8080/axis/Factorial.jws";
  if(args.length > 1) uriStr=args[1];

  try{
    System.out.println("seeking "+N+"! at "+ uriStr);
    URL url=new URL(uriStr);
    FactorialServiceLocator fSL=new FactorialServiceLocator();
    Factorial f = fSL.getFactorial(url);
    int res=f.factorial(N);
    System.out.println(uriStr+"\n  ... says that "+N+"! is "+res);
  }catch(Exception ex){ex.printStackTrace();}
}

}
