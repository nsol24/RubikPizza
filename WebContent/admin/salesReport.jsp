<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.84.0">
<title>Sales Report | Rubik Pizza</title>
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.24/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.24/datatables.min.js"></script>
<link rel="stylesheet" href="assets/panel.css">
<link href="assets/dist/css/bootstrap.css" rel="stylesheet">
<script>
    $(document).ready(function() {
      $('#table_id').DataTable();
    });
  </script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {'packages':['bar']});
    google.charts.load('current', { 'packages': ['corechart'] });
	google.charts.setOnLoadCallback(drawMonthChart);
	
	function drawMonthChart() {
		var status_array = new Array();
		
		status_array[0] = ['Month', 'Total'];
		<c:forEach begin="0" end="${monthlysales.size()}" step="1" varStatus="loop" items="${monthlysales}" var="ms">
			status_array["${loop.count}"] = ["${ms.orderMonth}", +"${ms.totalByMonth}"];
		</c:forEach>
		
		var data = new google.visualization.arrayToDataTable(status_array, false);
		var options = {
			legend: { position: 'none'},
			bar: { groupWidth: '40%' },
			colors: ['#ff66cc']
		};
		
		var chart = new google.charts.Bar(document.getElementById('month_chart'));
		chart.draw(data, google.charts.Bar.convertOptions(options));
	}
	</script>
<style>
.sidebar {
	width: 260px;
	height: 100%;
	margin: 0;
	padding: 0;
	position: fixed;
	overflow: auto;
}
</style>
</head>
<body>
	<div class="sidenav">
    	<img src="assets/logo.png" style="width: 160px; margin: 20px 0px 0px 15px;" alt="">
		<a href="AdminRedirectController?action=adminprofile"><i class="fa fa-fw fa-user"></i>Profile</a>
		<a href="AdminRedirectController?action=adminmenu"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Menu</a>
		<a href="AdminRedirectController?action=adminorder"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Order</a>
		<a href="AdminRedirectController?action=salesReport" class="active"><i class="fa fa-database" aria-hidden="true"></i>Report</a>
		<a href="AdminRedirectController?action=riderMgt"><i class="fa fa-motorcycle" aria-hidden="true"></i>Rider</a>
		<a href="LogoutAdminController"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a>
 	</div>

	<div class="main">
		<div class="header">
			<h1>Sales Report</h1>
		</div>
		




	<div style="margin-left: 270px;" class="p-4">
    <div class="py-5 text-center">
      <div id="month_chart" class="m-5" style="width: 80%; height: 350px; margin: 0 auto; display: inline-block;"></div>
      
    </div>
  	</div>
  
	<script src="form-validation.js"></script>

	</div>
</body>
</html>