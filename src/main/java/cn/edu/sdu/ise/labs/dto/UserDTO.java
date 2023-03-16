package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

import java.util.Date;
@Data
public class UserDTO {
    private Integer id;

    private String userCode;

    private String name;

    private Boolean sex;

    private Boolean enabled;

    private String password;

    private String department;

    private String phone;

    private String email;

    private String createdBy;

    private String updatedBy;

}
