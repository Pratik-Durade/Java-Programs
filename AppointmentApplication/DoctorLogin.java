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
import javax.servlet.http.HttpSession;

public class DoctorLogin extends HttpServlet {
	
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
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		System.out.println("\n\n \tLOGIN SUCCESSFULLY... \n");
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
				
		PrintWriter pw=resp.getWriter();
		
		String query="select * from doctor where name=? and password=?";
		
		try {
			
			pst=con.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
		
			
			// SETTING SESSION VALUES FOR ALL PAGES.
			
			HttpSession hs=req.getSession();
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
//				pw.println("<html><body bgcolor='cyan'><h1 align='center'>");
//				pw.println("Login Successfully</h1></body></html>");
				
				
			//  PASSING SESSION VALUES....
				hs.setAttribute("name", username);
				hs.setAttribute("id", rs.getInt(1));
				hs.setAttribute("specialist", rs.getString("specialist"));
				resp.sendRedirect("./doctor_home.html");
							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
