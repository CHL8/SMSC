package com.hp.controller.admin;

import com.hp.web.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminsController {
    @Autowired
    private AdminsService adminsService;

}

