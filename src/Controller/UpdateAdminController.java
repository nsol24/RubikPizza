package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.adminDAO;
import Model.Admin;

/**
 * Servlet implementation class UpdateAdminController
 */
@WebServlet("/admin/UpdateAdminController")
public class UpdateAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private adminDAO admindao;  
    
    public UpdateAdminController() {
        super();
       admindao = new adminDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin update =  new Admin();
		
		update.setId(Integer.parseInt(request.getParameter("admin_id")));
		update.setMgrid(Integer.parseInt(request.getParameter("manager_id")));
		update.setName(request.getParameter("admin_name"));
		update.setEmail(request.getParameter("admin_email"));
		update.setPhone(request.getParameter("admin_phonenum"));
		
		admindao.updateadmin(update);
		
		Admin admininfo = admindao.viewadminbyid(Integer.parseInt(request.getParameter("admin_id")));
		RequestDispatcher view = request.getRequestDispatcher("adminProfile.jsp");
		request.setAttribute("admin", admininfo);
		view.forward(request, response);
	}

}
