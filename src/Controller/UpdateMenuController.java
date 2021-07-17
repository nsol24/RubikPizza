package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.*;
import Model.*;
@WebServlet("/admin/UpdateMenuController")
public class UpdateMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private menuDAO menudao;  
	private categoryDAO categorydao;
	HttpSession session;
	
    public UpdateMenuController() {
        super();
        menudao = new menuDAO();
        categorydao = new categoryDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Menu updatemenu = new Menu();
		
		updatemenu.setId(request.getParameter("menu_id"));
		updatemenu.setName(request.getParameter("menu_name"));
		updatemenu.setPrice(Double.parseDouble(request.getParameter("menu_price")));
		updatemenu.setDesc(request.getParameter("menu_desc"));
	
        menudao.updatemenu(updatemenu);
        session = request.getSession(true);
		
		request.setAttribute("process_status", "success");
		request.setAttribute("categorylist", categorydao.viewCategorylist());
		request.setAttribute("menulist", menudao.getAllMenu());
		RequestDispatcher view = request.getRequestDispatcher("adminMenu.jsp");
		view.forward(request, response);
	}

}
