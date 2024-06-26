package Section2_OOP;

// Polymorphism Example
// In this example, we will discuss the concept of polymorphism in OOP.

// Superclass
class Vehicle {
    // Method to simulate driving the vehicle
    public void drive() {
        System.out.println("The vehicle is being driven.");
    }
}

// Subclass
class Car extends Vehicle {
    // Overridden method to simulate driving the car
    @Override
    public void drive() {
        System.out.println("The car is being driven.");
    }
}

// Subclass
class Motorcycle extends Vehicle {
    // Overridden method to simulate riding the motorcycle
    @Override
    public void drive() {
        System.out.println("The motorcycle is being ridden.");
    }
}

// Main class to test the polymorphism
class Main {
    public static void main(String[] args) {
        // Creating a Vehicle reference for Car
        Vehicle myCar = new Car();
        // Creating a Vehicle reference for Motorcycle
        Vehicle myMotorcycle = new Motorcycle();

        // Call the drive method on the Vehicle reference to Car
        myCar.drive(); // Outputs: The car is being driven.

        // Call the drive method on the Vehicle reference to Motorcycle
        myMotorcycle.drive(); // Outputs: The motorcycle is being ridden.
    }
}