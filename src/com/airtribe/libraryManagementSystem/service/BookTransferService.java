package com.airtribe.libraryManagementSystem.service;

import com.airtribe.libraryManagementSystem.entity.Book;
import com.airtribe.libraryManagementSystem.entity.Library;

public class BookTransferService {
	
	
	public void transferBook(Library to, Library from, Book book) {
		from.getBooks().remove(book);
		to.getBooks().add(book);
	}

}
