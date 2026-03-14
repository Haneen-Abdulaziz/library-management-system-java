/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_management_system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer extends User {
    private List<BorrowedBooks> borrowedBooks;

    // Constructor
    public Customer(String name, String id, String email, String phoneNumber,int age) {
        super(name, id, email, phoneNumber,age);
        this.borrowedBooks = new ArrayList<>(); 
    }

    // Method to borrow a book
    public void borrow(books book) {
        if (book.Availability()) {
            // Create a BorrowedBooks instance
            BorrowedBooks borrowedBook = new BorrowedBooks(
                book.getTitle(),
                book.getAuther(),
                book.getpublisher(),
                book.getisbn(),
                book.getCopies(),
                this.getName(),
                new Date(), // Borrow date
                null // Return date will be set later
            );

            // Add to borrowed books
            borrowedBooks.add(borrowedBook);
            System.out.println(getName() + " has borrowed the book: " + book.getTitle());
            book.decrementCopies(); // Update available copies
        } else {
            System.out.println("The book " + book.getTitle() + " is not available");
        }
    }

    // Method to return a book
    public void returnBook(BorrowedBooks borrowedBook) {
        if (borrowedBooks.contains(borrowedBook)) {
            borrowedBook.setReturnDate(new Date());
            borrowedBooks.remove(borrowedBook);
            System.out.println(getName() + " returned the book: " + borrowedBook.getTitle());
        } else {
            System.out.println("This book was not borrowed by " + getName());
        }
    }

    // Get list of borrowed books
    public List<BorrowedBooks> getBorrowedBooks() {
        return borrowedBooks;
    }
}