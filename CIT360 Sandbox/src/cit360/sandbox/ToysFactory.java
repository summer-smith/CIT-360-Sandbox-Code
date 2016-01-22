package cit360.sandbox;

/**
 *
 * @author Summer
 */
public class Toy{
    public String name = null;
    public double price = 0;
    
    public Toy(){
        
    }
    //constructor
    public Toy(String name, double price){
        this.name = name;
        this.price = price;
    }
    
    public void prepareToy(){
       System.out.println("Preparing " + name);
    }
    
    public void packageToy(){
       System.out.println("Packaging " + name);
    }

    public void labelToy(){
       System.out.println("Lableing " + name);
       System.out.println(name + "is priced at " + price);
    }
}

public class Car extends Toy {
    //constructor
    public Car(){
        this.name = "Car";
        this.price = 19.99;
    }
}

public class Plane extends Toy {
    //constructor
    public Plane(){
        this.name = "Plane";
        this.price = 14.99;
    }
}

public class ToysFactory {
    
    public void produceToy(String toyName, double toyPrice) {
        Toy newToy = null;
        newToy = this.createToy(toyName, toyPrice);
        
        newToy.prepareToy();
        newToy.packageToy();
        newToy.labelToy();
        
    }

    private Toy createToy(String toyName, double toyPrice){
        Toy newToy = null;
        if (toyName.equals("Car")){
            newToy = new Car();
        } else if (toyName.equals("Plane")){
            newToy = new Plane();
        } else
            newToy = new Toy(toyName, toyPrice);
            
        return (newToy);
    }
}

class NyToysFactory extends ToysFactory {


}