package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.util.List;
//import java.util.ArrayList;
import java.sql.Date;
import Connection.ConnectionManager;
import Model.*;
import Dao.*;
public class orderdetailsDAO {
	String orderStatus,custEmail,delTime;
	Date orderDate;
	int orderId;
	double orderTotalPrice;
	static Connection con = null;
	static Connection currentCon=null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	public static int addOrderDetails(int orderID ,String menuID)
	{
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("insert into orderdetails(order_id, menu_id)values(?,?)");
			
			ps.setInt(1,orderID);
			ps.setString(2, menuID);
			
			ps.executeUpdate();
			
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return orderID;
	}
	
	
}	
