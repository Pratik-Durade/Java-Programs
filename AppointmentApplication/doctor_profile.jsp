<html>
<body bgcolor="cyan">
<%@page import="java.sql.*" %>
<br><br>
	
	<table align="center" width="1000px" border="1px">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<!-- <th>Password</th> -->  <!-- for dr. profile password is not required -->
			<th>Email</th>
			<th>Phone</th>
			<th>Specialist</th>	
		</tr>
		
		<%	
		Connection con=null;
		PreparedStatement ps=null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/mondee";
		String username="root";
		String password="root";
		
		con=DriverManager.getConnection(url, username, password);
		
		// GETTING SESSION VALUES FROM SERVER
		int id=(Integer)session.getAttribute("id");   // we have to convert it into Object
		session.getAttribute("id");
		session.getAttribute("specialist");
		
		
		ps=con.prepareStatement("select * from doctor where id=?");
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			%>
			<tr style="text-align:center;"> <!--  for new line -->
			<td><%= rs.getInt(1)%></td>
			<td><%= rs.getString(2)%></td>
			<!-- <td><%= rs.getString(3)%></td>  -->  <!-- for dr. profile password is not required -->
			<td><%= rs.getString(4)%></td>
			<td><%= rs.getString(5)%></td>
			<td><%= rs.getString(6)%></td>
			</tr>
			<%
		}
	
		%>	
	</table>
</body>
</html>