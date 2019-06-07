package com.controller;

import com.pojo.project;
import com.service.projectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("departmentfield", pj);
        return "redirect:/project/allproject";
    }

}
