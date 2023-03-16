package cn.edu.sdu.ise.labs.service;

import cn.edu.sdu.ise.labs.dto.ContactsDTO;
import cn.edu.sdu.ise.labs.dto.query.ContactsQueryDTO;
import cn.edu.sdu.ise.labs.dto.query.ContactsQueryDTO0;
import cn.edu.sdu.ise.labs.model.Inquiry;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.model.Tongji;
import cn.edu.sdu.ise.labs.vo.ContactsProvinceVO;
import cn.edu.sdu.ise.labs.vo.ContactsVO;

import java.util.List;


public interface ContactsService {
    Integer insert(ContactsDTO contacts);
    Integer update(ContactsDTO contactsDTO);
    void delete(int id);
    Page<ContactsVO> listByPage(ContactsQueryDTO queryDTO);
    Inquiry<ContactsVO> inquiry(ContactsQueryDTO0 queryDTO);
    Tongji<ContactsProvinceVO> tongji();
    void deleteByCodes(List<Integer> ids);
}
