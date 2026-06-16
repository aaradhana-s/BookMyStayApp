import java.util.HashMap;
import java.util.Map;

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Create centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        System.out.println("=== Initial Room Inventory ===");
        inventory.getRoomAvailability().forEach((type, count) ->
                System.out.println(type + " Rooms: " + count)
        );

        // Update inventory centrally
        System.out.println("\nUpdating inventory...");
        inventory.updateAvailability("Single", 8);
        inventory.updateAvailability("Double", 18);
        inventory.updateAvailability("Suite", 4);

        // Display updated inventory
        System.out.println("\n=== Updated Room Inventory ===");
        inventory.getRoomAvailability().forEach((type, count) ->
                System.out.println(type + " Rooms: " + count)
        );
    }
}

