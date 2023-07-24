package com.hp.controller.index;


import com.hp.pojo.Users;
import com.hp.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("index")
public class IndexUsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("reg")
    public String reg(Users users) {
        int reg = usersService.reg(users);
        if (reg == 0)
            return "index/register";
        return "index/login";
    }

    @PostMapping("log")
    public String log(Users users, Model model, HttpSession session) {
        Users log = usersService.log(users);
        if(log==null){
            model.addAttribute("msg","账号或密码错误！");
            return "index/login";
        }
        session.setAttribute("user",log);
        return "index/index";
    }

    @GetMapping("logout")
    public String logout(Users users, HttpSession session) {
        session.removeAttribute("user");
        return "index/index";
    }

}
