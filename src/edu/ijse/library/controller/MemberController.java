/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.controller;

import edu.ijse.library.dto.MemberDto;
import edu.ijse.library.service.ServiceFactory;
import edu.ijse.library.service.custom.MemberService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class MemberController {
    
    private final MemberService memberService = (MemberService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);
    
    public String save(MemberDto memberDto) throws Exception {
        return memberService.save(memberDto);
    }

    public String update(MemberDto memberDto) throws Exception {
        return memberService.update(memberDto);
    }

    public String delete(String memberID) throws Exception {
        return memberService.delete(memberID);
    }

    public ArrayList<MemberDto> getAll() throws Exception {
        return memberService.getAll();
    }

    public MemberDto get(String memberID) throws Exception {
        return memberService.get(memberID);
    }
}
