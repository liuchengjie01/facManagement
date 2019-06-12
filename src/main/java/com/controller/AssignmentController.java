package com.controller;

import com.pojo.Assignment;
import com.service.assignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {

    @Autowired
    private assignmentService aService;

    @RequestMapping("/allAssignment")
    public String list(Model model) {
        List<Assignment> list = aService.queryAllAssignment();
        model.addAttribute("list", list);
        return "assignment";
    }

    @RequestMapping("/searchAssignment")
    public String search(Model model, Assignment iv){
        System.out.println("**********"+iv.toString());
        List<Assignment> list = aService.queryAllAssignment();
        Iterator<Assignment> it = list.iterator();
        String attribute = iv.getTask_id();
        if (attribute.equals("")){
            return "redirect:/assignment/allAssignment";
        }
        String value = iv.getProject_id();
        while (it.hasNext()){
            Assignment i = it.next();
            String a = "";
            System.out.println("attribute is " + attribute);
            switch (attribute){
                case "任务编号":
                    a = i.getTask_id();
                    break;
                case "项目编号":
                    a = i.getProject_id();
                    break;
                case "任务内容":
                    a = i.getTask_content();
                    break;
                case "任务完成度":
                    a = i.getTask_completion();
                    break;
                case "任务EF时间":
                    a = i.getTask_EFTime();
                    break;
                case "任务RF时间":
                    a = i.getTask_RFTime();
                    break;
                case "任务日志":
                    a = i.getTask_log();
                    break;
                default:
                    break;
            }
                if(!a.equals(value)) {
                    it.remove();
                }
        }
        model.addAttribute("list", list);
        return "assignment";
    }

    @RequestMapping("/oneAssignment/{taskID}/{projectID}")
    public String thelist(Model model,@PathVariable("taskID") String taskID, @PathVariable("projectID") String projectID) {
        Assignment assignment = aService.queryAssignmentByID(taskID,projectID);
        model.addAttribute("assignment", assignment);
        return "assignment";
    }
    @RequestMapping("toInsertAssignment")
    public String toInsertAssignment(){
        return "insertAssignment";
    }

    @RequestMapping("/insertAssignment")
    public String insertAssignment(Assignment ag) {
        aService.addAssignment(ag);
        return "redirect:/assignment/allAssignment";
    }

    @RequestMapping("/del/{taskID}/{projectID}")
    public String deleteAssignmentByID(@PathVariable("taskID") String taskID,@PathVariable("projectID") String projectID) {
        aService.deleteAssignmentByID(taskID,projectID);
        return "redirect:/assignment/allAssignment";
    }

    @RequestMapping("toUpdateAssignment/{taskID}/{projectID}")
    public String toUpdateAssignment(Model model,@PathVariable("taskID") String taskID,@PathVariable("projectID") String projectID) {
        model.addAttribute("Assignment", aService.queryAssignmentByID(taskID,projectID));
        return "updateAssignment";
    }

    @RequestMapping("/updateAssignment")
    public String updateAssignment(Model model, Assignment ag) {
        System.out.println(ag.getProject_id());
        System.out.println("**"+ag.getTask_id());
        System.out.println("--"+ag.getTask_content());
        System.out.println("~~"+ag.getTask_log());
        aService.updateAssignment(ag);
        Assignment AG = aService.queryAssignmentByID(ag.getTask_id(),ag.getProject_id());
        model.addAttribute("assignment", AG);
        return "redirect:/assignment/allAssignment";
    }

}
