import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListTest.
 */
public class ListTest
{
    List<String> list;
    
    /**
     * Default constructor for test class ListTest
     */
    public ListTest()
    {
        list = new List<String>();
    }
    
    /**
     * Tests add, remove and toString methods of the List class
     */
    @Test
    public void test() {
        list.add(new Node<String>("take CS exam", "05/15/2021", "CS150"));
        list.add(new Node<String>("CS lab exam", "05/10/2021", "CS150"));        
        assertEquals("1 take CS exam : 05/15/2021 : CS150\n" + 
            "2 CS lab exam : 05/10/2021 : CS150", list.toString());
        
        list.add("write PSYC paper", "05/15/2021");
        assertEquals("1 write PSYC paper : 05/15/2021 : \n" + 
            "2 take CS exam : 05/15/2021 : CS150\n" + 
            "3 CS lab exam : 05/10/2021 : CS150", list.toString());
        
        //get testing
        assertEquals("CS lab exam : 05/10/2021 : CS150", list.get(3).toString());
        assertEquals("write PSYC paper : 05/15/2021 : ", list.get(1).toString());
        
        //remove testing
        list.remove("CS lab exam");        
        assertEquals("1 write PSYC paper : 05/15/2021 : \n" + 
            "2 take CS exam : 05/15/2021 : CS150", list.toString());
            
        //contains testing
        assertTrue(true == list.contains(new Node<String>("take CS exam", "05/15/2021", "CS150")));
        assertTrue(false == list.contains(new Node<String>("CS lab exam", "05/10/2021", "CS150")));
    }
    
    @Test
    public void searchTest() {
        list.add(new Node<String>("take CS exam", "05/15/2021", "CS150"));
        list.add(new Node<String>("CS lab exam", "05/10/2021", "CS150"));
        list.add(new Node<String>("write PSYC paper", "05/20/2021", "PSYC"));
        
        List<String> comp = list.searchTag("CS150");
        assertEquals("1 take CS exam : 05/15/2021 : CS150\n" + 
            "2 CS lab exam : 05/10/2021 : CS150", comp.toString());
         
        List<String> comp1 = list.searchDate("05/15/2021");
        assertEquals("1 take CS exam : 05/15/2021 : CS150", comp1.toString());
        
        List<String> comp2 = list.searchDate("05/08/2021--05/15/2021");
        assertEquals("1 take CS exam : 05/15/2021 : CS150\n" + 
            "2 CS lab exam : 05/10/2021 : CS150", comp2.toString());   
    }

}
