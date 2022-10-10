import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ModelTest.

 */
public class ModelTest
{
    Model model;
    List<String> list;
    
    /**
     * Default constructor for test class ModelTest
     */
    public ModelTest()
    {
        list = new List<String>();        
        model = new Model(list);
    }
    
    /**
     * Tests the addTag, removeTag and search methods of the Model class. 
     */
    @Test
    public void test() {
        list.add(new Node<String>("take CS exam", "05/15/2021", "CS150"));
        list.add(new Node<String>("CS lab exam", "05/25/2021", "CS150"));
        list.add(new Node<String>("write PSYC paper", "05/15/2021", "PSYC"));
        
        assertTrue(true == model.validateTag("test"));
        assertTrue(false == model.validateTag("test;"));
        assertTrue(false == model.validateTag("/test"));
        assertTrue(false == model.validateTag("t e s t"));
        
        model.addTag("CS150");
        model.addTag("PSYC");
        model.addTag("exam");        
        assertEquals("exam PSYC CS150", model.getTagList().toString());
        
        model.removeTag("exam");
        assertEquals("PSYC\nCS150\n", model.toStrTagList());        
        model.removeTag("CS150");
        assertEquals("take CS exam : 05/15/2021 : untagged", list.get(1).toString());
    }
    
    @Test
    public void test2() {
        list.add(new Node<String>("take CS exam", "05/15/2021", "CS150"));
        list.add(new Node<String>("CS lab exam", "05/25/2021", "CS150"));
        list.add(new Node<String>("write PSYC paper", "05/20/2021", "PSYC"));
        
        model.addTag("CS150");
        model.addTag("PSYC");
        assertEquals("1 take CS exam : 05/15/2021 : CS150" + 
         "\n2 CS lab exam : 05/25/2021 : CS150", model.searchText("exam").toString());

        assertEquals("1 take CS exam : 05/15/2021 : CS150" + 
        "\n2 CS lab exam : 05/25/2021 : CS150", model.searchTagDate("AND CS150 05/15/2021--05/30/2021").toString());
    
        assertEquals("1 write PSYC paper : 05/20/2021 : PSYC" + 
        "\n2 CS lab exam : 05/25/2021 : CS150", model.searchTagDate("OR PSYC 05/20/2021--05/30/2021").toString());

    }
}
