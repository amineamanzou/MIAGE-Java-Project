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
public class ListPolygoneTest {
    
    public ListPolygoneTest() {
    }

    /**
     * Test of ajoutPolygone method, of class ListPolygone.
     */
    @Test
    public void testAjoutPolygone() {
        System.out.println("ajoutPolygone");
        Polygone p = new Polygone(6);
        ListPolygone instance = new ListPolygone();
        boolean expResult = true;
        boolean result = instance.ajoutPolygone(p);
        assertEquals(expResult, result);
        expResult = false;
        result = instance.ajoutPolygone(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of afficheInfos method, of class ListPolygone.
     */
    @Test
    public void testAfficheInfos() {
        System.out.println("afficheInfos");
        Polygone p = new Polygone(6);
        Polygone p1 = new Polygone(5);
        ListPolygone instance = new ListPolygone();
        instance.ajoutPolygone(p);
        instance.ajoutPolygone(p1);
        instance.afficheInfos();
    }

    /**
     * Test of toString method, of class ListPolygone.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Polygone p = new Polygone(6);
        Polygone p1 = new Polygone(5);
        ListPolygone instance = new ListPolygone();
        instance.ajoutPolygone(p);
        instance.ajoutPolygone(p1);
        String expResult = "Liste de 2 polygones";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
