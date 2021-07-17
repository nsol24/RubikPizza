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
import Model.Customer;

/**
 * Servlet implementation class CustRedirectController
 */
@WebServlet("/customer/CustRedirectController")
public class CustRedirectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private customerDAO custdao;
     HttpSession session;
    public CustRedirectController() {
        super();
        custdao =  new customerDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		session = request.getSession(true);
		String java_session_value = (String)session.getAttribute("session_email");
		RequestDispatcher view;
		String process_status = "";
		
		try {
			switch(action) {
				case "custprofile":
				Customer custinfo = custdao.viewcustbyemail(java_session_value);
				request.setAttribute("custinfo", custinfo);
				view = request.getRequestDispatcher("profile.jsp");
				view.forward(request, response);
				break;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
