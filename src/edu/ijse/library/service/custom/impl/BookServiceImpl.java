/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.service.custom.impl;

import edu.ijse.library.dao.DaoFactory;
import edu.ijse.library.dao.custom.BookDao;
import edu.ijse.library.dto.BookDto;
import edu.ijse.library.entity.BookEntity;
import edu.ijse.library.service.custom.BookService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class BookServiceImpl implements BookService {
    
   private final BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);

    @Override
    public String save(BookDto dto) throws Exception {
        BookEntity entity = new BookEntity(dto.getBookCode(), dto.getCategoryId(), dto.getBookTitle(), dto.getAuthor(), dto.getPublisher(), dto.getQuantity());
        return bookDao.save(entity);
    }

    @Override
    public String update(BookDto dto) throws Exception {
        BookEntity entity = getBookEntity(dto);
        return bookDao.update(entity);
    }

    @Override
    public String delete(String bookCode) throws Exception {
        return bookDao.delete(bookCode);
    }

    @Override
    public BookDto get(String bookCode) throws Exception {
        BookEntity entity = bookDao.get(bookCode);
        return getBookDto(entity);
    }

    @Override
    public ArrayList<BookDto> getAll() throws Exception {
         ArrayList<BookDto> bookDtos = new ArrayList<>();
        ArrayList<BookEntity> bookEntitys = bookDao.getAll();            

            for (BookEntity bookEntity : bookEntitys) {
            BookDto dto = getBookDto(bookEntity);
            bookDtos.add(dto);    
            }
            return bookDtos;
    }
    
    private BookEntity getBookEntity(BookDto dto){
        BookEntity entity = new BookEntity(dto.getBookCode(), dto.getCategoryId(), dto.getBookTitle(), dto.getAuthor(), dto.getPublisher(), dto.getQuantity());
         return entity;
    }

    private BookDto getBookDto(BookEntity entity){
        BookDto bookDto = new BookDto(entity.getBookCode(), entity.getCategoryId(), entity.getBookTitle(), entity.getAuthor(), entity.getPublisher(),entity.getQuantity());      
        return bookDto;
    }
    
}
