package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product1{
	
	LocalDate manufactureDate;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("dd/MM/yyyy"));

	public UsedProduct (String name, double valuePerHour, LocalDate manufactureDate) {
		super(name, valuePerHour);
		this.setManufactureDate(manufactureDate);
	}
	
	@Override
	public String priceTag () {
		this.setStr(this.getName());
		this.setStr(" (used) $ ");
		this.setStr(String.valueOf(this.getPrice()));
		this.setStr(" (Manufacture date: ");
		this.setStr(this.formatter.format(manufactureDate)+")");
		return this.getStr().toString();
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
}
