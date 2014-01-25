import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class TagTest {
    
    private Tag instance;
    
    public TagTest() {
        instance = new Tag();
        instance.setId(1);
        instance.setUserId(1);
        instance.setTag("friend");
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
     * Test of getTag method, of class Tag.
     */
    @Test
    public void testGetTag() {
        System.out.println("getTag");
        String expResult = "friend";
        String result = instance.getTag();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTag method, of class Tag.
     */
    @Test
    public void testSetTag() {
        System.out.println("setTag");
        String expResult = "familly";
        instance.setTag(expResult);
        String result = instance.getTag();
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
        instance.setTag("04E35345456");
        result = instance.isValide();
        assertFalse(result);
    }
    
}
