/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.service.custom.impl;

import edu.ijse.library.dao.DaoFactory;
import edu.ijse.library.dao.custom.BookDao;
import edu.ijse.library.dao.custom.IssueDao;
import edu.ijse.library.dao.custom.ReturnDao;
import edu.ijse.library.db.DBConnection;
import edu.ijse.library.dto.ReturnDto;
import edu.ijse.library.entity.BookEntity;
import edu.ijse.library.entity.ReturnEntity;
import edu.ijse.library.service.custom.ReturnService;
import java.sql.Connection;

/**
 *
 * @author osandaindunika
 */
public class ReturnServiceImpl implements ReturnService{
    private ReturnDao returnDao = (ReturnDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.RETURN);
    private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);
    private IssueDao issueDao = (IssueDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ISSUE);
    
    @Override
    public String save(ReturnDto returnDto) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
       
        try {
            connection.setAutoCommit(false);
            ReturnEntity returnEntity=new ReturnEntity(returnDto.getReturnID(), returnDto.getMemberID(), returnDto.getBookCode(), returnDto.getReturnDate(), returnDto.getDateDifference(), returnDto.getFine()); 
            String returnRsp=returnDao.save(returnEntity);
            if (returnRsp.equals("Success")){
                BookEntity bookEntity=bookDao.get(returnDto.getBookCode());
                bookEntity.setQuantity(bookEntity.getQuantity()+1);
                String bookRsp=bookDao.update(bookEntity);
                if (bookRsp.equals("Success")){
                    String issueRsp=issueDao.delete(returnEntity.getMemberID(), returnEntity.getBookCode());
                    if (issueRsp.equals("Success")){
                        connection.commit();
                        return "Return Placed!";   
                    }else{
                        connection.rollback();
                        return "bla bla bla";
                    }
                }else{
                    connection.rollback();
                    return "Book Table Update Error!";  
                } 
            }else{
                connection.rollback();
                return "Return Place Error!";
            }
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            return e.getMessage();
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public ReturnDto get(String memberId, String bookId) throws Exception {
        ReturnEntity returnEntity= returnDao.get(memberId, bookId);
        return getReturnDto(returnEntity);
    }

     private ReturnDto getReturnDto (ReturnEntity entity)throws Exception{
      ReturnDto dto=new ReturnDto(entity.getReturnID(), entity.getMemberID(), entity.getBookCode(), entity.getReturnDate(),entity.getDateDifference(), entity.getFine());
     
      return dto;
        
        
    }
    
    
}
