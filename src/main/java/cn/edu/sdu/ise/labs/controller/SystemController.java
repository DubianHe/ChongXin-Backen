package cn.edu.sdu.ise.labs.controller;

import cn.edu.sdu.ise.labs.annotation.NeedNoToken;
import cn.edu.sdu.ise.labs.dto.ContactsDTO;
import cn.edu.sdu.ise.labs.dto.UserDTO;
import cn.edu.sdu.ise.labs.model.Token;
import cn.edu.sdu.ise.labs.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李洪文
 * @description 系统控制器，包含登录
 * @date 2019/11/14 10:45
 */
@RestController
@RequestMapping("system")
public class SystemController {
    @Autowired
    private TokenService tokenService;

    @NeedNoToken
    @GetMapping("login")
    public Token login(String userId, String password, String group) {
        return tokenService.login(userId, password);
    }

    @GetMapping("ping")
    public Boolean ping() {
        return true;
    }

    @NeedNoToken
    @PostMapping("insert")
    public Integer insert(@RequestBody UserDTO userDTO) {
        return tokenService.insert(userDTO);

    }
    @PostMapping("update")
    public Integer update(@RequestBody UserDTO userDTO)
    {   return tokenService.update(userDTO);

    }
}
