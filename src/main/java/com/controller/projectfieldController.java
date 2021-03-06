package com.controller;


import com.pojo.projectfield;
import com.service.projectfieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/projectfield")
public class projectfieldController {

    @Autowired
    private projectfieldService pfService;

    @RequestMapping("/allprojectfield")
    public String allProjectfield(Model model){
        List<projectfield> list = pfService.queryAllProjectfield();
        System.out.println(list);
        model.addAttribute("list", list);
        return "projectfield";
    }

    @RequestMapping("/searchProjectfield")
    public String search(Model model, projectfield iv){
        List<projectfield> list = pfService.queryAllProjectfield();
        Iterator<projectfield> it = list.iterator();
        String attribute = iv.getProjectfield_id();
        System.out.println("attribute is " + attribute);
        if (attribute.equals("")){
            return "redirect:/projectfield/allprojectfield";
        }
        String value = iv.getProject_id();
        System.out.println("value is "+ value);
        while (it.hasNext()){
            projectfield i = it.next();
            String a = "";
            switch (attribute){
                case "项目编号":
                    a = i.getProject_id();
                    break;
                case "场地编号":
                    a = i.getProjectfield_id();
                    break;
                case "场地具体地点":
                    a = i.getProjectfield_location();
                    break;
                default:
                    break;
            }
            System.out.println("----"+a);
            if(!a.equals(value)) {
                it.remove();
                System.out.println("***************");
            }
        }
        model.addAttribute("list", list);
        return "projectfield";
    }


    @RequestMapping("toInsertprojectfield")
    public String toInsertprojectfield(){
        return "insertProjectField";
    }

    @RequestMapping("/insertprojectfield")
    public String insertprojectfield(projectfield df) {
        pfService.addProjectfield(df);
        return "redirect:/projectfield/allprojectfield";
    }

    @RequestMapping("/del/field/{projectfield_id}/project/{project_id}")
    public String deleteprojectfieldByID(@PathVariable("projectfield_id") String projectfield_id, @PathVariable("project_id") String project_id) {
        pfService.deleteProjectfieldByID(projectfield_id,project_id);
        return "redirect:/projectfield/allprojectfield";
    }

    @RequestMapping("toUpdateprojectfield/field/{projectfield_id}/project/{project_id}")
    public String toUpdateDepartmentfield(Model model,@PathVariable("projectfield_id") String projectfield_id,@PathVariable("project_id") String project_id) {
        model.addAttribute("projectfield", pfService.queryProjectfieldByID(projectfield_id,project_id));
        return "updateProjectfield";
    }

    @RequestMapping("/updatedeprojectfield")
    public String updateprojectfield(Model model, projectfield pf) {
        pfService.updateProjectfield(pf);
        pf = pfService.queryProjectfieldByID(pf.getProjectfield_id(),pf.getProject_id());
        model.addAttribute("departmentfield", pf);
        return "redirect:/projectfield/allprojectfield";
    }


}
