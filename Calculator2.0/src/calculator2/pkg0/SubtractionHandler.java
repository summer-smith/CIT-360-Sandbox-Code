package calculator2.pkg0;
import java.util.HashMap;
/**
 *
 * @author Summer
 */
public class SubtractionHandler implements CalcHandler{
    @Override
    public void handle(HashMap<?, ?> input) {
        int x = (int) input.get("first");
        int y = (int) input.get("second");
        int subtTotal = x - y;
        System.out.println(x + " - " + y + " = " + subtTotal);
    
}
