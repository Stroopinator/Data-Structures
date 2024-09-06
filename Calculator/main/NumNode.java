package Calculator.main;

public class NumNode extends RawNode {
    
    /**
     * Class fields:
     * TODO: Numerical content (double) of this node
     */
double numData;
    /**
     * Class constructor. Builds a new numerical node.
     * @param rawContent - the raw content stored in this node.
     */
    protected NumNode(String rawContent) {
        // Initializes the raw content of this node
        super(rawContent);
        numData = Double.parseDouble(super.getRawContent());
    }
    
    /**
     * NumNode factory method, returning a new numerical node 
     * for the given raw content or null if the node could not be created.
     * @param numNode - the raw content stored in this node.
     * @return the new numerical node.
     */
    public static NumNode createNode(String rawContent) {
        // TODO: Tries to parse the raw content into a double value
        // TODO: if successful, creates a NumNode for it and save the value within,
        // TODO: otherwise returns null 
        try {
            new NumNode(rawContent);
        } catch (Exception e) {
            return null;
        }
        return new NumNode(rawContent);
    }
    
    /**
     * Gets the node's numerical value.
     * @return
     */
    public double getNumValue() {
        // TODO: returns the numerical (double) content
        return numData;
    }
}
