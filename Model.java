import java.io.*;

/**
 * Represents the data structure and 
 * have all methods needed for the program functionality. 
 *
 * @author Oyu Gantumur
 */
public class Model
{
    List<String> list;
    ListTag<String> genTagList;

    /**
     * Constructor for objects of class Model
     */
    public Model(List list)
    {
        this.list = list;
        genTagList = new ListTag<String>();       
    }

    /**
     * Returns the TagList
     */
    public ListTag getTagList() {
        return this.genTagList;
    }

    /**
     * Returns the list
     */
    public List getList() {
        return this.list;
    }    
    
    /**
     * Checks if the tag is valid
     */
    public boolean validateTag(String tag) {
        for(int i = 0; i < tag.length(); i++) {
            if(Character.isLetterOrDigit(tag.charAt(i)) == false || tag.contains(" ") == true) {
                System.out.println(tag + " is in invalid format: either includes a space or pubctuation");
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Validates the tag and adds the tag to the tagList of the head 
     */
    public void addTagToTask(String tag) {
        if(validateTag(tag) == true) {
            list.head.addMoreTag(tag);
        }
    }
 
    /**
     * Adds the tag to the tagList if it doesn't already contain it
     */ 
    public void addTag(String tag) {
        //if the list doesn't contain the tag
        if(genTagList.contains(tag) == false && validateTag(tag) == true) {
            genTagList.add(tag);
        }
    }

    /**
     * Removes the given tag from the tagList and all tasks with that tag from the list
     * If the tagList is empty, assigns the tag "untagged".
     * 
     * @param String tag to be removed
     */
    public void removeTag(String tag) { 
        
        for(Node<String> curr = list.head; curr != null; curr = curr.next) {
            if(curr.tagList.contains(tag)) {
                curr.tagList.remove(tag);
                
                //if the list is empty, add untagged
                if(curr.tagList.head == null) {
                    curr.tagList.add("untagged");
                }
            }
        }

        genTagList.remove(tag);        
    }
 
    /**
     * Converts the tagList to String
     */
    public String toStrTagList() {
        return genTagList.toString2();
    }
    
    /**
     * Searches the list for tasks that contain the given text and 
     * returns a list of found tasks.
     * 
     * @return list of tasks that contain the text
     */
    public List searchText(String text) {
        List ret = new List();
        int count = 1;

        for(Node<String> curr = list.head; curr.next != null; curr = curr.next) {
            if(curr.task.contains(text)) {
                Node<String> temp = new Node<String>(curr);
                ret.add(temp);
                temp.setID(count);
                count++;
            }
            
            if(curr.next.next == null) {
                Node<String> temp = new Node<String>(curr. next);
                if(temp.task.contains(text)) {
                    ret.add(temp);
                    temp.setID(count);
                    count++;
                }
            }
        }

        return ret;
    }
    
    /**
     * Searches the list for a combination of tags and dates with the given logical expressions
     * and returns a list of found tasks
     * 
     * @return list of tasks that satisfy the requested search
     */
    public List searchTagDate(String inp) {
        List<String> ret = new List<String>();       
        String[] input = inp.split(" ");
        
        if(input[0].equals("AND")) {
            return searchAND(input);
        } 
        else if (input[0].equals("OR")) {
            return searchOR(input);
        } 
        else {
            System.out.println("Wrong formatting! For example: AND tag1 tag2 date");
        }        
        
        return ret;
    }
    
    /**
     * Searches and returns the list of tasks 
     * that contain all the elements of the input array
     * 
     * @param input array that specify the search
     * @return list of tasks with all the elements in the array
     */
    public List searchAND(String[] inp) {
        List<String> ret = this.list;
        
        for(int i = 1; i < inp.length; i++) {
            
            if(genTagList.contains(inp[i])) {
                ret = ret.searchTag(inp[i]);
            } 
            else if(inp[i].contains("/")){
                ret = ret.searchDate(inp[i]);
            } 
        }
        
        return ret;
    }
    
    /**
     * Searches and returns the list of tasks 
     * that contain at least one of the elements of the input array
     * 
     * @param input array that specify the search
     * @return list of tasks with at least one of the elements in the array
     */
    public List searchOR(String[] inp) {
        List<String> ret = new List<String>();
        List<String> output = new List<String>();
        
        for(int i = 1; i < inp.length; i++) {
            
            if(genTagList.contains(inp[i])) {
                output = list.searchTag(inp[i]);
                ret = combines(ret, output);
            } 
            else if(inp[i].contains("/")) {
                output = list.searchDate(inp[i]);
                ret = combines(ret, output);
            }
        }
        
        return ret;
    }
    
    /**
     * Checks if a list contains the tasks of the other list
     * If it doesn't, add that task to the list
     * 
     * @param two lists to be compared to
     * @return List ret that has all the elements of both input lists
     */
    public List combines(List ret, List input) {
        
        for(Node<String> curr = input.head; curr != null; curr = curr.next) {
            if(ret.contains(curr) == false) {
                
                Node<String> temp = new Node<String>(curr);
                ret.add(temp);
            }
        }
        
        return ret;
    }
}
