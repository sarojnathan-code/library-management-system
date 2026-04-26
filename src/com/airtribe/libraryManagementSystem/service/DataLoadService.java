package com.airtribe.libraryManagementSystem.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.airtribe.libraryManagementSystem.entity.Book;
import com.airtribe.libraryManagementSystem.entity.Genre;
import com.airtribe.libraryManagementSystem.entity.Library;
import com.airtribe.libraryManagementSystem.entity.Patron;
import com.airtribe.libraryManagementSystem.util.ApplicationConstants;

public class DataLoadService {

	public static  List<Book> books;

	public static Map<Genre, List<Book>> booksByGenre;
	
	public static Library libraryOne;
	
	public static Library libraryTwo;
	
	public static List<Patron> patrons1;
	
	public static List<Patron> patrons2;
	
	public static List<Book> libraryBooks1;
	
	public static List<Book> libraryBooks2;
	
	public static  List<Library> libraries;
	
	
	public static void loadBooks() {
		
		Book b1 = new Book(
			    "The Alchemist", "Paulo Coelho",
			    "978-0-06-112241-5", 1988, true, Genre.FICTION);

			Book b2 = new Book(
			    "Atomic Habits", "James Clear",
			    "978-0-7352-1129-2", 2018, true, Genre.SELF_HELP);

			Book b3 = new Book(
			    "Clean Code", "Robert C. Martin",
			    "978-0-13-235088-4", 2008, true, Genre.TECHNOLOGY);

			Book b4 = new Book(
			    "The Pragmatic Programmer", "Andrew Hunt & David Thomas",
			    "978-0-201-61622-4", 1999, true, Genre.TECHNOLOGY);

			Book b5 = new Book(
			    "Rich Dad Poor Dad", "Robert Kiyosaki",
			    "978-1-61268-019-4", 1997, true, Genre.FINANCE);

			Book b6 = new Book(
			    "To Kill a Mockingbird", "Harper Lee",
			    "978-0-06-112008-4", 1960, true, Genre.FICTION);

			Book b7 = new Book(
			    "1984", "George Orwell",
			    "978-0-452-28423-4", 1949, true, Genre.FICTION);

			Book b8 = new Book(
			    "Sapiens: A Brief History of Humankind", "Yuval Noah Harari",
			    "978-0-06-231609-7", 2011, true, Genre.HISTORY);

			Book b9 = new Book(
			    "The Psychology of Money", "Morgan Housel",
			    "978-0-85719-768-9", 2020, true, Genre.FINANCE);

			Book b10 = new Book(
			    "Deep Work", "Cal Newport",
			    "978-1-4555-8669-1", 2016, true, Genre.SELF_HELP);
			
			Book b11 = new Book(
					"Men are from Mars,Women are from Venus", "John Gray",
					"978-0-141-90944-8",1998, true, Genre.OTHERS);
			
			libraryBooks1 = new ArrayList<>(Arrays.asList(b6, b7, b8, b9, b10));
			libraryBooks2 = new ArrayList<>(Arrays.asList(b1, b2, b3, b4, b5,b11));
	}
	
	public static void groupBooksByGnere(){
		booksByGenre=  DataLoadService.books.stream()
		        .collect(Collectors.groupingBy(Book::getGenre));
	}
	
	public static void loadPatrons() {
		Patron p1 = new Patron("Saroj", 32, true, "Bengaluru", "9768214919");
		Patron p2 = new Patron("Anita", 28, false, "Chennai", "9840012345");
		Patron p3 = new Patron("Rahul", 40, true, "Mumbai", "9823456789");
		Patron p4 = new Patron("Priya", 35, true, "Hyderabad", "9701234567");
		Patron p5 = new Patron("Karthik", 30, false, "Coimbatore", "9898765432");
		
		 patrons1 = new ArrayList<>(Arrays.asList(p1,p2,p3));
		 patrons2 = new ArrayList<>(Arrays.asList(p4,p5));
	}
	
	public static void loadLibrary() {
		libraryOne = new Library(ApplicationConstants.MINDSPACE_READING_CORNER,"Bengaluru", "Saroj N",libraryBooks1,patrons1);
		libraryTwo = new Library(ApplicationConstants.READERS_VILLE,"Mumbai", "Saroj N",libraryBooks2,patrons2);
	}
	
	public static void loadLibraries() {
		libraries = new ArrayList<>();
		libraries.add(libraryOne);
		libraries.add(libraryTwo);
	}
	
	
}
