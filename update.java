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

@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String t=request.getParameter("tf");
		String bn1=request.getParameter("bus_name");
		String sf=request.getParameter("seat_fac");
		String f=request.getParameter("fac");
		String tm=request.getParameter("Time");
		String r=request.getParameter("rate");
		String ns=request.getParameter("no_of_seat");
		String bn=request.getParameter("bus_no");
		
		book b1=new book();
		b1.setTravel_From(t);		
		b1.setBus_Name(bn1);
		b1.setSeating_Facility(sf);
		b1.setFacility(f);
		b1.setTravelling_Time(tm);
		b1.setRate(r);
		b1.setNo_Of_Seats(ns);
		b1.setBus_Number(bn);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); // register driver 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root",""); 
            PreparedStatement ps=con.prepareStatement("update bookings set Travel_From=?,Bus_Name=?,Seating_Facility=?,Facility=?,Travelling_Time=?,Rate=?,Number_Of_Seats=? where Bus_Number=?");
            ps.setString(1,t);
            ps.setString(2,bn1);
            ps.setString(3,sf);
            ps.setString(4,f);
            ps.setString(5,tm);
            ps.setString(6,r);
            ps.setString(7,ns);
            ps.setString(8,bn);
           
            int k=ps.executeUpdate();
            if(k>0)
            {
              	response.sendRedirect("booking.jsp");
            }
            else
            {
            	pw.print("No Updation in booking");
            }
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}

}
