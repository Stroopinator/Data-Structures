package Mountains;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Assignment Mountains project creator @Jack Strathy
 * Date 9/20/23
 * This assignment will read a file
 * Ps I am not using the 3.281 conversion rate of feet to meters because this is my project and i am rounding it to 3
 */
public class MountainsProgram {
    public static void main(String[] args) throws IOException{
        ArrayList myMountains = new ArrayList<Mountain>();
        System.out.println("Welcome to the Mountains Project");
        Path dbPath = Paths.get("Mountains/files/mountains_db.tsv");
        BufferedReader br = Files.newBufferedReader(dbPath, StandardCharsets.UTF_8);
        int errors = 0;
        int index = 0;
        File p = new File("Mountains/files/ValidMountains.tsv");
        File f = new File("Mountains/files/InvalidMountains.tsv");
        FileWriter fw = new FileWriter(f);
        FileWriter pw = new FileWriter(p);
        BufferedWriter bfw = new BufferedWriter(fw);
        BufferedWriter bpw = new BufferedWriter(pw);
        bpw.write("Country  " + "Name   " + "Lat    " + "Long   " + "Elevation\n");
        bfw.write("Country  " + "Name   " + "Lat    " + "Long   " + "Elevation\n");
        while(br.ready()){
            String line = br.readLine();
            Mountain myMountain = new Mountain(line);
            if(myMountain.getHasError() == true){
                bfw.write(myMountain.getFailedStream() + "\t" +myMountain.getErrorMessages()+"\n");
            } else{
                bpw.write(myMountain.getCountry() + "\t" + myMountain.getName() + "\t" + myMountain.getLat() + "\t" + 
                myMountain.getLong() + "\t" + myMountain.getElevation() + "\t" + myMountain.getUnits()+"\n");
            }
            

            
            

            
        }
        bfw.close();
        bpw.close();
        System.out.println(errors + "");
        System.out.println(myMountains.size() +"");
        br.close();
    }
}
