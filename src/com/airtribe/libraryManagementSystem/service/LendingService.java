package com.airtribe.libraryManagementSystem.service;

import com.airtribe.libraryManagementSystem.entity.Book;
import com.airtribe.libraryManagementSystem.entity.Patron;

public class LendingService {
	
	private void lendBook(Patron patron,Book book) {
		patron.getBooks().add(book);
		book.setAvailable(false);
	}
	
	private void returnBook(Patron patron,Book book) {
		patron.getBooks().remove(book);
		book.setAvailable(true);
	}


}
