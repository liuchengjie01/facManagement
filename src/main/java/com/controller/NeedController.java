package com.controller;

import com.pojo.Need;
import com.service.NeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/Need")
public class NeedController {

    @Autowired
    private NeedService NeedService;

    @RequestMapping("/allNeed")
    public String list(Model model) {
        List<Need> list = NeedService.queryAllNeed();
        model.addAttribute("list", list);
        return "Need";
    }

    @RequestMapping("/searchNeed")
    public String search(Model model, Need iv){
        List<Need> list = NeedService.queryAllNeed();
        Iterator<Need> it = list.iterator();
        String attribute = iv.getProjectId();
        if (attribute.equals("")){
            return "redirect:/Need/allNeed";
        }
        String value = iv.getMaterialId();
        while (it.hasNext()){
            Need i = it.next();
            String a = "";
            System.out.println("attribute is " + attribute);
            switch (attribute){
                case "项目编号":
                    a = i.getProjectId();
                    break;
                case "材料编号":
                    a = i.getMaterialId();
                    break;
                case "需求量":
                    a = i.getMaterialDemand();
                    break;
                case "供应量":
                    a = i.getMaterialSupply();
                    break;
                case "差额":
                    a = i.getMaterialBalance();
                    break;
                default:
                    break;
            }
            if(!a.equals(value)) {
                it.remove();
            }
        }
        model.addAttribute("list", list);
        return "Need";
    }

    @RequestMapping("toInsertNeed")
    public String toInsertNeed(){
        return "insertNeed";
    }

    @RequestMapping("/insertNeed")
    public String insertNeed(Need Need) {
        NeedService.insert(Need);
        return "redirect:/Need/allNeed";
    }

    @RequestMapping("/del/pi/{projectId}/mi/{materialId}")
    public String deleteNeedByID(@PathVariable("projectId") String  projectId,@PathVariable("materialId") String materialId) {
        NeedService.deleteByPrimaryKey(projectId,materialId);
        return "redirect:/Need/allNeed";
    }

    @RequestMapping("toUpdateNeed/pi/{projectId}/mi/{materialId}")
    public String toUpdateNeed(Model model,@PathVariable("projectId") String  projectId,@PathVariable("materialId") String materialId) {
        model.addAttribute("Need", NeedService.selectByPrimaryKey(projectId,materialId));
        return "updateNeed";
    }

    @RequestMapping("/updateNeed")
    public String updateNeed(Model model, Need Need) {
        System.out.println(Need.toString());
        NeedService.updateByPrimaryKey(Need);
        Need = NeedService.selectByPrimaryKey(Need. getProjectId(),Need. getMaterialId());
        model.addAttribute("Need", Need);
        return "redirect:/Need/allNeed";
    }


}
