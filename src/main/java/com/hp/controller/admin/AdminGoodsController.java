package com.hp.controller.admin;

import com.hp.web.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminGoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping("goodList")
    public String goodList(HttpSession session){
        session.setAttribute("view","admin/good_list");
        return "admin/index";
    }
}
