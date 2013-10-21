/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polygoneApp;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class PolygoneTest {
    
    public PolygoneTest() {
    }

    /**
     * Test of size method, of class Polygone.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Polygone instance = new Polygone(5);
        int expResult = 5;
        int result = instance.getLength();
        assertEquals(expResult, result);
    }

    /**
     * Test of perimetre method, of class Polygone.
     */
    @Test
    public void testPerimetre() {
        System.out.println("perimetre");
        Point[] tab = { new Point(0.0,0.0),
                        new Point(1.0,0.0),
                        new Point(1.0,1.0),
                        new Point(0.0,1.0)
                      };
        Polygone instance = new Polygone( tab );
        double expResult = 4.0;
        double result = instance.perimetre();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of surface method, of class Polygone.
     */
    @Test
    public void testSurface() {
        System.out.println("surface");
        Point[] tab = { new Point(0.0,0.0),
                        new Point(1.0,0.0),
                        new Point(1.0,1.0),
                        new Point(0.0,1.0)
                      };
        Polygone instance = new Polygone( tab );
        double expResult = 1.0;
        double result = instance.surface();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of texteSommets method, of class Polygone.
     */
    @Test
    public void testTexteSommets() {
        System.out.println("texteSommets");
        Point[] tab = { new Point(0.0,0.0),
                        new Point(1.0,0.0),
                        new Point(1.0,1.0),
                        new Point(0.0,1.0)
                      };
        Polygone instance = new Polygone( tab );
        String expResult =  "<0.0,0.0>\n" +
                            "<1.0,0.0>\n" +
                            "<1.0,1.0>\n" +
                            "<0.0,1.0>\n";
        String result = instance.texteSommets();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Polygone.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Point[] tab = { new Point(0.0,0.0),
                        new Point(1.0,0.0),
                        new Point(1.0,1.0),
                        new Point(0.0,1.0)
                      };
        Polygone instance = new Polygone( tab );
        Polygone obj = new Polygone( tab );
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Point.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Polygone instance = new Polygone(5);
        String expResult = "Polygone à 5 sommets";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
