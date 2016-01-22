
package cit360.sandbox;

/**
 * An example of how a proxy class works
 * @author Summer
 */
public class Proxy {
    private String data = null;
    private RealFile file = null;
    
    //Constructor
    public Proxy(String data) {
        this.data = data;
    }
    
    //Outputs our data
    public void displayData(){
        if (file == null){
            file = new RealFile(data);
        }
        file.loadData();
    }
    
}

public class RealFile {
    private String data = null;
    
    //Constructor
    public RealFile (final String data) {
        this.data = data;
        loadData();
    }
    
    //Outputs our data
    public void loadData(){
        System.out.println("Loading " + data);
    }
  
}
