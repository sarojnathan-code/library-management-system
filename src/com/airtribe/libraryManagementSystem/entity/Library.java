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
	/**
	 * @param libraryName
	 * @param location
	 * @param librarianName
	 * @param books
	 * @param members
	 */
	public Library(String libraryName, String location, String librarianName, List<Book> books, List<Patron> members) {
		super();
		this.libraryName = libraryName;
		this.location = location;
		this.librarianName = librarianName;
		this.books = books;
		this.members = members;
	}
	
	
	/**
	 * 
	 */
	public Library() {
		super();
	}
	/**
	 * @return the libraryName
	 */
	public String getLibraryName() {
		return libraryName;
	}
	/**
	 * @param libraryName the libraryName to set
	 */
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	/**
	 * @return the members
	 */
	public List<Patron> getMembers() {
		return members;
	}
	/**
	 * @param members the members to set
	 */
	public void setMembers(List<Patron> members) {
		this.members = members;
	}
	
	
	
	
	

}
