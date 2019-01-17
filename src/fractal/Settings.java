/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractal;

import java.awt.Color;

/**
 *
 * @author Zachary Powell
 */
public interface Settings {
    
    public Polygon initialPolygon();
    public boolean addFractal(Fractal f);
    public Color getColor(Fractal f, int i);
    public Shape getShape(Fractal f, int i);
    public boolean insideEdge(Fractal f);
    public Point2 getOrigin(Fractal f, Point2 p1, Point2 p2);
    public Point2 getFirstPoint(Fractal f, Point2 p1, Point2 p2);
    
}
