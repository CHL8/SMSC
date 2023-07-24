package com.hp.mapper;

import com.hp.pojo.Types;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypesMapper {
    List<Types> getAll();
}
