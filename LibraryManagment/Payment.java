/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_management_system;

import java.time.LocalDate;

public class Payment {
    private double amount;
    private LocalDate paymentDate;

    // Constructor
    public Payment(double amount) {
        this.amount = amount;
        this.paymentDate = LocalDate.now();
    }

    // Getters
    public double getAmount() {
        return this.amount;
    }

    public LocalDate getPaymentDate() {
        return this.paymentDate;
    }

    // Setters
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    // General message that applies to all payments
    public void processPayment() {
        System.out.println("Processing a payment of $" + amount + "  on  " + paymentDate);
        // Add logic for handling payment confirmation, etc.
    }
}
