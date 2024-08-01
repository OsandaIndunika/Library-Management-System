/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.controller;

import edu.ijse.library.dto.CategoryDto;
import edu.ijse.library.service.ServiceFactory;
import edu.ijse.library.service.custom.CategoryService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class CategoryController {
    
    private final CategoryService categoryService = (CategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CATEGORY);//javafx ekata enne meka 
    
    public String save(CategoryDto categoryDto) throws Exception {
        return categoryService.save(categoryDto);
    }

    public String update(CategoryDto categoryDto) throws Exception {
        return categoryService.update(categoryDto);
    }

    public String delete(String categoryid) throws Exception {
        return categoryService.delete(categoryid);
    }

    public ArrayList<CategoryDto> getAll() throws Exception {
        return categoryService.getAll();
    }

    public CategoryDto get(String categoryid) throws Exception {
        return categoryService.get(categoryid);
    }
}
