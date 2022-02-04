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

String pname=request.getParameter("pname");
String doa=request.getParameter("doa");
String toa=request.getParameter("toa");
String specialist=request.getParameter("specialist");

String sql="insert into appointment(pid,pname,dname,doa,toa,specialist,status) values(?,?,?,?,?,?,?)";

int pid=(Integer)session.getAttribute("id");  // GETTING SESSION VALUE FROM login_patient.jsp

PreparedStatement ps=con.prepareStatement(sql);

ps.setInt(1,pid);
ps.setString(2,pname);
ps.setString(3,"None");		// don't know which doc accept the req.
ps.setString(4,doa);
ps.setString(5,toa);
ps.setString(6,specialist);
ps.setString(7,"Pending");

int x=ps.executeUpdate();

if(x!=0)
	response.sendRedirect("appointment_applied.jsp");
%>


</body>
</html>