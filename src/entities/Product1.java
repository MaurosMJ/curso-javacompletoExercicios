package entities;

public class Product1 {
	
	private String name;
	private double price;
	private StringBuilder str;
	
	public Product1 (String name, double price){
		this.name = name;
		this.price = price;
		this.str = new StringBuilder();
	}
	
	public String priceTag() {
		this.setStr(this.getName());
		this.setStr(" $ ");
		this.setStr(String.valueOf(this.getPrice()));
		return this.getStr().toString();
	}
	
	public void setStr (String input) {
		this.str.append(input);
	}
	
	public StringBuilder getStr () {
		return this.str;
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
	
	

}
