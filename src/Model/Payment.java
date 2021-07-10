package Model;

public class Payment {
	
	private int id;
	private String status;
	private String receipt;
	private String method;
	
	public Payment() {
		
	}
	public Payment(int id, String status, String receipt, String method) {
		super();
		this.id = id;
		this.status = status;
		this.receipt = receipt;
		this.method = method;
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
