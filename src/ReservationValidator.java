/**
 * ========================================================
 * CLASS - ReservationValidator
 * ========================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This class is responsible for validating
 * booking requests before they are processed.
 */
public class ReservationValidator {

    /**
     * Validates booking input provided by the user.
     *
     * @param guestName name of the guest
     * @param roomType requested room type
     * @param inventory centralized inventory
     * @throws InvalidBookingException if validation fails
     */
    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {

        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        if (!roomType.equals("Single") && !roomType.equals("Double") && !roomType.equals("Suite")) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        Integer availableCount = inventory.getRoomAvailability().get(roomType);
        if (availableCount == null || availableCount <= 0) {
            throw new InvalidBookingException("No rooms available for the selected type.");
        }
    }
}