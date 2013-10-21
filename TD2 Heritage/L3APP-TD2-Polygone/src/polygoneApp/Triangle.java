/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polygoneApp;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Triangle extends Polygone{
    
    // Size of each sides of the triangle
    private double sideA;
    private double sideB;
    private double sideC;
    
    /**
     * Construct a polygone with 3 points and adding information about sides.
     * @param Point p1
     * @param Point p2
     * @param Point p3 
     */
    public Triangle (Point p1, Point p2, Point p3) {
        super(p1,p2,p3);
        Point[] sommets = this.getSommets();
        this.sideA = sommets[0].distance(sommets[1]);
        this.sideB = sommets[1].distance(sommets[2]);
        this.sideC = sommets[2].distance(sommets[0]);
    }
    
    /**
     * Return the surface of the Triangle.
     * @return double surface sq.units
     */
    @Override
    public double surface() {
        double result = 0.0;
        double p = 0.5 * this.perimetre();
        
        result = Math.sqrt( p * (p-sideA) * (p-sideB) * (p-sideC) );
        
        return result;
    }

    /**
     * Return a String containing the type of the Triangle and the list his point.
     * @return String Type : list
     */
    @Override
    public String toString() {
        if ( this.is_equilateral() ) {
            return "Triangle Equilateral : \n" + this.texteSommets();
        }
        else if (   this.is_isocele() )
        {
            return "Triangle Isocele : \n" + this.texteSommets();
        }
        else if ( this.is_scalene() )
        {
            return "Triangle Scalene : \n" + this.texteSommets();
        }
        return null;
    }
    
    public boolean is_scalene () {
        if (    (!Point.memeReel(this.sideA, this.sideB)) &&
                (!Point.memeReel(this.sideA, this.sideC)) &&
                (!Point.memeReel(this.sideB, this.sideC))
           )
        {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean is_equilateral () {
        if ( Point.memeReel(this.sideA, this.sideB) &&
             Point.memeReel(this.sideA, this.sideC) ) {
            return true ;
        }
        else {
            return false ;
        }
    }
    
    public boolean is_isocele () {
        if (    (Point.memeReel(sideA, sideB) && !Point.memeReel(sideA, sideC)) ||
                (Point.memeReel(sideA, sideC) && !Point.memeReel(sideA, sideB)) ||
                (Point.memeReel(sideB, sideC) && !Point.memeReel(sideB, sideA) ))
        {
            return true;
        }
        else {
            return false;
        }
    }
}
