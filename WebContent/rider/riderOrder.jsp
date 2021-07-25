 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
	
	if(session.getAttribute("session_id") == null) {
		response.sendRedirect("loginRider.jsp");
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
<link rel="stylesheet" href="assets/panelRider.css">
<link href="assets/dist/css/bootstrap.css" rel="stylesheet">
  <title> profile </title>
  <script>
      $(document).ready( function () {
          $('#table_id').DataTable();
      } );
  </script>
  
</head>
<body>
  <div class="sidenav">
    <img src="assets/logo.png" style="width: 160px; margin: 20px 0px 0px 15px;" alt="">
    
    <a href="RiderRedirectController?action=riderprofile" ><i class="fa fa-fw fa-user"></i>Profile</a>
    
    <a href="RiderRedirectController?action=riderorder" class="active"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Order</a>
    
    <a href="LogoutRiderController"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a>
  </div>
  <div class="main">
    <div class="header"><h1>Manage Order</h1></div>
 		<div class="row">
                    <div class="col-lg-8">
                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fas fa-utensils"></i> Current Order List</div>
                            <div class="card-body">
                                <table id="tblCurrentOrder" table class="table table-bordered" width="100%" cellspacing="0">
                                    <thead>
                                        <th>Order #</th>
                                        <th>Customer Email</th>
                                        <th>Order Date</th>
                                        <th>Delivery Time</th>                                        
                                        <th class='text-center'>Status</th>
                                        <th class='text-center'>Rider</th>
                                        <th class='text-center'>Option</th>

                                    </thead>
									<c:forEach items="${orderlist}" var="o">
                                    <tr>
                                          <td><c:out value="${o.id}"/></td>
								          <td><c:out value="${o.custEmail}"/></td>
								          <td><c:out value="${o.orderdate}"/></td>
								          <td><c:out value="${o.time}"/></td>
								          <td><c:out value="${o.status}"/></td>
								           <td><c:out value="${o.rid}"/></td>
											<td>
									            <input type="button" class="w-40 btn btn-secondary"  value="Update" onclick="window.location.href='RiderRedirectController?action=updateorder&updateid=<c:out value="${o.id}"/>'">
									            <input type="button" class="w-40 btn btn-secondary" value="Delete" onclick="window.location.href='AdminRedirectController?action=deleteorder&deleteid=<c:out value="${o.id}"/>'">
									          </td>
                                    </tr>
                                    </c:forEach>
                                </table>
                            </div>
                            <div class="card-footer small text-muted"><i>Refresh every 5 second(s)</i></div>
                        </div>
                    </div>
 	
  </div>
  
</body>
</html>