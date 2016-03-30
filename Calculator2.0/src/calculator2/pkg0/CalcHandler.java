package calculator2.pkg0;

import java.util.HashMap;

/*
 *Create a handler interface to ensure uniformity among 
 *calculator function handlers
 */
public interface CalcHandler {
    public void handle(HashMap<?, ?> parameters);
}
