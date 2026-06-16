import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CancellationService {

    /** Stack that stores recently released room IDs. */
    private Stack<String> releasedRoomIds;

    /** Maps reservation ID to room type. */
    private Map<String, String> reservationRoomTypeMap;

    /** Initializes cancellation tracking structures. */
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    /**
     * Registers a confirmed booking.
     *
     * This method simulates storing confirmation
     * data that will later be required for cancellation.
     *
     * @param reservationId confirmed reservation ID
     * @param roomType allocated room type
     */
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /**
     * Cancels a confirmed booking and
     * restores inventory safely.
     *
     * @param reservationId reservation to cancel
     * @param inventory centralized room inventory
     */
    public void cancelBooking(String reservationId, RoomInventory inventory) {
        String roomType = reservationRoomTypeMap.get(reservationId);

        if (roomType == null) {
            System.out.println("Cancellation failed: Reservation not found.");
            return;
        }

        Map<String, Integer> availability = inventory.getRoomAvailability();
        int currentCount = availability.getOrDefault(roomType, 0);
        inventory.updateAvailability(roomType, currentCount + 1);

        releasedRoomIds.push(reservationId);
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    /**
     * Displays recently cancelled reservations.
     *
     * This method helps visualize rollback order.
     */
    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");
        for (String reservationId : releasedRoomIds) {
            System.out.println("Released Reservation ID: " + reservationId);
        }
    }
}