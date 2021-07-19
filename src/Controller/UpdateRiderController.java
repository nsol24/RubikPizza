package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.riderDAO;
import Model.Rider;


@WebServlet("/rider/UpdateRiderController")
public class UpdateRiderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private riderDAO riderdao;
    public UpdateRiderController() {
        super();
        riderdao = new riderDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Rider update = new Rider();
		
		update.setId(Integer.parseInt(request.getParameter("rider_id")));
		update.setName(request.getParameter("rider_name"));
		update.setEmail(request.getParameter("rider_email"));
		update.setPhone(request.getParameter("rider_phonenum"));
		update.setAddress(request.getParameter("rider_address"));
		
		riderdao.updaterider(update);
		
		Rider riderinfo = riderdao.viewriderbyid(Integer.parseInt(request.getParameter("rider_id")));
		RequestDispatcher view = request.getRequestDispatcher("riderProfile.jsp");
		request.setAttribute("rider", riderinfo);
		view.forward(request, response);
		
		
	}

}
