package zk.date.beans;

import java.util.Date;

public record TrainPassenger(String name, String telephoneNumber,
                             String address, Date ticketPurchaseDate,
                             Date travelDateTime, String bookingRefNumber,
                             String seatNumber, String departureCity,
                             String arrivalCity) {

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
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                '}';
    }
}
