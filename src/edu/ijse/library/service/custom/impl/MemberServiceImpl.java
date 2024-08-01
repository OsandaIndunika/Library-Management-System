/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.library.service.custom.impl;

import edu.ijse.library.dao.DaoFactory;
import edu.ijse.library.dao.custom.MemberDao;
import edu.ijse.library.dto.MemberDto;
import edu.ijse.library.entity.MemberEntity;
import edu.ijse.library.service.custom.MemberService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class MemberServiceImpl implements MemberService{

     private final MemberDao memberDao = (MemberDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.MEMBER);
    
    @Override
    public String save(MemberDto dto) throws Exception {
        MemberEntity entity = new MemberEntity(dto.getMemberID(), dto.getMemberTitle(), dto.getMemberName(), dto.getDob(), dto.getAddress(), dto.getContact(), dto.getEmail());
        return memberDao.save(entity);
    }

    @Override
    public String update(MemberDto dto) throws Exception {
        MemberEntity entity = getMemberEntity(dto);
        return memberDao.update(entity);
    }

    @Override
    public String delete(String memberID) throws Exception {
        return memberDao.delete(memberID);
    }

    @Override
    public MemberDto get(String memberID) throws Exception {
        MemberEntity entity = memberDao.get(memberID);
        return getMemberDto(entity);
    }

    @Override
    public ArrayList<MemberDto> getAll() throws Exception {
         ArrayList<MemberDto> memberDtos = new ArrayList<>();
        ArrayList<MemberEntity> memberEntitys = memberDao.getAll();            

            for (MemberEntity memberEntity : memberEntitys) {
            MemberDto dto = getMemberDto(memberEntity);
            memberDtos.add(dto);    
            }
            return memberDtos;
    }
    
     private MemberEntity getMemberEntity(MemberDto dto){
        MemberEntity entity = new MemberEntity(dto.getMemberID(), dto.getMemberTitle(), dto.getMemberName(), dto.getDob(), dto.getAddress(), dto.getContact(), dto.getEmail());
         return entity;
    }

    private MemberDto getMemberDto(MemberEntity entity){
        MemberDto memberDto = new MemberDto(entity.getMemberID(), entity.getMemberTitle(), entity.getMemberName(), entity.getDob(), entity.getAddress(), entity.getContact(), entity.getEmail());      
        return memberDto;
    }
    
    
}
