/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.dao.custom.impl;

import edu.ijse.library.dao.CrudUtil;
import edu.ijse.library.dao.custom.ReturnDao;
import edu.ijse.library.entity.ReturnEntity;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author osandaindunika
 */
public class ReturnDaoImpl implements ReturnDao {

    @Override
    public String save(ReturnEntity t) throws Exception {
         boolean isIssueSaved = CrudUtil.executeUpdate("INSERT INTO Returns VALUES(?,?,?,?,?)", t.getReturnID(), t.getBookCode(), t.getMemberID(), t.getReturnDate(), t.getFine());
        return isIssueSaved ? "Success" : "Fail";
    }

    @Override
    public String update(ReturnEntity t) throws Exception {
        return null;
    }

    @Override
    public String delete(String id) throws Exception {
        return null;
    }

    @Override
    public String delete(String id, String bId) throws Exception {
        return null;
    }

    @Override
    public ReturnEntity get(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<ReturnEntity> getAll() throws Exception {
        ArrayList<ReturnEntity> entitys = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Returns");
        while (rst.next()) {   
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date returnDate = rst.getDate("RETURNDATE");
            
            ReturnEntity entity = new ReturnEntity(rst.getString("ReturnID"),  rst.getString("MemberID"), rst.getString("BookCode"), returnDate, rst.getDouble("Fine"));
            entitys.add(entity);
        }
        return entitys;
    }

}