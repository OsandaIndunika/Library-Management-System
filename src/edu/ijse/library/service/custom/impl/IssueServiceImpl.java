/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.service.custom.impl;

import edu.ijse.library.dao.DaoFactory;
import edu.ijse.library.dao.custom.BookDao;
import edu.ijse.library.dao.custom.IssueDao;
import edu.ijse.library.db.DBConnection;
import edu.ijse.library.dto.IssueDto;
import edu.ijse.library.entity.BookEntity;
import edu.ijse.library.entity.IssueEntity;
import edu.ijse.library.service.custom.IssueService;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class IssueServiceImpl implements IssueService{
    private final BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);
    private final IssueDao issueDao = (IssueDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ISSUE);

    @Override
    public String Issue(IssueDto dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            BookEntity bookCount = bookDao.get(dto.getBookCode());
            if (bookCount.getQuantity()>0){
                IssueEntity issueEntity = new IssueEntity(dto.getIssueId(),dto.getBookCode(),dto.getMemberId(),dto.getIssueDate(),dto.getDueDate());
                String rsp = issueDao.save(issueEntity);
                    if (rsp.equals("Success")){
                        BookEntity bookEntity = bookDao.get(dto.getBookCode());
                        bookEntity.setQuantity(bookEntity.getQuantity()-1);
                        String bookRsp = bookDao.update(bookEntity);
                            if (bookRsp.equals("Success")){
                                connection.commit();
                                return "ISSUE PLACED";
                            }else{
                                 connection.rollback();
                                    return "Books Database Update ERROR";
                            }
                    }else{
                            connection.rollback();
                            return "Issue Save ERROR";
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
    public ArrayList<IssueDto> getAll() throws Exception {
        ArrayList<IssueDto> issueDtos = new ArrayList<>();
        ArrayList<IssueEntity> entitys = issueDao.getAll();
        for (IssueEntity entity : entitys) {
            IssueDto dto = getIssueDto(entity);
            issueDtos.add(dto);
        }
        return issueDtos;
    }
    
    public IssueDto getIssueDto(IssueEntity entity) throws Exception{
        IssueDto dto = new IssueDto(entity.getIssueId(),entity.getBookCode(),entity.getMemberId(),entity.getIssueDate(),entity.getDueDate());
        return dto;
    }
}
