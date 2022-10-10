
/**
 * ListTag is comprised of TagNode and respresents the tag list in each task
 *
 * @author Oyu Gantumur
 */
public class ListTag<E>
{
    TagNode<E> head;

    /**
     * Constructor for objects of class ListTag
     */
    public ListTag()
    {
        head = null;
    }

    /**
     * Adds the tag to the head of the list
     * 
     * @param tag to be added
     */
    public void add(E tag) {
        if(head == null) {
            head = new TagNode(tag);
        } else {
            TagNode<E> temp = new TagNode<E>(tag);
            temp.setNext(head);
            head = temp;
        }
    }
    
    /**
     * Removes the tag given from the list
     * If there's no tag in the list, the head becomes "untagged"
     * 
     * @param tag to be removed
     */
    public void remove(E tag) {
        if(head.getTag().equals(tag)) {
            head = head.getNext();
        } else {  
            
            for(TagNode<E> curr = head; curr.next != null; curr = curr.getNext()) {
                if(curr.getNext().getTag().equals(tag)) {
                    curr.setNext(curr.getNext().getNext());
                    break;
                }
            }
        }
    }
    
    /**
     * Checks if the given tag is in the list
     * 
     * @param tag to be checked
     * @return if the tag is in the listTag
     */
    public boolean contains(E tag) {
        for(TagNode<E> curr = head; curr != null; curr = curr.getNext()) {
            if(curr.getTag().equals(tag)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Converts the list to String - prints the list in one line
     * 
     * @return String of the tags
     */
    public String toString() {
        String ret = "";
        
        if(head != null) {        
            ret = "" + head.getTag();
            
            for(TagNode<E> curr = head.next; curr != null; curr = curr.getNext()) {
                ret += " " + curr.getTag();
            }            
        }
        
        return ret;
    }
    
    /**
     * Converts the list to String - prints one tag in a line
     * 
     * @return String of the tags
     */
    public String toString2() {
        String ret = "";
        
        for(TagNode<E> curr = head; curr != null; curr = curr.getNext()) {
            ret = ret + curr.getTag() + "\n";
        }
        
        return ret;
    }
}
