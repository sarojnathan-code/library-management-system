package com.airtribe.libraryManagementSystem.entity;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.libraryManagementSystem.service.Notify;
import com.airtribe.libraryManagementSystem.service.Reservable;
import com.airtribe.libraryManagementSystem.util.IdGenerator;

public class Patron implements Notify{
	
	private List<Reservable> subscribers = new ArrayList<>();
	
	private String name;
	private int age;
	private List<Book> booksBorrowed;
	private int membershipId;
	private boolean active;
	private String address;
	private String phoneNumber;
	

	/**
	 * @param name
	 * @param age
	 * @param active
	 * @param address
	 * @param phoneNumber
	 */
	public Patron(String name, int age, boolean active, String address, String phoneNumber) {
		super();
		this.membershipId= IdGenerator.getMembershipId();
		this.name = name;
		this.age = age;
		this.active = true;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	

	/**
	 * @param name
	 * @param age
	 * @param address
	 * @param phoneNumber
	 */
	public Patron(String name, int age, String address, String phoneNumber) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}



	@Override
	public void reserve(Reservable s) {
		subscribers.add(s);
		
	}

	@Override
	public void unreserve(Reservable s) {
		subscribers.remove(s);
		
	}

	@Override
	public void notifySubscribers() {
		for (Reservable s : subscribers) {
            s.available();
        }
	}

	/**
	 * @return the booksBorrowed
	 */
	public List<Book> getBooksBorrowed() {
		return booksBorrowed;
	}

	/**
	 * @param booksBorrowed the booksBorrowed to set
	 */
	public void setBooksBorrowed(List<Book> booksBorrowed) {
		this.booksBorrowed = booksBorrowed;
	}



	/**
	 * @return the membershipId
	 */
	public int getMembershipId() {
		return membershipId;
	}



	/**
	 * @param membershipId the membershipId to set
	 */
	public void setMembershipId(int membershipId) {
		this.membershipId = membershipId;
	}



	/**
	 * @return the subscribers
	 */
	public List<Reservable> getSubscribers() {
		return subscribers;
	}



	/**
	 * @param subscribers the subscribers to set
	 */
	public void setSubscribers(List<Reservable> subscribers) {
		this.subscribers = subscribers;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}



	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}



	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}



	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}



	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}



	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}



	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}



	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
	

}
