<%@page import="com.mysql.cj.protocol.Resultset"%>
<html>
<body bgcolor="grey">
<%@page import="java.sql.*" %>

<%
Connection con=null;

Class.forName("com.mysql.cj.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/mondee";
String un="root";
String pass="root";

con=DriverManager.getConnection(url, un, pass);

String id=request.getParameter("id");  // accepting this values from QUERY STRING i.e. <a href="accept.jsp?id=<%=rs.getInt(1)>
int aid=Integer.parseInt(id);

String dname=(String)session.getAttribute("name");  // GETTING SESSION VALUE FROM DoctorLogin.java

PreparedStatement ps=con.prepareStatement("update appointment set status=?,dname=? where aid=?");

	ps.setString(1, "Accepted");
	ps.setString(2, dname);
	ps.setInt(3, aid);
	
	int x=ps.executeUpdate();
	
	if(x!=0)
		response.sendRedirect("view_appointment.jsp");
%>

</body>
</html>