/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.dao.custom.impl;

import edu.ijse.library.dao.CrudUtil;
import edu.ijse.library.dao.custom.MemberDao;
import edu.ijse.library.entity.MemberEntity;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class MemberDaoImpl implements MemberDao{

    @Override
    public String save(MemberEntity entity) throws Exception {
        boolean isSaved = CrudUtil.executeUpdate("INSERT INTO Members VALUES(?,?,?,?,?,?,?)",
                entity.getMemberID(), entity.getMemberTitle(), entity.getMemberName(), entity.getDob(), entity.getAddress(), entity.getContact(), entity.getEmail());
        return isSaved ? "Success" : "Fail";
    }

    @Override
    public String update(MemberEntity entity) throws Exception {
        boolean isUpdated = CrudUtil.executeUpdate("UPDATE Members SET  MemberTitle=?, MemberName=?, DOB=?, Address=?, Contact=?, Email=? WHERE MemberID=?",
                entity.getMemberTitle(), entity.getMemberName(), entity.getDob(), entity.getAddress(), entity.getContact(), entity.getEmail(), entity.getMemberID());
        return isUpdated ? "Success" : "Fail";
    }

    @Override
    public String delete(String id) throws Exception {
        boolean isDeleted = CrudUtil.executeUpdate("DELETE FROM Members WHERE MemberID=?", id);
        return isDeleted ? "Success" : "Fail";
    }

    @Override
    public MemberEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Members WHERE MemberID=?", id);
        if(rst.next()){
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dob = rst.getDate("DOB");
            return new MemberEntity(rst.getString("MemberID"), rst.getString("MemberTitle"), rst.getString("MemberName"), dob, rst.getString("Address"), rst.getInt("Contact"), rst.getString("Email")); 
        }
        return null;
    }

    @Override
    public ArrayList<MemberEntity> getAll() throws Exception {
        ArrayList<MemberEntity> memberEntitys = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Members");
        while (rst.next()) {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dob = rst.getDate("DOB");
            MemberEntity entity = new MemberEntity(rst.getString("MemberID"), rst.getString("MemberTitle"), rst.getString("MemberName"), dob, rst.getString("Address"), rst.getInt("Contact"), rst.getString("Email"));
            memberEntitys.add(entity);
        }
        return memberEntitys;
    }
    
     @Override
    public String delete(String id, String bId) throws Exception {
        return null;
    }
    
}
