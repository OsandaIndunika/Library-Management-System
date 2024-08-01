/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.dao.custom.impl;

import edu.ijse.library.dao.CrudUtil;
import edu.ijse.library.dao.custom.IssueDao;
import edu.ijse.library.entity.IssueEntity;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author osandaindunika
 */
public class IssueDaoImpl implements IssueDao{

    @Override
    public String save(IssueEntity t) throws Exception {
        boolean isIssueSaved = CrudUtil.executeUpdate("INSERT INTO Issue VALUES(?,?,?,?,?)", t.getIssueId(), t.getMemberId(), t.getBookCode(), t.getIssueDate(), t.getDueDate());
        return isIssueSaved ? "Success" : "Fail";
    }

    @Override
    public String update(IssueEntity t) throws Exception {
        return null;
    }

    @Override
    public String delete(String id) throws Exception {
        return null;
    }

    @Override
    public IssueEntity get(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<IssueEntity> getAll() throws Exception {
        ArrayList<IssueEntity> entitys = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Issue");
        while (rst.next()) {   
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date issueDate = rst.getDate("ISSUEDATE");
            Date returnDate = rst.getDate("RETURNDATE");
            
            IssueEntity entity = new IssueEntity(rst.getString("IssueID"),  rst.getString("MemberID"), rst.getString("BookCode"), issueDate, returnDate);
            entitys.add(entity);
        }
        return entitys;
    }
    
    public  String delete(String id, String bId) throws Exception{
        try {
            boolean isDeleted = CrudUtil.executeUpdate("DELETE FROM Issue WHERE MemberID=? and BOOKID=?", id,bId);
            return isDeleted ? "Success" : "Fail";
        } catch (Exception e) {
            return  e.getMessage();
        }
    }
    
}
