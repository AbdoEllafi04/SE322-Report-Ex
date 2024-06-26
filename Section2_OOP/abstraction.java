package Section2_OOP;

// Abstraction Example
// In this example, we will discuss the concept of abstraction in OOP.

// Abstract class
abstract class Vehicle {
    private String brand;

    // Constructor to initialize the brand
    public Vehicle(String brand) {
        this.brand = brand;
    }

    // Getter method for the brand attribute
    public String getBrand() {
        return brand;
    }

    // Setter method for the brand attribute
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Abstract method to be implemented by subclasses
    public abstract void drive();
}

// Subclass of Vehicle
class Car extends Vehicle {
    private String model;

    // Constructor to initialize the brand and model
    public Car(String brand, String model) {
        super(brand); // Call the constructor of the superclass (Vehicle)
        this.model = model;
    }

    // Getter method for the model attribute
    public String getModel() {
        return model;
    }

    // Setter method for the model attribute
    public void setModel(String model) {
        this.model = model;
    }

    // Implementation of the abstract method drive
    @Override
    public void drive() {
        System.out.println("The Mercedes C63 is being driven.");
    }

    // Main method to test the Car class
    public static void main(String[] args) {
        
        // Create an instance of Car representing a Mercedes C63
        Car myCar = new Car("Mercedes", "C63");

        // Print the brand and model of the car
        System.out.println("Brand: " + myCar.getBrand() + "\nModel: " + myCar.getModel()); // Outputs: Brand: Mercedes, Model: C63
 
        // Call the drive method
        myCar.drive(); // Outputs: The Mercedes C63 is being driven.
    }
}