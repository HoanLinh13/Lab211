package Model;



public class FlightInformation extends Reservation {
    private String flightNumber;
    private String seatNumber;
    private String timePickUp;

    public FlightInformation() {
        this.flightNumber = "";
        this.seatNumber = "";
        this.timePickUp = "";
    }

    public void flightInformation(String bookingID, String customerName, String phoneNumber, String roomNumber, String bookingDate, String flightNumber, String seatNumber, String timePickUp) {
        super.reservation(bookingID, customerName, phoneNumber, roomNumber,bookingDate) ;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = timePickUp;
    }



    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getTimePickUp() {
        return timePickUp;
    }

    public void setTimePickUp(String timePickUp) {
        this.timePickUp = timePickUp;
    }

    @Override
    public String toString() {
        return super.toString() + "Flight: " + flightNumber + ", Seat: " + seatNumber + ", Pickup: " + timePickUp;
    }
}
