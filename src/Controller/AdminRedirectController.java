package Controller;

import java.io.IOException;
import Dao.*;
import Model.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminRedirectController
 */
@WebServlet("/admin/AdminRedirectController")
public class AdminRedirectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
     private  categoryDAO categorydao;
    private menuDAO menudao;
    private adminDAO admindao;
    private riderDAO riderdao;
    public AdminRedirectController() {
        super();
        categorydao = new categoryDAO();
        menudao = new menuDAO();
        admindao = new adminDAO();
        riderdao = new riderDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		session = request.getSession(true);
		int java_session_value = (int)session.getAttribute("session_id");
		
		RequestDispatcher view;
		String process_status = "";
		
		try {
			switch(action) {
			case "adminmenu":
				request.setAttribute("process_status", "success");
				request.setAttribute("categorylist", categorydao.viewCategorylist());
				request.setAttribute("menulist", menudao.getAllMenu());
				view = request.getRequestDispatcher("adminMenu.jsp");
				view.forward(request, response);
				break;
			case "deletemenu":
				String delete_menuid = request.getParameter("deleteid");
				menudao.deletemenu(delete_menuid);
				request.setAttribute("process_status", "success");
				request.setAttribute("categorylist", categorydao.viewCategorylist());
				request.setAttribute("menulist", menudao.getAllMenu());
				view = request.getRequestDispatcher("adminMenu.jsp");
				view.forward(request, response);
				break;
			case "adminprofile":
				Admin admininfo = admindao.viewadminbyid(java_session_value);
				request.setAttribute("admin", admininfo);
				view = request.getRequestDispatcher("adminProfile.jsp");
				view.forward(request, response);
				break;
			case "updatemenu":
				String update_menuid = request.getParameter("updateid");
				request.setAttribute("categorylist", categorydao.viewCategorylist());
				request.setAttribute("menuinfo", menudao.viewMenuById(update_menuid));
				view = request.getRequestDispatcher("updateMenu.jsp");
				view.forward(request, response);
				break;
			case "riderMgt":
				request.setAttribute("process_status", "success");
				request.setAttribute("riderlist", riderdao.getAllRider());
				view = request.getRequestDispatcher("riderMgt.jsp");
				view.forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
