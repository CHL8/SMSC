package com.hp.mapper;

import com.hp.pojo.Admins;
import com.hp.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminsMapper {
    Admins login(Admins admins);
}
