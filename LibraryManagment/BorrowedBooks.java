/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_management_system;

import java.util.Calendar;
import java.util.Date;
public class BorrowedBooks extends books {
    private String borrowerName;
    private Date borrowDate ;
    private Date returnDate;
    
    // Constructer for BorrowBooks
    public BorrowedBooks(String Title,String Auther,String publisher, String isbn, 
            int numOfCopy, String borrowerName, Date borrowDate, Date returnDate){
        super(Title,Auther,publisher,isbn,numOfCopy,0);
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
        Calendar calendar = Calendar.getInstance(); // to now the borrow,retune date
        calendar.setTime(borrowDate);
        calendar.add(Calendar.DAY_OF_MONTH, 15); // setting 15 days as a due date
        this.returnDate = calendar.getTime(); 
            }
    
   
    public String getBorrowerName(){ // getter & setter for borrower name
        return borrowerName;
    }
    public void setBorrowerName(String borrowerName){
        this.borrowerName = borrowerName;
    }
    public Date getBorrowDate() { // getter & setter for borrow date
        return borrowDate;
    } 
    public void setBorrowDate(Date borrowDate){
        this.borrowDate = borrowDate;
    }
    
    public Date getReturnDate() {  // getter & setter for return date
        return returnDate;
    } 
    public void setReturnDate(Date returnDate){
        this.returnDate = returnDate;  
    }
    
    public boolean checkIfAvaliable() {
    if (super.Availability()) {
        System.out.print("The book is available for borrowing");
        return true; 
    } else {
        System.out.print("Sorry, the book is not available");
        return false;
    }
}
    public boolean lateReturn(Date returnDate) { // method to check the return status
        return returnDate.after(returnDate); 
        }
    public void display(){ // displaying book,borrower information
        super.display();
        System.out.println("\n The borrower name is:" + borrowerName);
        System.out.println("The return date is: " + returnDate);
        
        
    }
    
    public double calculateFine(Date returnDate) {
    long diff = returnDate.getTime() - this.returnDate.getTime();
    long daysLate = diff / (1000 * 60 * 60 * 24); // Convert milliseconds to days

    if (daysLate > 0) {
        double fine = 20; // Initial fine
        long weeksLate = daysLate / 7;
        fine += weeksLate * 10; // Additional fine for each week
        return fine;
    }
    return 0; // No fine
}
        
    }
    
  
    
    
    
            
    
      
    

