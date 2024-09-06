import java.util.LinkedList;

public class IntQueue extends LinkedList<Integer>{
    @Override
    public Integer remove(){
        int temp = getFirst();
        removeFirst();
        return temp;
    }
    @Override
    public Integer peek(){
        return getFirst();
    }
    @Override
    public boolean add(Integer arg0){
        addLast(arg0);
        return false;
    }
    
    @Override
    public Integer element(){
        return getFirst();
    }

}

