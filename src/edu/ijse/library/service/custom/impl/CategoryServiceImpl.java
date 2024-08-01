/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.service.custom.impl;

import edu.ijse.library.dao.DaoFactory;
import edu.ijse.library.dao.custom.CategoryDao;
import edu.ijse.library.dto.CategoryDto;
import edu.ijse.library.entity.CategoryEntity;
import edu.ijse.library.service.custom.CategoryService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class CategoryServiceImpl implements CategoryService{

    private final CategoryDao categoryDao = (CategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CATEGORY);


    @Override
    public String save(CategoryDto dto) throws Exception {
        CategoryEntity entity = new CategoryEntity(dto.getCategoryid(), dto.getCategoryname(), dto.getDescription());
        return categoryDao.save(entity);
    }

    @Override
    public String update(CategoryDto dto) throws Exception {
        CategoryEntity entity = getCategoryEntity(dto);
        return categoryDao.update(entity);
    }

    @Override
    public String delete(String categoryid) throws Exception {
        return categoryDao.delete(categoryid);
    }

    @Override
    public CategoryDto get(String categoryid) throws Exception {
        CategoryEntity entity = categoryDao.get(categoryid);
        return getCategoryDto(entity);
    }

    @Override
    public ArrayList<CategoryDto> getAll() throws Exception {
        ArrayList<CategoryDto> categoryDtos = new ArrayList<>();
        ArrayList<CategoryEntity> categoryEntitys = categoryDao.getAll();            

            for (CategoryEntity categoryEntity : categoryEntitys) {
            CategoryDto dto = getCategoryDto(categoryEntity);
            categoryDtos.add(dto);  
            }
            return categoryDtos;
    }
    
    private CategoryEntity getCategoryEntity(CategoryDto dto){
        CategoryEntity entity = new CategoryEntity(dto.getCategoryid(), dto.getCategoryname(), dto.getDescription());
         return entity;
    }

    private CategoryDto getCategoryDto(CategoryEntity entity){
        CategoryDto categoryDto = new CategoryDto(entity.getCategoryid(), entity.getCategoryname(), entity.getDescription());      
        return categoryDto;
    }


}
