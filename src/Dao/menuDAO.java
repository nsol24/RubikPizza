package Dao;

import java.util.*;

import Connection.ConnectionManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Model.Menu;


public class menuDAO {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
	String id;
	String name, desc,category;
	double price;
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
				row.setCategory(rs.getString("category_id"));
				Blob blob = rs.getBlob("menu_image");
				
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer,0,bytesRead);
				}
				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				
				inputStream.close();
				outputStream.close();
				row.setBase64Image(base64Image);
				menu.add(row);
			}
			con.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return menu;
	}
	
	//getMenuById
	
	public static Menu viewMenuById(String view_menuid) {
		Menu menu = new Menu();
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("select * from menu where menu_id=?");
			ps.setString(1, view_menuid);
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
	
	//update menu by id
	public void updatemenu(Menu updatemenu) {
		id = updatemenu.getId();
		name = updatemenu.getName();
		price = updatemenu.getPrice();
		desc = updatemenu.getDesc();
		category = updatemenu.getCategory();
		image = updatemenu.getImage();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("UPDATE menu SET menu_id= ? , menu_name= ?, menu_price= ?, menu_desc= ? WHERE menu_id = ?");
			ps.setString(1,id);
			ps.setString(2, name);
			ps.setDouble(3, price);
			ps.setString(4, desc);
			ps.setString(5,id);
			ps.execute();
			System.out.println("ok dah masuk");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Menu getMenu(String menuID) throws IOException
	{
		Menu m = new Menu();
		try
		{
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from menu where menu_id='" + menuID + "'"); 
			if(rs.next())
			{
				m.setId(rs.getString("menu_id"));
				m.setName(rs.getString("menu_name"));
				m.setDesc(rs.getString("menu_desc"));
				m.setPrice(rs.getDouble("menu_price"));
				Blob blob = rs.getBlob("menu_image");
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer,0,bytesRead);
				}
				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				
				inputStream.close();
				outputStream.close();
				m.setBase64Image(base64Image);
			}
		}
		catch (SQLException e) 
		{
			 e.printStackTrace();
		}
		return m;
	}
	
	
	
}
