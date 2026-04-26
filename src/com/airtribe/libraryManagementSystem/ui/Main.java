package com.airtribe.libraryManagementSystem.ui;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.airtribe.libraryManagementSystem.entity.Book;
import com.airtribe.libraryManagementSystem.entity.Genre;
import com.airtribe.libraryManagementSystem.entity.Library;
import com.airtribe.libraryManagementSystem.entity.Patron;
import com.airtribe.libraryManagementSystem.service.BookService;
import com.airtribe.libraryManagementSystem.service.BookTransferService;
import com.airtribe.libraryManagementSystem.service.DataLoadService;
import com.airtribe.libraryManagementSystem.service.LendingService;
import com.airtribe.libraryManagementSystem.service.LibraryService;
import com.airtribe.libraryManagementSystem.util.ApplicationConstants;
import com.airtribe.libraryManagementSystem.util.LendingStatus;

public class Main {

	public static void main(String[] args) {
		DataLoadService.loadBooks();
		DataLoadService.loadPatrons();
		DataLoadService.loadLibrary();
		DataLoadService.loadLibraries();
		try {
			Scanner scanner = new Scanner(System.in);
			boolean running = true;

			while (running) {
				System.out.println("\n--- Console Menu ---");

				System.out.println("1. Manage Books");
				System.out.println("2. Manage Patrons");
				System.out.println("3. Borrow /Returns ");
				System.out.println("4. Lending History ");
				System.out.println("5. Transfer books ");
				System.out.println("6. Reserve books ");
				System.out.println("7. Recommend books ");
				System.out.print("Enter your choice: ");

				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					manageBooks();
					break;
				case 2:
					manageBooks();
					break;
				case 3:
					borrowOrReturnBook();
					break;
				case 4:
					getLendingHistory();
					break;
				case 5:
					transferBook();
						break;
				case 7:
					recommendBooks();
					break;
				}
			}

			scanner.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void recommendBooks() {
		Scanner scanner = new Scanner(System.in);
		BookService bookServive = new BookService();
		DataLoadService dataLoadService = new DataLoadService();
		Library library = new Library();
		System.out.println("Select Library of the member : 1. MindSpace Reading Corner 2. ReadersVille");
		int selectLibrary = scanner.nextInt();

		if(selectLibrary==1 ) {
			library = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.MINDSPACE_READING_CORNER)).findFirst()
					.orElse(null);
		}else if(selectLibrary == 2) {
			library = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.READERS_VILLE)).findFirst()
					.orElse(null);
		}
		System.out.println("Enter your membershipId");
		int id = scanner.nextInt();
		Map<Genre, Long> genreCount = library.getMembers().stream()
		.filter(m -> m.getMembershipId() == id).findFirst().orElse(null).
		getBookHistory().values().stream().flatMap(List::stream)                 // all books in one stream
	    .collect(Collectors.groupingBy(
	            Book::getGenre, 
	            Collectors.counting()
	        ));

		Genre maxGenre = genreCount.entrySet().stream()
			    .max(Map.Entry.comparingByValue())
			    .map(Map.Entry::getKey)
			    .orElse(null);
		List<Book> bookRecommendations = DataLoadService.booksByGenre.get(maxGenre);
		bookRecommendations.stream().forEach(System.out::println);
		
	}

	public static void manageBooks() {
		Scanner scanner = new Scanner(System.in);
		DataLoadService dataLoadService = new DataLoadService();
		Library library = new Library();
		LibraryService libraryService  = new LibraryService();
		while (true) {
			System.out.println("\n--- Manage Books ---");
			System.out.println("Select Library to update: 1. MindSpace Reading Corner 2. ReadersVille");
			int selectLibrary = scanner.nextInt();

			if(selectLibrary==1 ) {
				library = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.MINDSPACE_READING_CORNER)).findFirst()
						.orElse(null);
			}else if(selectLibrary == 2) {
				library = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.READERS_VILLE)).findFirst()
						.orElse(null);
			}

			System.out.println("1. Add Book");
			System.out.println("2. Remove Book");
			System.out.println("3. Update Book");
			System.out.println("4. Return to main menu");
			System.out.print("Select an option: ");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter book title");
				scanner.nextLine();
				String bookName = scanner.nextLine();
				System.out.println("Enter author");
				String author = scanner.nextLine();
				System.out.println("Enter ISBN");
				String isbn = scanner.nextLine();
				System.out.println("Enter publication year");
				int publicationYear = scanner.nextInt();
				System.out.println("Enter Genre");
				String genre = scanner.nextLine();
				scanner.nextLine();
				Book book = new Book(bookName,author,isbn,publicationYear, Genre.fromString(genre));
				libraryService.addBook(library,book);
				library.getBooks().toString();
				break;
			case 2:
				System.out.println("Enter book title");
				String searchString = scanner.nextLine();
				Book bookToRemove = new Book(searchString);
				libraryService.removeBooks(library, bookToRemove);
				scanner.nextLine();
				break;
			case 3:
				System.out.println("Enter book id to update");
				int bookIdToUpdate = scanner.nextInt();
				System.out.println("Enter book title");
				scanner.nextLine();
				String bookNameUpdate = scanner.nextLine();
				System.out.println("Enter author");
				String authorUpdate = scanner.nextLine();
				System.out.println("Enter ISBN");
				String isbnUpdate = scanner.nextLine();
				System.out.println("Enter publication year");
				int publicationYearUpdate = scanner.nextInt();
				System.out.println("Enter Genre");
				String genreUpdate = scanner.nextLine();
				System.out.println("Enter availablity");
				boolean availability = scanner.nextBoolean();
				Book bookToUpdate = new Book(bookNameUpdate,authorUpdate,isbnUpdate,publicationYearUpdate,availability, Genre.fromString(genreUpdate));

				libraryService.updateBook(library, bookIdToUpdate, bookToUpdate);
				scanner.nextLine();
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid option. Try again.");
			}
		}
	}

	public static void managPatrons() {
		Scanner scanner = new Scanner(System.in);
		DataLoadService dataLoadService = new DataLoadService();
		Library library = null;
		LibraryService libraryService  = new LibraryService();
		while (true) {
			System.out.println("\n--- Manage Patrons ---");

			System.out.println("1. Add Patron");
			System.out.println("2. Update Patron");
			System.out.println("3. Check Patron borrowing history");
			System.out.println("4. Return to main menu");
			System.out.print("Select an option: ");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter name");
				scanner.nextLine();
				String patronName = scanner.nextLine();
				System.out.println("Enter age");
				int patronAge = scanner.nextInt();
				System.out.println("Enter address");
				String patronAddress = scanner.nextLine();
				System.out.println("Enter phone number");
				String patronPhoneNumber = scanner.nextLine();
				scanner.nextLine();
				System.out.println("Select Library to add the member in: 1. MindSpace Reading Corner 2. ReadersVille");
				int selectLibrary = scanner.nextInt();

				if(selectLibrary==1 ) {
					library = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.MINDSPACE_READING_CORNER)).findFirst()
							.orElse(null);
				}else if(selectLibrary == 2) {
					library = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.READERS_VILLE)).findFirst()
							.orElse(null);
				}

				Patron newPatron = new Patron(patronName,patronAge,patronAddress,patronPhoneNumber);
				libraryService.addMember(library, newPatron);
				break;
			case 2:
				System.out.println("Enter membershipId");
				int membershipId = scanner.nextInt();
				System.out.println("Enter name");
				scanner.nextLine();
				String patronNameUpdate = scanner.nextLine();
				System.out.println("Enter age");
				int patronAgeUpdate = scanner.nextInt();
				System.out.println("Enter address");
				String patronAddressUpdate = scanner.nextLine();
				System.out.println("Enter phone number");
				String patronPhoneNumberUpdate = scanner.nextLine();
				System.out.println("Enter status");
				boolean patronStatusUpdate = scanner.nextBoolean();
				Patron updatePatron = new Patron(patronNameUpdate,patronAgeUpdate,patronStatusUpdate,patronAddressUpdate,patronPhoneNumberUpdate);
				libraryService.updateMember(library, membershipId, updatePatron);
				break;
			case 3:
				System.out.println("Enter membershipId");
				int borrowingHistoryMember = scanner.nextInt();
				library.getMembers().stream()
				.filter(m -> m.getMembershipId() == borrowingHistoryMember)
				.findFirst()
				.ifPresent(member -> 
				member.getBooksBorrowed()
				.forEach(book -> System.out.println(book))
						);
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid option. Try again.");
			}
		}
	}

	public static void borrowOrReturnBook() {
		Scanner scanner = new Scanner(System.in);
		Library library = new Library();
		DataLoadService dataLoadService = new DataLoadService();

		while (true) {
			System.out.println("Select Library of the member in: 1. MindSpace Reading Corner 2. ReadersVille");
			int selectLibrary = scanner.nextInt();

			if(selectLibrary==1 ) {
				library = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.MINDSPACE_READING_CORNER)).findFirst()
						.orElse(null);
			}else if(selectLibrary == 2) {
				library = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.READERS_VILLE)).findFirst()
						.orElse(null);
			}

			System.out.println("Enter membershipId");
			int membershipId = scanner.nextInt();
			Patron patron = library.getMembers().stream().filter(m -> m.getMembershipId() == membershipId).findFirst().orElse(null);
			System.out.println("Enter book title");
			String bookName = scanner.nextLine();
			LendingService lendingService = new LendingService();

			BookService bookService = new BookService();
			Book searchBook = bookService.searchBook(new Book(bookName));
			if(patron==null) {
				System.err.println("Invalid membership id");
				return;
			}

			System.out.println("\n--- Borrow or Return Book ---");

			System.out.println("1. Borrow book");
			System.out.println("2. Return book");
			System.out.println("3. Return to main menu");
			System.out.print("Select an option: ");


			int choice = scanner.nextInt();
			switch (choice) {
			case 1:

				if(searchBook == null) {
					System.err.println("This book is not available at the moment");
					return;
				}else {
					lendingService.lendBook(patron,searchBook);
				}

				break;
			case 2:
				if(searchBook == null) {
					System.err.println("This book is not available at the moment");
					return;
				}else {
					lendingService.returnBook(patron, searchBook);
				}


			}
		}
	}
	
	public static void getLendingHistory() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select Library of the member in: 1. MindSpace Reading Corner 2. ReadersVille");
		int selectLibrary = scanner.nextInt();
		DataLoadService dataLoadService = new DataLoadService();
		Library library = new Library();
		if(selectLibrary==1 ) {
			library = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.MINDSPACE_READING_CORNER)).findFirst()
					.orElse(null);
		}else if(selectLibrary == 2) {
			library = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.READERS_VILLE)).findFirst()
					.orElse(null);
		}
		System.out.println("Enter membershipId");
		int membershipId = scanner.nextInt();
		Patron patron = library.getMembers().stream().filter(m -> m.getMembershipId() == membershipId).findFirst().orElse(null);
		if(patron==null) {
			System.err.println("Invalid membership id");
			return;
		}else {
			patron.getBookHistory().forEach((status, books) -> {
			    System.out.println("Status: " + status);
			    books.forEach(System.out::println);
			});
		}
		
	}
	
	public static void transferBook() {
		BookTransferService bookTransferService= new BookTransferService();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select Library to transfer book from in: 1. MindSpace Reading Corner 2. ReadersVille");
		int selectLibraryFrom = scanner.nextInt();
		DataLoadService dataLoadService = new DataLoadService();
		Library toLibrary = new Library();
		if(selectLibraryFrom==1 ) {
			toLibrary = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.MINDSPACE_READING_CORNER)).findFirst()
					.orElse(null);
		}else if(selectLibraryFrom == 2) {
			toLibrary = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.READERS_VILLE)).findFirst()
					.orElse(null);
		}
		
		System.out.println("Select Library to transfer book to in: 1. MindSpace Reading Corner 2. ReadersVille");
		int selectLibraryTo = scanner.nextInt();
		
		Library fromLibrary = new Library();
		if(selectLibraryTo == 1) {
			fromLibrary = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.MINDSPACE_READING_CORNER)).findFirst()
					.orElse(null);
		}else if(selectLibraryTo == 2) {
			fromLibrary = dataLoadService.libraries.stream().filter(l -> l.getLibraryName().equalsIgnoreCase(ApplicationConstants.READERS_VILLE)).findFirst()
					.orElse(null);
		}
		System.out.println("Enter book title");
		String searchString = scanner.nextLine();
		Book bookToTransfer = new Book(searchString);
		bookTransferService.transferBook(toLibrary, fromLibrary, bookToTransfer);
		
	}


	}


