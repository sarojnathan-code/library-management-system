package com.airtribe.libraryManagementSystem.ui;

import java.util.Scanner;

import com.airtribe.learntrack.ui.EntityNotFoundException;
import com.airtribe.learntrack.ui.IdGenerator;
import com.airtribe.learntrack.ui.Student;
import com.airtribe.learntrack.ui.StudentService;
import com.airtribe.libraryManagementSystem.service.RecommendationService;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
	        boolean running = true;

	        while (running) {
	            System.out.println("\n--- Console Menu ---");
	            
	        	System.out.println("1. Manage Books");
	        	System.out.println("2. Manage Patrons");
	        	System.out.println("3. Borrow /Returns ");
	        	System.out.println("4. Inventory Management ");
	        	System.out.println("5. Borrow /Returns ");
	        	System.out.println("6. Transfer books ");
	        	System.out.println("7. Reserve books ");
	        	System.out.println("8. Recommend books ");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();

	            switch (choice) {
	            case 1:
	            	manageBooks();
	            	break;
	            }
	        }
	        
	        scanner.close();
			}
			catch(Exception ex) {
				System.err.println(ex.getMessage());
				main(args);
			}

	}
	
	public static void recommendBooks() {
		Scanner scanner = new Scanner(System.in);
		RecommendationService recommendationService = new RecommendationService();
		System.out.println("Enter your membershipId");
		int id = scanner.nextInt();
		
	}
	
	public static void manageBooks() {
		Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Manage Books ---");
            System.out.println("1. Add Books");
        	System.out.println("2. Remove Books");
        	System.out.println("3. Update Books");
        	System.out.println("4. Return to main menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
            case 1:
            	
                break;
            case 2:
            	
                break;
            case 3:
            	
                break;
            case 4:
                    return; // Return to the caller (Main Menu)
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
	

}
