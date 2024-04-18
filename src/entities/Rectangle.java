package entities;

public class Rectangle {

	private double width;
	private double height;

	public Rectangle(double width, double height) {
		this.setHeight(height);
		this.setWidth(width);
	}

	public double Area() {
		return (this.getWidth() * this.getHeight());
	}

	public double Perimeter() {
		return 2 * (this.getHeight() + this.getWidth());
	}

	public double Diagonal() {
		return Math.sqrt(Math.pow(this.getWidth(), 2) + Math.pow(this.getHeight(), 2));
	}

	public String toString() {

		return "AREA = " + this.Area() + "\n" + "PERIMETER = " + this.Perimeter() + "\n" + "DIAGONAL = "
				+ this.Diagonal();
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
