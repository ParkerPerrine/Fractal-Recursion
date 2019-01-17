

package fractal;

public class Point2 {
    public double x, y;
    // fill in the following methods.  This class does
    // not change the x or y values - create new points to return.

    public Point2(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public Point2 scale(double s)
    {
        return new Point2((x * s), (y * s));
    }
// Multiply x and y by s
    public Point2 add(Point2 p)
    {
        
        return new Point2((x + p.x), (y + p.y));
    }
    public Point2 interp(Point2 p, double t) // This is interpolation
            // return a point between the given point and p.
            // For each coordinate, create a point with
            //    (1-t)*coordinate in current object + t*coordinate in p
    {
        return new Point2((x * (1 - t) + p.x * t), (y * (1 - t) + p.y * t));
    }
    public double dist(Point2 p) // Distance from here to point p
    {
        return  + Math.sqrt(Math.pow((p.x - x), 2) + Math.pow((p.y - y), 2));
    }

    public String toString()  // Return point in the form "(1,2)"
    {
        return "(" + x + ", " + y + ")";
    }
    public Point2 max(Point2 p)
    {
        Point2 newPoint = new Point2(x, y);
        
        if(p != null)
        {
            if(p.x > newPoint.x)
            {
                newPoint.x = p.x;
            }
            if(p.y > newPoint.y)
            {
                newPoint.y = p.y;
            }
        }
        return newPoint;
    }
    public Point2 min(Point2 p)
    {
       Point2 newPoint = new Point2(x, y);
        
        if(p != null)
        {
            if(p.x < newPoint.x)
            {
                newPoint.x = p.x;
            }
            if(p.y < newPoint.y)
            {
                newPoint.y = p.y;
            }
        }
        return newPoint;
}
}
