package Model;

public class Order {
	private int id;
	private double totalprice;
	private String status;
	private int cid;
	private int pid;
	private int rid;
	
	
	public Order(){
		
	}
	
	
	
	
	
	public Order(int id, double totalprice, String status, int cid, int pid, int rid) {
		super();
		this.id = id;
		this.totalprice = totalprice;
		this.status = status;
		this.cid = cid;
		this.pid = pid;
		this.rid = rid;
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
	public int getCid() {
		return cid;
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
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	
}
