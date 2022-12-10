package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String n=request.getParameter("name");
		String e=request.getParameter("email");
		String m=request.getParameter("mob");
		String a=request.getParameter("address");
		String p=request.getParameter("psw");
		
		
		Bean b=new Bean();
		b.setName(n);
		b.setEmail_Address(e);
		b.setPhone_Number(m);
		b.setAddress(a);
		b.setPassword(p);
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); // register driver 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root",""); 
            PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
            ps.setString(1,n);
            ps.setString(2,e);
            ps.setString(3,m);
            ps.setString(4,a);
            ps.setString(5,p);
           
           
            int k=ps.executeUpdate();
            if(k>0)
            {
            
            	pw.print("Registration is Successful");
            	response.sendRedirect("login.html");
            	
            }
            else
            {
            	pw.print("not add data");
            }
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		}

}
