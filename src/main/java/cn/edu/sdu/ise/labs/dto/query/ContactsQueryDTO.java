package cn.edu.sdu.ise.labs.dto.query;

import lombok.Data;

@Data
public class ContactsQueryDTO extends PageQueryDTO{

    private String name;

    private String phone;

    private String province;

    private String address;

    private String workplace;

    private String emil;

}
