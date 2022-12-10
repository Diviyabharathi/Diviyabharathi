package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cancel")
public class cancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String bn=request.getParameter("bus_no");
		
		book b1=new book();
		
		b1.setBus_Number(bn);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); // register driver 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root",""); 
            PreparedStatement ps=con.prepareStatement("delete from bookings where Bus_Number=?");
            
            ps.setString(1,bn);
           
            int k=ps.executeUpdate();
            if(k>0)
            {
              	response.sendRedirect("booking.jsp");
            }
            else
            {
            	pw.print("Cancellation of  booking is not done");
            }
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}

}
