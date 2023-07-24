package com.hp.web.service.impl;

import com.hp.mapper.UsersMapper;
import com.hp.pojo.Users;
import com.hp.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public int reg(Users users) {
        return usersMapper.reg(users);
    }

    @Override
    public Users log(Users users) {
        return usersMapper.log(users);
    }
}
