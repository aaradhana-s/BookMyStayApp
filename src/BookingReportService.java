/**
 * ====================================================
 * MAIN CLASS - UseCase8BookingHistoryReport
 * ====================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * This class demonstrates how
 * confirmed bookings are stored
 * and reported.
 */
public class BookingReportService {

    /**
     * Displays a summary report
     * of all confirmed bookings.
     *
     * @param history booking history
     */
    public void generateReport(BookingHistory history) {
        System.out.println("\nBooking History Report");
        for (Reservation reservation : history.getConfirmedReservations()) {
            System.out.println("Guest: " + reservation.getGuestName()
                    + ", Room Type: " + reservation.getRoomType());
        }
    }
}