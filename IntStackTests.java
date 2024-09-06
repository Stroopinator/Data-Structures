import org.junit.Test;

import java.util.LinkedList;

public class IntStackTests {
    @Test
    public void TestAdd(){
        Long start = System.nanoTime();
        LinkedList<Integer> list = new LinkedList<Integer>();
        IntStack stack = new IntStack(list);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
        System.out.println((double)(System.nanoTime() - start) / 1000000000 + " Seconds");
    }

    @Test 
    public void TestBulkAdd(){
        Long start = System.nanoTime();
        LinkedList<Integer> list = new LinkedList<Integer>();
        IntStack stack = new IntStack(list);
        int num = 1000000;
        while(num > 0){
            stack.push(num);
            num--;
        }
        System.out.println((double)(System.nanoTime() - start) / 1000000000 + " Seconds");
    }

    @Test
    public void TestSearch(){
        Long start = System.nanoTime();
        LinkedList<Integer> list = new LinkedList<Integer>();
        IntStack stack = new IntStack(list);
        int num = 10;
        while(num > 0){
            stack.push(num);
            num--;
        }
        System.out.println((double)(System.nanoTime() - start) / 1000000000 + " Seconds");
    }
}
