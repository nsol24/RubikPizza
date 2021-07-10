package Dao;

import java.sql.*;
import java.security.*;
import Connection.ConnectionManager;
import Model.Admin;
import Model.Rider;

public class riderDAO {
	static ResultSet rs = null; 
	static Statement stmt=null;
	
	static Connection connect = null;
	static PreparedStatement ps = null;
	static String address, name,email,phone,password;
	static int id;
	
	public String registerrider(Rider newrider) {
		String status = null;
		id = newrider.getId();
		
		password = newrider.getPassword();
		
		try {
			connect = ConnectionManager.getConnection();
			ps = connect.prepareStatement("SELECT * FROM rider WHERE rider_id = ?");
			ps.setInt(1, id);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				status = "fail";
			}
			else {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(password.getBytes());

				byte byteData[] = md.digest();

				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < byteData.length; i++) {
					sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
				}
				
				ps = connect.prepareStatement("INSERT INTO rider (rider_id, rider_password) VALUES (?, ?)");
				ps.setInt(1,id);
				ps.setString(2, sb.toString());
				
				ps.execute();
				status = "success";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	//login rider
	
		public String loginrider (Rider newrider) {
			String login_status = null;
			id = newrider.getId();
			password = newrider.getPassword();
			try {
				connect = ConnectionManager.getConnection();
				ps = connect.prepareStatement("SELECT * FROM rider WHERE rider_id = ?");
				ps.setInt(1, id);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(password.getBytes());

					byte byteData[] = md.digest();

					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < byteData.length; i++) {
						sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
					}
					
					ps = connect.prepareStatement("SELECT * FROM rider WHERE rider_id = ? AND rider_password = ?");
					ps.setInt(1, id);
					ps.setString(2, sb.toString());
					
					ResultSet secrs = ps.executeQuery();
					
					boolean status = secrs.next();
					
					if(status) {
						login_status = "success";
					}
					else if(!status) {
						login_status = "Wrong password";
					}
				}
				else {
					login_status = "ID number not exist";
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return login_status;

		}
		
		//view rider by id
		
		public static Rider viewriderbyid(Integer java_session_value) {
			Rider viewrider = new Rider();
			try {
				connect = ConnectionManager.getConnection();
				ps = connect.prepareStatement("SELECT * FROM rider WHERE rider_id = ?");
				ps.setInt(1, java_session_value);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					viewrider.setId(Integer.parseInt(rs.getString("rider_id")));					
					viewrider.setPassword(rs.getString("rider_password"));
					viewrider.setName(rs.getString("rider_name"));
					viewrider.setEmail(rs.getString("rider_email"));
					viewrider.setPhone(rs.getString("rider_phoneNum"));
					viewrider.setAddress(rs.getString("rider_address"));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return viewrider;
		}
	
		//update rider by id
		public void updaterider (Rider updaterider) {
			name = updaterider.getName();
			email = updaterider.getEmail();
			phone = updaterider.getPhone();
			id = updaterider.getId();
			address = updaterider.getAddress();
			
			
			try {
				connect = ConnectionManager.getConnection();
				ps = connect.prepareStatement("UPDATE rider SET rider_address = ?, rider_name = ?, rider_email = ?, rider_phoneNum = ? WHERE rider_id = ?");
				ps.setString(1,address);
				ps.setString(2, name);
				ps.setString(3, email);
				ps.setString(4, phone);
				ps.setInt(5,id);
				
				ps.execute();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			  
		}

}
