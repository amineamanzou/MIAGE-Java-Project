/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polygoneApp;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Point {
    
    // Coordinates
    private double x;
    private double y;

    /**
     * Random Constructor of a point
     */
    public Point() {
        this.x = Math.random();
        this.y = Math.random();
    }
    
    /**
     * Construct a point with the right parameter coordinate
     * @param x
     * @param y 
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Return X coordinate of a point
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * Return Y coordinate of a point
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * Return the euclidian distance between two point
     * @param Point p 
     * @return double distance
     */
    public double distance(Point p){
        double distX = this.x-p.x;
        double distY = this.y-p.y;
        return Math.sqrt(
                ( distX*distX ) + ( distY*distY )
               );
        
    }
    
    /**
     * Compare two double with a epsilon precision
     * @param r1
     * @param r2
     * @return 
     */
    public static boolean memeReel(double r1, double r2) {
        return Math.abs(r1-r2) < 1e-10 ;
    } 
    
    /**
     * Compare two Point using the memeReel method
     * @param obj
     * @return boolean result of the comparaison
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Point other = (Point) obj;
        if( !(Point.memeReel(this.x, other.getX()) && Point.memeReel(this.y, other.getY())) ) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    /**
     * Print the coordinate of the Point object
     * @return String Coordinate
     */
    @Override
    public String toString() {
        return "<" + this.x + "," + this.y + ">";
    }
    
    
}
