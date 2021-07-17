package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Dao.customerDAO;
import Model.Customer;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/customer/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private customerDAO dao; 
    
    public RegisterController() {
        super();
        dao = new customerDAO();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cust_name = request.getParameter("cust_name");
		String cust_address = request.getParameter("cust_address");
		String cust_phone = request.getParameter("cust_phone");
		String cust_email = request.getParameter("cust_email");
		String cust_password = request.getParameter("cust_password");
		
		Customer cust = new Customer();
		
		cust.setName(cust_name);
		cust.setAddress(cust_address);
		cust.setPhone(cust_phone);
		cust.setEmail(cust_email);
		cust.setPassword(cust_password);
		
		String status = dao.registercust(cust);
		System.out.println(status);
		if(status.equalsIgnoreCase("fail")) {
			request.setAttribute("status", "ID number already exist");
			RequestDispatcher view = request.getRequestDispatcher("register.jsp");
			view.forward(request, response);
		}
		else if(status.equalsIgnoreCase("success")) {
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}
		
	}
	
	

}
