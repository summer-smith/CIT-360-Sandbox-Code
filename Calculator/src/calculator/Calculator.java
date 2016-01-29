package calculator;

/**
 * NOTE: CALCULATOR CLASS FUNCTIONS AS THE VIEW IN THE MVC
 * Reference code:
 * http://www.java2s.com/Code/Java/Tiny-Application/Asimplecalculator.htm
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * The view should translate data and prepare a response for the client (model).
 * Should not contain business or session logic.
 * @author Summer
 */
public class Calculator {
    //MVC members
    public static final Calculator INSTANCE = new Calculator();
    private Model model = new Model(INSTANCE);
    private Controller controller = new Controller(INSTANCE);
    
    //Variables
    private double result;
    private String lastCommand;
    private boolean start;
    ActionListener command = new CommandAction();
    
    //Getters
    public double getResult(){
        return result;
    }
    
    public String getLastCommand(){
        return lastCommand;
    }
    
    public boolean getStart(){
        return start;
    }
    
    public ActionListener getCommand(){
        return command;
    }
    
    //Setters
    public void setResult(double var){
        result = var;
    }
    
    public void setLastCommand(String var){
        lastCommand = var;
    }
    
    public void setStart(boolean var){
        start = var;
    }
    
    /**
     * Implement singleton on Calculator to ensure all objects only access one
     * Calculator (model) object.
     * @return instance
     */
    public static Calculator getInstance(){
        return INSTANCE;
    }
    
    public static void main(){

        EventQueue.invokeLater(new Runnable(){
            public void run() {
               model.run();
            }
        });
    }

    
   /**
    * This action executes the command that the button action string denotes.
    */
   public class CommandAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         String command = event.getActionCommand();

         if (start)
         {
            if (command.equals("-"))
            {
                model.setDisplayText(command);
               start = false;
            }
            else lastCommand = command;
         }
         else
         {
            controller.calculate(Double.parseDouble(model.getDisplayText()));        
            model.setDisplayText("" + result);
            lastCommand = command;
            start = true;
         }
      }
   }
}

   
    
