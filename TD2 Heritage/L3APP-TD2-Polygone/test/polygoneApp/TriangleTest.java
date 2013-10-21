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
public class TriangleTest {
    
    public TriangleTest() {
    }

    /**
     * Test of surface method, of class Triangle.
     */
    @Test
    public void testSurface() {
        System.out.println("surface");
        Point p1 = new Point(1.0,1.0);
        Point p2 = new Point(0.0,0.0);
        Point p3 = new Point(3.0,0.0);
        Triangle instance = new Triangle(p1,p2,p3);
        Polygone other = new Triangle(p1,p2,p3);
        double expResult = other.surface();
        double result = instance.surface();
        assertEquals(expResult, result, 1e-10);
    }

    /**
     * Test of toString method, of class Triangle.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Point p1 = new Point(2.0,3.0);
        Point p2 = new Point(0.0,0.0);
        Point p3 = new Point(4.0,0.0);
        Triangle instance = new Triangle(p1,p2,p3);
        String expResult = "";
        String result = instance.toString();
        System.out.println(result);
        p1 = new Point(6.0,0.0);
        p2 = new Point(0.0,0.0);
        p3 = new Point(3.0,Math.sqrt(27));
        instance = new Triangle(p1,p2,p3);
        result = instance.toString();
        System.out.println(result);
        p1 = new Point(1.0,1.0);
        p2 = new Point(0.0,0.0);
        p3 = new Point(-5.0,-1.0);
        instance = new Triangle(p1,p2,p3);
        result = instance.toString();
        System.out.println(result);
    }
}
