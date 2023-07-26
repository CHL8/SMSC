package com.hp.controller.admin;

import com.hp.pojo.Admins;
import com.hp.utils.SafeUtils;
import com.hp.web.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("admin")
public class AdminsController {
    @Autowired
    private AdminsService adminsService;

    @GetMapping("login")
    public String logins(){
        return "admin/login";
    }
    @GetMapping("redirect/index")
    public String redirectIndex(){
      return "redirect:/admin/typeList";
    }
    @GetMapping("index")
    public String Index(){
        return "redirect:/admin/typeList";
    }
    @PostMapping("login")
    public String login(Admins admins, HttpSession session, Model model, RedirectAttributes ra){
        Admins login = adminsService.login(admins);
        if(login==null){
            model.addAttribute("msg","账号或密码错误！");
            return "admin/login";
        }
        ra.addFlashAttribute("msg","登录成功!");
        session.setAttribute("admin",login);
        return "redirect:/admin/typeList";
    }
    @GetMapping("adminList")
    public String adminList(Model model,HttpSession session){

        session.setAttribute("view","admin/admin_list");
        return "admin/index";
    }
}

