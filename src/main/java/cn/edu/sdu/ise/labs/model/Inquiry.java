package cn.edu.sdu.ise.labs.model;

import lombok.Data;

import java.util.List;
@Data
public class Inquiry <T>{

    public Inquiry(List<T> dtolist)
    {
        this.setList(dtolist);
    }
    private List<T>list;
}
