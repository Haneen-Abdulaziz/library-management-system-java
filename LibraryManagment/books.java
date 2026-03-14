/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mycompany.library_management_system;


public class books {
    private String Title;
    private String Auther; 
    private String publisher;
    private String isbn;
    private int numOfCopy; 
    private double price;
    
    books(){
        
        this(null,null,null,null,0,0.0);
    }
    
    books(String Title, String Auther, String publisher, String isbn, int numOfCopy, double price){
        this.Title = Title;
        this.Auther = Auther;
        this.publisher = publisher;
        this.isbn = isbn;
        this.numOfCopy = numOfCopy;
        this.price = price;
        
    }
    
    public void display(){
        System.out.print("\nBook title: " + Title + "\n" +
                "Book Auther: " + Auther + "\n" +
                "Book publisher: " + publisher + "\n" +
                "Book ISBN: " + isbn + "\n" +
                "Book Copies: " + numOfCopy +"\n" +
                "Book price: " + price);
    }
    
    public String getTitle(){
        return Title;
    }
    public void setTitle(String Title){
        this.Title = Title;
    }
    public String getAuther(){
        return Auther;
    }
    public void setAuther(String Auther){
        this.Auther = Auther;
    }
    public String getpublisher(){
        return publisher;
    }
    public void setpublisher(String publisher){
        this.publisher = publisher;
    }
    public String getisbn(){
        return isbn;
    }
    public void setisbn(String isbn){
        this.isbn = isbn;
    }
    public double getprice(){
        return price;
    }
    public void setprice(double price){
        this.price = price;
    }
    public int getCopies(){
        return numOfCopy;
    }
    public void setCopies(int numOfCopy){
                if (numOfCopy >= 0) {
            this.numOfCopy = numOfCopy;
        } else {
            System.out.println("Number of copies cannot be negative.");
        }
    }
    public boolean Availability(){
        if (numOfCopy > 0)
            return true;
        else
            return false;
    }
    
   

    public void decrementCopies() {
        if (numOfCopy > 0) {
            numOfCopy--;
        } else {
            System.out.println("No copies available to borrow.");
        }
    }


    
}

