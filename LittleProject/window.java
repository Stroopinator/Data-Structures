package LittleProject;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
/*
 * this is just a little window used to dispaly the program on a JFrame
 * runs the thread that updates and renders the screen
 */
public class window extends JFrame{
    screen _screen;
    
    public window(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        setResizable(false);
        setTitle("Sand Sim");
        _screen = new screen(800, 800);
        add(_screen);
        setVisible(true);
        addKeyListener(new KeyInterceptor());
        TimerTask task = new TimerTask() {

            public void run(){
                _screen.Render();
            }
        };

        TimerTask updateScreen = new TimerTask() {
            
            public void run(){
                _screen.update();
            }
        };

        TimerTask pixelDaemon = new TimerTask() {
            boolean interupted = false;
            public void run(){
               System.out.println(_screen.getPixels(interupted));
               if(interupted) System.out.println("failed to gain access");
            }
        };
        

        //WOAH threading!
        Timer tick = new Timer();
        tick.schedule(task, 0, 9);

        tick.schedule(updateScreen, 0,  18);

        tick.schedule(pixelDaemon, 0, 1);
        
    }



}
