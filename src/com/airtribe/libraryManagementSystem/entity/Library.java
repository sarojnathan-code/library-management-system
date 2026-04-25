package com.airtribe.libraryManagementSystem.entity;

import java.util.List;

public class Library {
	
	private String libraryName;
	private String location;
	private String librarianName;
	private List<Book> books;
	private List<Patron> members;
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
	
	

}
