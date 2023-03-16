package cn.edu.sdu.ise.labs.service;

import cn.edu.sdu.ise.labs.dto.query.DepartmentQueryDTO;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.vo.DepartmentVO;

/**
 * 描述：
 *
 * @author 李洪文
 * @date 2021-03-13
 */
public interface TestService {
    Page<DepartmentVO> listByPage(DepartmentQueryDTO queryDTO);

    String add(String name, String persId);
}
