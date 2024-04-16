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
public class Circle extends Shape{
    
        private double radius;
    
        public Circle (Color color, double radius){
        super(color);
        this.radius = radius;
    }
        
    public double area(){
        //return Math.PI*Math.pow(this.getRadius(), 2);
        return Math.PI*(this.getRadius()*this.getRadius());
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
}
