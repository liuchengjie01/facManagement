package com.controller;


import com.pojo.BuMen;
import com.pojo.departmentfield;
import com.service.BuMenService;
import com.service.departmentfieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/departmentfield")
public class departmentfieldController {

    @Autowired
    private departmentfieldService dService;
    private BuMenService buMenService;

    @RequestMapping("/alldepartmentfield")
    public String list(Model model) {
        List<departmentfield> list = dService.queryAllDepartmentfield();
        model.addAttribute("list", list);
        return "departmentfield";
    }
    @RequestMapping("/thedepartmentfield/depart/{departmentID}")
    public String thelist(Model model,@PathVariable("departmentID") String departmentID) {
        List<departmentfield> list = dService.queryDepartmentfieldBydID(departmentID);
        model.addAttribute("list", list);
        return "departmentfield";
    }
    @RequestMapping("toInsertdepartmentfield")
    public String toInsertdepartmentfield(){
        return "insertDepartmentField";
    }

    @RequestMapping("/insertdepartmentfield")
    public String insertdepartmentfield(departmentfield df) {
        dService.adddepartmentfield(df);
        return "redirect:/departmentfield/alldepartmentfield";
    }

    @RequestMapping("/del/depart/{departmentID}/field/{departmentfieldID}")
    public String deletedepartmentfieldByID(@PathVariable("departmentID") String departmentID,@PathVariable("departmentfieldID") String departmentfieldID) {
        System.out.println(departmentID);
        System.out.println(departmentfieldID);
        dService.deletedepartmentfieldByID(departmentID,departmentfieldID);
        return "redirect:/departmentfield/alldepartmentfield";
    }

    @RequestMapping("toUpdatedepartmentfield/depart/{departmentID}/field/{departmentfieldID}")
    public String toUpdateDepartmentfield(Model model,@PathVariable("departmentID") String departmentID,@PathVariable("departmentfieldID") String departmentfieldID) {
        model.addAttribute("departmentfield", dService.queryByID(departmentID,departmentfieldID));
        return "updateDepartmentfield";
    }

    @RequestMapping("/updatedepartmentfield")
    public String updateBuMen(Model model, departmentfield df) {
        dService.updatedepartmentfield(df);
        df = dService.queryByID(df.getDepartmentID(),df.getDepartmentfieldID());
        model.addAttribute("departmentfield", df);
        return "redirect:/departmentfield/alldepartmentfield";
    }

}
