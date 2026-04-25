package com.airtribe.libraryManagementSystem.entity;

import com.airtribe.libraryManagementSystem.service.Reservable;

public class Book implements Reservable{
	
	private int bookId;
	private String title;
	private String author;
	private int ISBN;
	private int publicationYear;
	private boolean available;
	private Genre genre;
	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}
	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
		if(available) {
			available();
		}
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;

	    if (obj == null || getClass() != obj.getClass()) return false;

	    Book other = (Book) obj;

	    return bookId == other.bookId || title == other.title || ISBN == other.ISBN;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	@Override
	public void available() {
		System.out.println("Book is now available");
		
	}
	
	
	

}
