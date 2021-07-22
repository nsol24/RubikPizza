package Model;



public class Join {
	private int orderMenuID;
	private int menuQuantity;
	private int orderID;
	private int menuID;
	private String menuName;
	private String menuDescription;
	private double menuPrice;
	
	private String orderStatus;
	
	private double orderTotalPrice;
	private String custEmail;
	private String custName;
	private String custPhone;
	private String custAddress;
	
	public Join() {
		
	}

	public int getOrderMenuID() {
		return orderMenuID;
	}

	public int getMenuQuantity() {
		return menuQuantity;
	}

	public int getOrderID() {
		return orderID;
	}

	public int getMenuID() {
		return menuID;
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

	public String getOrderStatus() {
		return orderStatus;
	}

	public double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public String getCustName() {
		return custName;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setOrderMenuID(int orderMenuID) {
		this.orderMenuID = orderMenuID;
	}

	public void setMenuQuantity(int menuQuantity) {
		this.menuQuantity = menuQuantity;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
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

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setOrderTotalPrice(double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	
	
}
