package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.dao.ContactsMapper;
import cn.edu.sdu.ise.labs.dto.ContactsDTO;
import cn.edu.sdu.ise.labs.dto.query.ContactsQueryDTO;
import cn.edu.sdu.ise.labs.dto.query.ContactsQueryDTO0;
import cn.edu.sdu.ise.labs.model.*;
import cn.edu.sdu.ise.labs.service.ContactsService;
import cn.edu.sdu.ise.labs.service.utils.ContactsUtils;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.utils.PageUtils;
import cn.edu.sdu.ise.labs.utils.TokenContextHolder;
import cn.edu.sdu.ise.labs.vo.ContactsProvinceVO;
import cn.edu.sdu.ise.labs.vo.ContactsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    private ContactsMapper contactsMapper;
    @Override
    public Integer insert(ContactsDTO contactsDTO) {
        // 校验输入数据正确性
        ContactsUtils.validateContacts(contactsDTO);
        // 创建实体对象，用以保存到数据库
        Contacts contacts=new Contacts();
        // 将输入的字段全部复制到实体对象中
        BeanUtils.copyProperties(contactsDTO,contacts);
        // 调用DAO方法保存到数据库表
        contactsMapper.insert(contacts);
        return contacts.getId();
    }

    @Override
    public Integer update(ContactsDTO contactsDTO) {
        Token token = TokenContextHolder.getToken();
        ContactsUtils.validateContacts(contactsDTO);
        Assert.notNull(contactsDTO, "id不能为空");
        Contacts contacts = contactsMapper.selectByPrimaryKey(contactsDTO.getId());
        Assert.notNull(contacts, "没有找到联系人，Id为：" + contactsDTO.getId());
        BeanUtils.copyProperties(contactsDTO, contacts);
        contactsMapper.updateByPrimaryKey(contacts);
        return contacts.getId();
    }

    @Override
    public void delete(int id) {

        contactsMapper.deleteByPrimaryKey(id);
    }
    @Override
    public Page<ContactsVO> listByPage(ContactsQueryDTO queryDTO) {
        if (queryDTO == null) {
            queryDTO = new ContactsQueryDTO();
        }

        queryDTO.setName(FormatUtils.makeFuzzySearchTerm(queryDTO.getName()));
        queryDTO.setPhone(FormatUtils.makeFuzzySearchTerm(queryDTO.getPhone()));
        queryDTO.setAddress(FormatUtils.makeFuzzySearchTerm(queryDTO.getAddress()));
        queryDTO.setWorkplace(FormatUtils.makeFuzzySearchTerm(queryDTO.getWorkplace()));
        queryDTO.setEmil(FormatUtils.makeFuzzySearchTerm(queryDTO.getEmil()));
        queryDTO.setProvince(FormatUtils.makeFuzzySearchTerm(queryDTO.getProvince()));
        Inquiry<ContactsVO> data=new Inquiry<>(new ArrayList<>());
        Token token = TokenContextHolder.getToken();
        Integer size = contactsMapper.count(queryDTO);
        PageUtils pageUtils = new PageUtils(queryDTO.getPage(), queryDTO.getPageSize(), size);
        Page<ContactsVO> pageData = new Page<>(pageUtils.getPage(), pageUtils.getPageSize(), pageUtils.getTotal(), new ArrayList<>());
        if (size == 0) {
            // 没有命中，则返回空数据。
            return pageData;
        }

        List<Contacts> list = contactsMapper.list(queryDTO, pageUtils.getOffset(), pageUtils.getLimit());
        for (Contacts contacts : list) {
            pageData.getList().add(ContactsUtils.convertToVO(contacts));

        }

        return pageData;
    }

    @Override
    public Inquiry<ContactsVO> inquiry(ContactsQueryDTO0 queryDTO) {
        if (queryDTO == null) {
            queryDTO = new ContactsQueryDTO0();
        }
        queryDTO.setName(FormatUtils.makeFuzzySearchTerm(queryDTO.getName()));
        queryDTO.setPhone(FormatUtils.makeFuzzySearchTerm(queryDTO.getPhone()));
        queryDTO.setAddress(FormatUtils.makeFuzzySearchTerm(queryDTO.getAddress()));
        queryDTO.setWorkplace(FormatUtils.makeFuzzySearchTerm(queryDTO.getWorkplace()));
        queryDTO.setEmil(FormatUtils.makeFuzzySearchTerm(queryDTO.getEmil()));
        queryDTO.setProvince(FormatUtils.makeFuzzySearchTerm(queryDTO.getProvince()));
        Inquiry<ContactsVO> data=new Inquiry<>(new ArrayList<>());
        List<Contacts> list=contactsMapper.inquiry(queryDTO);
        for(Contacts contacts:list){
            data.getList().add(ContactsUtils.convertToVO(contacts));
        }
        return data;
    }
    public void deleteByCodes(List<Integer> ids) {
        Assert.notEmpty(ids, "id不能为空");
        contactsMapper.deleteByCodes(ids);
    }
    @Override
    public Tongji<ContactsProvinceVO> tongji(){
        Tongji<ContactsProvinceVO> data=new Tongji<>(new ArrayList<>());
        List<ContactsProvince> list=contactsMapper.tongji();
        for (ContactsProvince contactsProvince:list){
            ContactsProvinceVO contactsProvinceVO = new ContactsProvinceVO();
            BeanUtils.copyProperties(contactsProvince, contactsProvinceVO);
            data.getList().add(contactsProvinceVO);
        }
        return data;
    }
}
