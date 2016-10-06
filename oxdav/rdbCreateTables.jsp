<%@ page  errorPage="error.jsp" contentType="text/html"
   import="java.sql.*"
%><html><head><title>Initializing RDB</title></head>
<body>
<h1>preliminary setup</h1>
<pre>
C:\mysql\bin>mysql -u root
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 10 to server version: 3.23.52-nt

Type 'help;' or '\h' for help. Type '\c' to clear the buffer.

mysql> create database wsbkdb;
Query OK, 1 row affected (0.07 sec)

mysql> grant all privileges on wsbkdb.* to 'tjm'@'localhost' identified by 'tjm';
Query OK, 0 rows affected (0.37 sec)

mysql> flush privileges;
Query OK, 0 rows affected (0.05 sec)

Then call this page to create the two tables: topics and parts.
</pre>
<%
Connection con=null; Statement stmt=null; 
try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	
	con = DriverManager.getConnection(
		"jdbc:mysql://localhost/wsbkdb?user=tjm&password=tjm");

  stmt = con.createStatement();
try{stmt.executeUpdate("DROP TABLE parts");}
catch(Exception ex){out.write("<br/>ERR: unable to drop 'parts' table\n"+ex+"\n");}
try{stmt.executeUpdate("DROP TABLE topics");}
catch(Exception ex){out.write("<br/>ERR: unable to drop 'topics' table\n"+ex+"\n");}
try{
    stmt.executeUpdate(
     "CREATE TABLE parts (topicID VARCHAR(64) NOT NULL,partName VARCHAR(64) NOT NULL,partValue TEXT, PRIMARY KEY (topicID,partName))");
   %><br/>Table
   parts(topicID,partName, partValue)
   okay (topicID and partName must be non-null, and unique in combination)<br/><%
}catch(Exception ex){ex.printStackTrace(new java.io.PrintWriter(out));}

try{
    stmt.executeUpdate(
     "CREATE TABLE topics (topicID VARCHAR(64) NOT NULL PRIMARY KEY, header TEXT, fullValue TEXT)"
     );
   %>Table
   topics(topicID,header,fullValue)
   okay (topicID must be non-null unique) <br/> <%
}catch(Exception ex){ex.printStackTrace(new java.io.PrintWriter(out));}
   }finally {
    if(stmt!=null)try{stmt.close();stmt=null;}catch(Exception ex){}
    if(con!=null)try{con.close();con=null;}catch(Exception ex){}
  }
%>
</body></html>

