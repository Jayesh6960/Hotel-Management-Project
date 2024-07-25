package com.demo;

import java.util.ArrayList;
import java.util.Scanner;

import com.controller.GuestController;
import com.controller.ReservationController;
import com.controller.RoomController;

import com.model.Guest;
import com.model.Reservation;
import com.model.Room;

public class App {
	
	private static ArrayList<Room> rooms;
	private static ArrayList<Guest> guests;
	private static ArrayList<Reservation> reservations;

	public static void main(String[] args) {
		
		rooms = new ArrayList<Room>();
		guests = new ArrayList<Guest>();	
		reservations = new ArrayList<Reservation>();

		int i = 0;
		while (i != 14) {
			System.out.println("Welcom To the Hotel Taj");
			System.out.println("1. Add new room");
			System.out.println("2. Show all room");
			System.out.println("3. Edit room");
			System.out.println("4. Add new guest");
			System.out.println("5. Show all guest");
			System.out.println("6. Search guest by name");
			System.out.println("7. Edit guest data");
			System.out.println("8. Create new reservation");
			System.out.println("9. Show all reservation");
			System.out.println("10. get reservation by guest name");
			System.out.println("11. get reservation by id");
			System.out.println("12. edit reservation");
			System.out.println("13. Pay Reservation");
			System.out.println("14. Quit");

			Scanner scanner = new Scanner(System.in);
			i = scanner.nextInt();

			switch (i) {
			case 1: {
				RoomController.AddNewRoom(rooms, scanner);
				break;
			}
			case 2: {
				RoomController.showAllRooms(rooms);
				break;
			}

			case 3: {
				RoomController.editRoom(rooms, scanner);
				break;
			}
			
			case 4: {
				GuestController.AddNewGuest(guests, scanner);
				break;
			}
			
			case 5: {
				GuestController.ShowAllGuest(guests);
				break;
			}
			
			case 6: {
				GuestController.searchByName(guests,scanner);
				break;
			}
			
			case 7: {
				GuestController.editGuest(guests,scanner);
				break;
			}
			
			case 8: {
				 ReservationController.createNewReservation(guests,rooms,reservations,scanner);
				break;
			}
			
			case 9: {
				 ReservationController.showAllReservations(reservations,scanner);
				break;
			}
			
			case 10: {
				 ReservationController.getReservationByGuestName(reservations, scanner);
				break;
			}
			
			case 11: {
				 ReservationController.getReservationByGuestId(reservations, scanner);
				break;
			}
			
			case 12: {
				 ReservationController.editReservation(guests, rooms, reservations, scanner);
				break;
			}
			
			case 13: {
				 ReservationController.payReservation(reservations, scanner);
				break;
			}

			}

		}
	}
}
