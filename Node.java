import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a task as a Node, saves the tags as a ListTag, 
 * and validates the deadline.
 *
 * @author (your name)
 */
public class Node<E>
{
    E task;
    String deadline;
    Node next;
    ListTag<E> tagList;
    int id;

    /**
     * Constructor for objects of class Node with tag
     */
    public Node(E task, String deadline, E newTag)
    {
        this.task = task;       
        this.next = null;
        tagList = new ListTag<E>();
        tagList.add(newTag);      
        
        if(isValid(deadline)) {
            this.deadline = deadline;
        } else {
            this.deadline = null;
            System.out.println("Date is not valid and is not saved");
        }
    }
    
    /**
     * Constructor for objects of class Node without tag
     */
    public Node(E task, String deadline) {
        this.task = task;        
        this.next = null;
        tagList = new ListTag<E>();

        if(isValid(deadline)) {
            this.deadline = deadline;
        } else {
            this.deadline = null;
            System.out.println("Date is not valid and is not saved");
        }
    }
    
    /**
     * Constructor for objects of class Node with a Node
     */
    public Node(Node<E> n) {
        this.task = n.task;
        this.next = null;
        this.tagList = n.tagList;
        this.deadline = n.deadline;
    }
    
    /**
     * Adds a tag to the tagList
     * 
     * @param String tag to be added
     */
    public void addMoreTag(E tag) {
        tagList.add(tag);
    }
    
    /**
     * Checks if the date is valid
     * 
     * @param date to be validated
     * @return true if the date is valid
     */
    public boolean isValid(String date) {
        LocalDate ld = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        try{
            ld = LocalDate.parse(date, formatter);
            String result = ld.format(formatter);
            return result.equals(date);
        } catch (DateTimeParseException e) {
            System.out.println("Exception " + e + " occured.");
        }
        
        return false;
    }
    
    /**
     * Converts the task to a String
     */
    public String toString() {
        return this.task + " : " + this.deadline + 
            " : " + this.tagList.toString(); 
    }
    
    /**
     * Sets the task to the provided task
     */
    public void setTask(E task) {
        this.task = task;
    }
    
    /**
     * Checks if the given deadline is valid. If so, sets the deadline to the provided one. 
     */
    public void setDeadline(String deadline) {
        if(isValid(deadline)) {
            this.deadline = deadline;
        } else {
            this.deadline = null;
            System.out.println("Date is not valid and is not saved");
        }
    }
    
    /**
     * Sets the next node to the provided one
     */
    public void setNext(Node next) {
        this.next = next;
    }
    
    /**
     * Sets the id to the provided id
     */
    public void setID(int id) {
        this.id = id;
    }
}
