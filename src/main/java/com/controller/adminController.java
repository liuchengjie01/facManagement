package com.controller;


import com.pojo.admin;
import com.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

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
    public String queryByUsername(admin ad, Model model){
        admin testad = aService.queryByUsername(ad.getUsername());
        if(testad.getPassword().equals(ad.getPassword())){
            return "main";
        }
        else{
            model.addAttribute("message","用户名或密码输入错误");
            return "login";
        }
    }


}
