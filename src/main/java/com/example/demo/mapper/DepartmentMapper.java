package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Map;


//指定这是一个操作数据库的mapper
@Mapper
@Component
public interface DepartmentMapper {

    @Select("select * from article where id=#{id}")
    public Map<?,?> getDeptById(Integer id);


}
