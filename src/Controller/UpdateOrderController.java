package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.orderDAO;
import Model.Order;

/**
 * Servlet implementation class UpdateOrderController
 */
@WebServlet("/rider/UpdateOrderController")
public class UpdateOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private  orderDAO orderdao;  
     HttpSession session;
    public UpdateOrderController() {
        super();
      orderdao = new orderDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Order updateorder = new Order();
		updateorder.setId(Integer.parseInt(request.getParameter("orderid")));
		updateorder.setStatus(request.getParameter("status"));
		updateorder.setRid(Integer.parseInt(request.getParameter("rider_id")));
		
		orderdao.updateorder(updateorder);
		session = request.getSession(true);
		
		request.setAttribute("orderlist", orderDAO.viewOrderList());
		RequestDispatcher view = request.getRequestDispatcher("riderOrder.jsp");
		view.forward(request, response);
		
	}

}
