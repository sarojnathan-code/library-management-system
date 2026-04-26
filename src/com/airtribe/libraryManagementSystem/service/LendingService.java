package com.airtribe.libraryManagementSystem.service;

import com.airtribe.libraryManagementSystem.entity.Book;
import com.airtribe.libraryManagementSystem.entity.Patron;
import com.airtribe.libraryManagementSystem.util.LendingStatus;

public class LendingService {
	
	public void lendBook(Patron patron,Book book) {
		patron.getBooksBorrowed().add(book);
		patron.getBookHistory().get(LendingStatus.BORROWED).add(book);
		book.setAvailable(false);
	}
	
	public void returnBook(Patron patron,Book book) {
		patron.getBooksBorrowed().remove(book);
		patron.getBookHistory().get(LendingStatus.RETURNED).add(book);
		book.setAvailable(true);
	}


}
