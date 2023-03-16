package cn.edu.sdu.ise.labs.model;

import lombok.Data;

import java.util.List;
@Data
public class Tongji<T>{

    public Tongji(List<T> dtolist)
    {
        this.setList(dtolist);
    }
    private List<T>list;
}
