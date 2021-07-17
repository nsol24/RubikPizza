<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="Model.*,Dao.*,java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/logincust.css">
<link rel="icon" href="../img/favicon.png">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="assets/logo2.png" style="width: 160px; margin: 20px 0px 0px 15px;" id="icon" alt="User Icon" />
      <h1></h1>
    </div>

    <!-- Login Form -->
    <form action ="RegisterController" method="post">
      <input type="text" id="login" class="fadeIn second" name="cust_name" placeholder="Name">
      <input type="text" id="address" class="fadeIn second" name="cust_address" placeholder="Address">
      <input type="text" id="phone" class="fadeIn second" name="cust_phone" placeholder="Phone number">
      <input type="text" id="email" class="fadeIn second" name="cust_email" placeholder="Email">
      <input type="text" id="password" class="fadeIn third" name="cust_password" placeholder="password">
      
      <input type="submit" class="fadeIn fourth" value="Register">
    </form>

  
    <div id="formFooter">
      <a class="underlineHover" href="login.jsp">Login</a>
    </div>

  </div>
</div>
</body>
</html>

