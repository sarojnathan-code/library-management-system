package com.airtribe.libraryManagementSystem.service;

import java.util.List;

import com.airtribe.libraryManagementSystem.entity.Book;
import com.airtribe.libraryManagementSystem.entity.Library;
import com.airtribe.libraryManagementSystem.entity.Patron;

public class LibraryService {
	
	public static  List<Library> libraries = DataLoadService.libraries;
	
	
	public void addBook(Library library,Book book) {
		Library currentLibrary = libraries.stream().filter(l -> l.getLibraryName().equals(library.getLibraryName())).findFirst().orElse(null);
		currentLibrary.getBooks().add(book);
	}
	
	public void removeBooks(Library library,Book book) {
		Library currentLibrary = libraries.stream().filter(l -> l.getLibraryName().equals(library.getLibraryName())).findFirst().orElse(null);
		currentLibrary.getBooks().remove(book);
		
	}
	
	public void updateBook(Library library, int bookId, Book updatedBook) {
	    for (Book book : library.getBooks()) {
	        if (book.getBookId() == bookId) {
	            book.setTitle(updatedBook.getTitle());
	            book.setGenre(updatedBook.getGenre());
	            book.setAuthor(updatedBook.getAuthor());
	            book.setISBN(updatedBook.getISBN());
	            book.setPublicationYear(updatedBook.getPublicationYear());
	            return;
	        }
	    }
	}
	
	public void addMember(Library library,Patron patron) {
		Library currentLibrary = libraries.stream().filter(l -> l.getLibraryName().equals(library.getLibraryName())).findFirst().orElse(null);
		currentLibrary.getMembers().add(patron);
	}
	
	public void updateMember(Library library, int membershipId, Patron patron) {
	    for (Patron p : library.getMembers()) {
	        if (p.getMembershipId() == membershipId) {
	            p.setName(patron.getName());
	            p.setActive(patron.isActive());
	            p.setAge(patron.getAge());
	            p.setPhoneNumber(patron.getPhoneNumber());
	            p.setAddress(patron.getAddress());
	            return;
	        }
	    }
	}


}
