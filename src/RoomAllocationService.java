import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ========================================
 * CLASS - RoomAllocationService
 * ========================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class is responsible for confirming
 * booking requests and assigning rooms.
 *
 * It ensures:
 * - Each room ID is unique
 * - Inventory is updated immediately
 * - No room is double-booked
 *
 * @version 6.0
 */
public class RoomAllocationService {

    /**
     * Stores all allocated room IDs to
     * prevent duplicate assignments.
     */
    private Set<String> allocatedRoomIds;

    /**
     * Stores assigned room IDs by room type.
     *
     * Key   -> Room type
     * Value -> Set of assigned room IDs
     */
    private Map<String, Set<String>> assignedRoomsByType;

    /**
     * Initializes allocation tracking structures.
     */
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirms a booking request by assigning
     * a unique room ID and updating inventory.
     *
     * @param reservation booking request
     * @param inventory centralized room inventory
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();

        // Ensure a set exists for this room type
        assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());
        Set<String> assignedRooms = assignedRoomsByType.get(roomType);

        // Generate next unique room ID for this type (e.g., Single-1, Single-2)
        int roomNumber = assignedRooms.size() + 1;
        String roomId = roomType + "-" + roomNumber;

        // Ensure uniqueness across the system
        while (allocatedRoomIds.contains(roomId)) {
            roomNumber++;
            roomId = roomType + "-" + roomNumber;
        }

        // Assign the room
        allocatedRoomIds.add(roomId);
        assignedRooms.add(roomId);

        // Update inventory count
        Map<String, Integer> availability = inventory.getRoomAvailability();
        int currentCount = availability.getOrDefault(roomType, 0);
        if (currentCount > 0) {
            inventory.updateAvailability(roomType, currentCount - 1);
        }

        System.out.println("Booking confirmed for Guest: " + reservation.getGuestName()
                + ", Room ID: " + roomId);
    }
}