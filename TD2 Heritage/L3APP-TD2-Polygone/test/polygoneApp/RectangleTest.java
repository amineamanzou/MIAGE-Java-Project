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
public class RectangleTest {
    
    public RectangleTest() {
    }

    /**
     * Test of surface method, of class Rectangle.
     */
    @Test
    public void testSurface() {
        System.out.println("surface");
        Point sg = new Point(0.0,3.0);
        Point id = new Point(6.0,0.0);
        Polygone other = new Rectangle(sg,id);
        Rectangle instance = new Rectangle(sg,id);
        double expResult = other.surface();
        double result = instance.surface();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class Rectangle.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Point sg = new Point(0.0,3.0);
        Point id = new Point(6.0,0.0);
        Rectangle instance = new Rectangle(sg,id);
        String result = instance.toString();
        System.out.println(result);
    }
}
