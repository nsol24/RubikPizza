package Dao;

import java.sql.*;
import java.security.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.ConnectionManager;
import Model.Admin;
import Model.Customer;

public class customerDAO {
	static Connection currentCon = null;
	static ResultSet rs;
	static PreparedStatement ps=null;
	static Statement stmt;
	static String name,address,phone,email, password;
	
 
	//add new user (register)
	public String registercust (Customer newcust) {
		String status = null;
		name = newcust.getName();
		address = newcust.getAddress();
		phone = newcust.getPhone();
		email = newcust.getEmail();
		password = newcust.getPassword();
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("SELECT * FROM customer WHERE cust_email = ?");
			ps.setString(1, email);
			
			
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
				
				ps = currentCon.prepareStatement("INSERT INTO customer (cust_name, cust_address, cust_phone,cust_email,cust_password) VALUES (?, ?,?,?,?)");
				ps.setString(1, name);
				ps.setString(2, address);
				ps.setString(3, phone);
				ps.setString(4, email);
				ps.setString(5, sb.toString());
				
				ps.execute();
				status = "success";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	 
	//method to get user
	 public static Customer getCustomer(Customer bean) {
		//get email
		 email = bean.getEmail();
		 String searchQuery = "select * from customer where cust_email='" + email+ "'";
		 
		 try {
			//create connection
			 currentCon = ConnectionManager.getConnection();
			 //create statement
			 stmt = currentCon.createStatement();
			 //execute statement
			 rs = stmt.executeQuery(searchQuery);
			 boolean more = rs.next();
			 
			// if user exists set the isValid variable to true
			 if (more) {
			 String email = rs.getString("email");
			 bean.setEmail(email);
			 bean.setValid(true);
			 }
			 // if user does not exist set the isValid variable to false
			 else if (!more) {
			 bean.setValid(false);
			 }
		 }
		 catch(SQLException ex) {
			 ex.printStackTrace();
		 }
		 return bean;
	 }
	//view cust by email
	 public static Customer viewcustbyemail(String java_session_value) {
		 Customer cust = new Customer();
		 try {
			 currentCon = ConnectionManager.getConnection();
			 ps=currentCon.prepareStatement("select * from customer where cust_email=?");
			 ps.setString(1,java_session_value);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) { 
				 cust.setName(rs.getString("cust_name"));
				 cust.setAddress(rs.getString("cust_address"));
				 cust.setPhone(rs.getString("cust_phone"));
				 cust.setEmail(rs.getString("cust_email"));
				 cust.setPassword(rs.getString("cust_password"));
				 
			 }
			 
		 }
	 	catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return cust;
	 }
	 
	 //login customer
	 public String logincust(Customer newcust) {
			String login_status = null;
			email = newcust.getEmail();
			password = newcust.getPassword();
			try {
				currentCon = ConnectionManager.getConnection();
				ps = currentCon.prepareStatement("SELECT * FROM customer WHERE cust_email = ?");
				ps.setString(1, email);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(password.getBytes());

					byte byteData[] = md.digest();

					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < byteData.length; i++) {
						sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
					}
					
					ps = currentCon.prepareStatement("SELECT * FROM customer WHERE cust_email = ? AND cust_password = ?");
					ps.setString(1, email);
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
	 
	//update cust by email
		public void updatecust (Customer updatecust) {
			
			name =updatecust.getName();
			address = updatecust.getAddress();
			phone = updatecust.getPhone();
			email = updatecust.getEmail();
			
			try {
				currentCon = ConnectionManager.getConnection();
				ps = currentCon.prepareStatement("UPDATE customer SET cust_name = ?, cust_phone = ?, cust_address = ? WHERE cust_email = ?");
				ps.setString(1, name);
				ps.setString(2, phone);
				ps.setString(3, address);
				ps.setString(4, email);
				
				
				ps.execute();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			  
		}
		
	 
}
