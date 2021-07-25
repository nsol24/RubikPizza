 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
  <title>Order</title>
  <script>
      $(document).ready( function () {
          $('#table_id').DataTable();
      } );
  </script>
  
</head>
<body>
  <div class="sidenav">
    <img src="assets/logo.png" style="width: 160px; margin: 20px 0px 0px 15px;" alt="">
    
    <a href="AdminRedirectController?action=adminprofile" class="active"><i class="fa fa-fw fa-user"></i>Profile</a>
    <a href="AdminRedirectController?action=adminmenu"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Menu</a>
    <a href="AdminRedirectController?action=adminorder" class="active"><i class="fa fa-pencil-square-o" aria-hidden="true" ></i>Order</a>
    <a href="#"><i class="fa fa-database" aria-hidden="true"></i>Report</a>
    <a href="AdminRedirectController?action=riderMgt"><i class="fa fa-motorcycle" aria-hidden="true"></i>Rider</a>
    <a href="LogoutAdminController"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a>
  </div>
  <div class="main">
    <div class="header"><h1>Order</h1></div>
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

                                    </thead>
									<c:forEach items="${orderlist}" var="o">
                                    <tr>
                                          <td><c:out value="${o.id}"/></td>
								          <td><c:out value="${o.custEmail}"/></td>
								          <td><c:out value="${o.orderdate}"/></td>
								          <td><c:out value="${o.time}"/></td>
								          <td><c:out value="${o.status}"/></td>

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