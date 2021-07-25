package Dao;

import java.sql.*;
import java.util.*;

import Connection.ConnectionManager;
import Model.Order;

public class reportDAO {
	static Connection connect = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;

	//View & count specific parcel by month DAO
	public static List<Order> viewsalesbymonth() {
		List<Order> monthly_sales = new ArrayList<Order>();

		try {
			connect = ConnectionManager.getConnection();
			ps = connect.prepareStatement(
					"SELECT MONTHNAME(order_date) AS month_name, COUNT(MONTHNAME(order_date)) AS total FROM orders WHERE YEAR(order_date) = YEAR(CURRENT_DATE) GROUP BY MONTHNAME(order_date) ORDER BY MONTH(order_date)");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Order order_month_current = new Order();
				order_month_current.setOrderMonth(rs.getString("month_name"));
				order_month_current.setTotalByMonth(rs.getInt("total"));

				monthly_sales.add(order_month_current);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return monthly_sales;
	}
}