package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.adminDAO;
import Dao.riderDAO;
import Model.Admin;
import Model.Rider;
import java.sql.*;
import java.security.*;
@WebServlet("/rider/RegisterRiderController")
public class RegisterRiderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private adminDAO admindao;
	private riderDAO riderdao;
    
    public RegisterRiderController() {
        super();
        admindao = new adminDAO();
        riderdao = new riderDAO();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_type = request.getParameter("usertype");
		int user_id = (Integer.parseInt(request.getParameter("riderid")));
		
		String user_password = request.getParameter("password");
		
		if(user_type.equalsIgnoreCase("Rider")) {
			Rider newrider = new Rider();
			
			newrider.setId(user_id);
			newrider.setPassword(user_password);
			
			String status = riderdao.registerrider(newrider);
			
			if(status.equalsIgnoreCase("fail")) {
				request.setAttribute("status", "ID number already exist");
				RequestDispatcher view = request.getRequestDispatcher("registerRider.jsp");
				view.forward(request, response);
			}
			else if(status.equalsIgnoreCase("success")) {
				RequestDispatcher view = request.getRequestDispatcher("loginRider.jsp");
				view.forward(request, response);
			}
		}
		else if(user_type.equalsIgnoreCase("Manager")) {
			Admin newadmin = new Admin();
			
			newadmin.setId(user_id);
			
			newadmin.setPassword(user_password);
			
			String status = admindao.registeradmin(newadmin);
			
			if(status.equalsIgnoreCase("fail")) {
				request.setAttribute("status", "ID number already exist");
				RequestDispatcher view = request.getRequestDispatcher("registerAdmin.jsp");
				view.forward(request, response);
			}
			else if(status.equalsIgnoreCase("success")) {
				RequestDispatcher view = request.getRequestDispatcher("loginAdmin.jsp");
				view.forward(request, response);
			}
		}
	}

}
