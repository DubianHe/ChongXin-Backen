package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.dto.query.ContactsQueryDTO;
import cn.edu.sdu.ise.labs.dto.query.ContactsQueryDTO0;
import cn.edu.sdu.ise.labs.dto.query.DepartmentQueryDTO;
import cn.edu.sdu.ise.labs.model.Contacts;
import cn.edu.sdu.ise.labs.model.ContactsProvince;
import cn.edu.sdu.ise.labs.model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contacts record);

    int insertSelective(Contacts record);

    Contacts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contacts record);

    int updateByPrimaryKey(Contacts record);

    Integer count(ContactsQueryDTO queryDTO);

    List<Contacts> list(@Param("queryDTO") ContactsQueryDTO queryDTO, @Param("offset") Integer offset, @Param("limit") Integer limit
    );
    List<Contacts> listByCodes(
            @Param("codeList") List<String> codeList,
            @Param("tenantCode") String tenantCode);
    List<Contacts> listByName(
            @Param("name") String departmentName,
            @Param("tenantCode") String tenantCode);
    List<Contacts> inquiry(@Param("queryDTO") ContactsQueryDTO0 queryDTO);
    List<ContactsProvince> tongji();
    void deleteByCodes(@Param("codeList") List<Integer> codeList);
}