public class UseCase12DataPersistenceRecovery {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("System Recovery");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        String filePath = "inventory_data.txt";

        persistenceService.loadInventory(inventory, filePath);

        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.getRoomAvailability().get("Single"));
        System.out.println("Double: " + inventory.getRoomAvailability().get("Double"));
        System.out.println("Suite: " + inventory.getRoomAvailability().get("Suite"));

        persistenceService.saveInventory(inventory, filePath);
    }
}