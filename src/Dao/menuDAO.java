package Dao;

import java.util.*;

import Connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.Menu;

public class menuDAO {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	int id;
	String name, price,desc,image,category;
	
	

	public static List<Menu> getAllMenu(){
		List<Menu> menu = new ArrayList<Menu>();
		
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select menu_id, menu_name, menu_price,menu_desc,menu_image,category from menu");
			while(rs.next()) {
				
				Menu row = new Menu();
				row.setId(rs.getInt("menu_id"));
				row.setName(rs.getString("menu_name"));
				row.setPrice(rs.getDouble("menu_price"));
				row.setDesc(rs.getString("menu_desc"));
				row.setImage(rs.getString("menu_image"));
				row.setCategory(rs.getString("category"));
				
				menu.add(row);
			}
			con.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return menu;
		
		
	}
	
	
}
