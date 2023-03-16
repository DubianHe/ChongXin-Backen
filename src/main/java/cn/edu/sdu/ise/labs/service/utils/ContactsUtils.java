package cn.edu.sdu.ise.labs.service.utils;

import cn.edu.sdu.ise.labs.dto.ContactsDTO;
import cn.edu.sdu.ise.labs.dto.DepartmentDTO;
import cn.edu.sdu.ise.labs.model.Contacts;
import cn.edu.sdu.ise.labs.model.Department;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.vo.ContactsVO;
import cn.edu.sdu.ise.labs.vo.DepartmentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

public class ContactsUtils {
    /**
     * 规范并校验contactsDTO
     *
     * @param contactsDTO
     */
    public static void validateContacts(ContactsDTO contactsDTO) {
        FormatUtils.trimFieldToNull(contactsDTO);
        Assert.notNull(contactsDTO, "输入数据不能为空");
        Assert.hasText(contactsDTO.getName(), "名字不能为空");
    }

    /**
     * 将实体对象转换为VO对象
     *
     * @param contacts 实体对象
     * @return VO对象
     */
    public static ContactsVO convertToVO(Contacts contacts) {
        ContactsVO contactsVO = new ContactsVO();
        BeanUtils.copyProperties(contacts, contactsVO);
        return contactsVO;
    }
}
