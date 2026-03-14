/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_management_system;

import java.util.List;

public class User {
    String name;
    String id;
    String email;
    String phoneNumber;
    int age; 
    
    
    //constructor
    public User(String name, String id, String email, String phoneNumber,int age) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age=age;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name +
                           "\nID: " + id +
                           "\nEmail: " + email +
                           "\nPhone Number: " + phoneNumber +
                           "\nAge: " + age );
    }
    
    //display most borrowed/bought books method
    public void mostBorrowed_BoughtBooks(List<BoughtBook> boughtBooks) {
    System.out.println("Most Borrowed/Bought Books:");
    for (BoughtBook book : boughtBooks) {
        if (book.getBuyerName() != null && book.getBuyerName().equals(this.name)) {
            System.out.println(book.getTitle());
        }
    }
}

public void availableBooks(List<books> bookList) {
    System.out.println("Available Books:");
    for (books book : bookList) {
        if (book.Availability()) {
            System.out.println(book.getTitle());
        }
    }
}
    

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
     public int getAge() { // New getter for age
        return age;
    }

    public void setAge(int age) { // New setter for age
        this.age = age;
    }


}