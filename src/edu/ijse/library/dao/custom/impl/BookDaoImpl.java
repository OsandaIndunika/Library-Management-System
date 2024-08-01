/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.dao.custom.impl;

import edu.ijse.library.dao.CrudUtil;
import edu.ijse.library.dao.custom.BookDao;
import edu.ijse.library.entity.BookEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class BookDaoImpl implements BookDao{

    @Override
    public String save(BookEntity entity) throws Exception {
        boolean isSaved = CrudUtil.executeUpdate("INSERT INTO Books VALUES(?,?,?,?,?,?)",
                entity.getBookCode(),entity.getCategoryId(),entity.getBookTitle(),entity.getAuthor(),entity.getPublisher(),entity.getQuantity());
        return isSaved ? "Success" : "Fail";
    }

    @Override
    public String update(BookEntity entity) throws Exception {
        boolean isUpdated = CrudUtil.executeUpdate("UPDATE Books SET CategoryID=?, BookTitle=?, Publisher=?, Author=?, Quantity=? WHERE BookCode=?",
                entity.getCategoryId(),entity.getBookTitle(),entity.getAuthor(),entity.getPublisher(),entity.getQuantity(), entity.getBookCode());
        return isUpdated ? "Success" : "Fail";
    }

    @Override
    public String delete(String id) throws Exception {
        boolean isDeleted = CrudUtil.executeUpdate("DELETE FROM Books WHERE BookCode=?", id);
        return isDeleted ? "Success" : "Fail";
    }

    @Override
    public BookEntity get(String id) throws Exception {
         ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Books WHERE BookCode=?", id);
        if(rst.next()){
            return new BookEntity(rst.getString("BookCode"), rst.getString("CategoryID"), rst.getString("BookTitle"), rst.getString("Publisher"), rst.getString("Author"), rst.getInt("Quantity")); 
        }
        return null;
    }

    @Override
    public ArrayList<BookEntity> getAll() throws Exception {
        ArrayList<BookEntity> bookEntitys = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Books");
        while (rst.next()) {
            BookEntity entity = new BookEntity(rst.getString("BookCode"), rst.getString("CategoryID"), rst.getString("BookTitle"), rst.getString("Publisher"), rst.getString("Author"), rst.getInt("Quantity"));
            bookEntitys.add(entity);
        }
        return bookEntitys;
    }
    
     @Override
    public String delete(String id, String bId) throws Exception {
        return null;
    }
    
}
