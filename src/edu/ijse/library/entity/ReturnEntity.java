/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.entity;

import java.util.Date;

/**
 *
 * @author osandaindunika
 */
public class ReturnEntity {
    
    private String returnID;
    private String memberID;
    private String bookCode;
    private String returnDate;
    private Integer dateDifference;
    private Double fine;

    public ReturnEntity(String returnID, String memberID, String bookCode, String returnDate, Integer dateDifference, Double fine) {
        this.returnID = returnID;
        this.memberID = memberID;
        this.bookCode = bookCode;
        this.returnDate = returnDate;
        this.dateDifference = dateDifference;
        this.fine = fine;
    }

    public ReturnEntity() {
    }

    public String getReturnID() {
        return returnID;
    }

    public void setReturnID(String returnID) {
        this.returnID = returnID;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getDateDifference() {
        return dateDifference;
    }

    public void setDateDifference(Integer dateDifference) {
        this.dateDifference = dateDifference;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "ReturnEntity{" + "returnID=" + returnID + ", memberID=" + memberID + ", bookCode=" + bookCode + ", returnDate=" + returnDate + ", dateDifference=" + dateDifference + ", fine=" + fine + '}';
    }
  
}
