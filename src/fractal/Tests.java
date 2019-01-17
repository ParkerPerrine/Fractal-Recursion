/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractal;

/**
 *
 * @author Parker Perrine
 */
public class Tests {
    public static void main(String[] args) {
    Point2 a = new Point2(1,1);
    Point2 b = new Point2(2,3);
    System.out.println("a = " + a + " b = " + b);
    System.out.println("a + b = " + a.add(b));
    System.out.println("a.dist(b) = " + a.dist(b));
    System.out.println("a.interp(b, .5) = " + a.interp(b, .5));
    System.out.println("a.interp(b, .1) = " + a.interp(b, .1));
    }
    
}
