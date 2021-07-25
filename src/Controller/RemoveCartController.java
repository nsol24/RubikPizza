package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.OrderDetails;

@WebServlet("/customer/RemoveCartController")
public class RemoveCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RemoveCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menuID = request.getParameter("menuID");
		
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		List<OrderDetails>od = (List<OrderDetails>)session.getAttribute("custCart");
		
		od.remove(menuID);
		session.setAttribute("custCart", od);
		RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
		view.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
