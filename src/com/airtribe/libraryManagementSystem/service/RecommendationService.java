package com.airtribe.libraryManagementSystem.service;

import java.util.HashMap;
import java.util.List;

import com.airtribe.libraryManagementSystem.entity.Book;
import com.airtribe.libraryManagementSystem.entity.Genre;
import com.airtribe.libraryManagementSystem.entity.Patron;

public class RecommendationService {

	private List<Book> recommendBook(Patron patron){
		patron.getBooksBorrowed();
		return null;
	}
	
}
