package com.hp.controller.admin;

import com.hp.pojo.Types;
import com.hp.web.service.GoodsService;
import com.hp.web.service.TypesService;
import com.hp.web.service.impl.TypesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminGoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TypesService typesService;

    @GetMapping("goodEdit")
    public String goodEdit(Model model,HttpSession session){

        List<Types> typesList = typesService.getAll();
        model.addAttribute("typeList",typesList);
        session.setAttribute("view","admin/good_edit");
        return "admin/index";
    }
    @GetMapping("goodList")
    public String goodList(HttpSession session, HttpServletRequest request, Model model){
        String page = request.getParameter("page");
        Map<String, Object> map=null;
        if(page==null || page=="")
            map = goodsService.getAll(1);
        else
            map = goodsService.getAll(Integer.valueOf(page));
        model.addAttribute("map",map);
        session.setAttribute("view","admin/good_list");
        return "admin/index";
    }
}
