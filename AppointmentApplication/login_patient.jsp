<html>
<body bgcolor="grey">
<%@page import="java.sql.*" %>

<%
Connection con=null;
PreparedStatement ps=null;

Class.forName("com.mysql.cj.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/mondee";
String un="root";
String pass="root";

con=DriverManager.getConnection(url, un, pass);

String username=request.getParameter("username");
String password=request.getParameter("password");



String query="select * from patient where name=? and password=? ";

ps=con.prepareStatement(query);
ps.setString(1,username);
ps.setString(2,password );

ResultSet rs=ps.executeQuery();

	if(rs.next())
		
		// CREATING SEESION VALUES FOR APPLY APPOINTMENT PAGE AND ALL PAGES ALSO
		session.setAttribute("id", rs.getInt(1));		// patient id from patient table
		
		response.sendRedirect("./patient_home.html");

%>
</body>
</html>