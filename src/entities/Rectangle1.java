package entities;

import entities.enums.Color;

public class Rectangle1 extends Shape{

	private double width;
	private double height;

	public Rectangle1 (Color color, double width, double height){
        super(color);
        this.width = width;
        this.height = height;
    }

	@Override
	public double area() {
		return this.getHeight() * this.getWidth();
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
