package com.hp.mapper;

import com.hp.pojo.Types;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TypesMapper {
    List<Types> getAll();
    int add(Types types);
    int del(@Param("id") Integer id);

    Types getById(@Param("id") Integer id);
    int update(Types types);
}
