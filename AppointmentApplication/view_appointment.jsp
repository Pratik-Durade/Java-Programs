<html>
<body bgcolor="cyan">
<%@page import="java.sql.*" %>
<br><br>
	
	<table align="center" width="1000px" border="1px">
		<tr>
			<th>ID</th>
			<th>Patient Name</th>
			<!-- <th>Password</th> -->  <!-- for dr. profile password is not required -->
			<th>Date</th>
			<th>Time</th>
			<th>Specialist</th>	
			<th>Status</th>	
			<th>Action</th>	
		</tr>
		
		<%	
		Connection con=null;
				
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/mondee";
		String username="root";
		String password="root";
		
		con=DriverManager.getConnection(url, username, password);
		
		// GETTING SESSION VALUES FROM SERVER i.e(specialist)
//		int id=(Integer)session.getAttribute("id");   // we have to convert it into Object
		
		String specialist=(String)session.getAttribute("specialist");
		
		// session.getAttribute("id");
		// session.getAttribute("specialist");
		
		
		PreparedStatement ps=con.prepareStatement("select * from appointment where specialist=?");
		ps.setString(1,specialist);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			%>
			<tr style="text-align:center;"> <!--  for new line -->
			<td><%= rs.getInt(1)%></td>  <!-- rs.getInt(1) has appointment ID value -->
			<td><%= rs.getString("pname")%></td>
													<!-- <td><%= rs.getString(3)%></td>  -->  <!-- for dr. profile password is not required -->
			<td><%= rs.getString("doa")%></td>
			<td><%= rs.getString("toa")%></td>
			<td><%= rs.getString("specialist")%></td>
			<td><%= rs.getString("status")%></td>
			
			<td><a href="accept.jsp?id=<%=rs.getInt(1)%>">Accept</td>   <!-- this is ( QUERY STRING or URL Re-Writing )-->
					<!-- in above line ?id is variable which store appointment ID to approve status for particular patient
						
							this ?id value go into accept.jsp page so Doc can accept Req of particular user
					 -->
			
			
			</tr>
			<%
		}
	
		%>	
	</table>
</body>
</html>