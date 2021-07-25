package Dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileInputStream;
import Model.Cod;
import Model.Onlinebanking;
import Model.Payment;
import Connection.ConnectionManager;

public class paymentDAO {
	
	
	static Connection con = null;
	static Connection currentCon=null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	public int addPayment1 (Payment pay,Cod cod) {
		String paymentMethod = pay.getMethod();
		int orderid = pay.getOrderid();
		
		int paymentid =0;
		
		String query = "insert into payment(payment_method,order_id)values(?,?)";
		con = ConnectionManager.getConnection();
		if(pay!=null) {
			//insert into parent table (payment table)
			try(PreparedStatement ps  = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS))
			{
				ps.setString(1, paymentMethod);
				ps.setInt(2, orderid);
				
				int numRowAffected = ps.executeUpdate();
				
				try(ResultSet rs = ps.getGeneratedKeys())
				{
					if(rs.next()) {
						paymentid = rs.getInt(1);
						System.out.println("(PaymentDAO for COD)payment id in dao :"+paymentid);
					}
				}catch(SQLException e) {
					e.printStackTrace();
					System.out.println("failed in sql ");
				}
			}catch(Exception e) 
			{
				e.printStackTrace();
				System.out.println("failed");
			}
			
		}
		int payid = paymentid;
		//insert into child table (cod table)
				//payid got from result set paymentid parent table
		try {
			ps= con.prepareStatement("insert into cod(payment_id)values(?)");
			ps.setInt(1, payid);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return paymentid;
	}
	
	public int addPayment2(Payment pay,Onlinebanking ob) {
		String paymentMethod = pay.getMethod();
		int orderid = pay.getOrderid();
		InputStream receiptimage = ob.getReceiptImage();
		int paymentid =0;
		
		String card_number = ob.getCardNumber();
		String expiry_month = ob.getExpiryMonth();
		String expiry_year = ob.getExpiryYear();
		String cvv = ob.getCvv();
		
		String query = "insert into payment(payment_method,order_id)values(?,?)";
		con = ConnectionManager.getConnection();
		if(pay!=null) {
			//insert into parent table (payment table)
			try(PreparedStatement ps  = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS))
			{
				ps.setString(1, paymentMethod);
				ps.setInt(2, orderid);
				
				int numRowAffected = ps.executeUpdate();
				
				try(ResultSet rs = ps.getGeneratedKeys())
				{
					if(rs.next()) {
						paymentid = rs.getInt(1);
						System.out.println("(PaymentDAO for online banking)payment id in dao :"+paymentid);
					}
				}catch(SQLException e) {
					e.printStackTrace();
					System.out.println("failed in sql ");
				}
			}catch(Exception e) 
			{
				e.printStackTrace();
				System.out.println("failed");
			}
			
		}
		int payid = paymentid;
		//insert into child table (online banking table table)
		//payid got from result set paymentid parent table
		try {
			ps= con.prepareStatement("insert into onlinebanking(payment_id, card_number, expiry_month, expiry_year, cvv)values(?,?,?,?,?)");
			ps.setInt(1, payid);
			ps.setString(2, card_number);
			ps.setString(3, expiry_month);
			ps.setString(4, expiry_year);
			ps.setString(5, cvv);
			ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return paymentid;
	}
}
