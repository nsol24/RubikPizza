package Model;

public class Category {
	private int id;
	private String name;
	private String desc;
	private String image;
	
	public Category() {
		
	}
	public Category(int id, String name, String desc, String image) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
	public String getImage() {
		return image;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
