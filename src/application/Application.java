/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author 320167484
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in).useLocale(Locale.US);
        List <Shape> list = new ArrayList <>();
        
        System.out.print("Enter the number of shapes: ");
        int cont = input.nextInt();
        
        for (int c = 0; c < cont; c++){
        System.out.println("Shape "+"#"+(c+1)+" data:");
        System.out.print("Rectangle or Circle (r\\c)? ");
        String str = String.valueOf(input.next());
        
        System.out.print("Color (BLACK\\BLUE\\RED): ");
        String color = input.next();
        input.nextLine();
        
        if ("r".equals(str)){
            System.out.print("Width: ");
            double width = input.nextDouble();
            System.out.print("Height: ");
            double height = input.nextDouble();
            list.add(new Rectangle (Color.valueOf(color), width, height));
        } else {
            System.out.print("Radius: ");
            double radius = input.nextDouble();
            list.add(new Circle (Color.valueOf(color), radius));
        }
        } 
        
        System.out.println("SHAPE AREAS: ");
        
        for (Shape c : list){
            System.out.println(String.format("%.2f", c.area()));
        }

    }
    
}
