/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.library.service.custom;

import edu.ijse.library.dto.CategoryDto;
import edu.ijse.library.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public interface CategoryService extends SuperService {
    
    public String save(CategoryDto dto) throws Exception;
    public String update(CategoryDto dto) throws Exception;
    public String delete(String categoryid) throws Exception;
    public CategoryDto get(String categoryid) throws Exception;
    public ArrayList<CategoryDto> getAll() throws Exception;
    
}
