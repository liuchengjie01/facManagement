package com.controller;

import com.pojo.BuMen;
import com.utils.ID_manag;
import com.service.BuMenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/BuMen")
public class BuMenController {

    @Autowired
    private BuMenService buMenService;

    @RequestMapping("/allBumen")
    public String list(Model model) {
        List<BuMen> list = buMenService.queryAllBuMen();
        model.addAttribute("list", list);
        return "department";
    }

    @RequestMapping("/searchBumen")
    public String search(Model model, BuMen iv){
        System.out.println("**********"+iv.toString());
        List<BuMen> list = buMenService.queryAllBuMen();
        Iterator<BuMen> it = list.iterator();
        String attribute = iv.getDepartmentID();
        if (attribute.equals("")){
            return "redirect:/BuMen/allBumen";
        }
        String value = iv.getDepartmentName();
        while (it.hasNext()){
            BuMen i = it.next();
            String a = "";
            System.out.println("attribute is " + attribute);
            switch (attribute){
                case "部门编号":
                    a = i.getDepartmentID();
                    break;
                case "部门名字":
                    a = i.getDepartmentName();
                    break;
                case "部门经理":
                    a = i.getManagerID();
                    break;
                default:
                    break;
            }
            if(!a.equals(value)) {
                it.remove();
            }
        }
        model.addAttribute("list", list);
        return "department";
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
      buMenService.updateBumen(Bumen);
      Bumen = buMenService.queryByID(Bumen.getDepartmentID());
      model.addAttribute("BuMen", Bumen);
    return "redirect:/BuMen/allBumen";
  }
}
