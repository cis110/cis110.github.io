/**
 * Car class from 7/26 recitation. The same as the Car class from 7/24, with
 * the following changes:
 *   make and model are now final
 *   speed is now private
 *   getSpeed() added
 *   toString() added
 */
public class Car {
    //non static field variables
    public final String make;
    public final String model;
    private int speed;
    
    //static (class) variables
    public static int numCars = 0;
    
    //constructor, takes in String make and String model
    //sets speed to 0 as default, adds 1 to numCars
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.speed = 0;
        numCars++;
    }
    
    public Car(String make, String model, int speed) {
        this.make = make;
        this.model = model;
        this.speed = speed;
        numCars++;
    }
    
    //sets the speed of the car to 5
    public void start() {
        speed = 5;
    }
    
    //sets the speed of the car to 0
    public void stop() {
        speed = 0;
    }
    
    //takes an int input and adds the value to speed
    //if the added value makes the speed go below zero,
    //it resets the speed back at 0
    public void accelerate(int x) {
        speed += x;
        if (speed < 0) {
            speed = 0;
            //other option:
            //this.stop();
        }
    }
    
    //returns a boolean that checks if speed is zero
    //to determine if the car is moving
    public boolean isMoving() {
        return speed != 0;
    }
    
    public String toString() {
        return make + " " + model + ", speed: " + speed;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    //returns the total number of Car objects created so far
    public static int getNumCars() {
        return numCars;
    }
    
    public static void main(String[] args) {
        Car hondaCivic = new Car("Honda", "Civic");
        System.out.println("getNumCars expected: 1, actual: " + getNumCars());
        Car nissanSentra = new Car("Nissan", "Sentra");
        System.out.println("getNumCars expected: 2, actual: " + getNumCars());
        
        //test isMoving
        System.out.println("hondaCivic isMoving expected: false, actual: " + hondaCivic.isMoving());
        
        //start honda civic, then check again if it is moving
        hondaCivic.start();
        System.out.println("hondaCivic isMoving expected: true, actual: " + hondaCivic.isMoving());
        
        //test accelerate
        hondaCivic.accelerate(10);
        System.out.println("hondaCivic speed expected: 15, actual: " + hondaCivic.speed);
        
        //stop honda civic, then check again if it is moving
        hondaCivic.stop();
        System.out.println("hondaCivic isMoving expected: false, actual: " + hondaCivic.isMoving()); 
    }
}

