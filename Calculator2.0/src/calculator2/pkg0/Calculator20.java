package calculator2.pkg0;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/**
 *
 * @author Summer
 */
public class Calculator20 {
    //Member variables
    private HashMap<String, CalcHandler> handlerMap = new HashMap<String, CalcHandler>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        Calculator20 calculator = new Calculator20();
        
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); 
        String line; 
        ; 
        
        //Prompt for equasion
        System.out.println("Please enter equasion:");
        
        while ((line = stdin.readLine()) != null && line.length()!= 0) { 
            String[] input = line.split(" "); 
            int firstNum = Integer.parseInt(input[0]);
            String command = input[1];
            int secondNum = Integer.parseInt(input[2]);
            if (input.length == 3) { 
                HashMap<String, Integer> parameters = new HashMap<String, Integer>();
                parameters.put("first", firstNum);
                parameters.put("second", secondNum);
                
                calculator.handleRequest(line, parameters);
            } 
            else {
                System.out.println("Invalid format.  Please us this format:");
                System.out.println("integer command integer");
                System.out.println("Valid commands include: +, -, *, /");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++");
            }
        }
    }
    
    //Deal with user input
    public void handleRequest(String command, HashMap<String, ?> input) throws NullPointerException{
        CalcHandler handler = (CalcHandler) handlerMap.get(command);
        handler.handle(input);
    }
    
    public Calculator20(){
        handlerMap.put("+", new AdditionHandler());
        handlerMap.put("-", new SubtractionHandler());
        handlerMap.put("*", new MultiplicationHandler());
        handlerMap.put("/", new DivisionHandler());
    }
    
}
