package com.hp.web.service;

import com.hp.pojo.Admins;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

public interface AdminsService {
    Admins login(Admins admins);
}
