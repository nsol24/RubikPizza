<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="../css/receipt.css">
<title>Payment</title>
</head>
<body>

<c:forEach items="${orderhistory}" var="order">
	<div class="card">
    <div class="title">Purchase Reciept</div>
    <div class="title"><c:out value="${order.custEmail}" /></div>
    <div class="info">
        <div class="row">
            <div class="col-7"> <span id="heading">Date</span><br> <span id="details"><c:out value="${order.orderdate}" /></span> </div>
            <div class="col-5 pull-right"> <span id="heading">Order No.</span><br> <span id="details"><c:out value="${order.id}" /></span> </div>
        </div>
    </div>
    <div class="total">
        <div class="row">
            <div class="col-3"><big>TOTAL PRICE</big></div>
            <div class="col-3"><big>RM : <c:out value="${order.totalprice}" /></big></div>
        </div>
    </div>
    </c:forEach>
    <div class="tracking">
        <div class="title">Tracking Order</div>
    </div>
    <div class="progress-track">
        <ul id="progressbar">
           <li class="step0 active " id="step1">Ordered</li>
            <li class="step0 text-right" id="step4">Preparing</li>
            <li class="step0 text-right" id="step4">Delivery</li>
            <li class="step0 text-right" id="step4">Complete</li>
        </ul>
    </div>
    <div class="footer">
        <div class="row">
            <div class="col-2"><img class="img-fluid" src="../img/logo2.png"></div>
            <div class="col-10">Want any help? Please &nbsp;<a> contact us</a></div>
        </div>
    </div>
</div>
</body>
</html>