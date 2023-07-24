package com.hp.mapper;

import com.hp.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UsersMapper {
    int reg(Users users);
    Users log(Users users);
}
