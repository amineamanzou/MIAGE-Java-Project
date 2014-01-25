/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class MailTest {
    
    private Mail instance;
    
    public MailTest() {
        instance = new Mail();
        instance.setId(1);
        instance.setType(Type.PRO);
        instance.setUserId(1);
        instance.setEmail("amine@outlook.fr");
    }

    /**
     * Test of getId method, of class Mail.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Integer expResult = 1;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Mail.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer expResult = 2;
        instance.setId(expResult);
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Mail.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "amine@outlook.fr";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Mail.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String expResult = "mail@gmail.com";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class Mail.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Type expResult = Type.PRO;
        Type result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class Mail.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        Type expResult = Type.FIXE;
        instance.setType(expResult);
        Type result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserId method, of class Mail.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        Integer expResult = 1;
        Integer result = instance.getUserId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserId method, of class Mail.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        Integer expResult = 2;
        instance.setUserId(expResult);
        Integer result = instance.getUserId();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValide method, of class Mail.
     */
    @Test
    public void testIsValide() {
        System.out.println("isValide");
        boolean expResult = true;
        boolean result = instance.isValide();
        assertTrue(result);
    }
    
}
