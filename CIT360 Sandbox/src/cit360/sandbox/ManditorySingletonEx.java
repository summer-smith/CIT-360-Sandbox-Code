
package cit360.sandbox;

/**
 * If the program requires an instance of the object, this code implements the
 * "eager" initialization. 
 * 
 * @author Summer
 */
public class ManditorySingletonEx {
    private static final ManditorySingletonEx INSTANCE = new ManditorySingletonEx();
    
    private ManditorySingletonEx() {}
    
    public static ManditorySingletonEx getInstance() {
        return INSTANCE;
    }
}


