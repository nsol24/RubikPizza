package Model;

public class OrderDetails {
	
	private int orderdetailsid;
	private int orderid;
	private String menuid;
	private String menuName;
	private String menuDescription;
	private double menuPrice;
	private double orderTotalPrice;
	
	public OrderDetails() {
		
	}

	public int getOrderdetailsid() {
		return orderdetailsid;
	}

	public int getOrderid() {
		return orderid;
	}

	public String getMenuid() {
		return menuid;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getMenuDescription() {
		return menuDescription;
	}

	public double getMenuPrice() {
		return menuPrice;
	}

	public double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderdetailsid(int orderdetailsid) {
		this.orderdetailsid = orderdetailsid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public void setMenuPrice(double menuPrice) {
		this.menuPrice = menuPrice;
	}

	public void setOrderTotalPrice(double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
	
	
	
}
