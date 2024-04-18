package entities;

public class OutsourcedEmployee extends Employee3 {

	private double addtionalValue;
	
	public OutsourcedEmployee (String name, int hours, double valuePerHour, double addtionalValue) {
		super(name, hours, valuePerHour);
		this.addtionalValue = addtionalValue;
	}
	
	private double additionalCharge () {
		return  (addtionalValue * 110)/100;
	}
	
	@Override
	public double payment () {
		return super.payment() + this.additionalCharge();
	}

	public double getAddtionalValue() {
		return addtionalValue;
	}

	public void setAddtionalValue(double addtionalValue) {
		this.addtionalValue = addtionalValue;
	}
	
}
