package Controller;

import java.io.IOException;
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
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        dao = new customerDAO();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer cust = new Customer();
		
		cust.setName(request.getParameter("cust_name"));
		cust.setAddress(request.getParameter("cust_address"));
		cust.setPhone(request.getParameter("cust_phone"));
		cust.setEmail(request.getParameter("cust_email"));
		cust.setPassword(request.getParameter("cust_password"));
		
		if(!cust.isValid()) {
			try {
				dao.add(cust);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//redirect to login page
			response.sendRedirect("login.jsp");
		}
		
		
	}

}
