package entities;

public class ImportedProduct extends Product1 {

	private double customsFee;

	public ImportedProduct (String name, double price, double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {		
		this.setStr(this.getName());
		this.setStr(" $ ");
		this.setStr(String.valueOf(this.getPrice()+this.getCustomsFee()));
		this.setStr(" (Customs fee: $ ");
		this.setStr(String.valueOf(this.getCustomsFee())+")");
		return this.getStr().toString();
	}
	
	public double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(double customsFee) {
		this.customsFee = customsFee;
	}
	
	
	
}
