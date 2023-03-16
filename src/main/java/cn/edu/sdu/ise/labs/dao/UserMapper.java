package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.Contacts;
import cn.edu.sdu.ise.labs.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int update(User record);

    User login(String userCode, String password);
}