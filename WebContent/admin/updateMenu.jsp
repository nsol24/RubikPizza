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
    <a href="AdminRedirectController?action=adminmenu" class="active"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Menu</a>
    <a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Order</a>
    <a href="#"><i class="fa fa-database" aria-hidden="true"></i>Report</a>
    <a href="LogoutAdminController"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a>
  </div>
  <div class="main">
    <div class="header"><h1>Menu/Product Management</h1></div>
 	<form action="UpdateMenuController" method="post"  class="needs-validation" novalidate style="max-width: 800px; margin: 0 auto;">
      <div class="row g-3">
		<c:if test = "${process_status != 'success'}">
			<div class="alert alert-danger text-center" role="alert">
				<c:out value="${process_status}" />
			</div>
		</c:if>
        <div class="col-sm-6">
          <label for="menu_id" class="form-label">Menu number</label>
          <input type="text" class="form-control" id="id" name="menu_id"  value="<c:out value="${menuinfo.id}"/>" readonly>
          <div class="invalid-feedback"> Valid id number is required. </div>
        </div>
        
        <div class="col-sm-6">
          <label for="menu_name" class="form-label">Menu Name</label>
          <input type="text" class="form-control" id="name" name="menu_name" value="<c:out value="${menuinfo.name}"/>" required>
          <div class="invalid-feedback"> Valid id name is required. </div>
        </div>
        
        <div class="col-sm-6">
          <label for="menu_price" class="form-label">Menu Price</label>
          <input type="text" class="form-control" id="price" name="menu_price" value="<c:out value="${menuinfo.price}"/>" required>
          <div class="invalid-feedback"> Valid price is required. </div>
        </div>
        
        <div class="col-6">
          <label for="menu_desc" class="form-label">Description</label>
          <input type="email" class="form-control" id="desc" name="menu_desc" value="<c:out value="${menuinfo.desc}"/>" required>
          
        </div>
        
        


        
        <button class="w-100 my-5 btn btn-primary btn-lg" onclick="showAlertSuccessfulAdd()" type="submit">Update Menu</button>
      </div>
      	<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
                                <script>
                                    function showAlertSuccessfulAdd() {
                                    	Swal.fire({
                                    		  position: 'top-end',
                                    		  icon: 'success',
                                    		  title: 'update succesfully',
                                    		  showConfirmButton: false,
                                    		  timer: 1500
                                    		})
                                    }
                                </script>
    </form>
 		
  </div>
  
  
</body>
</html>