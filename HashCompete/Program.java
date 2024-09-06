package HashCompete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import HashCompete.HashWordSet;

public class Program {
    private static final String _bookFile = "HashCompete/TheCompleteWorks.txt";
    
    public static void main(String[] args) throws FileNotFoundException {


        HashWordSet hash = new HashWordSet();
         File file = new File(_bookFile);
         Scanner reader = new Scanner(file, "UTF-8");
        // for(int i = 0; i < 999; i++){
        //      reader = new Scanner(file, "UTF-8");
        //      hash = new HashWordSet(i);
        //         while(reader.hasNext()){
        //             hash.add(reader.next());
        //         }
        //         //System.out.println(hash);
        //    bpw.write(hash.getTelemtry());
        //    }
        //    bpw.close();
         while(reader.hasNext()){
             hash.add(reader.next());
         }
         System.out.println();
        reader.close();
        System.out.println(hash);
        
        // print the hash object
        
        System.out.println("Goodbye!");
    }
}


