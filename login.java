package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String n=request.getParameter("name");
		String p=request.getParameter("psw");
		try
		{
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root",""); 
	        PreparedStatement ps=con.prepareStatement("select Name,Password from register where Name=? and Password=?");
	        ps.setString(1,n);
	        ps.setString(2,p);
	        
	        ResultSet rs=ps.executeQuery();
	        if(rs.next())
	        {
	        	if(n.equals(rs.getString(1))&& p.equals(rs.getString(2)))
	        	{
	        		response.sendRedirect("User_Option.html");
	        	}
	        	else
	        	{
	        		pw.print("Incorrect User Name and Password");
	        		response.sendRedirect("login.html");
	        	}
	        }
	        
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
