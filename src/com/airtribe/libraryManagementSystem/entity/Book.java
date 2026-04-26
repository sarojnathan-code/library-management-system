package com.airtribe.libraryManagementSystem.entity;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.libraryManagementSystem.service.Reservable;
import com.airtribe.libraryManagementSystem.service.Reserver;
import com.airtribe.libraryManagementSystem.util.IdGenerator;

public class Book implements Reservable{
	
	private int bookId;
	private String title;
	private String author;
	private String ISBN;
	private int publicationYear;
	private boolean available;
	private Genre genre;
	private List<Patron> reservers = new ArrayList();
	
	
	/**
	 * @param bookId
	 * @param title
	 * @param author
	 * @param iSBN
	 * @param publicationYear
	 * @param available
	 * @param genre
	 */
	public Book(String title, String author, String iSBN, int publicationYear, boolean available,
			Genre genre) {
		super();
		this.bookId = IdGenerator.getNextBookId();
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.publicationYear = publicationYear;
		this.available = available;
		this.genre = genre;
	}
	
	public Book(String title, String author, String iSBN, int publicationYear,
			Genre genre) {
		super();
		this.bookId = IdGenerator.getNextBookId();
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.publicationYear = publicationYear;
		this.available = true;
		this.genre = genre;
	}
	
	
	
	/**
	 * @param title
	 */
	public Book(String title) {
		super();
		this.title = title;
		this.available = true;
	}
	
	

	/**
	 * @param bookId
	 */
	public Book(int bookId) {
		super();
		this.bookId = bookId;
	}

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
			notifyObservers("Book is now available");
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
	

	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	/**
	 * @return the publicationYear
	 */
	public int getPublicationYear() {
		return publicationYear;
	}

	/**
	 * @param publicationYear the publicationYear to set
	 */
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", ISBN=" + ISBN
				+ ", publicationYear=" + publicationYear + ", available=" + available + ", genre=" + genre + "]";
	}

	@Override
	public void registerObserver(Reserver observer) {
		
		
	}

	@Override
	public void removeObserver(Reserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers(String message) {
		// TODO Auto-generated method stub
		
	}

	

	

}
