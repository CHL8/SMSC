package com.hp.controller.admin;

import com.hp.pojo.Types;
import com.hp.web.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class TypesController {
    @Autowired
    private TypesService typesService;

    @GetMapping("typeList")
    public String typeList(Model model){
        List<Types> typesList = typesService.getAll();
        model.addAttribute("typeList",typesList);
        return "admin/index";
    }
}
