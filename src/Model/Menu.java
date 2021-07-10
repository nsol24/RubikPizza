package Model;

public class Menu {
	private int id;
	private String name;
	private Double price;
	private String desc;
	private String image;
	private int category;
	
	public Menu() {
		
	}
	public Menu(int id, String name, Double price, String desc, String image, int category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.image = image;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Double getPrice() {
		return price;
	}
	public String getDesc() {
		return desc;
	}
	public String getImage() {
		return image;
	}
	public int getCategory() {
		return category;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(Double string) {
		this.price = string;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", desc=" + desc + ", image=" + image
				+ ", category=" + category + "]";
	}
	
	
	
	
	
}
