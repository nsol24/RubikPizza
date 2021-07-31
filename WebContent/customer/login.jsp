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
<title>Login</title>
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
    <form action="LoginCustController" method="post">
      <input type="text" id="login" class="fadeIn second" name="email" placeholder="email">
      <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
      <input type="submit" class="fadeIn fourth" value="Log In" onclick="showAlertSuccessfulAdd()">
    </form>
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
              					<script>
                                    function showAlertSuccessfulAdd() {
                                    	const Toast = Swal.mixin({
                                    		  toast: true,
                                    		  position: 'top-end',
                                    		  showConfirmButton: false,
                                    		  timer: 3000,
                                    		  timerProgressBar: true,
                                    		  didOpen: (toast) => {
                                    		    toast.addEventListener('mouseenter', Swal.stopTimer)
                                    		    toast.addEventListener('mouseleave', Swal.resumeTimer)
                                    		  }
                                    		})

                                    		Toast.fire({
                                    		  icon: 'success',
                                    		  title: 'Signed in successfully'
                                    		})
                                    }
                                </script>	
  
    <div id="formFooter">
      <a class="underlineHover" href="register.jsp">Register</a>
    </div>

  </div>
</div>
</body>
</html>
