package soapUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Uri2StdOut{

public static void uri2StdOut(String name){
 int lines=0; String S="";
 try{
  BufferedReader bR=
    new BufferedReader(
      new InputStreamReader( new URL(name).openStream() ) );
  for(S=bR.readLine();S!=null;S=bR.readLine()){
      lines++;
      System.out.println(S);
      }
  }catch(IOException ex){
    System.out.println(
      "<exception>\n"
      +" <method>uri2StdOut</method>\n"
      +" <line>"+lines+"</line>\n"
      +" <lastVal>"+S+"</lastVal>\n"
      +" <err>"+ex+"</err>\n"
      +"</exception>\n");
   }
 }
public static void main(String[]args){
  uri2StdOut(args[0]);
}
}
