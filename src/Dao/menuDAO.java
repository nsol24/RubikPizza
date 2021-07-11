package Dao;

import java.util.*;

import Connection.ConnectionManager;

import java.io.InputStream;
import java.sql.Blob;
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
	String id;
	String name, desc,category;
	Double price;
	Blob image;
	InputStream file;
	
	
	//get all menu and display at page
	public static List<Menu> getAllMenu(){
		List<Menu> menu = new ArrayList<Menu>();
		
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select menu_id, menu_name, menu_price,menu_desc,menu_image,category_id from menu");
			while(rs.next()) {	
				Menu row = new Menu();
				row.setId(rs.getString("menu_id"));
				row.setName(rs.getString("menu_name"));
				row.setPrice(rs.getDouble("menu_price"));
				row.setDesc(rs.getString("menu_desc"));
				row.setImage(rs.getBlob("menu_image"));
				row.setCategory(rs.getString("category_id"));
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
				menu.setImage(rs.getBlob("menu_image"));
				menu.setId(rs.getString("menu_id"));
				menu.setName(rs.getString("menu_name"));
				menu.setPrice(rs.getDouble("menu_price"));
				menu.setDesc(rs.getString("menu_desc"));
				menu.setCategory(rs.getString("category_id"));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return menu;
	}
	
	//delete menu by id
	
	public void deletemenu (String delete_menuid) {
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("DELETE FROM menu WHERE menu_id = ?");
			ps.setString(1, delete_menuid);
			ps.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
