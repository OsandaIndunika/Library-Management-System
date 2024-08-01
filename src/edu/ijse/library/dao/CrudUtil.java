/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.dao;


import edu.ijse.library.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author osandaindunika
 */
public class CrudUtil {
    private static PreparedStatement getPreparedStatement(String sql, Object... args) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        
        if(args != null) {
            for(int i = 0; i < args.length; i++) {
                statement.setObject(i+1, args[i]);
            }
        }
        return statement;
    }
    
    public static boolean executeUpdate(String sql, Object... args) throws Exception {
        try {
            return getPreparedStatement(sql, args).executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ResultSet executeQuery(String sql, Object... args) throws Exception {
        return getPreparedStatement(sql, args).executeQuery();
    }
}
