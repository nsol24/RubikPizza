<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="assets/loginRider.css">
<meta charset="ISO-8859-1">
<title>Rider Login</title>
</head>
<body>
	<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="assets/logo.png" style="width: 160px; margin: 20px 0px 0px 15px;" id="icon" alt="User Icon" />
    </div>
<button class="w-50 tab-btn p-3 disable" onclick="window.location.href='loginRider.jsp'">Rider</button><button class="w-50 tab-btn p-3 fw-bold" onclick="window.location.href='../admin/loginAdmin.jsp'">Admin</button>
    <!-- Login Form -->
    <form action="LoginRiderController" method="post">
    <c:if test = "${status != null}">
					<div class="alert alert-danger" role="alert">
						<c:out value="${status}"/>
					</div>
				</c:if>
      <input type="text" id="id" class="fadeIn second" name="id" placeholder="Rider ID">
      
      <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
      <input type="hidden" name="user_type" value="Rider"/>
      <div class="pt-4">Don't have an account? <a href="registerRider.jsp" style="text-decoration: none;">Register</a> </div>
      <input type="submit" class="fadeIn fourth" value="Login">
    </form>

    

  </div>
</div>
</body>
</html>