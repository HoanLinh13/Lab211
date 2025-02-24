package Model;

public class Reservation {
    protected String bookingID;
    protected String customerName;
    protected String phoneNumber;
    protected String roomNumber;
    protected String bookingDate;

    // Default constructor
    public Reservation() {
        this.bookingID = "";
        this.customerName = "";
        this.phoneNumber = "";
        this.roomNumber = "";
        this.bookingDate = "";
    }

    public void reservation(String bookingID, String customerName, String phoneNumber, String roomNumber, String bookingDate) {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.bookingDate = bookingDate;
    }



    public String getBookingID() {
        return String.format("%06d", Integer.parseInt(bookingID));
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String toString() {
        return "ID: " + bookingID + ", Name: " + customerName + ", Phone: " + phoneNumber + ", Room: " + roomNumber + ", Booking Date: " + bookingDate + ", " ;
    }
}


