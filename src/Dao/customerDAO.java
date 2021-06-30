package Dao;

import java.sql.*;
import java.security.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.ConnectionManager;
import Model.Customer;

public class customerDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String name,address,phone,email, password;
	
 
	//add new user (register)
	 public void add(Customer cust) throws NoSuchAlgorithmException{
		
		 name = cust.getName();
		 address =  cust.getAddress();
		 phone = cust.getPhone();
		 email = cust.getEmail();
		 password = cust.getPassword();
		 
		 
		 
		try {
			//create connection
			currentCon = ConnectionManager.getConnection();
			//create statement
			ps=currentCon.prepareStatement("insert into customer(cust_name,cust_address,cust_phone,cust_email,cust_password)values(?,?,?,?,?)");
			ps.setString(1,name );
			ps.setString(2, address);
			ps.setString(3, phone);
			ps.setString(4, email);
			ps.setString(5, password);
			
			//execute statement
			ps.executeUpdate();
			System.out.println("Added in database");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		 
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
	//get user by email
	 public static Customer getCustomerByEmail(String email) {
		 Customer cust = new Customer();
		 try {
			 currentCon = ConnectionManager.getConnection();
			 ps=currentCon.prepareStatement("select * from customer where cust_email=?");
			 ps.setString(1, email);
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()) { 
				 cust.setName(rs.getString("cust_name"));
				 cust.setAddress(rs.getString("cust_address"));
				 cust.setPhone(rs.getString("cust_phone"));
				 cust.setPassword(rs.getString("cust_password"));
				 
			 }
			 
		 }
	 	catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return cust;
	 }
	 
}
