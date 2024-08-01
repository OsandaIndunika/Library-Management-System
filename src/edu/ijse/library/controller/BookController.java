/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.controller;

import edu.ijse.library.dto.BookDto;
import edu.ijse.library.service.ServiceFactory;
import edu.ijse.library.service.custom.BookService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class BookController {
    
    private final BookService bookService = (BookService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);
    
    public String save(BookDto bookDto) throws Exception {
        return bookService.save(bookDto);
    }

    public String update(BookDto bookDto) throws Exception {
        return bookService.update(bookDto);
    }

    public String delete(String bookCode) throws Exception {
        return bookService.delete(bookCode);
    }

    public ArrayList<BookDto> getAll() throws Exception {
        return bookService.getAll();
    }

    public BookDto get(String bookCode) throws Exception {
        return bookService.get(bookCode);
    }
    
}
