package model;

import java.sql.Blob;

public class Menu {
	
	private int id;
	private String name;
	private double price;
	private String desc;
	private Blob image;
	
	private Category category;
	
	
	public Menu() {
		
	}

	public Menu(int id, String name, float price, String desc, Blob image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
	
	
	
	

}
