package com.hp.web.service.impl;

import com.hp.mapper.AdminsMapper;
import com.hp.pojo.Admins;
import com.hp.web.service.AdminsService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminsServiceImpl implements AdminsService {
    @Autowired
    private AdminsMapper adminsMapper;
    @Override
    public Admins login(Admins admins) {
        return adminsMapper.login(admins);
    }
}
