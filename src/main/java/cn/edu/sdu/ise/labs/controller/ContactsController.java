package cn.edu.sdu.ise.labs.controller;

import cn.edu.sdu.ise.labs.dto.ContactsDTO;
import cn.edu.sdu.ise.labs.dto.DepartmentDTO;
import cn.edu.sdu.ise.labs.dto.query.ContactsQueryDTO;
import cn.edu.sdu.ise.labs.dto.query.ContactsQueryDTO0;
import cn.edu.sdu.ise.labs.dto.query.DepartmentQueryDTO;
import cn.edu.sdu.ise.labs.model.Inquiry;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.model.Tongji;
import cn.edu.sdu.ise.labs.service.ContactsService;
import cn.edu.sdu.ise.labs.service.DepartmentService;
import cn.edu.sdu.ise.labs.vo.ContactsProvinceVO;
import cn.edu.sdu.ise.labs.vo.ContactsVO;
import cn.edu.sdu.ise.labs.vo.DepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contacts")
public class ContactsController {
    @Autowired
    private ContactsService contactsService;

    @PostMapping("insert")
    public Integer insert(@RequestBody ContactsDTO contactsDTO) {
        return contactsService.insert(contactsDTO);

    }
    @PostMapping("updateByPrimaryKey")
    public Integer update(@RequestBody ContactsDTO contactsDTO)
    {   return contactsService.update(contactsDTO);

    }
    @PostMapping("deleteByPrimaryKey")
    public boolean delete(@RequestBody int id){
        contactsService.delete(id);
        return true;
    }
    @PostMapping("list")
    public Page<ContactsVO> list(@RequestBody ContactsQueryDTO queryDTO) {
        return contactsService.listByPage(queryDTO);
    }
    @PostMapping("inquiry")
    public Inquiry<ContactsVO> inquiry(@RequestBody ContactsQueryDTO0 queryDTO){
        return contactsService.inquiry(queryDTO);
    }
    @PostMapping("delete")
    public Boolean delete(@RequestBody List<Integer> ids) {
        contactsService.deleteByCodes(ids);
        return true;
    }
    @PostMapping("tongji")
    public Tongji<ContactsProvinceVO>tongji(){
        return contactsService.tongji();
    }
}
