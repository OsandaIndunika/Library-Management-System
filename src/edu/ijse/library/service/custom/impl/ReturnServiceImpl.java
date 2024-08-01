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
import edu.ijse.library.dto.IssueDto;
import edu.ijse.library.dto.ReturnDto;
import edu.ijse.library.entity.BookEntity;
import edu.ijse.library.entity.IssueEntity;
import edu.ijse.library.entity.ReturnEntity;
import edu.ijse.library.service.custom.ReturnService;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class ReturnServiceImpl implements ReturnService{
    private ReturnDao returnDao = (ReturnDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.RETURN);
    private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);

    @Override
    public String Return(ReturnDto returnDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            BookEntity bookCount = bookDao.get(returnDto.getBookCode());
            if (bookCount.getQuantity()>0){
                ReturnEntity returnEntity = new ReturnEntity(returnDto.getReturnID(), returnDto.getBookCode(), returnDto.getMemberID(), returnDto.getReturnDate(), returnDto.getFine());
                String rsp = returnDao.save(returnEntity);
                    if (rsp.equals("Success")){
                        BookEntity bookEntity = bookDao.get(returnDto.getBookCode());
                        bookEntity.setQuantity(bookEntity.getQuantity()+1);
                        String bookRsp = bookDao.update(bookEntity);
                            if (bookRsp.equals("Success")){
                                connection.commit();
                                return "RETURN PLACED";
                            }else{
                                 connection.rollback();
                                    return "Books Database Update ERROR";
                            }
                    }else{
                            connection.rollback();
                            return "Return Save ERROR";
                    }
            }else{
                connection.rollback();
                return "Book NOT AVAILABLE";
            }
                            
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            return e.getMessage();
        }finally{
            connection.setAutoCommit(true);
        }
        
    }

    @Override
    public ArrayList<ReturnDto> getAll() throws Exception {
        ArrayList<ReturnDto> returnDtos = new ArrayList<>();
        ArrayList<ReturnEntity> entitys = returnDao.getAll();
        for (ReturnEntity entity : entitys) {
            ReturnDto dto = getReturnDto(entity);
            returnDtos.add(dto);
        }
        return returnDtos;
    }
    
    public ReturnDto getReturnDto(ReturnEntity entity) throws Exception{
        ReturnDto dto = new ReturnDto(entity.getReturnID(), entity.getBookCode(),entity.getMemberID(),entity.getReturnDate(),entity.getFine());
        return dto;
    }

    
}
