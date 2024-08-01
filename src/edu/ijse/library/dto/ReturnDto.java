/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.dto;

import java.util.Date;

/**
 *
 * @author osandaindunika
 */
public class ReturnDto {
    
    private String returnID;
    private Date returnDate;
    private Double fine;

    public ReturnDto(String returnID, Date returnDate, Double fine) {
        this.returnID = returnID;
        this.returnDate = returnDate;
        this.fine = fine;
    }

    public ReturnDto() {
    }

    public String getReturnID() {
        return returnID;
    }

    public void setReturnID(String returnID) {
        this.returnID = returnID;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "ReturnDto{" + "returnID=" + returnID + ", returnDate=" + returnDate + ", fine=" + fine + '}';
    }

    
    
    
}
