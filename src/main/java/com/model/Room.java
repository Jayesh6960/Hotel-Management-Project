package com.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Room {
	private int id;
	private int floor;
	private int capacity;
	private String type;  
	private String Description;
	private double price;
	ArrayList<String> reservedDates;
	
	
	public int getId() {
	
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", floor=" + floor + ", capacity=" + capacity + ", type=" + type + ", Description="
				+ Description + ", price=" + price + "]";
	}
	public Room(int id, int floor, int capacity, String type, String description, double price) {
		super();
		this.id = id;
		this.floor = floor;
		this.capacity = capacity;
		this.type = type;
		this.Description = description;
		this.price = price;
		reservedDates =new ArrayList<>();
		
	}
	
	public Room() {
		reservedDates =new ArrayList<>();
	}
	
	public void Reverse(LocalDate startDate, LocalDate endDates) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for(LocalDate date= startDate;date.isBefore(endDates);date=date.plusDays(1)) {
			String d=date.format(formatter);
			reservedDates.add(d);
			
		}
		
	}
	
	public boolean isReversed(LocalDate startDate, LocalDate endDates ) {
		boolean b =false;
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for(LocalDate date= startDate;date.isBefore(endDates);date=date.plusDays(1)) {
			String d=date.format(formatter);
		
			if(reservedDates.contains(d)) {
				b=true;
				break;
			}
			
	}
		return b;
	}
	
	public void print() {
		
				
		System.out.println("id: "+id);
		System.out.println("Floor: "+floor);
		System.out.println("Capacity: "+capacity);
		System.out.println("type: "+type);
		System.out.println("Description: "+Description);
		System.out.println("Price: "+price);
	}

}

