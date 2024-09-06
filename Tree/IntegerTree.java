package Tree;
import java.util.ArrayList;
import java.util.function.Consumer;


public class IntegerTree{
    public static void main(String[] args){
        ArrayList<String> words = new ArrayList<String>();
        words.add("Hello");
        words.add("World!");
        Consumer<String> print = (n) -> System.out.print(n +"! ");
        Consumer<String> print2 = (n) -> System.out.print(n+"? ");
        Test2(words, print2);
    }  
    
    public static void Test2(ArrayList<String> words, Consumer<String> method){
        words.forEach(method);
    }
}