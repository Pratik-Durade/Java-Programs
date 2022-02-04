package com.mondee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Doctor_Select extends HttpServlet{
	
	Connection con=null;
	PreparedStatement pst=null;
	public void init(ServletConfig config)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/mondee";
		String username="root";
		String password="root";
		
		try {
			con=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		System.out.println("\n\n \tDATA RETRIEVED SUCCESSFULLY... \n");
		
		String id1=req.getParameter("id");
		int id=Integer.parseInt(id1);
		//String specialist=req.getParameter("specialist");
		
		PrintWriter pw=resp.getWriter();
		
		String query="select * from doctor where id=?";
		
		try {
			
			pst=con.prepareStatement(query);
			pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
			
			rs.next();
			pw.println("<html><body bgcolor='cyan'><h1 align='center'>");
			pw.println("<Doctor Details><br>ID : "+rs.getInt(1)+"<br> Name : "+rs.getString(2)+"<br> Password : "+rs.getString(3)+"<br> E-mail : "+rs.getString(4)+"<br> Phone : "+rs.getInt(5)+"<br> Specialist : "+rs.getString(6)+"<br><br>"+"\nData Retrieved Successfully</h1></body></html>");
			
//			if(rs!=0)
//				pw.println("<html><body bgcolor='cyan'><h1 align='center'>");
//				pw.println("Registered Successfully</h1></body></html>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
