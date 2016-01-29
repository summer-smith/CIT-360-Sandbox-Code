/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Summer
 */
public class Model {
    private Calculator view;
    
    //Variables
    private JButton display;
    private JPanel panel;
    
    //Getters
    public String getDisplayText(){
        return (display.getText());
    }
    
    //Setters
    public void setDisplayText(String command){
        display.setText(command);        
    }
    
    /*
    * Make sure we have access to the view (calculator) singelton class when
    * this class is instantiated
    */
    public Model(Calculator calcInstance){
        view = calcInstance;
    }
    
    /*
    * Starts up the calculator GUI
    */
    public void run(){
        CalculatorFrame frame = new CalculatorFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    
    /**
    * A frame with a calculator panel.
    */
    class CalculatorFrame extends JFrame{
        public CalculatorFrame(){
            setTitle("Calculator");
            CalculatorPanel panel = new CalculatorPanel();
            add(panel);
            pack();
        }
    }

    /**
     * A panel with calculator buttons and a result display.
     */
    class CalculatorPanel extends JPanel{
        public CalculatorPanel(){
            setLayout(new BorderLayout());

            view.setResult(0);
            view.setLastCommand("=");
            view.setStart(true);

            // add the display
            display = new JButton("0");
            display.setEnabled(false);
            add(display, BorderLayout.NORTH);

            ActionListener insert = new InsertAction();
            ActionListener command = view.getCommand();

            // add the buttons in a 4 x 4 grid

            panel = new JPanel();
            panel.setLayout(new GridLayout(4, 4));    

            addButton("7", insert);
            addButton("8", insert);
            addButton("9", insert);
            addButton("/", command);

            addButton("4", insert);
            addButton("5", insert);
            addButton("6", insert);
            addButton("*", command);

            addButton("1", insert);
            addButton("2", insert);
            addButton("3", insert);
            addButton("-", command);

            addButton("0", insert);
            addButton(".", insert);
            addButton("=", command);
            addButton("+", command);

            add(panel, BorderLayout.CENTER);
        }

        /**
         * Adds a button to the center panel.
         * @param label the button label
         * @param listener the button listener
         */
        private void addButton(String label, ActionListener listener)
        {
           JButton button = new JButton(label);
           button.addActionListener(listener);
           panel.add(button);
        }
    

        /**
         * This action inserts the button action string to the end of the display text.
         */
        private class InsertAction implements ActionListener{
           public void actionPerformed(ActionEvent event){
              String input = event.getActionCommand();
              if (view.getStart()){
                 display.setText("");
                 view.setStart(false);
              }
              display.setText(display.getText() + input);
           }
        }
    }
}
