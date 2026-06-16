/**
 * Use Case 7: Add-On Service Selection
 *
 * This use case allows attaching optional
 * services to a confirmed reservation
 * and do not affect inventory.
 *
 * @version 7.0
 */
public class UseCase7AddOnServiceSelection {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Add-On Service Selection");

        AddOnServiceManager serviceManager = new AddOnServiceManager();

        String reservationId = "Single-1";

        AddOnService breakfast = new AddOnService("Breakfast", 500.0);
        AddOnService roomCost = new AddOnService("Room Charge", 1000.0);

        serviceManager.addService(reservationId, roomCost);
        serviceManager.addService(reservationId, breakfast);

        double totalCost = serviceManager.calculateTotalServiceCost(reservationId);

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}