/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.library_management_system;

import java.util.Scanner; 

public class CardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;
    
    public CardPayment(double amount) {
        super(amount);
        collectCardDetails();  
    }

    // Method to collect card details from the user
    private void collectCardDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Card Holder Name: ");
        this.cardHolderName = scanner.nextLine();

        System.out.println("Enter Card Number: ");
        this.cardNumber = scanner.nextLine();

        System.out.println("Enter Expiry Date (MM/YY): ");
        this.expiryDate = scanner.nextLine();
        System.out.println("Enter CVV Number: ");
        this.cvv = scanner.nextLine();}


    public String getCardNumber() {
        return cardNumber;
    }


    public String getCardHolderName() {
        return cardHolderName;
    }


    public String getExpiryDate() {
        return expiryDate;
    }
    
 
    @Override
    public void processPayment(){
        System.out.println("Processing card payment of $"+getAmount() +"on"+getPaymentDate());
        System.out.println("Card Holder: "+ cardHolderName);
        System.out.println("Card Number: "+ "**** **** **** "+ cardNumber.substring(cardNumber.length()-4));
        System.out.println("Expiry Date: "+ expiryDate);
    }
    

    

    }
