/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractal;

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;


public class Fractal{
    public int depth;
    public int n;
    public Settings settings;
    public Polygon here;
    public ArrayList<Fractal> kids = new ArrayList<Fractal>();
    
    public Fractal(Settings settings) {
        this.settings = settings;
        this.here = settings.initialPolygon();
        this.depth = 0;
        this.n = 0;
        expand();
    }
    public Fractal(Settings settings, Polygon here, int depth, int n) {
        this.settings = settings;
        this.here = here;
        this.depth = depth;
        this.n = n;
        expand();
    }
    public final void expand() {
        if(settings.addFractal(this))
        {
            //settings.initialPolygon().decorate(this, settings.insideEdge(this));
            kids.addAll(this.here.decorate(this, settings.insideEdge(this)));
        }
    }

    public void draw(Graphics g) {
        // Draw the polygon in the fractal as well as all sub-fractals
        this.here.draw(g);
        for(Fractal child:kids)
        {
            child.draw(g);
        }
    }

    public Fractal decorate(Point2 p1, Point2 p2, int i) {
       // Create a sub-fractal along a side of a polygon.  p1 and p2 are the side; i is the
       // side number (used in coloring).
       Fractal value = null;
       Shape shape = settings.getShape(this, i);
       Point2 origin = settings.getOrigin(this, p1, p2);
       Point2 First = settings.getFirstPoint(this, p1, p2);
       Color color = settings.getColor(this, i);
       Polygon poly = new Polygon(shape,origin,First,color);
       value = new Fractal(settings, poly, depth + 1, n);
       
       return value;
    }
    
    public Point2 max() {
        return null;
    }
    
    public Point2 min() {
        return null;
    }

   
    
}
