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
public class CarreTest {
    
    public CarreTest() {
    }

    /**
     * Test of surface method, of class Carre.
     */
    @Test
    public void testSurface() {
        System.out.println("surface");
        Carre instance = new Carre(new Point(0.0,1.0),1);
        double expResult = 1;
        double result = instance.surface();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class Carre.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Carre instance = new Carre(new Point(0.0,1.0),1);
        String result = instance.toString();
        System.out.println(result);
    }
}
