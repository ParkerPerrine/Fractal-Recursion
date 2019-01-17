/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractal;


import java.awt.Color;


public class F1 implements Settings{
    public Shape s = Shape.regularShape(8);//children shape
        Color colors[] = {Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW};
        public F1() {};
        
        public Polygon initialPolygon() {
            Shape seed = Shape.regularShape(8); //baseshape
            Polygon middle = new Polygon(seed, new Point2(300, 150), new Point2(380, 150), Color.CYAN);
            return middle; }

        public boolean addFractal(Fractal f) {
            return f.depth < 6; //
        }

        public Color getColor(Fractal f, int i) {
            return colors[f.depth % 4];
        }

        public Shape getShape(Fractal f, int i) {
            return s;
        }

        public boolean insideEdge(Fractal f) {
            return f.depth == 0;
        }

        public Point2 getOrigin(Fractal f, Point2 p1, Point2 p2) {
            return p1.interp(p2, .5);
        }

        public Point2 getFirstPoint(Fractal f, Point2 p1, Point2 p2) {
            return p1.interp(p2, .3);
        }
}
