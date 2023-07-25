package com.hp.web.service.impl;

import com.hp.mapper.TypesMapper;
import com.hp.pojo.Types;
import com.hp.web.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesServiceImpl implements TypesService {
    @Autowired
    private TypesMapper typesMapper;
    @Override
    public List<Types> getAll() {
        return typesMapper.getAll();
    }

    @Override
    public int add(Types types) {
        return typesMapper.add(types);
    }

    @Override
    public int del(Integer id) {
        return typesMapper.del(id);
    }

    @Override
    public Types getById(Integer id) {
        return typesMapper.getById(id);
    }

    @Override
    public int update(Types types) {
        return typesMapper.update(types);
    }
}
