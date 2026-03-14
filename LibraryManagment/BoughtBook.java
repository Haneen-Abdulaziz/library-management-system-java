/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_management_system;

import java.util.Date;

public class BoughtBook extends books {
    private Date purchaseDate;
    private String buyerName;
    private int buyerAge;
    private String id; 
    private String paymentType;

    // Default constructor
    public BoughtBook() {
        this.purchaseDate = new Date();
        this.buyerName = null;
        this.buyerAge = 0;
        this.id = null;
        this.paymentType = null;
    }

    // Parameterized constructor
    public BoughtBook(String title, String author, String publisher, String isbn,
                      int numOfCopy, double price, String buyerName, int buyerAge, 
                      String id, String paymentType) {
        super(title, author, publisher, isbn, numOfCopy, price);
        this.purchaseDate = new Date();
        this.buyerName = buyerName;
        this.buyerAge = buyerAge;
        this.id = id;
        this.paymentType = paymentType;
    }

    // Getters and Setters
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public int getBuyerAge() {
        return buyerAge;
    }

    public void setBuyerAge(int buyerAge) {
        this.buyerAge = buyerAge;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    // Method to get the book object
    public books getBook() {
        return this; // Return the current instance of BoughtBook
    }

    // Method to process the book purchase
    public void bookPurchaseProcess(Payment payment) {
        if (super.Availability()) {
            System.out.print("# Book And Buyer Details #");
            super.display(); // Display book details
            System.out.printf("\nBuyer Name: " + buyerName + "\n" +
                    "Buyer Age: " + buyerAge + "\n" +
                    "Buyer National ID: " + id + "\n" + 
                    "Payment Type: " + paymentType + "\n" +        
                    "Purchase Date: " + purchaseDate + "\n");
            payment.processPayment(); // Call payment processing
        } else {
            System.out.print("Sorry! The book is not available");
        }
    }
}