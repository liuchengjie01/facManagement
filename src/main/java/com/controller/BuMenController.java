package com.controller;

import com.pojo.BuMen;
import com.utils.ID_manag;
import com.service.BuMenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/BuMen")
public class BuMenController {

    @Autowired
    private BuMenService buMenService;
    private ID_manag idm = new ID_manag();

    @RequestMapping("/allBumen")
    public String list(Model model) {
        List<BuMen> list = buMenService.queryAllBuMen();
        model.addAttribute("list", list);
        return "department";
    }

    @RequestMapping("toInsertBumen")
    public String toInsertBumen(){
        return "insertBumen";
    }

    @RequestMapping("/insertBumen")
    public String insertBumen(BuMen buMen) {
        System.out.println(buMen.toString());
        buMenService.addBumen(buMen);
        return "redirect:/BuMen/allBumen";
    }

}
