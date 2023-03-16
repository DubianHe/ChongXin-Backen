package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.Test;

public interface TestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

    Test getByStudentNo(String no);
}