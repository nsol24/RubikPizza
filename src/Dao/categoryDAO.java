package Dao;
import java.sql.*;
import java.util.*;
import java.security.*;
import Connection.ConnectionManager;
import Model.Category;

public class categoryDAO {
	static Connection connect = null;
	static PreparedStatement ps = null;
	
	int category_id;
	String category_name,category_desc;
	
	//view list category
	
	public static List<Category> viewCategorylist(){
		List<Category> cat_list = new ArrayList<Category>();
		
		try {
			connect = ConnectionManager.getConnection();
			ps = connect.prepareStatement("SELECT * FROM category");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Category category_info = new Category();
				category_info.setId(rs.getString("category_id"));
				category_info.setName(rs.getString("category_name"));
				category_info.setDesc(rs.getString("category_desc"));
				category_info.setImage(rs.getString("category_image"));
				
				cat_list.add(category_info);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cat_list;
	}
	
}
