package com.hp.web.service;

import com.hp.pojo.Types;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypesService {
    List<Types> getAll();
    int add(Types types);
    int del(Integer id);
    Types getById(Integer id);
    int update(Types types);
}
