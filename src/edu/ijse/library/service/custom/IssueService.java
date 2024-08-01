/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.library.service.custom;

import edu.ijse.library.dto.IssueDto;
import edu.ijse.library.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public interface IssueService extends SuperService{
    
    String Issue(IssueDto issueDto) throws Exception;
    public ArrayList<IssueDto> getAll() throws Exception;
    
}
