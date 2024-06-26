package Section2_OOP;

// Encapsulation Example
// In this example, we will discuss the concept of encapsulation in OOP.

class Car {
    // Private fields (attributes)
    private String model;
    private String color;
    private int year;

    // Constructor to initialize the fields
    public Car(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }

    // Public getter and setter methods for model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Public getter and setter methods for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Public getter and setter methods for year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Public method to start the engine
    public void startEngine() {
        System.out.println("The engine of the " + model + " has started.");
    }

    // Main method to test the Car class
    public static void main(String[] args) {
        // Create an instance of Car representing a Mercedes C63
        Car myCar = new Car("Mercedes", "Black", 2014);

        // Print the model, color, and year of the car
        System.out.println("Model: " + myCar.getModel() + "\nColor: " + myCar.getColor() + "\nYear: " + myCar.getYear()); // Outputs: Model: Mercedes, Color: Black, Year: 2014

        // Call the startEngine method
        myCar.startEngine(); // Outputs: The engine of the Mercedes has started.
    }
}