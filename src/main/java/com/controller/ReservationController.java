package com.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import com.model.Guest;
import com.model.Reservation;
import com.model.Room;

public class ReservationController {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void createNewReservation(ArrayList<Guest> guests, ArrayList<Room> rooms, ArrayList<Reservation> reservations, Scanner scanner) {
        System.out.println("Enter arrival Date (yyyy-mm-dd): ");
        String arrDate = scanner.next();

        System.out.println("Enter departure Date (yyyy-mm-dd): ");
        String depDate = scanner.next();

        System.out.println("Enter Guest id (int): \n-1 search guest by name");
        int guestId = scanner.nextInt();
        if (guestId == -1) {
            GuestController.searchByName(guests, scanner);
            System.out.println("Enter Guest id (int): ");
            guestId = scanner.nextInt();
        }

        System.out.println("Enter Room id (int): \n-1 Show all rooms");
        int roomId = scanner.nextInt();
        if (roomId == -1) {
            RoomController.showAllRooms(rooms);
            System.out.println("Enter Room id (int): ");
            roomId = scanner.nextInt();
        }

        LocalDate arrivalDate = LocalDate.parse(arrDate, formatter);
        LocalDate departureDate = LocalDate.parse(depDate, formatter);

        Guest guest = guests.get(guestId);
        Room room = RoomController.getRoomById(roomId, rooms);
        if (room.isReversed(arrivalDate, departureDate)) {
            System.out.println("This room is reserved");
            return;
        } else {
            long days = ChronoUnit.DAYS.between(arrivalDate, departureDate);
            double sum = days * room.getPrice();
            double total = sum - sum * guest.getDiscount() / 100;
            System.out.println("Total Before discount = " + sum);
            System.out.println("Total After Discount = " + total);
            System.out.println("Will you pay now\n1. yes\n2. No");
            int j = scanner.nextInt();
            String status;
            if (j == 1) {
                status = "paid";
            } else {
                status = "reserved";
            }

            Reservation r = new Reservation(arrivalDate, departureDate, total, status, guest, room);
            reservations.add(r);
            r.print();
            System.out.println();
        }
    }

    public static void showAllReservations(ArrayList<Reservation> reservations, Scanner scanner) {
        for (Reservation r : reservations) {
            System.out.println("\n*********************************************************");
            System.out.println("id: " + reservations.indexOf(r));
            System.out.println("Arrival Date: = " + r.getArrivalDateToString());
            System.out.println("Departure: = " + r.getDepartureDate());
            System.out.println("Guest Name: = " + r.getGuest().getName());
            System.out.println("Room Id: = " + r.getRoom().getId());
            System.out.println("Price: = " + r.getPrice());
            System.out.println("Status: = " + r.getStatus());
            System.out.println("***********************************************************\n");
        }
    }

    public static void getReservationByGuestName(ArrayList<Reservation> reservations, Scanner scanner) {
        System.out.println("*********************Enter Guest Name: ");
        String guestName = scanner.next();
        for (Reservation r : reservations) {
            String name = r.getGuest().getName();
            if (guestName.equalsIgnoreCase(name)) {
                r.print();
            }
        }
    }

    public static void getReservationByGuestId(ArrayList<Reservation> reservations, Scanner scanner) {
        System.out.println("*********************Enter Guest id: ");
        int guestId = scanner.nextInt();
        for (Reservation r : reservations) {
            int id = r.getGuest().getId();
            if (guestId == id) {
                r.print();
            }
        }
    }

    public static void editReservation(ArrayList<Guest> guests, ArrayList<Room> rooms, ArrayList<Reservation> reservations, Scanner scanner) {
        System.out.println("Enter reservation id (int):\n-1 show all reservation ids");
        int id = scanner.nextInt();
        if (id == -1) {
            showAllReservations(reservations, scanner);
            System.out.println("Enter reservation id (int):");
            id = scanner.nextInt();
        }

        Reservation reservation = reservations.get(id);

        System.out.println("Enter Arrival Date (yyyy-mm-dd): \n-1 to keep it");
        String arrDate = scanner.next();
        if (arrDate.equals("-1")) {
            arrDate = reservation.getArrivalDateToString();
        }

        System.out.println("Enter Departure Date (yyyy-mm-dd): \n-1 to keep it");
        String depDate = scanner.next();
        if (depDate.equals("-1")) {
            depDate = reservation.getDepartureDateToString();
        }

        System.out.println("Enter Room Id (int): \n-1 to keep it \n-2 To show all Rooms");
        int roomId = scanner.nextInt();
        if (roomId == -1) {
            roomId = reservation.getRoom().getId();
        } else if (roomId == -2) {
            RoomController.showAllRooms(rooms);
            System.out.println("Enter Room Id (int): ");
            roomId = scanner.nextInt();
        }

        LocalDate arrivalDate;
        LocalDate departureDate;

        try {
            arrivalDate = LocalDate.parse(arrDate, formatter);
            departureDate = LocalDate.parse(depDate, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid Date Format yyyy-mm-dd.");
            return;
        }

        Guest guest = reservation.getGuest();
        Room room = RoomController.getRoomById(roomId, rooms);
        if (room.isReversed(arrivalDate, departureDate)) {
            System.out.println("This room is reserved");
            return;
        } else {
            long days = ChronoUnit.DAYS.between(arrivalDate, departureDate);
            double sum = days * room.getPrice();
            double total = sum - sum * guest.getDiscount() / 100;
            System.out.println("Total Before discount = " + sum);
            System.out.println("Total After Discount = " + total);
            System.out.println("Will you pay now\n1. yes\n2. No");
            int j = scanner.nextInt();
            String status;
            if (j == 1) {
                status = "paid";
            } else {
                status = "reserved";
            }

            reservation.setArrivalDate(arrivalDate);
            reservation.setDepartureDate(departureDate);
            reservation.setRoom(room);
            reservation.setStatus(status);
            reservation.setPrice(total);

            reservations.set(id, reservation);

            reservation.print();
            System.out.println();
        }
    }

    public static void payReservation(ArrayList<Reservation> reservations, Scanner scanner) {
        System.out.println("Enter Reservation Id (int): \n-1 to show all reservation Ids");
        int id = scanner.nextInt();
        if (id == -1) {
            showAllReservations(reservations, scanner);
            System.out.println("Enter Reservation Id (int): ");
            id = scanner.nextInt();
        }
        Reservation reservation = reservations.get(id);
        if (reservation.getStatus().equalsIgnoreCase("Reserved")) {
            reservation.setStatus("Paid");
            System.out.println("Reservation paid Successfully..");
            System.out.println("***********************************************************\n");
        } else {
            System.out.println("This Reservation is Already paid...");
            System.out.println("***********************************************************\n");
        }
    }
}