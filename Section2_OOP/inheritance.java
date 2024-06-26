package Section2_OOP;

// Inheritance Example
// In this example, we will discuss the concept of inheritance in OOP.

// Superclass
class Vehicle {
    private String brand;

    // Constructor to initialize the brand
    public Vehicle(String brand) {
        this.brand = brand;
    }

    // Getter for brand
    public String getBrand() {
        return brand;
    }

    // Setter for brand
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Method to simulate driving the vehicle
    public void drive() {
        System.out.println("The vehicle is being driven.");
    }
}

// Subclass
class Car extends Vehicle {
    private String model;

    // Constructor to initialize the brand and model
    public Car(String brand, String model) {
        super(brand);
        this.model = model;
    }

    // Getter for model
    public String getModel() {
        return model;
    }

    // Setter for model
    public void setModel(String model) {
        this.model = model;
    }

    // Overridden method to simulate driving the car
    @Override
    public void drive() {
        System.out.println("The car is being driven.");
    }

    // Main method to test the Car class
    public static void main(String[] args) {
        
        // Create an instance of Car representing a Mercedes C63
        Car myCar = new Car("Mercedes", "C63");

        // Print the brand and model of the car
        System.out.println("Brand: " + myCar.getBrand() + "\nModel: " + myCar.getModel()); // Outputs: Brand: Mercedes, Model: C63

        // Call the drive method
        myCar.drive(); // Outputs: The car is being driven.
    }
}