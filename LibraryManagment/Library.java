/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_management_system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Library {
    private static List<books> bookList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static List<Admin> admins = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static List<BorrowedBooks> borrowedBooksList = new ArrayList<>();
    private static List<BoughtBook> boughtBooksList = new ArrayList<>();

    public static void main(String[] args) {
        initializeBooks();
        initializeAdmins();

        System.out.println("Welcome to the Library Management System");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    signUp();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void BuyBook(User user) {
        System.out.print("Enter ISBN of the book: ");
        String isbn = scanner.nextLine();
        books bookToBuy = null;

        for (books book : bookList) {
            if (book.getisbn().equals(isbn) && book.Availability()) {
                bookToBuy = book;
                break;
            }
        }

        if (bookToBuy != null) {
            System.out.println("You selected: " + bookToBuy.getTitle());
            System.out.println("Choose payment method (for buying):");
            System.out.println("1. Cash");
            System.out.println("2. Credit Card");
            int paymentOption = 0;
            while (true) {
            System.out.print("Select payment option (1 or 2): ");
            try {
                paymentOption = Integer.parseInt(scanner.nextLine());
                if (paymentOption == 1 || paymentOption == 2) {
                    break; // Valid payment option
                } else {
                    System.out.println("Invalid selection. Please select 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }

            double amount = bookToBuy.getprice();

            Payment payment;
            if (paymentOption == 1) {
                double cashReceived = 0;
                 while (true) {
                System.out.print("Enter cash received: ");
                try {
                    cashReceived = Double.parseDouble(scanner.nextLine());
                    if (cashReceived >= amount) {
                        payment = new CashPayment(amount, cashReceived);
                        break;
                    } else {
                        System.out.println("Error: Cash received must be at least the price of the book.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid amount.");
                }
            }
            } else {
                payment = new CardPayment(amount);
            }

            payment.processPayment();

            // Gather buyer's information
            
            String buyerName = user.getName();
            String id = user.getId();
           
            
            int buyerAge = 0;
            while (true) {
            System.out.print("Enter Buyer Age: ");
            try {
                buyerAge = Integer.parseInt(scanner.nextLine());
                if (buyerAge > 0) {
                    break; // Valid age
                } else {
                    System.out.println("Error: Age must be greater than zero. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number for age.");
            }
        }
            
            String paymentType = (paymentOption == 1) ? "Cash" : "Credit Card";

            // Create the BoughtBook object
            BoughtBook boughtBook = new BoughtBook(
                bookToBuy.getTitle(),
                bookToBuy.getAuther(),
                bookToBuy.getpublisher(),
                bookToBuy.getisbn(),
                bookToBuy.getCopies(),
                bookToBuy.getprice(),
                buyerName,
                buyerAge,
                id,
                paymentType
            );

            // Add to the bought books list
            boughtBooksList.add(boughtBook);

            // Reduce available copies
            bookToBuy.setCopies(bookToBuy.getCopies() - 1);
            System.out.println("Book " + bookToBuy.getTitle() + " has been bought.");
        } else {
            System.out.println("Book not available.");
        }
    }

    private static void initializeBooks() {
        for (int i = 1; i <= 50; i++) {
            books book = new books("Book Title " + i, "Author " + i, "Publisher " + i, "ISBN" + i, 5, 10.0);
            bookList.add(book);
        }
    }

    private static void initializeAdmins() {
        admins.add(new Admin("Amal Alghamdi", "1234", "amal@gmail.com","5432",20));
        admins.add(new Admin("Haneen Abdulaziz","6491", "haneen@gmail.com","0751",20));
        admins.add(new Admin("Aqelah Alawi", "3015", "aqelah@gmail.com","5276",20));
        admins.add(new Admin("Shahad Adel", "7289", "shahad_a@gmail.com","9616",20));
    }
    private static void login() {
        System.out.print("Enter your ID: ");
        String id = scanner.nextLine();

        for (Admin admin : admins) {
            if (admin.getId().equals(id)) {
                System.out.println("\nWelcome, " + admin.getName() + "!");
                adminMenu(admin);
                return;
            }
        }

        for (User user : users) {
            if (user.getId().equals(id)) {
                System.out.println("\nWelcome, " + user.getName() + "!");
                userMenu(user);
                return;
            }
        }

        System.out.println("You are not registered. Please sign up.");
    }

    private static void signUp() {
    System.out.print("Enter your name: ");
    String name = scanner.nextLine();
    System.out.print("Enter your ID: ");
    String id = scanner.nextLine();
    System.out.print("Enter your email: ");
    String email = scanner.nextLine();
    System.out.print("Enter your phone number: ");
    String phoneNumber = scanner.nextLine();
    
    int age = 0;
    while (true) {
        System.out.print("Enter your age: ");
        try {
            age = Integer.parseInt(scanner.nextLine());
            if (age > 0) {
                break; // Valid age
            } else {
                System.out.println("Error: Age must be greater than zero. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number for age.");
        }
    }

    System.out.println("Are you signing up as:");
    System.out.println("1. User");
    System.out.println("2. Admin");
    System.out.print("Select an option (1 or 2): ");
    int userType = 0;
    while (true) {
        try {
            userType = Integer.parseInt(scanner.nextLine());
            if (userType == 1 || userType == 2) {
                break; // Valid user type
            } else {
                System.out.println("Invalid selection. Please select 1 or 2.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        }
    }

    switch (userType) {
        case 1:
            User newUser = new User(name, id, email, phoneNumber, age);
            users.add(newUser);
            System.out.println("Sign-up successful! Welcome, " + newUser.getName() + "!");
            userMenu(newUser);
            break;
        case 2:
            Admin newAdmin = new Admin(name, id, email, phoneNumber, age);
            admins.add(newAdmin);
            System.out.println("Admin sign-up successful! Welcome, " + newAdmin.getName() + "!");
            adminMenu(newAdmin);
            break;
        default:
            System.out.println("Invalid selection. Please try again.");
            break;
    }
}

    private static void userMenu(User user) {
        boolean userRunning = true;

        while (userRunning) {
            System.out.println("\nUser Menu");
            System.out.println("1. Borrow Book");
            System.out.println("2. Buy Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display All Books");
            System.out.println("5. View Most Borrowed/Bought Books");
            System.out.println("6. Exit to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    borrowBook(user);
                    break;
                case 2:
                    BuyBook(user);
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    viewMostBorrowedBoughtBooks();
                    break;
                case 6:
                    userRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

        private static void adminMenu(Admin admin) {
        boolean adminRunning = true;

        while (adminRunning) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. Display All Books");
            System.out.println("5. View Most Borrowed/Bought Books");
            System.out.println("6. Exit to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(admin);
                    break;
                case 2:
                    removeBook(admin);
                    break;
                case 3:
                    updateBook(admin);
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    viewMostBorrowedBoughtBooks();
                    break;
                case 6:
                    adminRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
private static void addBook(Admin admin) {

    System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

    int numOfCopies;
    while (true) {
        System.out.print("Enter Number of Copies: ");
        if (scanner.hasNextInt()) {
            numOfCopies = scanner.nextInt();
            if (numOfCopies > 0) {
                break;
            } else {
                System.out.println("Error: Number of copies must be greater than zero. Please try again.");
            }
        } else {
            System.out.println("Error: Please enter a valid number for 'Number of Copies'.");
            scanner.next();
        }
    }
    scanner.nextLine();

    double price;
    while (true) {
        System.out.print("Enter Price: ");
        if (scanner.hasNextDouble()) {
            price = scanner.nextDouble();
            if (price > 0) {
                break;
            } else {
                System.out.println("Error: Price must be greater than zero. Please try again.");
            }
        } else {
            System.out.println("Error: Please enter a valid number for 'Price'.");
            scanner.next();
        }
    }
    scanner.nextLine();

    books newBook = admin.addBook(title, author, publisher, isbn, numOfCopies, price);
    bookList.add(newBook);
    System.out.println("Book added successfully!");
}


    private static void removeBook(Admin admin) {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();

        books bookToRemove = null;
        for (books book : bookList) {
            if (book.getisbn().equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            admin.removeBook(bookToRemove);
            bookList.remove(bookToRemove);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void updateBook(Admin admin) {
        System.out.print("Enter ISBN of the book to update: ");
        String isbn = scanner.nextLine();

        books bookToUpdate = null;
        for (books book : bookList) {
            if (book.getisbn().equals(isbn)) {
                bookToUpdate = book;
                break;
            }
        }

        if (bookToUpdate != null) {
            System.out.print("Enter New Title: ");
            String newTitle = scanner.nextLine();
            System.out.print("Enter New Author: ");
            String newAuthor = scanner.nextLine();
            System.out.print("Enter New Publisher: ");
            String newPublisher = scanner.nextLine();
            System.out.print("Enter New ISBN: ");
            String newIsbn = scanner.nextLine();
           
            int newNumOfCopies;
    while (true) {
        System.out.print("Enter Number of Copies: ");
        if (scanner.hasNextInt()) {
            newNumOfCopies = scanner.nextInt();
            if (newNumOfCopies > 0) {
                break;
            } else {
                System.out.println("Error: Number of copies must be greater than zero. try again.");
            }
        } else {
            System.out.println("Error: Please enter a number .");
            scanner.next();
        }
    }
    scanner.nextLine();

    double newPrice;
    while (true) {
        System.out.print("Enter Price: ");
        if (scanner.hasNextDouble()) {
            newPrice = scanner.nextDouble();
            if (newPrice > 0) {
                break;
            } else {
                System.out.println("Error: Price must be greater than zero. Please try again.");
            }
        } else {
            System.out.println("Error: Please enter a valid number for 'Price'.");
            scanner.next();
        }
    }
    scanner.nextLine();

            admin.updateBook(bookToUpdate, newTitle, newAuthor, newPublisher, newIsbn, newNumOfCopies, newPrice);
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }
   
    private static void borrowBook(User user) {
    System.out.print("Enter ISBN of the book to borrow: ");
    String isbn = scanner.nextLine();

    books bookToBorrow = null;

    for (books book : bookList) {
        if (book.getisbn().equals(isbn) && book.Availability()) {
            bookToBorrow = book;
            break;
        }
    }

    if (bookToBorrow != null) {
        bookToBorrow.decrementCopies();
        BorrowedBooks borrowedBook = new BorrowedBooks(
            bookToBorrow.getTitle(),
            bookToBorrow.getAuther(),
            bookToBorrow.getpublisher(),
            bookToBorrow.getisbn(),
            1,
            user.getName(),
            new Date(),
            null
        );
        borrowedBooksList.add(borrowedBook);
        System.out.println("You have successfully borrowed: " + bookToBorrow.getTitle());
        borrowedBook.display();
    } else {
        System.out.println("Book not available for borrowing.");
    }
}


    private static void displayBooks() {
        System.out.println("\nDisplaying all books:");
        for (books book : bookList) {
            book.display();
            System.out.println("\n----------------------");
        }
    }

private static void returnBook() {
    System.out.print("Enter the title of the book to return: ");
    String title = scanner.nextLine();

    boolean found = false;

    for (BorrowedBooks borrowedBook : borrowedBooksList) {
        if (borrowedBook.getTitle().equalsIgnoreCase(title)) {
            found = true;

            // Check if the book is returned late
            Date currentDate = new Date();
            if (borrowedBook.lateReturn(currentDate)) {
                double fine = borrowedBook.calculateFine(currentDate);
                System.out.println("The book is late! Fine: " + fine + " riyals.");
            } else {
                System.out.println("The book has been returned on time. No fine!");
            }

            // Update the number of copies in the main book list
            for (books book : bookList) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    book.setCopies(book.getCopies() + 1);
                    break;
                }
            }

            // Remove the book from the borrowed books list
            borrowedBooksList.remove(borrowedBook);

            System.out.println("The book has been successfully returned.");
            break;
        }
    }

    if (!found) {
        System.out.println("No record found for this borrowed book.");
    }
}

    private static void viewMostBorrowedBoughtBooks() {
        Map<String, Integer> borrowedCount = new HashMap<>();
        Map<String, Integer> boughtCount = new HashMap<>();

        for (BorrowedBooks borrowedBook : borrowedBooksList) {
            String title = borrowedBook.getTitle();
            borrowedCount.put(title, borrowedCount.getOrDefault(title, 0) + 1);
        }

        for (BoughtBook boughtBook : boughtBooksList) {
            String title = boughtBook.getTitle();
            boughtCount.put(title, boughtCount.getOrDefault(title, 0) + 1);
        }

        String mostBorrowedTitle = borrowedCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("No borrowed books");
        int mostBorrowedCount = borrowedCount.getOrDefault(mostBorrowedTitle, 0);

        String mostBoughtTitle = boughtCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("No bought books");
        int mostBoughtCount = boughtCount.getOrDefault(mostBoughtTitle, 0);

        System.out.println("Most Borrowed Book: " + mostBorrowedTitle + " (Borrowed " + mostBorrowedCount + " times)");
        System.out.println("Most Bought Book: " + mostBoughtTitle + " (Bought " + mostBoughtCount + " times)");
    }
}