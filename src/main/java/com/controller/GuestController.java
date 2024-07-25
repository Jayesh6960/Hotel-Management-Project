package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.model.Guest;

public class GuestController {

	public static void AddNewGuest(ArrayList<Guest> guests, Scanner scanner) {
		scanner.nextLine();
		System.out.println("Enter Guest Name: ");
		String name= scanner.nextLine();
		
	
		System.out.println("Enter Email Name: ");
		String email= scanner.nextLine();	
		
		
		System.out.println("Enter discount: ");
		int discounts= scanner.nextInt();	
		
		
		Guest guest = new Guest(guests.size(), name,email,discounts);
		
		guests.add(guest);
	}

	public static void ShowAllGuest(ArrayList<Guest> guests) {
		for(Guest guest:guests) {
			System.out.println("-----------------------------------------------------");
			guest.prints();
			System.out.println("-----------------------------------------------------");
			System.out.println();
		}
	
	}

	
	public static void searchByName(ArrayList<Guest> guests, Scanner scanner) {
		System.out.println("Enter Guest Name: ");
		String name= scanner.next();
		
		
		for(Guest guest:guests) {
			if(guest.getName().equalsIgnoreCase(name)){
				guest.prints();
			}
		}	
	}

	
	public static void editGuest(ArrayList<Guest> guests, Scanner scanner) {
		System.out.println("Enter Guest id: \n-1 to search by name");
		int id=scanner.nextInt();
		
		if(id==-1) {
			searchByName(guests, scanner);
			System.out.println("Enter id: ");
			id=scanner.nextInt();
			
		}
		
		Guest guest =guests.get(id);
		
		System.out.println("Enter name (String): \n-1 to keep it");
		scanner.nextLine();
		String name =scanner.nextLine();
	
		if(name.equals(-1)) {
			name=guest.getName();
		}
		
		scanner.nextLine();
		System.out.println("Enter Email (String): \n-1 to keep it");
		String email =scanner.nextLine();
		if(email.equals(-1)) {
			email=guest.getEmail();
		}
		scanner.nextLine();
		
		System.out.println("Enter Discount (int): \n-1 to keep it");
		int discount =scanner.nextInt();
		if(discount==-1) {
			discount=guest.getDiscount();
		}
		
		
		guest.setName(name);
		guest.setEmail(email);
		guest.setDiscount(discount);
		
		for(Guest g:guests) {
			if(g.getId()==id) {
				g=guest;
				break;
			}
		}
		
	}

	
	

}
