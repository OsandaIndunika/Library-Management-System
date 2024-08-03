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
    private final ReturnService service = (ReturnService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RETURN);
    
    public ReturnDto get(String memberID, String bookCode) throws Exception{
        return service.get(memberID,bookCode);
    }
    
    public String Return(ReturnDto dto) throws Exception{
        return service.save(dto);
    }
    
}
