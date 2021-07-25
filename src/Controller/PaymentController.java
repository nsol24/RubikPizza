package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Dao.orderDAO;
import Dao.paymentDAO;
import Model.Cod;
import Model.Onlinebanking;
import Model.Order;
import Model.Payment;

@WebServlet("/customer/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private paymentDAO paydao;
	static Connection connect = null;
	static PreparedStatement ps = null;

	public PaymentController() {
		super();
		paydao = new paymentDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Payment parentPay = new Payment();
		Cod cod = new Cod();
		Onlinebanking ob = new Onlinebanking();
		HttpSession session = request.getSession(true);
		int orderid = (int) session.getAttribute("CurrentSessionOrderID");

		String paymentMethod = request.getParameter("paymentMethod");
		System.out.println("paymentMethod");

		if (paymentMethod.equalsIgnoreCase("cod")) {
			// insert value into setter method parent table
			parentPay.setOrderid(orderid);
			parentPay.setMethod(paymentMethod);
			// insert into add payment dao class
			int paymentid = paydao.addPayment1(parentPay, cod);
			System.out.println("pay with cod : payment id :" + paymentid);

		} else if (paymentMethod.equalsIgnoreCase("onlinebanking")) {
			// insert value into setter method parent table
			parentPay.setOrderid(orderid);
			parentPay.setMethod(paymentMethod);
			
			ob.setCardNumber(request.getParameter("cardNumber"));
			ob.setExpiryMonth(request.getParameter("expiryMonth"));
			ob.setExpiryYear(request.getParameter("expiryYear"));
			ob.setCvv(request.getParameter("cvv"));

			// insert into add payment dao class
			int paymentid = paydao.addPayment2(parentPay, ob);
			System.out.println("pay with online banking : payment id :" + paymentid);
			
			int paymentid2 = paydao.addPayment2(parentPay, ob);
			System.out.println("pay with online banking : payment id :" + paymentid2);
		}
		List<Order> order = orderDAO.viewallOrderCustomer(orderid);
		request.setAttribute("orderhistory" ,order);
		RequestDispatcher view = request.getRequestDispatcher("thankyou.jsp");
		view.forward(request, response);

	}

}
