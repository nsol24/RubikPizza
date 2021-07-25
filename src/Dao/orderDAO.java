package Dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import Connection.ConnectionManager;
import Model.Menu;
import Model.Order;
import Model.OrderDetails;

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
	//view order at admin,
	public static List<Order> viewOrderList(){
		List<Order> order = new ArrayList<Order>();
		
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select order_id, cust_email, order_date,del_time,order_status,rider_id from orders");
			while(rs.next()) {	
				Order row = new Order();
				row.setId(rs.getInt("order_id"));
				row.setCustEmail(rs.getString("cust_email"));
				row.setOrderdate(rs.getDate("order_date"));
				row.setTime(rs.getString("del_time"));
				row.setStatus(rs.getString("order_status"));
				row.setRid(rs.getInt("rider_id"));
				
				order.add(row);
			}
			con.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return order;
	}
	
	//update order by id status and rider id
	
	public void updateorder(Order updateorder) {
		int id = updateorder.getId();
		String status = updateorder.getStatus();
		int rider_id = updateorder.getRid();
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("UPDATE orders SET order_status=? ,rider_id=? WHERE order_id = ?");
			ps.setString(1, status);
			ps.setInt(2, rider_id);
			ps.setInt(3,id );
			ps.execute();
			System.out.println("ok dah masuk");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Order> viewallOrderCustomer(int orderid){
		List<Order> orderC = new ArrayList<Order>();
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from orders where order_id='"+orderid+"' ");
			
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("order_id"));
				order.setOrderdate(rs.getDate("order_date"));
				order.setTotalprice(rs.getDouble("order_totalprice"));
				order.setStatus(rs.getString("order_status"));
				
				orderC.add(order);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return orderC;
	}
	
}
