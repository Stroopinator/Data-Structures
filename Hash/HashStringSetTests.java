package Hash;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class HashStringSetTests {

    public static void main(String[] args) throws IOException{
        String link = "https://www.gutenberg.org/cache/epub/1533/pg1533.txt";
        URL url = new URL(link);
        URLConnection urlCnx = url.openConnection();
        InputStream urlStream = urlCnx.getInputStream();

        Scanner urlScan = new Scanner(urlStream);
        urlScan.useDelimiter("//A");

        String urlContent = urlScan.next();
        urlContent.toLowerCase();
        HashStringSet myHash = new HashStringSet();
        String[] words = urlContent.split(" ");
        Long time0 = System.nanoTime();

        for(int i = 0; i < words.length; i++){
            myHash.add(words[i]);
        }
        Long time1 = System.nanoTime();
        System.out.println("Time: " + (time1 - time0) / Math.pow(10,9));
        System.out.println("Size: " + myHash.size());
        System.out.println("Buckets: " + myHash.getBuckets());
        System.out.println("Data: " + myHash.getData());
        System.out.println("LoadFactor " + myHash.loadFactor());
        System.out.println("Overhead: " + myHash.getOverhead());
        System.out.println("ME: " + myHash.getData()/(myHash.getOverhead() + myHash.getData()));
        System.out.println("Words: " + myHash.getAllData());
        urlScan.close();
    }
}
