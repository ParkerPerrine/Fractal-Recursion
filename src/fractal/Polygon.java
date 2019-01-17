

package fractal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Polygon {
    // A polygon is a sequence of points (vertices) and a color.
    // To use the fillPolygon method, you need to fill in the integer arrays
    // of x and y coordinates.
    // instance variables for display
    public ArrayList<Point2> pts;
    public Color c;

    public Polygon(Shape s, Point2 origin, Point2 first, Color c) {
        // Create a polygon based on a shape whose origin is at the given
        // point and whose first point is given - this stretches and rotates
        // the underlying shape

        pts = new ArrayList<Point2>();
        this.c = c;
        // Code goes here to create a point for each point in the shape.
        double dp = origin.dist(first);
        double ds = new Point2(0,0).dist(s.pts.get(0));
        double scale = dp/ds;
        double dx = first.x - origin.x;
        double dy = first.y - origin.y;
        double sin = dy/dp;
        double cos = dx /dp;
            
        initPoint(origin, s.pts, scale, sin, cos);

    }
    
    private void initPoint(Point2 origin, ArrayList<Point2> points, double scale, double sin, double cos)
    {
        for(Point2 p:points)
        {
            double x = scale * (p.x * cos - p.y * sin) + origin.x;
            double y = scale * (p.x * sin + p.y * cos) + origin.y;
            Point2 point = new Point2(x, y);
            this.pts.add(point);
        }
    }
    public void draw(Graphics g) {
        int[] xp = new int[pts.size()];
        int[] yp = new int[pts.size()];
        int np = 0;
        for (Point2 p : pts) {
            xp[np] = (int)((p.x * Main.zoom) - Main.panx);
            yp[np] = (int)((p.y * Main.zoom) - Main.pany);
            np++;
        }
        g.setColor(c);
        g.fillPolygon(xp, yp, np);
    }
    // This changes to the following in part 2:
    public ArrayList<Fractal> decorate(Fractal f, boolean insideEdge) {
        ArrayList<Fractal> value = new ArrayList<>();
        
        if(pts.size() > 1)
        {
            
            Fractal t;
            Point2 bPoint;
            Point2 ePoint;
            int i = 0;
            
            for(i = 0; i < pts.size() - 1; i++)
            {
                bPoint = pts.get(i);
                ePoint = pts.get(i + 1);
                
                
                t = f.decorate(bPoint, ePoint, i);
                value.add(t);
            }
           if(insideEdge){ 
            bPoint = pts.get(pts.size() - 1);
            ePoint = pts.get(0);
            
            
            t = f.decorate(bPoint, ePoint, i);
            value.add(t);
        }
        }
        return value;
    }
//    public ArrayList<Polygon> olddecorate(Fractal s, boolean bool, Color color) {
//        ArrayList<Polygon> value = new ArrayList<>();
//        
//        if(pts.size() > 1)
//        {
//            Polygon p;
//            Point2 bPoint;
//            Point2 ePoint;
//            Point2 midPoint;
//            
//            for(int i = 0; i < pts.size() - 1; i++)
//            {
//                bPoint = pts.get(i);
//                ePoint = pts.get(i + 1);
//                midPoint = bPoint.interp(ePoint, 0.5);
//                
//                p = new Polygon(s, midPoint, ePoint, color);
//                value.add(p);
//            }
//            
//            bPoint = pts.get(pts.size() - 1);
//            ePoint = pts.get(0);
//            midPoint = bPoint.interp(ePoint, 0.5);
//            
//            p = new Polygon(s, midPoint, ePoint, color);
//            value.add(p);
//        }
//        return value;
//    }
       // Create a polygon for every line segment in the polygon and return them.  
    public Point2 min() {
        
        double x = pts.get(0).x;
        double y = pts.get(0).y;
        
        for(int i = 1; i < pts.size(); i++)
        {
            x = Math.min(x, pts.get(i).x);
            y = Math.min(y, pts.get(i).y);
        }
        return new Point2(x, y);
    }
    public Point2 max() {
        double x = pts.get(0).x;
        double y = pts.get(0).y;
        
        for(int i = 1; i < pts.size(); i++)
        {
            x = Math.max(x, pts.get(i).x);
            y = Math.max(y, pts.get(i).y);
        }
        return new Point2(x, y);
    }
}
