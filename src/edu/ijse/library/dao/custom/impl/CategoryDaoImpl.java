/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.dao.custom.impl;

import edu.ijse.library.dao.CrudUtil;
import edu.ijse.library.dao.custom.CategoryDao;
import edu.ijse.library.entity.CategoryEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class CategoryDaoImpl implements CategoryDao {
    
    @Override
    public String save(CategoryEntity entity) throws Exception {
        boolean isSaved = CrudUtil.executeUpdate("INSERT INTO BookCategory VALUES(?,?,?)", entity.getCategoryid(),entity.getCategoryname(),entity.getDescription());
        return isSaved ? "Success" : "Fail";
    }

    @Override
    public String update(CategoryEntity entity) throws Exception {
        boolean isUpdated = CrudUtil.executeUpdate("UPDATE BookCategory SET Categoryname=?, Description=? WHERE CategoryID =?", entity.getCategoryname(),entity.getDescription(),entity.getCategoryid());
        return isUpdated ? "Success" : "Fail";
    }

    @Override
    public String delete(String id) throws Exception {
        boolean isDeleted = CrudUtil.executeUpdate("DELETE FROM BookCategory WHERE CategoryID =?", id);
        return isDeleted ? "Success" : "Fail";
    }

    @Override
    public CategoryEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM BookCategory WHERE CategoryID =?", id);
        if(rst.next()){
            return new CategoryEntity(rst.getString("CategoryID"), rst.getString("Categoryname"), rst.getString("Description"));  
        }
        return null;
    }

    @Override
    public ArrayList<CategoryEntity> getAll() throws Exception {
        ArrayList<CategoryEntity> categoryEntitys = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM BookCategory");
        while (rst.next()) {
            CategoryEntity entity = new CategoryEntity(rst.getString("CategoryID"), rst.getString("CategoryName"), rst.getString("Description"));
            categoryEntitys.add(entity);
        }
        return categoryEntitys;
    }
    
     @Override
    public String delete(String id, String bId) throws Exception {
        return null;
    }

}
