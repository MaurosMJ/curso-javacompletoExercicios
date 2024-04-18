package entities;

public class LegalPerson extends Person {

	private int employNum;

	public LegalPerson(String name, double anualIncome, int employNum) {
		super(name, anualIncome);
		this.setEmployNum(employNum);
	}

	@Override
	public double calcTaxes() {
		if (this.getEmployNum() <= 10) {
			return this.getAnualIncome() * 0.16f;
		} else {
			return this.getAnualIncome() * 0.14f;
		}
	}

	public int getEmployNum() {
		return employNum;
	}

	public void setEmployNum(int employNum) {
		this.employNum = employNum;
	}
	
	public String toString () {
		return this.getName() + ": $ "+String.format("%.2f",this.calcTaxes());
	}

}
