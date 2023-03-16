package cn.edu.sdu.ise.labs.service.utils;

import cn.edu.sdu.ise.labs.dto.ContactsDTO;
import cn.edu.sdu.ise.labs.dto.UserDTO;
import cn.edu.sdu.ise.labs.model.Contacts;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.vo.ContactsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

public class UserUtils {
    /**
     * 规范并校验contactsDTO
     *
     * @param
     */
    public static void validateContacts(UserDTO userDTO) {
        FormatUtils.trimFieldToNull(userDTO);
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
