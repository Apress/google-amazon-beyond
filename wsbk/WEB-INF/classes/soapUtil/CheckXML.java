package soapUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class CheckXML{

public static BufferedReader uri2BufferedReader(String name)
  throws IOException {
  return new BufferedReader(
           new InputStreamReader( new URL(name).openStream() ) );
}
public static BufferedReader file2BufferedReader(String name)
  throws IOException {
  return new BufferedReader(
           new FileReader(name) );
}

public static void name2StdOut(String name){
 int lines=0; String S=""; BufferedReader bR=null;
 Handler handler=new Handler();
 try{
   if(name.startsWith("http")) bR=uri2BufferedReader(name);
   else bR=file2BufferedReader(name);
    for(S=bR.readLine();S!=null;S=bR.readLine()){
      lines++;
      handler.readLine(S);
      }
  }catch(Exception ex){
    System.out.println(
      "<exception>\n"
      +" <method>name2StdOut</method>\n"
      +" <line>"+lines+"</line>\n"
      +" <lastVal>"+S+"</lastVal>\n"
      +" <err>"+ex+"</err>\n"
      +"</exception>\n");
   }
}


public static void main(String[]args){
  name2StdOut(args[0]);
}
}

class Handler {
  boolean trace=true;

  final int AT_START=0;
  final int IN_TAGNAME=1;
  final int IN_ATTRS=2;
  final int IN_TEXT=3;

  int state=AT_START;
  StringBuffer sB=new StringBuffer();
  String[]tagStack=new String[10];
  int tagStackN=0;
  public void stackPush(String S){
    if(tagStackN==tagStack.length){
      String[]tmp=new String[tagStack.length*2];
      for(int i=0;i<tagStackN;i++)tmp[i]=tagStack[i];
      tagStack=tmp;
      }
    tagStack[tagStackN++]=S;
  }
  public String stackTop(){return tagStack[tagStackN-1];}
  public String stackPop(){return tagStack[--tagStackN];}
  public boolean stackEmpty(){return tagStackN==0;}

  String indentStr="**********";
  public String indent(){
    while(indentStr.length() < tagStackN)indentStr+=indentStr;
    return indentStr.substring(0,tagStackN);
  }
  public Handler(){}
  public void readLine(String S)throws Exception{
   if(S==null)return;
   for(int i=0;i<S.length();i++)readChar(S.charAt(i));
  }
  public void readChar(char ch)throws Exception{
    if(ch=='<')readLT();
    else if(ch=='>')readGT();
    else if(ch <= ' ') readWS();
    else sB.append(ch);
  }
  public void readLT()throws Exception{
    if(state==IN_TAGNAME || state==IN_ATTRS)
       throw new Exception("unexpected '<' in tag "+sB.toString());
    state=IN_TAGNAME;
    sB.setLength(0);
  }
  public void readGT()throws Exception{
    if(state==AT_START)
      throw new Exception("unexpected '>' at start");
    if(state==IN_TEXT)
      throw new Exception("unexpected '>' in text");
    if(state==IN_TAGNAME)readTagName();
    state=IN_TEXT;
  }
  public void readWS()throws Exception{
    if(state==IN_TAGNAME)readTagName();
  }
  public void readTagName()throws Exception{
    String tag=sB.toString(); sB.setLength(0); state=IN_ATTRS;
    if(!tag.startsWith("/")) {
      stackPush(tag);
      if(trace)System.out.println(indent()+tag);
      return;
      }
    if(stackEmpty())
      throw new Exception("cannot match '"+tag+"' with empty stack");
    if(trace)System.out.println(indent()+tag);
    tag=tag.substring(1);
    String prev=stackPop();
    if(!tag.equals(prev))
      throw  new Exception("cannot match '"+tag+"' to '"+prev+"'"); 
    state=IN_ATTRS;
  }

}
