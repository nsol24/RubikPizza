package Dao;
import java.sql.*;
import java.security.*;

import Connection.ConnectionManager;
import Model.Admin;


public class adminDAO {
	
	static Connection connect = null;
	static PreparedStatement ps = null;
	
	String  admin_password, admin_name, admin_email, admin_phonenum; 
	int  admin_id,admin_mgrid;
	//register admin
	
	public String registeradmin (Admin newadmin) {
		String status = null;
		admin_id = newadmin.getId();
		admin_mgrid = newadmin.getMgrid();
		admin_password = newadmin.getPassword();
		
		try {
			connect = ConnectionManager.getConnection();
			ps = connect.prepareStatement("SELECT * FROM admin WHERE admin_id = ?");
			ps.setInt(1, admin_id);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				status = "fail";
			}
			else {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(admin_password.getBytes());

				byte byteData[] = md.digest();

				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < byteData.length; i++) {
					sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
				}
				
				ps = connect.prepareStatement("INSERT INTO admin (admin_id, manager_id, admin_password) VALUES (?, ?,?)");
				ps.setInt(1, admin_id);
				ps.setInt(2, admin_mgrid);
				ps.setString(3, sb.toString());
				
				ps.execute();
				status = "success";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	//login staff
	
	public String loginadmin (Admin newadmin) {
		String login_status = null;
		admin_id = newadmin.getId();
		admin_password = newadmin.getPassword();
		try {
			connect = ConnectionManager.getConnection();
			ps = connect.prepareStatement("SELECT * FROM admin WHERE admin_id = ?");
			ps.setInt(1, admin_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(admin_password.getBytes());

				byte byteData[] = md.digest();

				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < byteData.length; i++) {
					sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
				}
				
				ps = connect.prepareStatement("SELECT * FROM admin WHERE admin_id = ? AND admin_password = ?");
				ps.setInt(1, admin_id);
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
	
	//view admin by id
	
	public static Admin viewadminbyid(Integer java_session_value) {
		Admin viewadmin = new Admin();
		try {
			connect = ConnectionManager.getConnection();
			ps = connect.prepareStatement("SELECT * FROM admin WHERE admin_id = ?");
			ps.setInt(1, java_session_value);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				viewadmin.setId(Integer.parseInt(rs.getString("admin_id")));
				viewadmin.setMgrid(Integer.parseInt(rs.getString("manager_id")));
				viewadmin.setPassword(rs.getString("admin_password"));
				viewadmin.setName(rs.getString("admin_name"));
				viewadmin.setEmail(rs.getString("admin_email"));
				viewadmin.setPhone(rs.getString("admin_phone"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return viewadmin;
	}
	
	//update admin by id
	public void updateadmin (Admin updateadmin) {
		admin_name = updateadmin.getName();
		admin_email = updateadmin.getEmail();
		admin_phonenum = updateadmin.getPhone();
		admin_id = updateadmin.getId();
		admin_mgrid = updateadmin.getMgrid();
		
		try {
			connect = ConnectionManager.getConnection();
			ps = connect.prepareStatement("UPDATE admin SET manager_id = ?, admin_name = ?, admin_email = ?, admin_phone = ? WHERE admin_id = ?");
			ps.setInt(1, admin_mgrid);
			ps.setString(2, admin_name);
			ps.setString(3, admin_email);
			ps.setString(4, admin_phonenum);
			ps.setInt(5, admin_id);
			
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		  
	}
	
	
	
}

