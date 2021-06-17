<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link rel="stylesheet" href="../css/style.css">
  <title>Document</title>
  
  
</head>
<body>
  <div class="sidenav">
    <img src="logo2.png" style="width: 160px; margin: 20px 0px 0px 15px;" alt="">
    <div>Rubik Pizza</div>
    
  </div>
  <div class="main">
    <div class="header"><h1>Menu Management</h1></div>
 		<form id="signup" method="POST" action="addmenuServlet">
				<h1>Add Menu Details</h1><br>
				<h3>Please fill in the details below</h3><br><br>
				
				<label >Menu Name</label><br>
				<input placeholder="Name"  type="text" name="name" required><br><br>
				
				<label >Price (RM)</label><br>
				<input placeholder="Price"  type="text" name="price" required><br><br>
				
				<label >Description</label><br>
				<textarea placeholder="Description"  name="desc" rows="5" cols="30" required></textarea><br><br>
				
				<label >Image</label><br>
				<input type="file" name="photo" size="50" required><br><br>
				
				<label >Type Of Menu</label><br>
				<select name="category">
				    <c:forEach items="${listCategory}" var="category">
				         <option value="${category.id}"
		                    <c:if test="${category.id eq selectedCatId}">selected="selected"</c:if>
		                    >
		                    ${category.name}
		                </option>
				    </c:forEach>
				</select><br><br>				
				<input type="submit" class="submit-btn" value="REGISTER">
			</form>
 	
  	
  </div>
  
</body>
</html>