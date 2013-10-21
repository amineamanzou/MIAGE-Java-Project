/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polygoneApp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class ListPolygone {
    
    // List of polygone
    private List<Polygone> list;

    /**
     * Construct a list of polygone creating an empty Arraylist class
     */
    public ListPolygone() {
        this.list = new ArrayList();
    }
    
    /**
     * Add a polygone to the list and verify if it's also added to the list.
     * In that case it returns false.
     * @param Polygone p
     * @return boolean success
     */
    public boolean ajoutPolygone(Polygone p) {
        if(this.list.contains(p)){
            return false;
        }
        else {
            return this.list.add(p);
        }
    }
    
    /**
     * Display informations about the polygone :
     * Type
     * Point Coordinate
     * Perimeter
     * Surface
     */
    public void afficheInfos() {
        int i;
        Polygone p;
        for(i=0;i<this.list.size();i++){
            p = (Polygone) this.list.get(i);
            System.out.println("–––––––––––––––––––––");
            System.out.println("Type : " + p.toString());
            System.out.println("Sommet :");
            System.out.print(p.texteSommets());
            System.out.println("Perimetre : " + p.perimetre());
            System.out.println("Surface : " + p.surface());
            System.out.println("–––––––––––––––––––––");
        }  
    }

    /**
     * Return a string containing the number of polygone in the ArrayList.
     * @return String Number of polygone in the list
     */
    @Override
    public String toString() {
        return "Liste de " + this.list.size() + " polygones";
    }
    
}
