import java.io.*;
import java.net.*;


public class Client {
    
    public static void main(String[] args){
        try{
            Socket s = new Socket("192.168.1.18", 167);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("hello");
            dout.flush();
            dout.close();
            s.close();
        } catch(Exception e){
            
        }
    }
}
