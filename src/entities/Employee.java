package entities;

public class Employee {

	private String name;
	private double GrossSalary;
	private double Tax;

	public Employee(String name, double GrossSalary, double Tax) {
		this.setGrossSalary(GrossSalary);
		this.setName(name);
		this.setTax(Tax);
	}

	public double NetSalary() {
		return this.getGrossSalary() - this.getTax();

	}

	public void IncreaseSalary(double percentage) {
		this.setGrossSalary(this.getGrossSalary() + (GrossSalary * (percentage / 100)));
		System.out.println("Updated data: " + this.getName() + ", $ " + this.NetSalary());

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGrossSalary() {
		return GrossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		GrossSalary = grossSalary;
	}

	public double getTax() {
		return Tax;
	}

	public void setTax(double tax) {
		Tax = tax;
	}

}
