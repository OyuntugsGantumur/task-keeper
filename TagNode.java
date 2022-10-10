
/**
 * Represents each tag as a node.
 * Each node has a String name and next. 
 *
 * @author Oyu Gantumur
 */
public class TagNode<E>
{
    E tag;
    TagNode next;

    /**
     * Constructor for objects of class Tags
     */
    public TagNode(E tag)
    {
        this.tag = tag;
        this.next = null;
    }
    
    /**
     * Constructor for objects of class Tags
     */
    public TagNode() {
        this.tag = null;
        this.next = null;
    }
    
    /**
     * Returns the name tag
     */
    public E getTag(){
        return this.tag;
    }
    
    /**
     * Returns the next tag
     */
    public TagNode getNext() {
        return this.next;
    }
    
    /**
     * Sets the tag to the specified value
     */
    public void setTag(E tag) {
        this.tag = tag;
    }
    
    /**
     * Sets the next tag to the specified TagNode
     */
    public void setNext(TagNode next) {
        this.next = next;
    }

}
