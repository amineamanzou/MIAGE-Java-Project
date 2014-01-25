import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class PhoneTest {
    
    private Phone instance;
    
    public PhoneTest() {
        instance = new Phone();
        instance.setId(1);
        instance.setType(Type.PRO);
        instance.setUserId(1);
        instance.setNumber("0435345456");
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
    public void testGetNumber() {
        System.out.println("getNumber");
        String expResult = "0435345456";
        String result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Mail.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        String expResult = "+33435345456";
        instance.setNumber(expResult);
        String result = instance.getNumber();
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
        instance.setNumber("0435345456");
        result = instance.isValide();
        assertTrue(result);
        instance.setNumber("04E35345456");
        result = instance.isValide();
        assertFalse(result);
    }
    
}
