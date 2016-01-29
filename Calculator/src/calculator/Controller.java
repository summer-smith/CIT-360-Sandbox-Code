package calculator;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The controller processes incoming requests and provides responses.  Most 
 * requests to the view should contain data.
 * @author Summer
 */
public class Controller {
    private Calculator view;
    
    /*
    * Make sure we have access to the view (calculator) singelton class when
    * this class is instantiated
    */
    public Controller(Calculator calcInstance){
        view = calcInstance;
    }
   
    
    
    
       /**
    * Carries out the pending calculation.
    * @param x the value to be accumulated with the prior result.
    */
   public void calculate(double x)
   {
        double newResult = 0;
            if (view.getLastCommand().equals("+")) newResult = view.getResult() + x;
            else if (view.getLastCommand().equals("-")) newResult -= x;
            else if (view.getLastCommand().equals("*")) newResult *= x;
            else if (view.getLastCommand().equals("/")) newResult /= x;
            else if (view.getLastCommand().equals("=")) newResult = x;
        
        view.setResult(newResult);
   }
}
