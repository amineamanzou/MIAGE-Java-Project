/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polygoneApp;

import java.util.Arrays;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Polygone {
    
    private int N;                  // Number of Points in the polygon
    private Point[] sommets;        // P[0] = P[N] f

    /**
     * Construct a polygon using an array of Point
     * @param Point[] t array containing points
     */
    public Polygone(Point[] t) {
        int i;
        this.N = t.length;
        this.sommets = new Point[N];
        for (i=0; i < this.N; i++) {
            this.sommets[i] = t[i];
        }
    }
    
    /**
     * Randomely generate a polygone with the corresponding number of Point
     * @param int size the number of Point in the polygon
     */
    public Polygone(int size) {
        int i;
        this.N = size;
        this.sommets = new Point[N];
        for (i=0; i < this.N; i++) {
            this.sommets[i] = new Point();
        }
    }
    
    /**
     * Construct a polygon with 3 points. Constructor used by Triangle Class.
     * @param Point p1
     * @param Point p2
     * @param Point p3 
     */
    public Polygone(Point p1, Point p2, Point p3) {
        this.N = 3;
        this.sommets = new Point[N];
        this.sommets[0] = p1;
        this.sommets[1] = p2;
        this.sommets[2] = p3;
    }
    
    /**
     * Construct a polygon with 3 points. Constructor used by Rectangle Class.
     * @param Point sg
     * @param Point id 
     */
    public Polygone(Point sg, Point id) {
        this.N = 4;
        this.sommets = new Point[N];
        this.sommets[0] = sg;
        this.sommets[2] = id;
        this.sommets[1] = new Point(id.getX(),sg.getY());
        this.sommets[3] = new Point(sg.getX(),id.getY());
    }
    
    /**
     * Retrun all the array containing the points of the current polygon.
     * @return Point[] p
     */
    public Point[] getSommets() {
        return this.sommets;
    }
    
    /**
     * Return the number of point in the current polygon.
     * @return int size
     */
    public int size() { 
        return N; 
    }
    
    /**
     * Return the perimeter of the polygon. The distance between all the point of the current polygon.
     * @return double perimeter
     */
    public double perimetre() {
        int i;
        double result = 0;
        for (i=0; i < this.N-1; i++) {
            result += this.sommets[i].distance(this.sommets[i+1]);
        }
        result += this.sommets[this.N-1].distance(this.sommets[0]);
        return result;
    }
    
    /**
     * Return the surface of the polygon.
     * @return 
     */
    public double surface() {
        int i;
        double result = 0.0;
        for (i = 0; i < this.N-1; i++) {
            result += (this.sommets[i].getX() * this.sommets[i+1].getY()) 
                        - (this.sommets[i].getY() * this.sommets[i+1].getX());
        }
        result += (this.sommets[this.N-1].getX() * this.sommets[0].getY()) 
                        - (this.sommets[this.N-1].getY() * this.sommets[0].getX());
        result *= 0.5;
        return Math.abs(result);
    }
    
    /**
     * Return a string that give information about the coordinate of each point composing the current polygon.
     * @return String Sommets
     */
    public String texteSommets() {
        int i = 0;
        String list = this.sommets[i].toString()+'\n';
        for (i=1; i < this.sommets.length; i++) {
            list = list.concat(this.sommets[i].toString()+'\n');
        }
        return list;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Compare all the point of the current polygon. 
     * A polygon could be composed of the same point but in a different order.
     * The only restriction is that they have to be on the same order. 
     * @param obj
     * @return boolean result
     */
    @Override
    public boolean equals(Object obj) {
        int i,j;
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Polygone other = (Polygone) obj;
        if (!Arrays.deepEquals(this.sommets, other.sommets)) {
            return false;
        }
        else if (this.N != other.N) {
            return false;
        }
        
        int startSommet = -1;
        for (i=0; i <= this.N; i++) {
            if(i == this.N){
                return false;
            }
            // Searching for the same starting 
            if (this.sommets[0].equals(other.sommets[i])){
                startSommet = i;
                i = this.N;
            }
            
        }
        for(i=0,j=startSommet; i < this.N; i++,j++){
            if (!this.sommets[i].equals(other.sommets[j])){
                return false;
            }
            if (j == this.N-1){
                j = 0;
            }
        }
        i = 0;
        j = startSommet;
        while(i < this.N){
            if (!this.sommets[i].equals(other.sommets[j])){
                return false;
            }
            if (j == this.N-1){
                j = 0;
            }
            else {
                j++;
            }
            i++;
        }
        
        return true;
    }

    /**
     * Return a string that give the number of point in the current polygon.
     * @return String
     */
    @Override
    public String toString() {
        return "Polygone à " + this.N + " sommets";
    }
    
}
