/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polygoneApp;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Rectangle extends Polygone {
    
    // Size of each sides of the rectangle
    private double sideLong;
    private double sideLarg;
    
    /**
     * Construct a polygone with 4 point using the TopLeft point and the BottomRight
     * @param Point sg
     * @param Point id 
     */
    public Rectangle ( Point sg, Point id ) {
        super(new Point[4]);
        this.setLength(4);
        this.setSommet(0,sg);
        this.setSommet(2,id);
        this.setSommet(1,new Point(id.getX(),sg.getY()));
        this.setSommet(3,new Point(sg.getX(),id.getY()));
        Point[] sommets = this.getSommets();
        double distance1 = sommets[0].distance(sommets[1]);
        double distance2 = sommets[1].distance(sommets[2]);
        if (distance1 >= distance2 ) {
            this.sideLong = distance1;
            this.sideLarg = distance2;
        }
        else {
            this.sideLong = distance2;
            this.sideLarg = distance1;
        }
    }

    public void setSideLong(double sideLong) {
        this.sideLong = sideLong;
    }

    public void setSideLarg(double sideLarg) {
        this.sideLarg = sideLarg;
    }
    
    /**
     * Return the surface of the rectangle.
     * @return double surface
     */
    @Override
    public double surface() {
        return this.sideLong*this.sideLarg;
    }

    /**
     * Return a String containing the type of the polygone and the list of his points.
     * @return 
     */
    @Override
    public String toString() {
        return "Rectangle a plat : \n" + this.texteSommets();
    }
       
}
