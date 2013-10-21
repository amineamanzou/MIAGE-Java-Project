/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polygoneApp;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Carre extends Rectangle {
    
    // size of the side of the squarre
    private double side;
    
    /**
     * Construct a polygone with 4 point using the rectangle constructor.
     * @param sg
     * @param longueur 
     */
    public Carre ( Point sg, double longueur ) {
        super(sg,new Point(sg.getX()+longueur,sg.getY()-longueur));
        Point[] sommets = this.getSommets();
        double distance1 = sommets[0].distance(sommets[1]);
        this.setSideLong(distance1);
        this.setSideLarg(distance1);
        this.side = longueur;
    }

    /**
     * Return the surface of the squarre
     * @return double surface
     */
    @Override
    public double surface() {
        return this.side*this.side;
    }
    
    /**
     * Return the perimeter of the square.
     * @return double perimeter
     */
    @Override
    public double perimetre() {
        return side*4;
    }

    /**
     * return a string containing the type of the polygone and a list of his point.
     * @return String type : list
     */
    @Override
    public String toString() {
        return "Carre a plat : \n" + this.texteSommets();
    }

}
