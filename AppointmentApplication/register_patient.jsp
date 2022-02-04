<html>
<body bgcolor="wheat">

<%@page import="java.sql.*" %>

<%
Connection con=null;
PreparedStatement pst=null;
Class.forName("com.mysql.cj.jdbc.Driver");

String url="jdbc:mysql://localhost:3306/mondee";
String username="root";
String password="root";

con=DriverManager.getConnection(url, username, password);

System.out.println("\n\n \tDATA ADDED SUCCESSFULLY... \n");
	
	String name=request.getParameter("username");
	String pass=request.getParameter("password");
	String email=request.getParameter("email");
	String phone=request.getParameter("phone");
	long mobile=Long.parseLong(phone);
	String address=request.getParameter("address");
		
	String query="insert into patient (name,password,email,phone,address) values(?,?,?,?,?)";

	pst=con.prepareStatement(query);
	pst.setString(1, name);
	pst.setString(2, pass);
	pst.setString(3, email);
	pst.setLong(4, mobile);
	pst.setString(5, address);
	
	int count=pst.executeUpdate();
	
	if(count!=0)
		response.sendRedirect("./patient_login.html");
	


%>

</body>
</html>