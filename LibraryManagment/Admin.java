package com.mycompany.library_management_system;

public class Admin extends User {
 
//constructor
    public Admin(String name, String id, String email, String phoneNumber,int age){
        super(name, id, email, phoneNumber,age);
    }
    

    // Method to add a book
    public books addBook(String Title, String Auther, String publisher, String isbn, int numOfCopy, double price) {
        books newBook = new books(Title, Auther, publisher, isbn, numOfCopy, price);
        System.out.println("Book '" + Title + "' has been added.");
        return newBook; 
    }

    // Method to remove a book 
    public void removeBook(books book) {
        if (book != null) {
            System.out.println("Book with ISBN '" + book.getisbn() + "' has been removed.");
            book = null; 
        } else {
            System.out.println("No book found.");
        }
    }

    // Method to update a book's details
    public void updateBook(books book, String newTitle, String newAuther, String newPublisher, String newIsbn, int newNumOfCopy, double newPrice) {
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuther(newAuther);
            book.setpublisher(newPublisher);
            book.setisbn(newIsbn);
            book.setCopies(newNumOfCopy);
            book.setprice(newPrice);
            System.out.println("Book has been updated with new details:");
            book.display();
        } else {
            System.out.println("No book found to update.");
        }
    }

   
   
    
    
}
