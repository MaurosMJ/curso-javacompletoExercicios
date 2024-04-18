package entities;

public class NaturalPerson extends Person {

	private double healthExp;

	public NaturalPerson(String name, double anualIncome, double healthExp) {
		super(name, anualIncome);
		this.setHealthExp(healthExp);
	}

	@Override
	public double calcTaxes() {
		if (this.getAnualIncome() < 20000f) {
			return (this.getAnualIncome() * 0.15f) - (this.getHealthExp() * 0.5f);
		} else {
			return (this.getAnualIncome() * 0.25f) - (this.getHealthExp() * 0.5f);
		}
	}

	public double getHealthExp() {
		return healthExp;
	}

	public void setHealthExp(double healthExp) {
		this.healthExp = healthExp;
	}

	public String toString () {
		return this.getName() + ": $ "+String.format("%.2f",this.calcTaxes());
	}
	
}
