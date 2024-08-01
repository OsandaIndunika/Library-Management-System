/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.controller;

import edu.ijse.library.dto.IssueDto;
import edu.ijse.library.service.ServiceFactory;
import edu.ijse.library.service.custom.IssueService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class IssueController {
    
    private IssueService issueService = (IssueService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ISSUE);
    
    
    public String Issue(IssueDto issueDto) throws Exception{
        return issueService.Issue(issueDto);
    }
    
    public ArrayList<IssueDto> getAll() throws Exception{
        return issueService.getAll();
    }
}
