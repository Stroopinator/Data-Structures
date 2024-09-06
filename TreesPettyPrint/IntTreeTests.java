package TreesPettyPrint;


public class IntTreeTests {
    
    public static void main(String[] args){
        IntTree tree = new IntTree(50);
        tree.addNode(25);
        tree.addNode(75);
        tree.addNode(12);
        tree.addNode(38);
        tree.addNode(62);
        tree.addNode(87);
        tree.addNode(44);
        tree.addNode(6);
        tree.addNode(18);
        tree.addNode(32);
        tree.addNode(10);
        tree.addNode(19);
        tree.addNode(16);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(9);


        tree.prettyPrint();
        System.out.println(tree.toPreOrder());
    }
}
