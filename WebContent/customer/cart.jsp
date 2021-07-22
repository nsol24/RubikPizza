<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import = "Model.OrderDetails" %>
<%@ page import = "java.util.*" %>
<% List<OrderDetails> ods = (List<OrderDetails>) session.getAttribute("custCart"); %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/homepage1.css">
<link rel="stylesheet" href="../css/homepage.css">
<link rel="stylesheet" href="../css/cartbutton.css">
<link rel="icon" href="../img/favicon.png">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Online Pizza Delivery |Cart</title>
</head>
<body>
	<div class="logo">
		<a href="CustRedirectController?action=homepage"><img src="../img/logo2.png"></a>
	</div>
	<nav>
		<ul>		
			<li><a href="cart.jsp">CART</a></li>
			<li><a href="CustRedirectController?action=homepage" >BACK </a></a></li>			
		</ul>
	</nav>
	<section style="background-color:  #ffe6cc;" class="categories" id="menu">
	</center>
		<form action="AddOrderController" method="post">
			<input type="hidden" name="custEmail" value="<%=session.getAttribute("session_email")%>" />
			
			<table class="table">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Name</th>
				      <th scope="col">Price</th>
				      <th scope="col">Action</th>
				    </tr>
				  </thead>
				  <tbody>
				  	   <% if (ods == null) {%>
                     		<tr class="table-light">
	                     		<td colspan="4" align="center">
	                     				<div class="card-body cart">
						                    <div class="col-sm-12 empty-cart-cls text-center"> <img src="https://i.imgur.com/dCdflKN.png" width="130" height="130" class="img-fluid mb-4 mr-3">
						                        <h3><strong>Your Cart is Empty</strong></h3>
						                        <h4>Add something to make me happy :)</h4> <a href="#" class="btn btn-primary cart-btn-transform m-3" data-abc="true">continue shopping</a>
						                    </div>
						                </div>
	                     		</td>
							</tr> 
						<%}
				  	   else
				  	   {
				  		 double totalPrice = 0;
				  		 for (int i=0; i<ods.size();i++)
				  		 {
				  			 OrderDetails o = ods.get(i);
				  			%>
				  			<tr class="table-light">
				  				<td><%= o.getMenuid() %></td>
				  				<td><%= o.getMenuName() %></td>
				  				<td>Rm <%= o.getMenuPrice() %></td>
				  				<td> <a href="RemoveCartController?menuID=<%=i%>" rel="tooltip" class="w3-btn w3-red w3-round-large">Remove</a></td>
				  			</tr>
				  			<% 
				  				totalPrice += o.getMenuPrice();
				  				o.setOrderTotalPrice(totalPrice);
				  				System.out.println("harga total dalam ni: " +o.getOrderTotalPrice());
				  			%>
				  		 <%}%>
				  		 <tr class="table-light">
				  		 	<td colspan = 4 class="cell100 column4" align = "center">
				  	   		<input type="hidden" name="orderTotalPrice" value="<%=totalPrice%>"> Total Price: RM<%= totalPrice%>  </td>
				  		 </tr>
				  	   
				  </tbody>
				</table>
				<div class="form-row">
				    <div class="form-group col-md-6">
				      <label for="inputDate">Date</label>
				      <input type="date" class="form-control"  id="date" name="date">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="inputDelivery">Delivery Time</label>
				      <input type="time" class="form-control"  id="time" name="time"  >
				    </div>
				  </div>
				<center>
				<input type = "submit" class="cart_button_checkout" align = "center" value="Checkout" onclick="showAlertSuccessfulAdd()"></input>
				</center>
				
				<% }%>
		</form>
			<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
                                <script>
                                    function showAlertSuccessfulAdd() {
                                        Swal.fire({
                                            position: 'top-center',
                                            icon: 'success',
                                            title: 'Checkout successfully',
                                            showConfirmButton: false,
                                            timer: 4500
                                        });
                                    }
                                </script>								
	</section>
</body>
</html>