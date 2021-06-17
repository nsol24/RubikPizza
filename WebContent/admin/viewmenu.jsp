<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.24/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.24/datatables.min.js"></script>
<link rel="stylesheet" href="admin.css">
  <title>Document</title>
  <script>
      $(document).ready( function () {
          $('#table_id').DataTable();
      } );
  </script>
  
</head>
<body>
  <div class="sidenav">
    <img src="logo2.png" style="width: 160px; margin: 20px 0px 0px 15px;" alt="">
    <div>Rubik Pizza</div>
    <a href="HomeParcel.jsp" class="active"><i class="fa fa-fw fa-home"></i>Parcel</a>
    <a href="staff.jsp"><i class="fa fa-fw fa-user"></i>Staff</a>
    <a href="addstaff.jsp"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Add Staff</a>
    <a href="report.jsp"><i class="fa fa-database" aria-hidden="true"></i>Report</a>
    <a href="index.jsp"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a>
  </div>
  <div class="main">
    <div class="header"><h1>Menu Management</h1></div>
 	
 	<table  border="1" id="table_id" class="display">
    <thead>
      <tr>
        <th>#Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Image</th>
        <th>Type Category</th>
        
        <th>Option</th>
        
      </tr>
    </thead>
	      <tbody>
	        
	        
	        
	        
	      </tbody>
	    
	    </table>
  	<a href="addParcel.jsp" class="w3-button w3-blue">Add Parcel</a>
  </div>
  
</body>
</html>