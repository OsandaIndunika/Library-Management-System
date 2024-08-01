/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.library.service.custom;

import edu.ijse.library.dto.MemberDto;
import edu.ijse.library.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public interface MemberService extends SuperService{
    
    public String save(MemberDto dto) throws Exception;
    public String update(MemberDto dto) throws Exception;
    public String delete(String memberID) throws Exception;
    public MemberDto get(String memberID) throws Exception;
    public ArrayList<MemberDto> getAll() throws Exception;
}
