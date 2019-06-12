package com.controller;

import com.pojo.Involve;
import com.service.involveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/involve")
public class InvolveController {

    @Autowired
    private involveService iService;

    @RequestMapping("/allinvolve")
    public String list(Model model){
        List<Involve> list = iService.queryAllInvolve();
        model.addAttribute("list", list);
        return "involve";
    }

    @RequestMapping("/searchInvolve")
    public String search(Model model, Involve iv){
        System.out.println("**********"+iv.toString());
        List<Involve> list = iService.queryAllInvolve();
        Iterator<Involve> it = list.iterator();
        String attribute = iv.getEmployee_id();
        if (attribute.equals("")){
            return "redirect:/involve/allinvolve";
        }
        String value = iv.getProject_id();
        while (it.hasNext()){
            Involve i = it.next();
            String a = "";
            int b = 0;
            System.out.println("attribute is " + attribute);
            switch (attribute){
                case "雇员编号":
                    a = i.getEmployee_id();
                    break;
                case "项目编号":
                    a = i.getProject_id();
                    break;
                case "开始日期":
                    a = i.getWeek_startdate();
                    break;
                case "工作时间":
                    b = i.getWeek_workhour();
                    break;
                default:
                    break;
            }
            if(a.equals("")){
                if(!String.valueOf(b).equals(value)) {
                    it.remove();
                }
            } else if (b==0){
                if (!a.equals(value)){
                    it.remove();
                }
            }
        }
        model.addAttribute("list", list);
        return "involve";
    }

    @RequestMapping("toInsertinvolve")
    public String toInsertInvolve(){
        System.out.println("test");
        return "insertInvolve";
    }

    @RequestMapping("/insertinvolve")
    public String insertInvolve(Involve Iv) {
        System.out.println("-----"+Iv);
        iService.addInvolve(Iv);
        return "redirect:/involve/allinvolve";
    }

    @RequestMapping("/del/{employee_id}/{project_id}/{week_startdate}")
    public String deleteInvolveByID(@PathVariable("employee_id") String employee_id,@PathVariable("project_id") String project_id,@PathVariable("week_startdate") String week_startdate) {
        iService.deleteInvolveByID(employee_id,project_id,week_startdate);
        return "redirect:/involve/allinvolve";
    }

    @RequestMapping("toUpdateInvolve/{employee_id}/{project_id}/{week_startdate}")
    public String toUpdateInvolve(Model model,@PathVariable("employee_id") String employee_id,@PathVariable("project_id") String project_id,@PathVariable("week_startdate") String week_startdate) {
        model.addAttribute("involve", iService.queryInvolveByID(employee_id,project_id,week_startdate));
        return "updateInvolve";
    }

    @RequestMapping("/updateinvolve")
    public String updateInvolve(Model model, Involve iv) {
        iService.updateInvolve(iv);
        System.out.println("======="+iv.getEmployee_id()+"======="+iv.getProject_id());
        Involve IV = iService.queryInvolveByID(iv.getEmployee_id(),iv.getProject_id(),iv.getWeek_startdate());
        model.addAttribute("involve", IV);
        return "redirect:/involve/allinvolve";
    }

//    @RequestMapping("/searchInvolve")
//    public String showInvolve(Model model, Involve iv) {
//        iService
//    }

}
