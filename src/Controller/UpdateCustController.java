package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.customerDAO;
import Model.Customer;


@WebServlet("/customer/UpdateCustController")
public class UpdateCustController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     customerDAO custdao;  
    
    public UpdateCustController() {
        super();
       custdao = new customerDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer update = new Customer();
		
		update.setName(request.getParameter("cust_name"));
		update.setAddress(request.getParameter("cust_address"));
		update.setEmail(request.getParameter("cust_email"));
		update.setPhone(request.getParameter("cust_phone"));
		
		custdao.updatecust(update);
		
		Customer custinfo = custdao.viewcustbyemail(request.getParameter("cust_email"));
		RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
		request.setAttribute("custinfo", custinfo);
		view.forward(request, response);
		
	}

}
