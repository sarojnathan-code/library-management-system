package com.airtribe.libraryManagementSystem.entity;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.libraryManagementSystem.service.Notify;
import com.airtribe.libraryManagementSystem.service.Reservable;

public class Patron extends Person implements Notify{
	
	private List<Reservable> subscribers = new ArrayList<>();
	
	private int membershipId;
	private boolean active;
	private String address;
	private int phoneNumber;
	
	private List<Book> books= new ArrayList();

	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
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
	
	

}
