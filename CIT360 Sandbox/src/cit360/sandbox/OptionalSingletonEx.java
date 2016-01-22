
package cit360.sandbox;

/**
 * If the instance may not actually be required by the program, this implementation
 * works fine.
 * 
 * @author Summer
 */
public class OptionalSingletonEx {
    private static OptionalSingletonEx instance = null;
    private OptionalSingletonEx() { }

    public static synchronized OptionalSingletonEx getInstance() {
        if (instance == null) {
            instance = new OptionalSingletonEx();
        }

        return instance;
    }
}


