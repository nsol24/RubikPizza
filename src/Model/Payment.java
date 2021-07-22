package Model;

public class Payment {
	
	private int id;
	private String status;
	private String receipt;
	private String method;
	private double payAmount;
	private int orderid;
	public boolean valid;
	
	
	public Payment() {
		
	}
	
	public Payment(int id, String status, String receipt, String method, double payAmount, int orderid, boolean valid) {
		super();
		this.id = id;
		this.status = status;
		this.receipt = receipt;
		this.method = method;
		this.payAmount = payAmount;
		this.orderid = orderid;
		this.valid = valid;
	}
	public double getPayAmount() {
		return payAmount;
	}
	public int getOrderid() {
		return orderid;
	}
	public boolean isValid() {
		return valid;
	}
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public int getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public String getReceipt() {
		return receipt;
	}
	public String getMethod() {
		return method;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	
}
