package Calculator.main;

public class RawNode {

    /**
     * Class fields:
     * TODO: Raw content in this node, as a string.
     * TODO: References to the previous and next node, or null respectively if nodes do not exist. 
     */
private String nodeData;
protected RawNode next;
protected RawNode prev;
    /**
     * Class constructor. Builds a new generic raw content node.
     * @param rawContent - the raw content stored in this node.
     */
    protected RawNode(String rawContent) {
        nodeData = rawContent;
        // TODO: configures / initializes class fields.
    }
    
    /**
     * Node factory method, returning a new node for the given raw content
     * or null if the node could not be created.
     * @param rawContent - the row content stored in this node.
     * @return the new node.
     * THIS METHOD DOES NOT WORK COME BACK WHEN YOU UNDERSTAND HOW TO FIX
     */
    public static RawNode createNode(String rawContent) {
        try {
            return new RawNode(rawContent);
        } catch (Exception e) {
            return null;
        }
        
       
    }
    /**
     * Gets the node's raw content.
     * @return the raw content.
     */
    public String getRawContent() {
        // TODO: returns the raw content
        return nodeData;
    }
    
    /**
     * Gets the previous node.
     * @return the reference to the previous node, or null if none exists.
     */
    public RawNode getPrev() {
        // TODO: returns the reference to the previous node
        if(prev == null){
            return null;
        }
        return prev;
    }
    
    /**
     * Gets the next node.
     * @return the reference to the next node, or null if none exists.
     */
    public RawNode getNext() {
        // TODO: returns the reference to the next node
        if(next == null){
            return null;
        }
        return next;
    }
    
    /**
     * Adds another node right after this node.
     * @param other - the node to be added.
     * @return the node that's been added.
     */
    public RawNode addNext(RawNode other) {
        // TODO: code inserting the other node after this node
        if(next != null){
        next.prev = other;
        other.next = next;
        }
        next = other;
        next.prev = this;

        return other;
    }
//sets next without inserting it
    public RawNode setNext(RawNode other){
       next = other;
       return next;
    }
    
    /**
     * Adds another node to the tail of the list.
     * @param other - the node to be added.
     * @return the new tail of the list.
     */
    public RawNode addTail(RawNode other) {
        // TODO: code inserting the other node at the very end of
        // TODO: the list where this node is part of.
        //this doesnt work come back to fix it later
        if(next != null){
            next.addTail(other);
        }
        else {
        addNext(other);
        return next;
        }
        return null;
    }
    public RawNode addPrev(RawNode other){
        prev = other;
        prev.next = this;
        return other;
    }
}
