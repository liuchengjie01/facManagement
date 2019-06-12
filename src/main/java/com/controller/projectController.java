package com.controller;

import com.pojo.project;
import com.service.projectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/project")
public class projectController {

    @Autowired
    private projectService pService;

    @RequestMapping("/allproject")
    public String list(Model model){
        List<project> list = pService.queryAllProject();
        model.addAttribute("list", list);
        return "project";
    }

    @RequestMapping("/searchProject")
    public String search(Model model, project iv){
        List<project> list = pService.queryAllProject();
        Iterator<project> it = list.iterator();
        String attribute = iv.getProject_id();
        if (attribute.equals("")){
            return "redirect:/project/allproject";
        }
        String value = iv.getEmployee_id();
        while (it.hasNext()){
            project i = it.next();
            String a = "";
            switch (attribute){
                case "项目编号":
                    a = i.getProject_id();
                    break;
                case "负责人编号":
                    a = i.getEmployee_id();
                    break;
                case "项目名字":
                    a = i.getProject_name();
                    break;
                case "负责部门":
                    a = i.getDepartment_id();
                    break;
                case "开始时间":
                    a = i.getProject_starttime();
                    break;
                case "项目经费":
                    a = i.getProject_budget();
                    break;
                case "已花费":
                    a = i.getProject_expenditure();
                    break;
                case "out_sourcing":
                    a = i.getOutsourcing();
                    break;
                default:
                    break;
            }
            if(!a.equals(value)) {
                it.remove();
            }
        }
        model.addAttribute("list", list);
        return "project";
    }

    @RequestMapping("toInsertproject")
    public String toInsertproject(){
        System.out.println("test");
        return "insertProject";
    }

    @RequestMapping("/insertproject")
    public String insertproject(project pj) {
        pService.addProject(pj);
        return "redirect:/project/allproject";
    }

    @RequestMapping("/del/{project_id}")
    public String deleteprojectByID(@PathVariable("project_id") String project_id) {
        pService.deleteProjectByID(project_id);
        return "redirect:/project/allproject";
    }

    @RequestMapping("toUpdateproject/{project_id}")
    public String toUpdateproject(Model model,@PathVariable("project_id") String project_id) {
        model.addAttribute("project", pService.queryProjectByID(project_id));
        return "updateProject";
    }

    @RequestMapping("/updatedeproject")
    public String updateProject(Model model, project pj) {
        pService.updateProject(pj);
        pj = pService.queryProjectByID(pj.getProject_id());
        model.addAttribute("project", pj);
        return "redirect:/project/allproject";
    }

}
