package com.controller;

import com.pojo.RecordsOfManagers;
import com.service.RMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/RecordsOfManagers")
public class RMController {

    @Autowired
    private RMService RMService;

    @RequestMapping("/allRecordsOfManagers")
    public String list(Model model) {
        List<RecordsOfManagers> list = RMService.queryAllRecordsOfManagers();
        model.addAttribute("list", list);
        return "RM";
    }
    
    @RequestMapping("toInsertRecordsOfManagers")
    public String toInsertRecordsOfManagers(){
        return "insertRM";
    }

    @RequestMapping("/insertRecordsOfManagers")
    public String insertRecordsOfManagers(RecordsOfManagers RecordsOfManagers) {
        RMService.insert(RecordsOfManagers);
        return "redirect:/RecordsOfManagers/allRecordsOfManagers";
    }

    @RequestMapping("/del/depart/{departmentId}/ei/{employeeId}/t/{te}")
    public String deleteRecordsOfManagersByID(@PathVariable("departmentId") String departmentId,@PathVariable("employeeId") String  employeeId,@PathVariable("te") Date te) {
        RMService.deleteByPrimaryKey(departmentId,employeeId,te);
        return "redirect:/RecordsOfManagers/allRecordsOfManagers";
    }

    @RequestMapping("toUpdateRecordsOfManagers/depart/{departmentId}/ei/{employeeId}/t/{te}")
    public String toUpdateRecordsOfManagers(Model model, @PathVariable("departmentId") String departmentId,@PathVariable("employeeId") String  employeeId,@PathVariable("te") Date te) {
        model.addAttribute("RecordsOfManagers", RMService.selectByPrimaryKey(departmentId,employeeId,te));
        return "updateRM";
    }

    @RequestMapping("/updateRecordsOfManagers")
    public String updateRecordsOfManagers(Model model, RecordsOfManagers RecordsOfManagers) {
        System.out.println(RecordsOfManagers.toString());
        RMService.updateByPrimaryKey(RecordsOfManagers);
        RecordsOfManagers = RMService.selectByPrimaryKey(RecordsOfManagers. getDepartmentId(),RecordsOfManagers. getEmployeeId(),RecordsOfManagers. getTakeofficeDate());
        model.addAttribute("RecordsOfManagers", RecordsOfManagers);
        return "redirect:/RecordsOfManagers/allRecordsOfManagers";
    }


}
