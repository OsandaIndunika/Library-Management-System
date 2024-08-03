/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.library.dao;

import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public interface CrudDaoReturn<T ,MemberID,BookCode> extends SuperDao{
    
    String save(T t) throws Exception;
    String update(T t)throws Exception;
    T get(MemberID id,BookCode bId)throws Exception;
    ArrayList<T> getAll() throws Exception;
    
}
