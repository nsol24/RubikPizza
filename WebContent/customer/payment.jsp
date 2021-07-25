<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="Payment.css">

</head>

<body>
	<div class="card mt-50 mb-50">
    <div class="card-title mx-auto"> Select Your Payment Method </div>
    <div class="nav">
        <ul class="mx-auto">
            
            <li class="active"><a href="#">Payment</a></li>
        </ul>
    </div>
    <form action="PaymentController" method="post"> 
    <span id="card-header">Cash On Delivery:</span>
        <div class="row row-1">
            <input type="radio" name="paymentMethod" value="cod">
			<label for="cod">Cash on Delivery</label><br>
				
        </div>
        
        <span id="card-header">Card Payment</span>
        <div class="row row-1">
            	<input type="radio" name="paymentMethod" value="onlinebanking">
				<label for="css">Credit/Debit Card</label><br>
        </div>
       
        <div class="row three">
            <div class="col-7">
                <div class="row-1">
                    <div class="row row-2"> <span id="card-inner">Card number</span> </div>
                    <div class="row row-2"> <input type="text" placeholder="5134-5264-4" name="cardNumber"> </div>
                </div>
            </div>
            <div class="col-2"> <input type="text" placeholder="Exp. Month" name="expiryMonth"> </div>
            <div class="col-2"> <input type="text" placeholder="Exp. Year" name="expiryYear"> </div>
            <div class="col-2"> <input type="text" placeholder="CVV" name="cvv"> </div>
        <input type="submit" class="btn btn-success btn-lg btn-block" value="PAY NOW">
    </form>
</div>

</body>

</html>