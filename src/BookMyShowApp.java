// Abstract Room class
abstract class Room {
    protected String type;
    protected int beds;
    protected double size; // in square meters
    protected double price; // per night

    public Room(String type, int beds, double size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public abstract void displayDetails();
}

// SingleRoom class
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 15.0, 50.0);
    }

    @Override
    public void displayDetails() {
        System.out.println(type + ": Beds = " + beds + ", Size = " + size + " sqm, Price = $" + price);
    }
}

// DoubleRoom class
class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 25.0, 80.0);
    }

    @Override
    public void displayDetails() {
        System.out.println(type + ": Beds = " + beds + ", Size = " + size + " sqm, Price = $" + price);
    }
}

// SuiteRoom class
class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 50.0, 150.0);
    }

    @Override
    public void displayDetails() {
        System.out.println(type + ": Beds = " + beds + ", Size = " + size + " sqm, Price = $" + price);
    }
}

// Main application class
public class RoomAvailabilityApp {
    public static void main(String[] args) {
        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Hardcoded availability variables
        int availableSingles = 5;
        int availableDoubles = 3;
        int availableSuites = 2;

        // Display room details and availability
        singleRoom.displayDetails();
        System.out.println("Available: " + availableSingles);
        System.out.println();

        doubleRoom.displayDetails();
        System.out.println("Available: " + availableDoubles);
        System.out.println();

        suiteRoom.displayDetails();
        System.out.println("Available: " + availableSuites);
    }
}
