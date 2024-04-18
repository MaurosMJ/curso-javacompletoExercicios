package entities;

public abstract class Person {
	
	private String name;
	private double anualIncome;
	
	public Person (String name, double anualIncome) {
		this.name = name;
		this.anualIncome = anualIncome;
	}

	public abstract double calcTaxes ();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAnualIncome() {
		return anualIncome;
	}

	public void setAnualIncome(double anualIncome) {
		this.anualIncome = anualIncome;
	}
	
}
