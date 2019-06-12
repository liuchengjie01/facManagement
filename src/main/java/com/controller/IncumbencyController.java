package com.controller;

import com.pojo.Incumbency;
import com.service.IncumbencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Incumbency")
public class IncumbencyController {

    @Autowired
    private IncumbencyService IncumbencyService;

    @RequestMapping("/allIncumbency")
    public String list(Model model) {
        List<Incumbency> list = IncumbencyService.queryAllIncumbency();
        model.addAttribute("list", list);
        return "Incumbency";
    }

    @RequestMapping("toInsertIncumbency")
    public String toInsertIncumbency(){
        return "insertIncumbency";
    }

    @RequestMapping("/insertIncumbency")
    public String insertIncumbency(Incumbency Incumbency) {
        IncumbencyService.insert(Incumbency);
        return "redirect:/Incumbency/allIncumbency";
    }

    @RequestMapping("/del/ei/{employeeId}/depart/{departmentId}/ent/{departmentEtime}")
    public String deleteIncumbencyByID(@PathVariable("employeeId") String  employeeId,@PathVariable("departmentId") String departmentId,@PathVariable("departmentEtime") Date departmentEtime) {
        IncumbencyService.deleteByPrimaryKey(employeeId,departmentId,departmentEtime);
        return "redirect:/Incumbency/allIncumbency";
    }

    @RequestMapping("toUpdateIncumbency/ei/{employeeId}/depart/{departmentId}/ent/{departmentEtime}")
    public String toUpdateIncumbency(Model model, @PathVariable("employeeId") String  employeeId,@PathVariable("departmentId") String departmentId,@PathVariable("departmentEtime") Date departmentEtime) {
        model.addAttribute("Incumbency", IncumbencyService.selectByPrimaryKey(employeeId,departmentId,departmentEtime));
        return "updateIncumbency";
    }

    @RequestMapping("/updateIncumbency")
    public String updateIncumbency(Model model, Incumbency Incumbency) {
        System.out.println(Incumbency.toString());
        IncumbencyService.updateByPrimaryKey(Incumbency);
        Incumbency = IncumbencyService.selectByPrimaryKey(Incumbency. getEmployeeId(),Incumbency. getDepartmentId(),Incumbency. getDepartmentEtime());
        model.addAttribute("Incumbency", Incumbency);
        return "redirect:/Incumbency/allIncumbency";
    }

}
