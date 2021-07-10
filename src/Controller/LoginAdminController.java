package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Dao.adminDAO;
import Dao.riderDAO;
import Model.Admin;
import Model.Rider;


/**
 * Servlet implementation class LoginAdminController
 */
@WebServlet("/admin/LoginAdminController")
public class LoginAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private adminDAO admindao;  
     private riderDAO riderdao;
     HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminController() {
        super();
        admindao = new adminDAO();
        riderdao = new riderDAO();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_type = request.getParameter("user_type");
		int user_id = (Integer.parseInt(request.getParameter("id")));
		String user_password = request.getParameter("password");
		if(user_type.equalsIgnoreCase("Rider")) {
			Rider newrider = new Rider();
			
			newrider.setId(user_id);
			newrider.setPassword(user_password);
			
			String status = riderdao.loginrider(newrider);
			if(status.equalsIgnoreCase("success")) {
				
				session = request.getSession(true);
				session.setAttribute("session_id", user_id);
				
				Integer java_session_value = (Integer)session.getAttribute("session_id");
				
				Rider riderinfo = riderdao.viewriderbyid(java_session_value);
				
				request.setAttribute("student", riderinfo);
				
				RequestDispatcher view = request.getRequestDispatcher("riderProfile.jsp");
				view.forward(request, response);
				session.setAttribute("noti_status", false);
			}
			else {
				request.setAttribute("status", status);
				RequestDispatcher view = request.getRequestDispatcher("loginRider.jsp");
				view.forward(request, response);
			}
		}
		else if(user_type.equalsIgnoreCase("Manager")) {
			Admin newadmin = new Admin();
			
			newadmin.setId(user_id);
			newadmin.setPassword(user_password);
			
			String status = admindao.loginadmin(newadmin);
			if(status.equalsIgnoreCase("success")) {
				
				session = request.getSession(true);
				session.setAttribute("session_id", user_id);
				
				Integer java_session_value = (Integer)session.getAttribute("session_id");
				System.out.println(java_session_value);
				Admin admininfo = admindao.viewadminbyid(java_session_value);
				request.setAttribute("admin", admininfo);
				
				RequestDispatcher view = request.getRequestDispatcher("adminProfile.jsp");
				view.forward(request, response);
			}
			else {
				request.setAttribute("status", status);
				RequestDispatcher view = request.getRequestDispatcher("loginAdmin.jsp");
				view.forward(request, response);
			}
		}
	}
}
