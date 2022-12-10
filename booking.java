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

@WebServlet("/booking")
public class booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String t=request.getParameter("tf");
		String bn=request.getParameter("bus_no");
		String bn1=request.getParameter("bus_name");
		String sf=request.getParameter("seat_fac");
		String f=request.getParameter("fac");
		String tm=request.getParameter("Time");
		String r=request.getParameter("rate");
		String ns=request.getParameter("no_of_seat");
		
		book b1=new book();
		b1.setTravel_From(t);
		b1.setBus_Number(bn);
		b1.setBus_Name(bn1);
		b1.setSeating_Facility(sf);
		b1.setFacility(f);
		b1.setTravelling_Time(tm);
		b1.setRate(r);
		b1.setNo_Of_Seats(ns);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); // register driver 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root",""); 
            PreparedStatement ps=con.prepareStatement("insert into bookings values(?,?,?,?,?,?,?,?)");
            ps.setString(1,t);
            ps.setString(2,bn);
            ps.setString(3,bn1);
            ps.setString(4,sf);
            ps.setString(5,f);
            ps.setString(6,tm);
            ps.setString(7,r);
            ps.setString(8,ns);
           
            int k=ps.executeUpdate();
            if(k>0)
            {
              	response.sendRedirect("booking.jsp");
            }
            else
            {
            	pw.print("Not accept to booking");
            }
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}

}
