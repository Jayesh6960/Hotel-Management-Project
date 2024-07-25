package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.model.Room;

public class RoomController {
	
	public static void AddNewRoom(ArrayList<Room> rooms,Scanner scanner) {
		
		System.out.println("Enter Floor(int): ");
		int floor=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter capacity(int): ");
		int capacity=scanner.nextInt();
		scanner.nextLine();
	
		System.out.println("Enter type(String): ");
		String type=scanner.nextLine();
		
		System.out.println("Enter description(String): ");
		String Description=scanner.nextLine();

		
		System.out.println("Enter price(double): ");
		double price=scanner.nextDouble();
		
		int id =1000+rooms.size()+1;
		
		Room room =new Room(id,floor,capacity,type,Description,price);
		rooms.add(room);
		
		System.out.println("Room added successfully");
		System.out.println();
		
	}

	public static void showAllRooms(ArrayList<Room> rooms) {
			for(Room room:rooms) {
				System.out.println("-----------------------------------------------------");
				room.print();
				System.out.println("-----------------------------------------------------");
				System.out.println();
			}
				
		
	}

	
	public static void editRoom(ArrayList<Room> rooms, Scanner scanner) {
		
		System.out.println("Enter room id: \n-1 to show all room");
		int id=scanner.nextInt();
		
		if(id==-1) {
			showAllRooms(rooms);
			System.out.println("Enter room id: \n-1 to show all room");
			int j=scanner.nextInt();
			id=j;
		}
		
		Room room =getRoomById(id,rooms);
		System.out.println("Enter floor (int): \n-1 to keep it");
		int floor =scanner.nextInt();
		if(floor==-1) {
			floor=room.getFloor();
		}
		
		System.out.println("Enter capacity (int): \n-1 to keep it");
		int capacity =scanner.nextInt();
		if(capacity==-1) {
			capacity=room.getCapacity();
		}
		scanner.nextLine();
		System.out.println("Enter type (String): \n-1 to keep it");
		String type =scanner.nextLine();
		if(type.equals(-1)) {
			type=room.getType();
		}
		scanner.nextLine();
		System.out.println("Enter Description (String): \n-1 to keep it");
		String Description =scanner.nextLine();
		if(Description.equals(-1)) {
			Description=room.getDescription();
		}
		
		System.out.println("Enter price (double): \n-1 to keep it");
		double price =scanner.nextDouble();
		if(price==-1) {
			price=room.getPrice();
		}
		
		room.setFloor(floor);
		room.setCapacity(capacity);
		room.setType(type);
		room.setDescription(Description);
		room.setPrice(price);

		for(Room r:rooms) {
			if(r.getId()==id) {
				r=room;
				break;
			}
		}
	}
	
	
	public static Room getRoomById(int id, ArrayList<Room> rooms) {
		Room room=new Room();
		
		for(Room r : rooms) {
			if(r.getId()==id) {
				room=r;
				break;
			}
		}
		return room;
	}

	

}

