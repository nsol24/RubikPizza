package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.ConnectionManager;
import Model.Order;

public class orderDAO {
	String orderStatus,custEmail,delTime;
	Date orderDate;
	int orderId;
	double orderTotalPrice;
	static Connection con = null;
	static Connection currentCon=null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	private static final String INSERT_SQL = "insert into orders(cust_email, order_totalprice , order_date ,del_time)values(?,?,?,?)";
	
	public int addOrder (Order bean) {
		custEmail = bean.getCustEmail();
		orderTotalPrice = bean.getTotalprice();
		orderDate = (Date) bean.getOrderdate();
		delTime = bean.getTime();
		
		int orderId =0;
		
		con = ConnectionManager.getConnection();
		if(bean !=null) {
			try (PreparedStatement ps = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)){
				
				ps.setString(1,custEmail);
				ps.setDouble (2,orderTotalPrice);
				ps.setDate (3,orderDate);
				ps.setString(4, delTime);
				
				int numRowAffected = ps.executeUpdate();
				try (ResultSet rs = ps.getGeneratedKeys()){
					if (rs.next())
					{
						orderId =rs.getInt(1);
		                 System.out.println("order id dalam DAO: " + orderId);
					}
				}catch(SQLException s) {
					s.printStackTrace();
				}
				
			}catch(Exception ex) {
				System.out.println("failed: An Exception has occurred! " + ex);
				ex.printStackTrace();
			}
			
		}
		return orderId;
	}
	
	public static Order viewOrderById(int orderID) {
		System.out.println("Order ID dalam DAO: "+ orderID);
		Order order = new Order();
		
		try {
			Connection currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from orders where order_id= '"+ orderID +"'  ");
			//ps.setInt(1, orderID);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				order.setId(rs.getInt("order_id"));
				order.setStatus(rs.getString("order_status"));
				order.setOrderdate(rs.getDate("order_date"));
				order.setTotalprice(rs.getDouble("order_totalprice"));
				order.setCustEmail(rs.getString("cust_email"));
				order.setTime(rs.getString("del_time"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
}
