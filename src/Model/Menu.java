package Model;

import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;


public class Menu {
	private String id;
	private String name;
	private Double price;
	private String desc;
	private Blob image;
	private String category;
	private Category cat;
	InputStream menuPicture;

	public Menu() {
		
	}
	public Menu(String id, int menuQty ,String name, Double price, String desc, Blob image, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.image = image;
		this.category = category;
		
	}
	public InputStream getMenuPicture() {
		return menuPicture;
	}
	public String getBase64Image() {
		return base64Image;
	}
	public void setMenuPicture(InputStream menuPicture) {
		this.menuPicture = menuPicture;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	String base64Image;
	
	
	
	
	
	public Category getCat() {
		return cat;
	}
	public void setCat(Category cat) {
		this.cat = cat;
	}
	public String getId() {
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
	public Blob getImage() {
		return image;
	}
	public String getCategory() {
		return category;
	}
	public void setId(String id) {
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
	public void setImage(Blob image) {
		this.image = image;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", desc=" + desc + ", image=" + image
				+ ", category=" + category + "]";
	}
	
	public boolean check(ArrayList<String> cartlist, String menuid2){
        for (String menuid : cartlist){
            if(menuid == menuid2)
                return true;
        }
        return false;
    }
	
	
	
	
	
	
}
