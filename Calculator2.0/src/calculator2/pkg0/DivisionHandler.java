package calculator2.pkg0;

import java.util.HashMap;
/**
 *
 * @author Summer
 */
public class DivisionHandler implements CalcHandler {

    /**
     *
     * @param input
     */
    @Override
    public void handle(HashMap<?, ?> input) {
        int x = (int) input.get("first");
        int y = (int) input.get("second");
        int divTotal = 0;
        try {
            divTotal = x/y;
            System.out.println(x + " / " + y + " = " + divTotal);
        }catch (ArithmeticException E){
            System.out.println("ERROR: cannot divide by zero.");
        }
    }
}