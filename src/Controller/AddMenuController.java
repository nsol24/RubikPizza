package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.*;
import Model.*;
import Connection.*;

/**
 * Servlet implementation class AddMenuController
 */
@MultipartConfig(maxFileSize = 16177215) 
@WebServlet("/admin/AddMenuController")
public class AddMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private menuDAO menudao;  
    private categoryDAO categorydao;
    static Connection connect = null;
	static PreparedStatement ps = null;
    public AddMenuController() {
        super();
        menudao = new menuDAO();
        categorydao = new categoryDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Menu newmenu = new Menu();
		InputStream inputStream = null;
		
        String id = request.getParameter("menu_id");
        String name = request.getParameter("menu_name");
        Double price = Double.parseDouble(request.getParameter("menu_price"));
        String desc = request.getParameter("menu_desc");
        String category = request.getParameter("category_id");
        String message = null;
        Part filePart = request.getPart("menu_image");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
       try {
    	   
    	   connect = ConnectionManager.getConnection();
    	   String sql = "INSERT INTO menu (menu_id, menu_name, menu_price,menu_desc,category_id,menu_image) values (?, ?, ?, ?, ?, ?)";
    	   ps = connect.prepareStatement(sql);
    	   ps.setString(1, id);
    	   ps.setString(2, name);
    	   ps.setDouble(3, price);
    	   ps.setString(4, desc);
    	   ps.setString(5, category);
    	   if (inputStream != null) {
               // fetches input stream of the upload file for the blob column
               ps.setBlob(6, inputStream);
           }
    	   
    	   ps.execute();
    	   System.out.println("ok");
    	   
       }catch(SQLException e) {
    	   message = "ERROR: " + e.getMessage();
    	   e.printStackTrace();
       }
       request.setAttribute("menulist", menudao.getAllMenu());
       request.setAttribute("categorylist", categorydao.viewCategorylist()); 
       // forwards to the message page
       RequestDispatcher view = request.getRequestDispatcher("adminMenu.jsp");
		view.forward(request, response);
	}

}
