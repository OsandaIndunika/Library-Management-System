/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.dto;

//import java.util.Date;

import java.util.Date;


/**
 *
 * @author osandaindunika
 */
public class MemberDto {
    
    private String memberID;
    private String memberTitle;
    private String memberName;
    private Date dob;
    private String address;
    private Integer contact;
    private String email;

    public MemberDto(String memberID, String memberTitle, String memberName, Date dob, String address, Integer contact, String email) {
        this.memberID = memberID;
        this.memberTitle = memberTitle;
        this.memberName = memberName;
        this.dob = dob;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public MemberDto() {
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberTitle() {
        return memberTitle;
    }

    public void setMemberTitle(String memberTitle) {
        this.memberTitle = memberTitle;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "MemberDto{" + "memberID=" + memberID + ", memberTitle=" + memberTitle + ", memberName=" + memberName + ", dob=" + dob + ", address=" + address + ", contact=" + contact + ", email=" + email + '}';
    }

    
    
    
    
}
