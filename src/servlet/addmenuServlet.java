package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import dao.MenuDAO;
import db.connection.ConnectionManager;
import model.Menu;

/**
 * Servlet implementation class addmenuServlet
 */
@WebServlet("/addmenuServlet")
public class addmenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MenuDAO dao = new MenuDAO();
    
    public addmenuServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Menu menu = new Menu();
			InputStream inputStream = null; // input stream of the upload file
			int result = 0;
	        menu.setName(request.getParameter("name"));
	        menu.setPrice(Double.parseDouble(request.getParameter("price")));
	        menu.setDesc(request.getParameter("desc"));
	        
	        //request photo
	        Part filePart = request.getPart("photo");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	            
	            
	             try {
	            	 Connection con = ConnectionManager.getConnection();
					PreparedStatement ps = con.prepareStatement("insert into menu (menu_iamge) values(?)");
					
					
					InputStream is = filePart.getInputStream();
					ps.setBlob(1,is);
					result = ps.executeUpdate();
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
	            
	        }
	        
	       dao.insert(menu); 
	      
	        
		}
	
	

}
