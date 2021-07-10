package Model;

public class OrderDetails extends Menu {
	
	private int quantity;
	private int mid;
	private int oid;
	
	
	public OrderDetails() {
		
	}
	
	public OrderDetails(int quantity, int mid, int oid) {
		super();
		this.quantity = quantity;
		this.mid = mid;
		this.oid = oid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getMid() {
		return mid;
	}
	public int getOid() {
		return oid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	
}
