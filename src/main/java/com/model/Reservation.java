package com.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private double price;
    private String status;
    private Guest guest;
    private Room room;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String toString() {
        return "Reservation [arrivalDate=" + arrivalDate + ", departureDate=" + departureDate + ", price=" + price
                + ", status=" + status + ", guest=" + guest + ", room=" + room + "]";
    }

    public Reservation(LocalDate arrivalDate, LocalDate departureDate, double price, String status, Guest guest,
                       Room room) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.price = price;
        this.status = status;
        this.guest = guest;
        this.room = room;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public String getArrivalDateToString() {
        return arrivalDate.format(formatter);
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public String getDepartureDateToString() {
        return departureDate.format(formatter);
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void print() {
        System.out.println("***********************************************");
        System.out.println("Arrival Date: " + arrivalDate.format(formatter));
        System.out.println("Departure Date: " + departureDate.format(formatter));
        long days = ChronoUnit.DAYS.between(arrivalDate, departureDate);
        System.out.println(days + " Days ");
        System.out.println("**************Guest Information**************");
        guest.prints();
        System.out.println("**************Room Information**************");
        room.print();
        double price = days * room.getPrice();
        System.out.println("Price = " + price);
        System.out.println("Total after Discount: " + this.price);
        System.out.println("***********************************************");
    }
}