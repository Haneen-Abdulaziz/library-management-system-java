/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_management_system;


public class CashPayment extends Payment {
    private double cashReceived;
    private double change;

    public CashPayment(double amount, double cashReceived) {
        super(amount);
        this.cashReceived = cashReceived;
        this.change = cashReceived - amount; // Calculates change if cash received is more than total price
    }

    public double getCashReceived() {
        return this.cashReceived;
    }

    public double getChange() {
        return this.change;
    }

    public void setCashReceived(double cashReceived) {
        this.cashReceived = cashReceived;
    }

    public void setChange(double change) {
        this.change = change;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing cash payment of $" + getAmount() + " on " + getPaymentDate());
        System.out.println("Cash received: $" + cashReceived);
        System.out.println("Change: $" + change);
    }
}
