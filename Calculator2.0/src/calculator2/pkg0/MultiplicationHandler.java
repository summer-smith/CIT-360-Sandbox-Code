package calculator2.pkg0;
import java.util.HashMap;
/**
 *
 * @author Summer
 */
public class MultiplicationHandler implements CalcHandler{
    @Override
    public void handle(HashMap<?, ?> input) {
        int x = (int) input.get("first");
        int y = (int) input.get("second");
        int multTotal = x * y;
        System.out.println(x + " * " + y + " = " + multTotal);
    }
}
