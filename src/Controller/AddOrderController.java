package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.menuDAO;
import Model.Menu;

/**
 * Servlet implementation class AddOrderController
 */
@WebServlet("/customer/AddOrderController")
public class AddOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    menuDAO dao;   
    
    public AddOrderController() {
        super();
        dao = new menuDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			Menu m = dao.getMenuById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("menu",m);
			RequestDispatcher view = request.getRequestDispatcher("orderDetails.jsp");
	        view.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
