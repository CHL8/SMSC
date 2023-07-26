package com.hp.controller.admin;

import com.hp.pojo.Types;
import com.hp.utils.HintUtils;
import com.hp.web.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("admin")
public class TypesController {
    @Autowired
    private TypesService typesService;
    @GetMapping("goodAdd")
    public String goodAdd(Model model,HttpSession session){
        session.setAttribute("view","admin/good_add");
        List<Types> typesList = typesService.getAll();
        model.addAttribute("typeList",typesList);
        return "admin/index";
    }
    @GetMapping("typeList")
    public String typeList(Model model, HttpSession session){
        List<Types> typesList = typesService.getAll();
        model.addAttribute("typeList",typesList);
        session.setAttribute("view","admin/type_list");
        return "admin/index";
    }
    @GetMapping("/redirect/type_add")
    public String typeAdd(Model model, HttpSession session){
        session.setAttribute("view","admin/type_add");
        return "admin/index";
    }
    @PostMapping("/redirect/typeSave")
    public String typeSave(Types types, Model model, HttpSession session, RedirectAttributes ra){
        int add = typesService.add(types);
        HintUtils.BackendPrompt(ra,"类目添加",add);
        session.setAttribute("view","admin/type_list");
        return "redirect:/admin/typeList";
    }
    @GetMapping("typeDelete")
    public String typeDelete(@RequestParam("id")Integer id, Model model, HttpSession session,RedirectAttributes ra){
        int del = typesService.del(id);
        HintUtils.BackendPrompt(ra,"类目删除",del);
        session.setAttribute("view","admin/type_list");
        return "redirect:/admin/typeList";
    }
    @GetMapping("typeEdit")
    public String typeEdit(@RequestParam("id")Integer id, Model model, HttpSession session){
        Types byId = typesService.getById(id);
        model.addAttribute("type",byId);
        session.setAttribute("view","admin/type_edit");
        return "admin/index";
    }
    @PostMapping("typeUpdate")
    public String typeUpdate(Types types, Model model, HttpSession session,RedirectAttributes ra){
        int update = typesService.update(types);
        HintUtils.BackendPrompt(ra,"类目修改",update);
        session.setAttribute("view","admin/type_list");
        return "redirect:/admin/typeList";
    }

}
