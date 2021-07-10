package Model;

public class Admin {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String password;
	private int mgrid;
	private boolean valid;
	
	public Admin() {
		
	}
	public Admin(int id,boolean valid, String name, String email, String phone, String password, int mgrid) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.mgrid = mgrid;
		this.valid = valid;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getPassword() {
		return password;
	}
	public int getMgrid() {
		return mgrid;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMgrid(int mgrid) {
		this.mgrid = mgrid;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
	
	
}
