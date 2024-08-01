/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.library.service.custom;

import edu.ijse.library.dto.ReturnDto;
import edu.ijse.library.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public interface ReturnService extends SuperService{
    
    public String Return(ReturnDto returnDto) throws Exception;
    public ArrayList<ReturnDto> getAll() throws Exception;
    
}
