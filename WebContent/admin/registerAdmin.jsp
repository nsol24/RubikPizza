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
<link rel="stylesheet" href="assets/loginAdmin.css">
<meta charset="ISO-8859-1">
<title>register admin</title>
</head>
<body>
	<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="assets/logo.png" style="width: 160px; margin: 20px 0px 0px 15px;" id="icon" alt="User Icon" />
    </div>
    <!-- Register Form -->
    <form action="RegisterAdminController" method="post">
    <c:if test = "${status != null}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${status}"/>
			</div>
		</c:if>
      <input type="text" id="adminid" class="fadeIn second" name="adminid" placeholder="Admin ID">
      <input type="text" id="mgrid" class="fadeIn second" name="mgrid" placeholder="Manager ID">
      
      <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
      <select class="form-select p-3 mb-5" name="usertype" required>
          <option value="">User type</option>
          <option value="Rider">Rider</option>
          <option value="Manager">Manager</option>
        </select>
      <input type="submit" class="fadeIn fourth" value="Sign Up">
    </form>

    

  </div>
</div>
</body>
</html>