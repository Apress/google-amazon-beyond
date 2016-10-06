package soapUtil;

public class DBQueryData {
public DBQueryData(){}
protected String qStr="";
  public void setQStr(String S){qStr=S;} 
  public String getQStr(){return qStr;}

protected String qTypes="";
protected String[]qTypeArray=null;
  public void setQTypes(String S){
   qTypes=S; 
   if(S==null||S.length()==0){qTypeArray=new String[0]; return;}
   int nc=0;for(int i=0;i<S.length();i++)if(S.charAt(i)==',')nc++;
   qTypeArray=new String[nc+1];
   java.util.StringTokenizer st=new java.util.StringTokenizer(S,",");
   for(int j=0; st.hasMoreTokens(); j++)qTypeArray[j]=st.nextToken();
  } 
  public String getQTypes(){
   if(qTypeArray==null || qTypeArray.length==0)return "";

   StringBuffer sB=new StringBuffer().append(qTypeArray[0]);
   for(int i=1;i<qTypeArray.length;i++)
     sB.append(",").append(qTypeArray[i]);
    return sB.toString();
  }
  public String[]getQTypeArray(){return qTypeArray;}

protected String qID="";
  public void setQID(String S){qID=S;} 
  public String getQID(){return qID;}
public String toString(){
  return "{qID:"+qID+";\n   qStr:"+qStr+";\n   qTypes="+getQTypes()+"}";
  }
}
