package Calculator.main;

import Calculator.main.OpNode.OpCode;

public class NumCalc {
    
    /**
     * Class fields:
     * TODO: Operators precedence table, as a double array of operator codes (OpNode.OpCode).
     * TODO: Expression list: a double-linked list containing the numbers and operators to be evaluated.
     * TODO: Tracing list: a double-linked list containing raw nodes, each holding a trace frame as a string. 
     */
    private double mathPointer;
    /**
     * Class constructor.
     */
private RawNode expressionList;
private RawNode tracingList;
     // [^]
     // [* / %]
     // [+ -]
    /**
     * I dont know what this does i just followed my teachers example
     */
     private OpCode[][] _precedenceTb1 = {
        {OpNode.OpCode.POWER},
        {OpNode.OpCode.MULTIPLICATION, OpNode.OpCode.DIVISION, OpNode.OpCode.MODULO},
        {OpNode.OpCode.ADDITION, OpNode.OpCode.SUBTRACTION}
     };
    public NumCalc() {
        // TODO: initialize the calculator

    }
    
    /**
     * Takes the expression strings and builds the internal
     * double-linked list storing the expression nodes.
     * @param exprStrings - components of the expression string 
     */
    private void buildExprList(String[] exprStrings) {
        // TODO: For each string in the expression, try creating either
        try {
            expressionList = NumNode.createNode(exprStrings[0]);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("Failed to build expression list");
        }
        String[] refinedList = new String[exprStrings.length -1];
        for(int i = 0; i < refinedList.length; i++){
            refinedList[i] = exprStrings[i+1];
        }
        for (String str : refinedList) {
            try {
                RawNode temp = OpNode.createNode(str);
                if(temp == null){
                    temp = NumNode.createNode(str);
                }
                expressionList.addTail(temp);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }  
                }
        // TODO: a numeric node or an operator node.
        // TODO: Whichever succeeds first, is added to the tail of the expression list.
        // TODO: If neither nodes could be created, thrown a runtime exception.
    }
    
    /**
     * Evaluates the expression stored in the double linked list
     * and returns the final result. 
     * @return - evaluation result.
     * @throws Exception
     */
    private String evalExprList() throws Exception {
        // TODO: For each row of operators in the precedence table,
        String output = "";
        addTraceFrame();
        RawNode p = expressionList;
        //NumNode node = null;
        for(OpCode[] operatorPrecedence: _precedenceTb1){
            //temp = expressionList;
            //System.out.println("I ran");
            for(OpCode operator: operatorPrecedence){
                p = expressionList;
                //checks to ensure temp is an opNode
                while(p != null){
                if(p instanceof OpNode){
                    //Checks operators for precedence
                    //System.out.println("is an operator node");
                    if(((OpNode) p).getOpCode() == operator){
                       // System.out.println("case evaluated");
                        //evaluates the node and creates a new node
                      NumNode node = (((OpNode) p).evaluate());
                       //Logical expressions to handel insertion of the new Node
                       if(p.getPrev().getPrev() != null){
                       // System.out.println("case 1");
                        p.getPrev().getPrev().addNext(node);
                            if(p.getNext().getNext() != null){
                                //System.out.println("case 2");
                                //p.getPrev().cut();
                                p.getPrev().getPrev().setNext(p.getNext().getNext());
                                p.getNext().getNext().addPrev(p.getPrev().getPrev());
                                p = p.getPrev().getPrev();
                            } else {
                            p.getPrev().getPrev().setNext(null);
                            p = p.getPrev().getPrev();
                            }
                       } else
                        if(p.getNext().getNext() != null){
                            //System.out.println("case 3");
                            p.getNext().getNext().addPrev(node);
                            //p.getNext().cut();
                            p = p.getNext().getNext().getPrev();
                        }
                             else {output = node.getRawContent();
                             expressionList = RawNode.createNode(output);
                             addTraceFrame();
                             return output;
                             }
                        //TODO: THIS NEEDS TO BE CHANGED BECUASE OF THINGS FIGURE IT OUT AGIAN!
                        
                        //reset temp to the first expression in the list
                        //tacing can be done later
                        RawNode temp = p;
                        while(temp.getPrev() != null){
                            temp = temp.getPrev();
                        }
                        expressionList = temp;
                        addTraceFrame();
                       // return evalExprList();
                       }
                    } //else temp = temp.getNext();
                p = p.getNext();
                } 
            }
        }


        return null;
    }   
        // TODO: Scan the expression lists and check each operator node.
        // TODO: If the operator code is found in the row of operators,
        // TODO: evaluate it, and replace the operator node and its operands
        // TODO: with the node for the result. After each such reduction of the list
        // TODO: add the entire expression list as a frame into the trace frames list.
        // TODO: When all loops are done, expression list should contain only one numerical node,
        // TODO: which is the final result. Method returns the numerical value, as a string.
    
    
    /**
     * Constructs a new trace frame string from the expression list
     * and adds it to the trace list.
     */
    private void addTraceFrame() {
        // TODO: Builds a trace frame from the expression list:
        String output = "";
        RawNode temp = expressionList;
        while(temp != null){
            output += temp.getRawContent() + " ";
            temp = temp.getNext();
        }
        
if (tracingList == null){
    tracingList = RawNode.createNode(output);
} else tracingList.addTail(RawNode.createNode(output));
        // TODO: Goes through the expression list nodes and adds their raw content
        // TODO: to a string accumulator, separated by one space character.
        // TODO: The resulting string is added as a new raw node to the tail of the tracing list. 
    }
    
    /**
     * Takes a raw expression and returns the final evaluation result.
     * @param expression as entered by the user.
     * @return - evaluation result.
     * @throws Exception
     */
    public String evaluate(String expression) throws Exception {
        // TODO: Resets the expression list and the tracing list,
        expressionList = null;
        tracingList = null;
        // TODO: Splits the expression string around the " " character, into its individual parts
        String[] question = expression.split(" ");
        // TODO: Builds the expression list,
        buildExprList(question);
        // TODO: Evaluates the expression and returns the result of the evaluation.
        return evalExprList();
    }
    
    /**
     * Gives the evaluation trace of the last evaluated expression,
     * as a multi-line string.
     */
    @Override
    public String toString() {
        String output = "";
        RawNode p = tracingList;
        while(p != null){
            output += p.getRawContent();
            output += "\n";
            p = p.getNext();
        }
        // TODO: Goes through the tracing list nodes adding the node raw content to
        // TODO: an accumulator string, separated by "\n" (each trace frame on a new line)
        // TODO: then returns the accumulated result.
        return output;
    }
}


