package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import db.connection.ConnectionManager;
import model.Category;

public class CategoryDAO {

	static Connection con= null;
	static PreparedStatement ps =  null;
	
	int id;
	String name;
	
}
