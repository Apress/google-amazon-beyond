package soapUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File2StdOut{

public static void file2StdOut(String name){
 int lines=0; String S="";
 try{
  BufferedReader bR=new BufferedReader(new FileReader(name));
  for(S=bR.readLine();S!=null;S=bR.readLine()){
      lines++;
      System.out.println(S);
      }
  }catch(IOException ex){
    System.out.println(
      "<exception>\n"
      +" <method>file2StdOut</method>\n"
      +" <line>"+lines+"</line>\n"
      +" <lastVal>"+S+"</lastVal>\n"
      +" <err>"+ex+"</err>\n"
      +"</exception>\n");
   }
 }
public static void main(String[]args){
  file2StdOut(args[0]);
}
}
