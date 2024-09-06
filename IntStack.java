import java.util.LinkedList;


public class IntStack {
    int tail;
    LinkedList<Integer> list;

    public IntStack(LinkedList<Integer> x){
        list = x;
        try {
            tail = x.getLast();
        } catch (Exception e) {
            
        }
    }

    public int pop(){
        list.removeLast();
        int temp = tail;
        if(!empty()) tail = list.getLast();
        return temp;
    }

    public void push(int other){
        tail = other;
        list.add(other);
    }

    public int peek(){
        return tail;
    }

    public boolean empty(){
        return list.size() == 0;
    }
}
