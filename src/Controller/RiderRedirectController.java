package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.menuDAO;
import Dao.riderDAO;
import Model.Rider;

/**
 * Servlet implementation class RiderRedirectController
 */
@WebServlet("/rider/RiderRedirectController")
public class RiderRedirectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private menuDAO menudao;   
	private riderDAO riderdao;
	HttpSession session;
    public RiderRedirectController() {
        super();
        // TODO Auto-generated constructor stub\
        menudao = new menuDAO();
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
			case "riderprofile":
				Rider riderinfo = riderdao.viewriderbyid(java_session_value);				
				request.setAttribute("rider", riderinfo);				
				view = request.getRequestDispatcher("riderProfile.jsp");
				view.forward(request, response);
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
