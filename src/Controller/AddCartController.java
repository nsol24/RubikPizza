package Controller;

import java.io.IOException;

import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.menuDAO;
import Model.Menu;
import Model.OrderDetails;


@WebServlet("/customer/AddCartController")
public class AddCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     menuDAO menudao;  
    
    public AddCartController() {
        super();
       menudao = new menuDAO(); 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String menuID = request.getParameter("id");
		
		Menu menu = menudao.getMenu(menuID);
		System.out.println(menuID);
		
		OrderDetails od = new OrderDetails();
		
		od.setMenuid(menu.getId());
		od.setMenuName(menu.getName());
		od.setMenuPrice(menu.getPrice());
		od.setOrderTotalPrice(od.getOrderTotalPrice());
		
		HttpSession session = request.getSession(true);
		@SuppressWarnings ("unchecked")
		List<OrderDetails>ods = (List<OrderDetails>) session.getAttribute("custCart");
		
		if(ods == null) {
			List<OrderDetails>odss = new ArrayList<OrderDetails>();
			odss.add(od);
			
			session.setAttribute("custCart", odss);
			request.setAttribute("orderDetails", odss);
			response.sendRedirect("cart.jsp");
		}
		else
		{
			ods.add(od);
			session.setAttribute("custCart", ods);
			response.sendRedirect("cart.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
