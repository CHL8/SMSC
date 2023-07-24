package com.hp.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping("/header")
    public String header(HttpSession session){
        Object user = session.getAttribute("user");
        if(user!=null)
            return "index/header-login";
        return "index/header";
    }
}
