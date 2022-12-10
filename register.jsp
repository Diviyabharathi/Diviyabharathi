<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body style="background-color:pink;">
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost/bus" user="root" password=""></sql:setDataSource>
<sql:query dataSource="${db}" var="rs">
select * from register;
</sql:query>
<div class="container">
<table border="4" style="border:2px solid grey;" class="table table-hover table-borderless caption-top ">
<caption style="color:blue;font-weight:bold; font-size:30px; text-align:center;"><i><b>USER DETAILS</b></i></caption>
<a href="Admin_Option.html" role="button" class="btn btn-group mt-4 btn-primary"><i><b>Admin Home Page</b></i><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
  <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
  <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
</svg></a>
<thead class="table-dark ">
<tr>
<th>Name</th>
<th>Email Address</th>
<th>Phone Number</th>
<th>Address</th>

<th>Password</th>
</tr>
</thead>

<tbody>
<c:forEach var="table" items="${rs.rows}">
<tr>
<td><c:out value="${table.Name}"/></td>
<td><c:out value="${table.Email_Address}"/></td>
<td><c:out value="${table.Phone_Number}"/></td>
<td><c:out value="${table.Address}"/></td>
<td><c:out value="${table.Password}"/></td>

</tr>
</c:forEach>
</tbody>
</table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>