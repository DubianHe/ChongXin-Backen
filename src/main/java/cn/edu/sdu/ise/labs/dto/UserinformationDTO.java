package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

@Data
public class UserinformationDTO {
    private Integer id;
    private String name;

    private Boolean sex;

    private String department;

    private String phone;

    private String email;
}
