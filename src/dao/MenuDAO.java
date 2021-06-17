package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.connection.ConnectionManager;
import model.Menu;
public class MenuDAO {
	
	static Connection con= null;
	static PreparedStatement ps =  null;
	
	int id;
	String name, desc;
	Double price;
	
	public void insert(Menu bean) {
		name = bean.getName();
		desc = bean.getDesc();
		price = bean.getPrice();
		
		try {
			con= ConnectionManager.getConnection();
			ps = con.prepareStatement("insert into menu (menu_name,menu_desc,menu_price) values(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, desc);
			ps.setDouble(3, price);
			ps.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
}
