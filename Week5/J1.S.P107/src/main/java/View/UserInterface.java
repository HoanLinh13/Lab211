package View;

import Controller.ManageReservations;
import Model.FlightInformation;
import Model.Reservation;
import Uitility.CheckValidate;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private int menu() {
        int option = 0;
        System.out.println("\n*** Reservation Management ***");
        System.out.println("1. Create new reservation\n" +
                "2. Update reservation\n" +
                "3. Delete reservation\n" +
                "4. Print Flight Information\n" +
                "5. Print all");
        System.out.print("You choose: ");
        option = scanner.nextInt();
        scanner.nextLine();

        return option;
    }
    public void start(){
        ManageReservations mr = new ManageReservations();
        CheckValidate cv = new CheckValidate();

        while(true){
            switch (menu()){
                case 1:
                    System.out.println("*** Create new reservation ***");
                    Reservation re = new Reservation();

                    String id, name, phone, roomNumber, bookingDate, needPickUp, flight, seat, timePickup;

                    do {
                        System.out.print("ID: ");
                        id = cv.validateInput(scanner.nextLine().trim(), "ID");
                    } while (id == null);
                    do {
                        System.out.print("Name: ");
                        name = cv.validateInput(scanner.nextLine().trim(), "NAME");
                    } while (name == null);
                    do {
                        System.out.print("Phone: ");
                        phone = cv.validateInput(scanner.nextLine().trim(), "PHONE");
                    } while (phone == null);
                    do {
                        System.out.print("RoomNumbers: ");
                        roomNumber = cv.validateInput(scanner.nextLine().trim(), "ROOM");
                    } while (roomNumber == null);
                    do {
                        System.out.print("BookingDate (dd/MM/yyyy): ");
                        bookingDate = cv.validateInput(scanner.nextLine().trim(), "DATE");
                    } while (bookingDate == null);

                    while(true){
                        String type;
                        do {
                            System.out.print("Need airport pick up? (Y/N): ");
                            type = cv.validateInput(scanner.nextLine().trim(), "YN");
                        } while (type == null);

                        if(type.equals("Y")) {
                            do {
                                System.out.print("Flight: ");
                                flight = cv.validateInput(scanner.nextLine().trim(), "FLIGHT");
                            } while (flight == null);

                            do {
                                System.out.print("Seat: ");
                                seat = cv.validateInput(scanner.nextLine().trim(), "SEAT");
                            } while (seat == null);

                            do {
                                System.out.print("TimePickUp (dd/MM/yyyy hh:mmAM/PM): ");
                                timePickup = cv.validateInput(scanner.nextLine().trim(), "TIME");
                            } while (timePickup == null);

                            FlightInformation fi = (FlightInformation)re;
                            fi.flightInformation(id, name, phone, roomNumber, bookingDate, flight, seat, timePickup);
                            mr.createReservation(fi);
                            break;
                        }else if(type.equals("N")) {
                            re.reservation(id, name, phone, roomNumber, bookingDate);
                            mr.createReservation(re);
                            break;
                        }
                    }

                    break;
                case 2:
                    while (true) {
                        System.out.println("*** Update reservation ***");
                        System.out.print("ID: ");
                        String idUpdate = scanner.nextLine();

                        Reservation reservation = mr.findById(idUpdate);
                        if (reservation == null) {
                            System.err.println("No information found");
                            System.out.print("You want to find again? (Y/N): ");
                            String choice = scanner.nextLine().toUpperCase();
                            if (choice.equals("N")) {
                                break;
                            }
                            continue;
                        }

                        FlightInformation fi = (FlightInformation) reservation;
                        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
                        System.out.println(fi);

                        System.out.println("If you do not want to change the information, just press enter to skip.");
                        System.out.print("Name: ");
                        String newName = scanner.nextLine();
                        if (!newName.isEmpty()) {
                            fi.setCustomerName(newName);
                        }
                        System.out.print("Phone: ");
                        String newPhone = scanner.nextLine();
                        if (!newPhone.isEmpty()) {
                            fi.setPhoneNumber(newPhone);
                        }
                        System.out.print("RoomNumbers: ");
                        String newRoomNumber = scanner.nextLine();
                        if (!newRoomNumber.isEmpty()) {
                            fi.setRoomNumber(newRoomNumber);
                        }
                        System.out.print("BookingDate (yyyy-MM-dd): ");
                        String newBookingDate = scanner.nextLine();
                        if (!newBookingDate.isEmpty()) {
                            fi.setBookingDate(newBookingDate);
                        }

                        while(true){
                            System.out.print("Need airport pick up? (Y/N): ");
                            String type = scanner.nextLine().toUpperCase();
                            if(type.equals("Y")) {
                                System.out.print("Flight: ");
                                String newFlight = scanner.nextLine();
                                if (!newFlight.isEmpty()) {
                                    fi.setFlightNumber(newFlight);
                                }
                                System.out.print("Seats: ");
                                String newSeats = scanner.nextLine();
                                if (!newSeats.isEmpty()) {
                                    fi.setFlightNumber(newSeats);
                                }
                                System.out.print("Time pickup: ");
                                String newTimePickup = scanner.nextLine();
                                if (!newTimePickup.isEmpty()) {
                                    fi.setFlightNumber(newTimePickup);
                                }

                                mr.updateReservation(fi);
                                break;
                            }else if(type.equals("N")) {
                                mr.updateReservation(reservation);
                                break;
                            }
                        }
                        break;
                    }
                    break;
                case 3:
                    return;
            }
        }
    }
}

