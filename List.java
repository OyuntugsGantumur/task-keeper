
/**
 * Creates a task list with Nodes
 *
 * @author Oyu Gantumur
 */
public class List<E>
{
    Node<E> head;

    /**
     * Constructor for objects of class List
     */
    public List()
    {
        head = null;
    }

    /**
     * Adds the node to the back of the list
     * 
     * @param Node to be added
     */
    public void add(Node n) {
        if(n.isValid(n.deadline)) {
            
            if(head == null) {
                head = n;
            } 
            else {                
                for(Node<E> curr = head; curr != null; curr = curr.next) {
                    
                    if(curr.next == null) {
                        curr.setNext(n);
                        break;                    
                    }
                }
            }
        }
    }

    /**
     * Creates a Node with the given task and date
     * then adds to the head of the list 
     * 
     * @param String task to be added
     * @param String date to be added
     */
    public void add(E task, String date) {
        Node<E> temp = new Node<E>(task, date);

        if(head == null) {
            head = temp; 
        } else {
            temp.setNext(head);
            head = temp;
        }
    }

    /**
     * Removes the given task from the list
     * 
     * @param String task to be removes
     */
    public void remove(E done) {        
        if(head.task.equals(done)) {
            head = head.next;
        } else {        
            for(Node<E> curr = head; curr != null; curr = curr.next) {
                if(curr.next.task.equals(done)) {
                    curr.setNext(curr.next.next);
                }        
            }
        }
    }
    
    /**
     * Removes the given node from the list
     * 
     * @param node to be removed
     */
    public void remove(Node<E> done) {        
        if(head.task.equals(done.task)) {
            head = head.next;
        } else {        
            for(Node<E> curr = head; curr != null; curr = curr.next) {
                if(curr.next.task.equals(done.task)) {
                    curr.setNext(curr.next.next);
                }        
            }
        }
    }

    /**
     * Searches a Node at the given index and returns the node.
     * 
     * @param index to be search
     */
    public Node get(int id) {
        int count = 1;
        Node ret = null;

        for(Node<E> curr = head; curr != null; curr = curr.next) {
            if(count == id) {
                ret = curr;
                break;
            }
            count++;
        }

        return ret;
    }
    
    /**
     * Checks if the list contains the provided task
     * 
     * @return true if the task is in the list
     */
    public boolean contains(Node<E> n) {        
        for(Node<E> curr = head; curr != null; curr = curr.next) {
            if(n.task.equals(curr.task)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Searches the list for tasks that contain the given tag and 
     * returns a list containing those tasks.
     * 
     * @return list of tasks that contain the tag
     */
    public List searchTag(E tag) {
        List<E> ret = new List<E>();
        //int count = 1;
        
        for(Node<E> curr = this.head; curr != null; curr = curr.next) {
            if(curr.tagList.contains(tag)) { 
                Node<E> temp = new Node<E>(curr);
                ret.add(temp);
                //temp.setID(count);
                //count++;
            } 
        }

        return ret;
    }

    /**
     * Searches the list for tasks that contain the given date and 
     * returns a list of found tasks.
     * 
     * @return list of tasks that contain the date
     */
    public List searchDate(String date) {
        List<E> ret = new List<E>();
        //int count = 1;
        String[] dates = date.split("--"); 

        //all dates in the array have to be valid
        if(verifyDate(dates)) {
            
            for(Node<E> curr = this.head; curr != null; curr = curr.next) {
                if(curr.deadline.compareTo(dates[0]) >= 0 && curr.deadline.compareTo(dates[dates.length-1]) <= 0) {
                    
                    Node<E> temp = new Node<E>(curr);
                    ret.add(temp);
                    //temp.setID(count);
                    //count++;
                
                }
            }
        } 
        else {
            System.out.println("The date(s) is not valid. Please try again.");
        }

        return ret;
    }
    
    /**
     * Checks if the dates entered are valid 
     */
    public boolean verifyDate(String[] dates){
        
        for(int i = 0; i < dates.length; i++) {
            if(head.isValid(dates[i]) == false) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Converts the list to String
     * 
     * @return String of the list 
     */
    public String toString() {
        int count = 1;
        String ret = "";
        
        if(head != null) {
            head.setID(count);
            ret = count + " " + head.toString();
    
            for(Node<E> curr = head.next; curr != null; curr = curr.next) {
                count++;
                curr.setID(count);
                ret += "\n" + curr.id + " " + curr.toString();
            }
        }

        return ret;
    }
}



