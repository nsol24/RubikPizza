package Model;

public class Category {
	private String id;
	private String name;
	private String desc;
	private String image;
	
	public Category() {
		
	}
	public Category(String id, String name, String desc, String image) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.image = image;
	}
	public String getId() {
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
	public void setId(String id) {
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
