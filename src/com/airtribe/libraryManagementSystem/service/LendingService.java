package com.airtribe.libraryManagementSystem.service;

import com.airtribe.libraryManagementSystem.entity.Book;
import com.airtribe.libraryManagementSystem.entity.Patron;

public class LendingService {
	
	public void lendBook(Patron patron,Book book) {
		patron.getBooksBorrowed().add(book);
		book.setAvailable(false);
	}
	
	public void returnBook(Patron patron,Book book) {
		patron.getBooksBorrowed().remove(book);
		book.setAvailable(true);
	}


}
