package Controller;

import Model.Reservation;
import java.util.*;

public class ManageReservations {
    private Map<String, Reservation> reservationsMap  = new HashMap<>();
    Scanner scanner = new Scanner(System.in);


    public void createReservation(Reservation reservation) {
        String id = reservation.getBookingID();
        reservationsMap.put(id, reservation);
    }

    public Reservation findById(String courseID) {
        if (reservationsMap.containsKey(courseID)) {
            return reservationsMap.get(courseID);
        }
        return null;
    }

    public void updateReservation(Reservation updatedReservation) {
        String id = updatedReservation.getBookingID();

        reservationsMap.put(id, updatedReservation); // Ghi đè dữ liệu cũ
    }

}
