package Calculator.main;


public class OpNode extends RawNode {
    
    public enum OpCode {
        UNKNOWN,
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        POWER,
        MODULO
    }
    
    /**
     * Class fields:
     * TODO: Operator code for this node
     */
    OpCode nodeOperator;

    /**
     * Class constructor. Builds a new operator node.
     * @param rawContent - the raw content stored in this node.
     */
    protected OpNode(String rawContent) {
        super(rawContent);

        // TODO: UNKNOWN initial value for this node's operator code
        // TODO: since the raw content is not parsed.
    }
    
    /**
     * OpNode factory method, returning a new operator node 
     * for the given raw content or null if the node could not be created.
     * @param rawContent - the raw content stored in this node.
     * @return the new operator node.
     */
    public static OpNode createNode(String rawContent) {
        // TODO: Tries to parse the raw content into a OpCode value
        // TODO: if successful, creates an OpNode for it and save the operator code value within,
        // TODO: otherwise returns null 
        OpNode returnBoi = null;
        if(rawContent.equals("+")){
            returnBoi = new OpNode(rawContent);
            returnBoi.setData(OpCode.ADDITION);
            return returnBoi;
        }
        if(rawContent.equals("-")){
            returnBoi = new OpNode(rawContent);
            returnBoi.setData(OpCode.SUBTRACTION);
            return returnBoi;
        }
        if(rawContent.equals("*")){
            returnBoi = new OpNode(rawContent);
            returnBoi.setData(OpCode.MULTIPLICATION);
            return returnBoi;
        }
        if(rawContent.equals("/")){
            returnBoi = new OpNode(rawContent);
            returnBoi.setData(OpCode.DIVISION);
            return returnBoi;
        }
        if(rawContent.equals("^")){
            returnBoi = new OpNode(rawContent);
            returnBoi.setData(OpCode.POWER);
            return returnBoi;
        }
        if(rawContent.equals("%")){
            returnBoi = new OpNode(rawContent);
            returnBoi.setData(OpCode.MODULO);
            return returnBoi;
        }
        return null;
        };
    
    
    /**
     * Gets the node's operator code.
     * @return - the operator code.
     */
    public OpCode getOpCode() {
        // TODO: returns the operator code (OpCode)
        return nodeOperator;
    }

    public void setData(OpCode operator){
        nodeOperator = operator;
    }
    
    /**
     * Evaluates this operator node, returning the result of the evaluation
     * as a new numerical node.
     * @return the result as a new numerical node.
     * @throws Exception
     */
    public NumNode evaluate() throws Exception {
        double answer = 0.0;
        // TODO: precondition for evaluation is that this (operator) node is surrounded
        if(this.getPrev() == null || this.getNext() == null){
            throw new Exception("LMAOBOZO");
        }
        if(!(this.getPrev() instanceof NumNode && this.getNext() instanceof NumNode)){
            throw new Exception("LMAOBOZO");
        }
        double a = ((NumNode) prev).getNumValue();
        double b = ((NumNode) next).getNumValue();
        switch(nodeOperator){
            case ADDITION:
            answer = a + b;
            break;

            case SUBTRACTION:
            answer = a - b;
            break;

            case MULTIPLICATION:
            answer = a * b;
            break;

            case DIVISION:
            if(b == 0.0){
                throw new RuntimeException("divide by 0 XD");
            }
            answer = a / b;
            break;

            case MODULO:
            if(b == 0.0){
                throw new RuntimeException("mod by 0 XD");
            }
            answer = a % b;
            break;

            case POWER:
            answer = Math.pow(a, b);
            break;
            
            case UNKNOWN:
            default:
            throw new RuntimeException("LMAOYOUTHOUGHTXD");

        }
        // TODO: by numerical nodes. Check and throw runtime exceptions if these are not true
        // TODO: Otherwise get the two numerical (operand) nodes, execute the operator and
        // TODO: return the result as a new numerical node.
        NumNode newNode = NumNode.createNode(""+answer);
        return newNode;
    }

}
