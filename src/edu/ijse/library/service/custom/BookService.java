/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.library.service.custom;

import edu.ijse.library.dto.BookDto;
import edu.ijse.library.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public interface BookService extends SuperService{
    
    public String save(BookDto dto) throws Exception;
    public String update(BookDto dto) throws Exception;
    public String delete(String bookCode) throws Exception;
    public BookDto get(String bookCode) throws Exception;
    public ArrayList<BookDto> getAll() throws Exception;
}
