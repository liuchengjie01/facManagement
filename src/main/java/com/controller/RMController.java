package com.controller;

import com.pojo.RecordsOfManagers;
import com.service.RMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Iterator;
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

    @RequestMapping("/searchRecordsOfManagers")
    public String search(Model model, RecordsOfManagers iv){
        System.out.println("**********"+iv.toString());
        List<RecordsOfManagers> list = RMService.queryAllRecordsOfManagers();
        Iterator<RecordsOfManagers> it = list.iterator();
        String attribute = iv.getDepartmentId();
        if (attribute.equals("")){
            return "redirect:/RecordsOfManagers/allRecordsOfManagers";
        }
        String value = iv.getEmployeeId();
        while (it.hasNext()){
            RecordsOfManagers i = it.next();
            String a = "";
            Date d = null;
            switch (attribute){
                case "部门编号":
                    a = i.getDepartmentId();
                    break;
                case "员工号":
                    a = i.getEmployeeId();
                    break;
                case "上任时间":
                    d = i.getTakeofficeDate();
                    break;
                case "是否为代理经理":
                    a = i.getAgentManager();
                    break;
                default:
                    break;
            }
            if (!a.equals("")){
                if(!a.equals(value)) {
                    it.remove();
                }
            } else if (!d.equals(null)){ //尚待修正
                if (!d.equals(value)){
                    it.remove();
                }
            }
        }
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
