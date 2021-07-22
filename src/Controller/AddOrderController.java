package Controller;

import java.io.IOException;

import java.util.List;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.orderDAO;
import Dao.orderdetailsDAO;
import Model.Order;
import Model.OrderDetails;


/**
 * Servlet implementation class AddOrderController
 */
@WebServlet("/customer/AddOrderController")
public class AddOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private orderDAO orderdao;
   private orderdetailsDAO orderdetailsdao;
    public AddOrderController() {
        super();
       orderdao = new orderDAO(); 
       orderdetailsdao = new orderdetailsDAO();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order = new Order();
		
		HttpSession session = request.getSession(true);
		
		@SuppressWarnings("unchecked")
		List<OrderDetails>od = (List<OrderDetails>) session.getAttribute("custCart");
		
		order.setCustEmail(request.getParameter("custEmail"));
		
		double totalPrice = Double.parseDouble(request.getParameter("orderTotalPrice"));
		order.setTotalprice(totalPrice);
		System.out.println("Total Price in Order :" + totalPrice); //debugging purpose
		String dateStr = request.getParameter("date");
		 
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			order.setOrderdate(sqlDate);
		} catch (ParseException e) {
		
		e.printStackTrace();
		}
		
		String delTime = request.getParameter("time");
		order.setTime(delTime);
		
		//insert order id /simpan as session utk nk guna di payment
		int orderid = orderdao.addOrder(order);
		order.setId(orderid);
		request.setAttribute("order",orderdao.viewOrderById(order.getId()) );
		order = orderdao.viewOrderById(order.getId());
		session.setAttribute("CurrentSessionOrderID", order.getId());
		
		//inside orderdetails
		
		for(int i=0 ; i<od.size(); i++)
		{
			OrderDetails o = od.get(i);
			String menuid = o.getMenuid();
			orderdetailsdao.addOrderDetails(orderid, menuid);
			System.out.println("Menuid in Orderdetails : "+ menuid); //debugging purpose
		}
		//debugging purpose
				System.out.println("order id: "+ orderid);
				
				RequestDispatcher view = request.getRequestDispatcher("payment.jsp");
				view.forward(request, response);	
	}

	
	

}
