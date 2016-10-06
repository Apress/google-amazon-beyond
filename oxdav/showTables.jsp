<%@ page  errorPage="error.jsp" contentType="text/html"
   import="java.sql.*"
%><html><head><title> RDB Contents</title></head>
<body>
<%
/* 
Show the three tables.
*/
Connection con=null; Statement stmt=null; 
try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	
	con = DriverManager.getConnection(
		"jdbc:mysql://localhost/wsbkdb?user=tjm&password=tjm");

  stmt = con.createStatement();

ResultSet rs=null;
try{StringBuffer sB=new StringBuffer();
     sB.append("<table border='1'><tr><th>topicID</th><th>header</th>");
     sB.append("<th>fullValue</th></tr>\n");
      rs=stmt.executeQuery("SELECT * FROM topics");
      while(rs.next()){sB.append("<tr>\n");
        for(int i=1;i<=3;i++)
          sB.append(" <td>").append(rs.getString(i)).append("</td>\n");
        sB.append("</tr>\n");
       }
      sB.append("</table>\n");
      out.write(sB.toString());
    }catch(Exception ex){ex.printStackTrace();
    }finally{
     if(rs!=null)try{rs.close();}catch(Exception ex){}
    }

try{StringBuffer sB=new StringBuffer();
     sB.append("<table border='1'><tr><th>assocID</th><th>partName</th>");
     sB.append("<th>partValue</th></tr>\n");
      rs=stmt.executeQuery("SELECT * FROM parts");
      while(rs.next()){sB.append("<tr>\n");
        for(int i=1;i<=3;i++)
          sB.append(" <td>").append(rs.getString(i)).append("</td>\n");
        sB.append("</tr>\n");
       }
      sB.append("</table>\n");
      out.write(sB.toString());
    }catch(Exception ex){ex.printStackTrace();
    }finally{
     if(rs!=null)try{rs.close();}catch(Exception ex){}
    }


   }finally {
    if(stmt!=null)try{stmt.close();stmt=null;}catch(Exception ex){}
    if(con!=null)try{con.close();con=null;}catch(Exception ex){}
  }
%>
</body></html>

