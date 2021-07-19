 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
	
	if(session.getAttribute("session_email") == null) {
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="../css/homepage1.css">

<link rel="stylesheet" href="../css/profilecust.css">
<link rel="icon" href="../img/favicon.png">

<meta charset="ISO-8859-1">
<title>Profile</title>

</head>
<body>
	<div class="logo">
		<a href="CustRedirectController?action=homepage"><img src="../img/logo2.png"></a>
	</div>
	<nav>
		<ul>
			<li><a href="logout.jsp">LOGOUT</a></li>
			<li><a>MY ACCOUNT</a></li>
			<li><a href="CustRedirectController?action=homepage">HOMEPAGE</a></li>
		</ul>
	</nav>
	<div class="container emp-profile">
            <form action="UpdateCustController" method="post">
                <div class="row">
                    <div class="col-md-4">
                        
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h5>
                                        <c:out value="${custinfo.name}" />
                                    </h5>
                                   
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                
                            
                            </ul>
                        </div>
                    </div>
                    
                </div>
                <div class="row">
                    
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                       
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Name</label>
                                            </div>
                                            <div class="col-md-6">
                                                 <input type="text" class="form-control" id="staff_name" name="cust_name" value="<c:out value="${custinfo.name}" />" >
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                 <input type="text" class="form-control" id="staff_name" name="cust_email" value="<c:out value="${custinfo.email}" />" readonly >
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Phone</label>
                                            </div>
                                            <div class="col-md-6">
                                                 <input type="text" class="form-control" id="staff_name" name="cust_phone" value="<c:out value="${custinfo.phone}" />" >
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Address</label>
                                            </div>
                                            <div class="col-md-6">
                                                 <input type="text" class="form-control" id="staff_name" name="cust_address" value="<c:out value="${custinfo.address}" />" >
                                            </div>
                                        </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-success">Update Profile</button>
            </form>           
        </div>
	
</body>
</html>