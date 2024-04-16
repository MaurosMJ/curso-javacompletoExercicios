/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.enums.Color;

/**
 *
 * @author 320167484
 */
public class Rectangle extends Shape {

    private double width;
    private double height;
    
    public Rectangle (Color color, double width, double height){
        super(color);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double area (){
        return this.getHeight()*this.getWidth();
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
