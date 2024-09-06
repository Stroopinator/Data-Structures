    package TreesPettyPrint;
    //WOAH CLASS INSIDE A CLASS!!!!
    public class IntTree {
    
        private class IntTreeNode{
        private int data;
        private IntTreeNode left;
        private IntTreeNode right;
        private IntTreeNode parent;
        
        public IntTreeNode(int data){
            left = null;
            right = null;
            parent = null;
            this.data = data;
        }
        
        
        public int getData(){
            return data;
        }
    } 



    private IntTreeNode overallRoot;
    private String[][] map;
    public IntTree(){
        overallRoot = null;
    }
    public IntTree(int data){
        overallRoot = new IntTreeNode(data);
        map = new String[30][100];
    }


    public void addNode(int _data){
        addNode(_data, overallRoot);
    }

    private void addNode(int data, IntTreeNode r){
        if(data >= r.data){
            if(r.right == null) {
                r.right = new IntTreeNode(data);
                r.right.parent = r;
            }
            else addNode(data, r.right);
        }
        if(data < r.data){
            if(r.left == null) {
                r.left = new IntTreeNode(data);
                r.left.parent = r;
            }
            else addNode(data, r.left);
        }
    }
    //returns the depth of the tree as an int
    public int getDepth(){
        return getDepth(overallRoot);
    }


    private int getDepth(IntTreeNode r){
        if(r == null) return 0;
        if(getDepth(r.right) > getDepth(r.left)){
            return 1 + getDepth(r.right);
        } return 1 + getDepth(r.left);
    }

    public boolean shares(){
        return shares(overallRoot);
    }
    
    private boolean shares(IntTreeNode r){
        if(r.parent == null) return false;
        if(r.parent.left == null) return false;
        if(r.parent.right == null) return false;
        if(r.parent.right.left != null && r.parent.left.right != null){
            return true;
        }
        return false;
    }

    public String toPreOrder(){
        return toPreOrder(overallRoot);
    }
    private String toPreOrder(IntTreeNode r){
        if(r == null) return "";
            if(r.right == null && r.left == null){
                return r.getData() + "";
            } 
        return("(" + r.getData() + ", " + toPreOrder(r.left) + toPreOrder(r.right) + ")");

    }
    public String toInOrder(){
    return "";
    }
    
    public String toPostOrder(){
        return "";
    }

    public void prettyPrint(){
        prettyPrint(overallRoot, 0, map[0].length/2, false, 0);
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == null){
                    System.out.print(" ");
                } 
                else System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private void prettyPrint(IntTreeNode r, int x, int y, boolean side, int depth){
        if(r == null) return;
        map[x][y] = "[";
        map[x][y+1] = r.data +"";
        map[x][y+2] = "]";
        
        
        if(r.left != null && shares(r) && side){
                int numberOfShares = (numShares(r.parent.left) + numShares(r.parent.right))*3 + 2;
                map[x+1][y + numberOfShares] = map[x][y];
                map[x][y] = null;
                map[x+1][y + numberOfShares + 1] = map[x][y+1];
                map[x][y+1] = null;
                map[x+1][y + numberOfShares + 2] = map[x][y+2];
                map[x][y+2] = null;
                for(int i = numberOfShares; i > 1; i--){
                    map[x-1][y + i] = "_";
                }
                map[x][y + numberOfShares] = "\\";
                map[x+2][y + numberOfShares-2] = "/";
                prettyPrint(r.left, x+3, y + numberOfShares - 3, false, depth+1);
                if(r.right != null){
                    map[x+2][y+ numberOfShares+1] = "\\";
                    prettyPrint(r.right, x + 3, y + numberOfShares + 2, true, depth+1);
            }
        } else  {
        if(r.right != null){
            map[x+1][y + 3 + depth/2] = "\\";
            prettyPrint(r.right, x+2, y + 2 + depth, true, depth+1);
        }

        if(r.left != null){
            map[x+1][y] = "/";
            prettyPrint(r.left, x+2 ,y-3, false, depth + 1); 
        }
        }
        
    }
    public int numShares(){
        return numShares(overallRoot)/2;
    }

    private int numShares(IntTreeNode r){
        if(r == null) return 0;
        if(shares(r)) return 1 + numShares(r.right) + numShares(r.left);
        else return numShares(r.right) + numShares(r.left);
    }
}


