/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.controller;

import edu.ijse.library.dto.ReturnDto;
import edu.ijse.library.service.ServiceFactory;
import edu.ijse.library.service.custom.ReturnService;
import java.util.List;


/**
 *
 * @author osandaindunika
 */
public class ReturnController {
    private ReturnService service = (ReturnService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RETURN);
    
    public String Return(ReturnDto dto) throws Exception{
        return service.Return(dto);
    }
    
    public List<ReturnDto> getAllReturns() throws Exception {
        return service.getAll();
    }
}
