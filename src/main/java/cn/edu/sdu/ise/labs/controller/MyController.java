package cn.edu.sdu.ise.labs.controller;

import cn.edu.sdu.ise.labs.annotation.NeedNoToken;
import cn.edu.sdu.ise.labs.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author 李洪文
 * @date 2021-03-13
 */
@RestController
@RequestMapping("user")
@Slf4j
public class MyController {

    @Autowired
    private TestService testService;

    @NeedNoToken
    @PostMapping("add")
    public String add(String userName, String persId) {
        log.debug("Hello!!!!");
        return testService.add(userName, persId);
    }

}
