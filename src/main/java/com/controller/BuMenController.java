package com.controller;

import com.pojo.BuMen;
import com.utils.ID_manag;
import com.service.BuMenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/BuMen")
public class BuMenController {

    @Autowired
    private BuMenService buMenService;

    @RequestMapping("/allBumen")
    public String list(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String role = (String)session.getAttribute("role");
        System.out.println(role);
        if(role.equals("0")){
            model.addAttribute("message","对不起，您没有权限！");
            return "main";
        }
        else{
            List<BuMen> list = buMenService.queryAllBuMen();
            model.addAttribute("list", list);
            return "department";
        }
    }

    @RequestMapping("toInsertBumen")
    public String toInsertBumen(){
        return "insertDepartment";
    }

    @RequestMapping("/insertBumen")
    public String insertBumen(BuMen buMen) {
        buMenService.addBumen(buMen);
        return "redirect:/BuMen/allBumen";
    }

  @RequestMapping("/del/{departmentID}")
  public String deleteBumenByID(@PathVariable("departmentID") String departmentID) {
    buMenService.deleteBumenByID(departmentID);
    return "redirect:/BuMen/allBumen";
  }

  @RequestMapping("toUpdateBuMen/{departmentID}")
  public String toUpdateBuMen(Model model, @PathVariable("departmentID") String departmentID) {
      model.addAttribute("Bumen", buMenService.queryByID(departmentID));
    return "updateDepartment";
  }

  @RequestMapping("/updateBuMen")
  public String updateBuMen(Model model, BuMen Bumen) {
      System.out.println(Bumen.toString());
      buMenService.updateBumen(Bumen);
      Bumen = buMenService.queryByID(Bumen.getDepartmentID());
      model.addAttribute("BuMen", Bumen);
    return "redirect:/BuMen/allBumen";
  }
}
