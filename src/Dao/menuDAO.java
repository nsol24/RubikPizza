package Dao;

import java.util.*;

import Connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Model.Menu;
import Model.OrderDetails;

public class menuDAO {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
	int id;
	String name, price,desc,image,category;
	
	
	//get all menu and display at page
	public static List<Menu> getAllMenu(){
		List<Menu> menu = new ArrayList<Menu>();
		
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select menu_id, menu_name, menu_price,menu_desc,menu_image from menu");
			while(rs.next()) {
				
				Menu row = new Menu();
				row.setId(rs.getInt("menu_id"));
				row.setName(rs.getString("menu_name"));
				row.setPrice(rs.getDouble("menu_price"));
				row.setDesc(rs.getString("menu_desc"));
				row.setImage(rs.getString("menu_image"));
				
				
				menu.add(row);
			}
			con.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return menu;
		
		
	}
	
	//getMenuById
	
	public static Menu getMenuById(int id) {
		Menu menu = new Menu();
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("select * from menu where menu_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				menu.setId(rs.getInt("menu_id"));
				menu.setName(rs.getString("menu_name"));
				menu.setPrice(rs.getDouble("menu_price"));
				
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return menu;
	}
	
	
	
}
