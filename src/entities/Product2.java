package entities;

public class Product2 {

	private String name;
	double price;
	int qtd;
	
	public Product2 (String name, double price, int qtd) {
		this.name = name;
		this.price = price;
		this.qtd = qtd;
	}
	
	@Override
	public String toString() {
		return this.getName()+","+this.getPrice()+","+(String.format("%.2f", this.getQtd()*this.getPrice()));
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
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	
	
}
