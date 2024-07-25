package com.model;

public class Guest {
	private int id;
	private String name;
	private String email;
	private int discount;
	@Override
	public String toString() {
		return "Guest [id=" + id + ", name=" + name + ", email=" + email + ", discount=" + discount + "]";
	}
	public Guest(int id, String name, String email, int discount) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.discount = discount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public void prints() {
		
		System.out.println("----------------------------------------------");
		System.out.println("id: "+id);
		System.out.println("Name: "+name);
		System.out.println("Email: "+email);
		System.out.println("Discount: "+discount);
		System.out.println("----------------------------------------------");
		System.out.println();
	
	}

	

}
