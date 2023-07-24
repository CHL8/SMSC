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
}
