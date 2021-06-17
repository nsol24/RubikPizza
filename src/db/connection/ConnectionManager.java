package db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	  
	static Connection con;
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static final String DB_CONNECTION = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_76c19b622dd9a4e";
	private static final String DB_USER = "b9d191c32faac0";
	private static final String DB_PASSWORD = "f4a019ef";
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName(DB_DRIVER);
			try {
				
				con= DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
				System.out.println("Connected");
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		return con;
	}
}
