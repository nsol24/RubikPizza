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
    <a href="AdminRedirectController?action=adminorder"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Order</a>
    <a href="#"><i class="fa fa-database" aria-hidden="true"></i>Report</a>
    <a href="AdminRedirectController?action=riderMgt"><i class="fa fa-motorcycle" aria-hidden="true"></i>Rider</a>
    <a href="LogoutAdminController"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a>
  </div>
  <div class="main">
    <div class="header"><h1>Menu/Product Management</h1></div>
 	<form action="AddMenuController" method="post" enctype="multipart/form-data" class="needs-validation" novalidate style="max-width: 800px; margin: 0 auto;">
      <div class="row g-3">
		<c:if test = "${process_status != 'success'}">
			<div class="alert alert-danger text-center" role="alert">
				<c:out value="${process_status}" />
			</div>
		</c:if>
        <div class="col-sm-6">
          <label for="menu_id" class="form-label">Menu number</label>
          <input type="text" class="form-control" id="id" name="menu_id"  required>
          <div class="invalid-feedback"> Valid id number is required. </div>
        </div>
        
        <div class="col-sm-6">
          <label for="menu_name" class="form-label">Menu Name</label>
          <input type="text" class="form-control" id="name" name="menu_name" required>
          <div class="invalid-feedback"> Valid id name is required. </div>
        </div>
        
        <div class="col-sm-6">
          <label for="menu_price" class="form-label">Menu Price</label>
          <input type="text" class="form-control" id="price" name="menu_price"  required>
          <div class="invalid-feedback"> Valid price is required. </div>
        </div>
        
        <div class="col-6">
          <label for="menu_desc" class="form-label">Description</label>
          <input type="email" class="form-control" id="desc" name="menu_desc"  required>
          
        </div>
        
        
        <div class="col-6">
          <label for="category_id" class="form-label">Category of Menu</label>
          <select class="form-select" id="category_id" name="category_id" required>
          	<option value=""></option>
            <c:forEach items="${categorylist}" var="c">
				<option value="<c:out value="${c.id}"/>"><c:out value="${c.name}"/></option>
			</c:forEach>
          </select>
          <div class="invalid-feedback"> Valid email address is required. </div>
        </div>
        
        
        <div class="col-6">
          <label for="menu_image" class="form-label">Menu Image</label>
          
          <input type="file"  size="1000000" class="form-control" id="menu_image" name="menu_image"  required>
          <div class="invalid-feedback"> Valid image is required. </div>
        </div>
        <button class="w-100 my-5 btn btn-primary btn-lg" onclick="showAlertSuccessfulAdd()" type="submit">Add Product</button>
      </div>
      <script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
                                <script>
                                    function showAlertSuccessfulAdd() {
                                        Swal.fire({
                                            position: 'top-center',
                                            icon: 'success',
                                            title: 'Add Product successfully',
                                            showConfirmButton: false,
                                            timer: 4500
                                        });
                                    }
                                </script>	
    </form>
 	
 	<!--table menu -->
 	
 	<div>
  	<table id="table_id" class="display">
  		<thead>
        <tr>
          
          <th>Id</th>
          <th>Name</th>
          <th>Price</th>
          <th>Description</th>
          <th>Category</th>
          <th>Action</th>
        </tr>
      </thead>
  		<tbody>
      	<c:forEach items="${menulist}" var="m">
        <tr>
          
          <td><c:out value="${m.id}"/></td>
          <td><c:out value="${m.name}"/></td>
          <td><c:out value="${m.price}"/></td>
          <td><c:out value="${m.desc}"/></td>
          <td><c:out value="${m.category}"/></td>
          <td>
            <input type="button" class="w-40 btn btn-secondary"  value="Update" onclick="window.location.href='AdminRedirectController?action=updatemenu&updateid=<c:out value="${m.id}"/>'">
            <input type="button" class="w-40 btn btn-secondary" value="Delete" onclick="window.location.href='AdminRedirectController?action=deletemenu&deleteid=<c:out value="${m.id}"/>'">
          </td>
        </tr>
        </c:forEach>
        
      </tbody>
  	</table>
  
  
  </div>
 	
  </div>
  
  
</body>
</html>