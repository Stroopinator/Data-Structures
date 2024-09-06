package TowerOfHanoi;

import java.util.Stack;

public class Program {
    //Author @Jack Strathy 11/21/2023
    //This program will sovle the tower of hanoi problem for nay number of given disks
    private static int numberOfDisks;
    private static Stack<Disk> s1= new Stack<Disk>();
    private static Stack<Disk> s2= new Stack<Disk>();
    private static Stack<Disk> s3= new Stack<Disk>();
    
    
    public static void main(String[] args){
    boolean solved = false;
    numberOfDisks = 3;
    for(int i = numberOfDisks; i > 0; i--){
        s1.add(new Disk(i));
        }
    while(!solved){
        s2.add(s1.pop());
        s3.add(s1.pop());
        s2.add(s3.pop());
        s3.add(s1.pop());
        s1.add(s2.pop());
        s3.add(s2.pop());
        s3.add(s1.pop());
        }
    }

}
