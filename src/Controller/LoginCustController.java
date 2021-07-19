package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.customerDAO;
import Dao.menuDAO;
import Model.Customer;


@WebServlet("/customer/LoginCustController")
public class LoginCustController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     customerDAO custdao;  
     menuDAO menudao;
     HttpSession session;
    public LoginCustController() {
        super();
      custdao = new customerDAO();
      menudao = new menuDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cust_email = request.getParameter("email");
		String cust_password = request.getParameter("password");
		
		Customer cust = new Customer();
		cust.setEmail(cust_email);
		cust.setPassword(cust_password);
		String status = custdao.logincust(cust);
		if(status.equalsIgnoreCase("success")) {
			session = request.getSession(true);
			session.setAttribute("session_email", cust_email);
			
			String java_session_value = (String)session.getAttribute("session_email");
			System.out.print(java_session_value);
			request.setAttribute("menu", menuDAO.getAllMenu());
			RequestDispatcher view = request.getRequestDispatcher("homepage.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("status", status);
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}
	}

}
