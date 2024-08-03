/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.dao.custom.impl;

import edu.ijse.library.dao.CrudUtil;
import edu.ijse.library.dao.custom.ReturnDao;
import edu.ijse.library.entity.ReturnEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class ReturnDaoImpl implements ReturnDao {

    @Override
    public String save(ReturnEntity t) throws Exception {
        boolean isReturnSaved = CrudUtil.executeUpdate("INSERT INTO Returns VALUES(?,?,?,?,?,?)", t.getReturnID(), t.getMemberID(), t.getBookCode(), t.getReturnDate(), t.getFine());
        return isReturnSaved?"Success":"Fail";
    }

    @Override
    public String update(ReturnEntity t) throws Exception {
        return null;
    }

    @Override
    public ReturnEntity get(String id, String bId) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT IssueDate, DueDate, CURRENT_DATE AS ReturnDate, DATEDIFF(CURRENT_DATE, DueDate) AS daysDifference FROM Issue WHERE MemberID=? AND B=?", id,bId);
        if (rst.next()){
            return new ReturnEntity(id,bId,rst.getString("ReturnID"), rst.getString("RETURNDATE"),rst.getInt("daysDifference"), rst.getDouble("Fine"));
        }
        return null;
    }

    @Override
    public ArrayList<ReturnEntity> getAll() throws Exception {
        return null;
    }

    

 
}