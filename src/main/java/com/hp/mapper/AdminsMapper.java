package com.hp.mapper;

import com.hp.pojo.Admins;
import com.hp.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminsMapper {
    Admins login(Admins admins);

    List<Admins> getAll();
}
