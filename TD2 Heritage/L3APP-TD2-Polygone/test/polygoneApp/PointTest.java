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
public class PointTest {
    
    public PointTest() {
    }

    /**
     * Test of getX method, of class Point.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Point instance = new Point(4.0,0.0);
        double expResult = 4.0;
        double result = instance.getX();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getY method, of class Point.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Point instance = new Point(3.0,2.0);
        double expResult = 2.0;
        double result = instance.getY();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of distance method, of class Point.
     */
    @Test
    public void testDistance() {
        System.out.println("distance");
        Point p = new Point(3.0,0.0);
        Point instance = new Point(4.0,0.0);
        double expResult = 1.0;
        double result = instance.distance(p);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of memeReel method, of class Point.
     */
    @Test
    public void testMemeReel() {
        System.out.println("memeReel");
        double r1 = 1.03;
        double r2 = 0.01;
        boolean expResult = false;
        boolean result = Point.memeReel(r1, r2);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Point.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Point(3.0,2.0);
        Point instance = new Point(3.0,2.0);
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
        Point instance = new Point(34.0,22.0);
        String expResult = "<34.0,22.0>";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
}
