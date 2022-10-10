import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListTagTest.
 *
 * @author  Oyu Gantumur
 */
public class ListTagTest
{
    private ListTag<String> list;
    
    /**
     * Default constructor for test class ListTagTest
     */
    public ListTagTest()
    {
        list = new ListTag<String>();
    }
    
    /**
     * Tests add, contains, and remove methods of the ListTag class
     */
    @Test
    public void test() {
        list.add("CS150");
        assertTrue(true == list.contains("CS150"));
        assertTrue(false == list.contains("paper"));
        
        list.add("exam");
        list.add("PSYC");
        
        assertEquals("PSYC exam CS150", list.toString());        
        assertTrue(true == list.contains("exam"));
        assertTrue(false == list.contains("paper"));
        
        list.remove("exam");
        assertEquals("PSYC CS150", list.toString());
        list.remove("CS150");
        assertEquals("PSYC", list.toString());
        //list.remove("PSYC");
        //assertEquals("untagged", list.toString());
    }

}
