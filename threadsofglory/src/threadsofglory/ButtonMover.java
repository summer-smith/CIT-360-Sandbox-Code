package threadsofglory;

import javafx.application.Platform;
import javafx.scene.control.Button;

/**
 * ButtonMover is a misnomer...
 * this class merely changes the text
 * of the "Stop" button to "Go," then
 * back to "Stop."
 *
 * @author Summer Smith
 */

public class ButtonMover implements Runnable{
   
    Button button;
    
    /**
     * Changes the text on the "Stop" button from the 
     * ThreadOfGlory GUI
     */
    @Override
    public void run(){
        ThreadsOfGlory glory = ThreadsOfGlory.getInstance();
        
        button = glory.getStopBtn();
        
        try {
        for (int i =0; i < 50; i++){
            while (glory.keepRunning()){
                Platform.runLater(new Runnable(){
                    @Override
                    public void run(){
                    button.setText("Go");
                    }
                });
            
                Thread.sleep(100);
            
                Platform.runLater(new Runnable(){
                    @Override
                    public void run(){
                    button.setText("Stop");
                }
                });
            
                Thread.sleep(100);
            }
        }
        }catch (Exception E){
            System.out.println("ERROR: " + E);
        }
    }     
}  