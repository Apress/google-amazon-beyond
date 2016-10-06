<%@ page  errorPage="error.jsp" contentType="text/html"
   import="java.sql.*,java.io.PrintWriter,java.io.Writer"
%><html><head><title> getLinks Contents</title></head>
<body>
<%
  webappPrefix= request.getRequestURL().toString();
  int nameLoc=webappPrefix.indexOf("openXMLctl.jsp");
  if(nameLoc >=0) webappPrefix=webappPrefix.substring(0,nameLoc);
  webappPrefix+="res";
   %>
Given a query, we're trying to find the docItems which match
them and produce links to those items.

<%
Connection con=null; Statement stmt=null; 
String dbStr="jdbc:mysql://localhost/wsbkdb?user=tjm&password=tjm";
PrintWriter pw=new PrintWriter(out,true);
String linkedTo=request.getParameter("linkedTo");
String partName=request.getParameter("partName");
String partValue=request.getParameter("partValue");
String topicNameStr=request.getParameter("topicNameStr");
String topicIDStr=request.getParameter("topicIDStr");
String matchType=request.getParameter("matchType");
String queryStr=request.getParameter("queryStr");
if(linkedTo==null)linkedTo="";
if(partName==null)partName="";
if(partValue==null)partValue="";
if(topicNameStr==null)topicNameStr="";
if(topicIDStr==null)topicIDStr="";
if(matchType==null)matchType="";
if(queryStr==null)queryStr="";
try{
  Class.forName("com.mysql.jdbc.Driver").newInstance();
  con = DriverManager.getConnection(dbStr);
  stmt = con.createStatement();
  if(linkedTo.length() > 0)showLinks(linksTo(linkedTo,stmt,pw),pw);
  if(partName.length() > 0 && partValue.length() > 0)
     showLinks(hasNameVal(partName,partValue,matchType,stmt,pw),pw);
  if(topicNameStr.length() > 0)
     showLinks(topicNameContains(topicNameStr,stmt,pw),pw);
  if(topicIDStr.length() > 0)
     showLinks(topicIDContains(topicIDStr,stmt,pw),pw);
}catch(Exception ex)
 {ex.printStackTrace(pw);
}finally{
  if(stmt!=null){try{stmt.close();}catch(Exception e){}}
  stmt=null;
  if(con!=null){try{con.close();}catch(Exception e){}}
  con=null;
 }
%>
<script>
 function beforeString(S,c){
  S=""+S; // make sure it's a string
  var n=S.indexOf(c);
  if(n<0)return S;
  return S.substring(0,n);
}
</script>
<form action="openXMLctl.jsp" method="GET">
<table>
<tr><td>localLink</td><td><input type="text" name="linkedTo" size="80"/>
<input type="button" value="current doc" 
onclick="this.form.linkedTo.value=beforeString(parent.dataFrame.location,'#')"/>
</td></tr>
<tr><td>topicName contains</td><td><input type="text" name="topicNameStr"/>
topicID contains <input type="text" name="topicIDStr"/>
</td></tr>
<tr><td>Name/Value</td>
<td><input type="text" name="partName"/>
<select name="matchType">
  <option value="startsWith">startsWith</option>
  <option value="equals">equals</option>
  <option selected="1" value="contains">contains</option>
  <option value="endsWith">endsWith</option>
</select>
<input type="text" name="partValue"/>
</td></tr>
<tr style="display:none">
  <td>topicID,prettyName,partValue query</td>
  <td><input type="text" name="queryStr" size="80"/></td>
</tr>

</table>
<input type="submit" value="go"/>
</form>
</body></html><%!

 public String webappPrefix="http://localhost:8080/oxdav/res";

 public String itemURL(String item)throws Exception{
  // given /openXML/MyerhoffUnitStructured.htm_1_10_2
  // produce http://localhost:8080/oxdav/openXML/res/Myer...htm#s_10_2
  return webappPrefix+item;
 }
  public String[][] linksTo(String docItem,Statement stmt,Writer out){
  return hasNameEqValLike("localLink",docItem,stmt,out);
}

 public String[][] hasNameEqValLike(String nam,String val,Statement stmt,Writer out){
   ResultSet rs=null; String[][]res={};
   if(nam==null || val==null)return res;
   String qStr="SELECT topicID,partValue FROM parts WHERE partName='"+nam+"' AND partValue LIKE '"+val+"%' ORDER BY topicID";
   return getStringSeqs(qStr,nam,stmt,out);
}
 public String[][] getStringSeqs(String qStr,String mid,Statement stmt,Writer out){
   ResultSet rs=null; String[][]res={};
 try{
   rs=stmt.executeQuery(qStr);
   if(!rs.next())return res;
   rs.last(); int rowCount=rs.getRow(); rs.first();  
   res=new String[rowCount][3];
   for(int i=0;i<rowCount;i++){res[i][0]=itemURL(rs.getString(1)); res[i][1]=mid; res[i][2]=rs.getString(2); rs.next();}
    }catch(Exception ex){ex.printStackTrace(new PrintWriter(out,true));
    }finally{
      if(rs!=null)try{rs.close();}catch(Exception e){}
      rs=null;
      }
   return res;
}
 public String[][] topicNameContains(String cont,Statement stmt,Writer out){
   String qStr="SELECT topicID,header FROM topics WHERE header LIKE '%"+cont+"%' ORDER BY topicID";
   return getStringSeqs(qStr,"name",stmt,out);
}
 public String[][] topicIDContains(String cont,Statement stmt,Writer out){
   String qStr="SELECT topicID,header FROM topics WHERE topicID LIKE '%"+cont+"%' ORDER BY topicID";
   return getStringSeqs(qStr,"name",stmt,out);
}
public void showLinks(String[][]links,PrintWriter out)throws Exception{
  if(links==null)return;
  out.println("<p>");
  for(int i=0;i<links.length;i++)
    out.println("<a target='dataFrame' href='"+links[i][0]+"'>"
                +links[i][0]+"</a> \n"
                +" has "+links[i][1]+" "+links[i][2]+" <br/>"); 
  out.println("</p>");
}
public String[][]hasNameVal(String partName,String partValue,String matchType,
                            Statement stmt, PrintWriter pw){
  if("startsWith".equalsIgnoreCase(matchType))partValue+="%";
  else if("endsWith".equalsIgnoreCase(matchType))partValue="%"+partValue;
  else if("contains".equalsIgnoreCase(matchType))partValue="%"+partValue+"%";
  String qStr="SELECT topicID,partValue FROM parts WHERE partName='"+
           partName+"' AND partValue LIKE '"+partValue+"' ORDER BY topicID";
  return getStringSeqs(qStr,partName,stmt,pw);
}
%>


