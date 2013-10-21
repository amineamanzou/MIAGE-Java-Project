package polygoneApp;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class polygoneApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Creating an empty list of polygone.");
        ListPolygone listPoly = new ListPolygone();
        
        System.out.println("Creating a random polygone with 6 points.");
        Polygone p6 = new Polygone(6);
        System.out.println(p6.toString());
        
        listPoly.ajoutPolygone(p6);
        
        System.out.println("Adding 3 different triangle type to the list.");
        Point p1 = new Point(2.0,3.0);
        Point p2 = new Point(0.0,0.0);
        Point p3 = new Point(4.0,0.0);
        Triangle t1 = new Triangle(p1,p2,p3);
        System.out.println(t1.toString());
        p1 = new Point(6.0,0.0);
        p2 = new Point(0.0,0.0);
        p3 = new Point(3.0,Math.sqrt(27));
        Triangle t2 = new Triangle(p1,p2,p3);
        System.out.println(t2.toString());
        p1 = new Point(1.0,1.0);
        p2 = new Point(0.0,0.0);
        p3 = new Point(-5.0,-1.0);
        Triangle t3 = new Triangle(p1,p2,p3);
        System.out.println(t3.toString());
        
        listPoly.ajoutPolygone(t1);
        listPoly.ajoutPolygone(t2);
        listPoly.ajoutPolygone(t3);

        System.out.println("Adding a rectangle to the list.");
        Point sg = new Point(0.0,3.0);
        Point id = new Point(6.0,0.0);
        Rectangle r4 = new Rectangle(sg,id);
        System.out.println(r4.toString());
        
        listPoly.ajoutPolygone(r4);
        
        System.out.println("Adding a squarre to the list.");
        sg = new Point(1.0,0.0);
        Carre c4 = new Carre(sg,1);
        System.out.println(c4.toString());
        
        listPoly.ajoutPolygone(c4);
        
        System.out.println("Trying to add the same again to the list.");
        boolean result = listPoly.ajoutPolygone(c4);
        System.out.println("Returned " + result);
        
        System.out.println("Displaying information about all the list");
        listPoly.afficheInfos();
        
        System.out.println("End of test for more tests read the junit testing file !");
    }
}
