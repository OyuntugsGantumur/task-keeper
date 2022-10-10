import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NodeTest.
 */
public class NodeTest
{
    Node<String> node;
    Node<String> node1;
    
    /**
     * Default constructor for test class NodeTest
     */
    public NodeTest()
    {
        node = new Node<String>("do homework", "13/23/2020");
        node1 = new Node<String>("lab exam", "05/26/1999");
    }
    
    /**
     * Tests the validDate method of the Node class
     */
    @Test
    public void validDateTest() {
        assertTrue(true == node.isValid("02/25/2020"));
        assertTrue(false == node.isValid("12/35/2020"));
        assertTrue(false == node.isValid("02/29/2021"));
        
        assertEquals(null, node.deadline);
        assertEquals("05/26/1999", node1.deadline);
    }    
}
