package zk.date.beans;

import java.util.Date;

public class TrainPassenger {
    private String name;
    private String telephoneNumber;
    private String address;
    private Date ticketPurchaseDate;
    private Date travelDateTime;
    private String bookingRefNumber;
    private String seatNumber;
    private String departureTown;
    private String arrivalTown;

    public TrainPassenger(String name, String telephoneNumber,
                          String address, Date ticketPurchaseDate, Date travelDateTime,
                          String bookingRefNumber, String seatNumber,
                          String departureTown, String arrivalTown) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.ticketPurchaseDate = ticketPurchaseDate;
        this.travelDateTime = travelDateTime;
        this.bookingRefNumber = bookingRefNumber;
        this.seatNumber = seatNumber;
        this.departureTown = departureTown;
        this.arrivalTown = arrivalTown;
    }

    @Override
    public String toString() {
        return "TrainPassenger{" +
                "name='" + name + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", ticketPurchaseDate=" + ticketPurchaseDate +
                ", travelDateTime=" + travelDateTime +
                ", bookingRefNumber='" + bookingRefNumber + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", departureTown='" + departureTown + '\'' +
                ", arrivalTown='" + arrivalTown + '\'' +
                '}';
    }
}
