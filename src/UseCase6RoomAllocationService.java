/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * @version 6.0
 */
public class UseCase6RoomAllocationService {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Single");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        allocationService.allocateRoom(r1, inventory);
        allocationService.allocateRoom(r2, inventory);
        allocationService.allocateRoom(r3, inventory);
    }
}