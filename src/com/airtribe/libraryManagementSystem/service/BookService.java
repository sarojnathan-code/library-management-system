package com.airtribe.libraryManagementSystem.service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.airtribe.libraryManagementSystem.entity.Book;

public class BookService {
	
	private List<Book> books = DataLoadService.books;
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void updateBook(Book book) {
		for(int i=0;i<=books.size();i++) {
			if(books.get(i).equals(book)) {
				books.add(i, book);
			}
		}
		
	}
	
	public void removeBook(Book book) {
		books.remove(book);
	}
	
	public Book searchBook(Book book) {
		Iterator iterator = books.iterator();
		while(iterator.hasNext()){
			Book currentBook = (Book) iterator.next();
			if(currentBook.equals(book)) {
				return currentBook;
			} 
		}
		return null;
		
	}

	public List<Book> getAvailableBooks() {
		return books.stream().filter(book -> book.isAvailable()).collect(Collectors.toList());
		
	}
	
	public List<Book> getBorrowedBooks() {
	 return books.stream().filter(book -> !book.isAvailable()).collect(Collectors.toList());
		
	}
}
