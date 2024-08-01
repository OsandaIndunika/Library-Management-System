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
public class IssueDto {
    private String issueId;
    private String bookCode;
    private String memberId;
    private Date issueDate;
    private Date dueDate;

    public IssueDto(String issueId, String bookCode, String memberId, Date issueDate, Date dueDate) {
        this.issueId = issueId;
        this.bookCode = bookCode;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public IssueDto() {
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "IssueDto{" + "issueId=" + issueId + ", bookCode=" + bookCode + ", memberId=" + memberId + ", issueDate=" + issueDate + ", dueDate=" + dueDate + '}';
    }

    
    
    
    
}
