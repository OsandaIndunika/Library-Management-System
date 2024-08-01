/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.entity;

/**
 *
 * @author osandaindunika
 */
public class BookEntity {
    
    private String bookCode;
    private String categoryId;
    private String bookTitle;
    private String author;
    private String publisher;
    private int quantity;

    /**
     * @return the bookCode
     */
    public String getBookCode() {
        return bookCode;
    }

    /**
     * @param bookCode the bookCode to set
     */
    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the bookTitle
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * @param bookTitle the bookTitle to set
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BookEntity(String bookCode, String categoryId, String bookTitle, String author, String publisher, int quantity) {
        this.bookCode = bookCode;
        this.categoryId = categoryId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    public BookEntity() {
    }

    @Override
    public String toString() {
        return "BookEntity{" + "bookCode=" + bookCode + ", categoryId=" + categoryId + ", bookTitle=" + bookTitle + ", author=" + author + ", publisher=" + publisher + ", quantity=" + quantity + '}';
    }
    
    
}
