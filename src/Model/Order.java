package Model;

import java.util.Date;

public class Order {
	private int id;
	private double totalprice;
	private String status;
	private int orderquantity;
	private Date orderdate;
	private int pid;
	private int rid;
	private int cartid;
	private String custEmail;
	private String time;
	private String orderMonth;
	private int totalByMonth;

	public Order() {

	}
	
	public Order(int id, double totalprice, String status, int pid, int rid) {
		super();
		this.id = id;
		this.totalprice = totalprice;
		this.status = status;

		this.pid = pid;
		this.rid = rid;
	}

	public String getOrderMonth() {
		return orderMonth;
	}

	public void setOrderMonth(String orderMonth) {
		this.orderMonth = orderMonth;
	}

	public int getTotalByMonth() {
		return totalByMonth;
	}

	public void setTotalByMonth(int totalByMonth) {
		this.totalByMonth = totalByMonth;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getOrderquantity() {
		return orderquantity;
	}

	public void setOrderquantity(int orderquantity) {
		this.orderquantity = orderquantity;
	}

	public int getId() {
		return id;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public String getStatus() {
		return status;
	}

	public int getPid() {
		return pid;
	}

	public int getRid() {
		return rid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

}
