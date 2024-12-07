<%@page import="javax.websocket.Session"%>
<%@page import="java.util.Enumeration"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Product</title>
</head>
<body>
<center>
<%-- <%
    Enumeration<String> enm = session.getAttributeNames();
%>
 --%>
<h2>Registered Student</h2>
<table border="1">
    <th>
        <tr>
        	<th>Student Id</th>
            <th>Student Name</th>
            <th>Student Address</th>
            <th>Student Fees</th>
           <!--  <th>Delete a Student</th>
            <th>Update a Student</th> -->
            
        </tr>
    </th>
    <tbody>
     
      
     
            <tr>
            <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.addr}</td>
                <td>${student.fee}</td>
                <%-- <td><a href="delet?sid=${student.id}">Delete</a></td>
                <td><a href="edit?name=${student.name}&addr=${student.addr}&fee=${student.fee}&id=${student.id}">Update</a></td> --%>
            </tr>

        
    </tbody>
</table>
<br>
<a href="/StudentDetailWithServRepo/">Go To Home Page</a><br><br>

</center>
</body>
</html>