 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader ("Expires", 0);
	
	if(session.getAttribute("session_id") == null) {
		response.sendRedirect("loginAdmin.jsp");
	}
%>

    <!DOCTYPE html>
<html>
<head>
  
  
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.24/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.24/datatables.min.js"></script>
<link rel="stylesheet" href="assets/panel.css">
<link href="assets/dist/css/bootstrap.css" rel="stylesheet">
  <title>profile</title>
  <script>
      $(document).ready( function () {
          $('#table_id').DataTable();
      } );
  </script>
  
</head>
<body>
  <div class="sidenav">
    <img src="assets/logo.png" style="width: 160px; margin: 20px 0px 0px 15px;" alt="">
    
    <a href="AdminRedirectController?action=adminprofile" ><i class="fa fa-fw fa-user"></i>Profile</a>
    <a href="AdminRedirectController?action=adminmenu" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Menu</a>
    <a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Order</a>
    <a href="#"><i class="fa fa-database" aria-hidden="true"></i>Report</a>
    <a href="AdminRedirectController?action=riderMgt" class="active"><i class="fa fa-motorcycle" aria-hidden="true"></i>Rider</a>
    <a href="LogoutAdminController"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a>
  </div>
  <div class="main">
    <div class="header"><h1>Rider Management</h1></div>
 	
 	
 	<!--table rider -->
 	
 	<div>
  	<table id="table_id" class="display">
  		<thead>
        <tr>
          
          <th>Id</th>
          <th>Name</th>
          <th>Email</th>
          <th>Address</th>
          <th>Phone </th>
        
        </tr>
      </thead>
  		<tbody>
      	<c:forEach items="${riderlist}" var="r">
        <tr>
          
          <td><c:out value="${r.id}"/></td>
          <td><c:out value="${r.name}"/></td>
          <td><c:out value="${r.email}"/></td>
          <td><c:out value="${r.address}"/></td>
          <td><c:out value="${r.phone}"/></td>
          
        </tr>
        </c:forEach>
      </tbody>
  	</table>
  <button class="btn btn-outline-primary" onclick="window.location.href='../rider/registerRider.jsp'">Add New Rider</button>
  
  </div>
 	
  </div>
  
  
</body>
</html>