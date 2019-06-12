package com.controller;


import com.pojo.admin;
import com.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private adminService aService;

    @RequestMapping("tologin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String queryByUsername(admin ad, Model model, HttpServletRequest request){
        admin testad = aService.queryByUsername(ad.getUsername());
        if(testad.toString().isEmpty()){
            System.out.println("!");
            model.addAttribute("message","用户名或密码输入错误");
            return "login";
        }
        else if(testad.getPassword().equals(testad.getPassword())){
            HttpSession session = request.getSession(true);
            System.out.println(testad.getRole());
            session.setAttribute("role",testad.getRole());
            System.out.println(session.getAttribute("role"));
            return "main";
        }
        else{
            model.addAttribute("message","用户名或密码输入错误");
            return "login";
        }
    }


}
