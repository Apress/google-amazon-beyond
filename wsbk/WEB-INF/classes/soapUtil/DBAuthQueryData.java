package soapUtil;

public class DBAuthQueryData extends DBQueryData {
public DBAuthQueryData(){}
protected String qAuth=""; // can be "", "user", or "admin"
  public void setQAuth(String S){qAuth=S;} 
  public String getQAuth(){return qAuth;}

protected String[]qValArray=null;
public String[]getQValArray(){return qValArray;}

protected int paramCount=0;
public int getParamCount(){return paramCount;}

public void setQTypes(String S){
  qTypes=S;  paramCount=0; int minParams=0;
  if(S==null||S.length()==0){qTypeArray=new String[0]; return;}
  int nc=0;for(int i=0;i<S.length();i++)if(S.charAt(i)==',')nc++;
  qTypeArray=new String[nc+1];
  qValArray=new String[nc+1];
  java.util.StringTokenizer st=new java.util.StringTokenizer(S,",");
  for(int j=0; st.hasMoreTokens(); j++){
    String typeVal=st.nextToken();
    int delimLoc=typeVal.indexOf('=');
    if(delimLoc<0){qTypeArray[j]=typeVal;qValArray[j]=""; paramCount++;}
    else{
      String qT=typeVal.substring(0,delimLoc);
      String qV=typeVal.substring(delimLoc+1);
      qTypeArray[j]=qT;
      qValArray[j]=qV;
      for(int nLoc=qV.indexOf('$');nLoc>=0;nLoc=qV.indexOf('$',nLoc+1)){
        int pLoc=qV.indexOf('+',nLoc); if(pLoc < 0) pLoc=qV.length();
        String nStr=qV.substring(nLoc+1,pLoc);
        try{int N=Integer.parseInt(nStr); if(N>minParams)minParams=N;
        }catch(Exception ex){System.out.println("Error parsing ["+nStr+"] from ["+qV+"] as integer");}
      }
    }
  }
  if(minParams > paramCount)paramCount = minParams; // found ref $i otherwise unused.
}
public String getQType(int i){
  String S=qValArray[i];
  if(S.length()==0)return qTypeArray[i];
  return qTypeArray[i]+"="+S;
}
public String getQTypes(){
  if(qTypeArray==null || qTypeArray.length==0)return "";
  StringBuffer sB=new StringBuffer().append(getQType(0));
  for(int i=1;i<qTypeArray.length;i++)
    sB.append(",").append(getQType(i));
  return sB.toString();
}
public String toString(){
  return "{qID:"+qID+";\n   qAuth:"+qAuth+";\n   qStr:"+qStr+";\n   qTypes="+getQTypes()+"}";
  }

}
