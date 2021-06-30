package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.menuDAO;

/**
 * Servlet implementation class ListMenuController
 */
@WebServlet("/customer/ListMenuController")
public class ListMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private menuDAO dao;  
    
    public ListMenuController() {
        super();
       dao = new menuDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("menu", menuDAO.getAllMenu());        
		RequestDispatcher view = request.getRequestDispatcher("pizza.jsp");
        view.forward(request, response);
		
		
	}

	

}
