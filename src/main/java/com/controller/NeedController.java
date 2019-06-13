package com.controller;

import com.pojo.Material;
import com.pojo.Need;
import com.pojo.project;
import com.service.NeedService;
import com.service.materialService;
import com.service.projectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/Need")
public class NeedController {

    @Autowired
    private NeedService NeedService;

    @Autowired
    private projectService projectservice;

    @Autowired
    private materialService mService;

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
            int in = 0;
            Date d = null;
            System.out.println("attribute is " + attribute);
            switch (attribute){
                case "项目编号":
                    a = i.getProjectId();
                    break;
                case "材料编号":
                    a = i.getMaterialId();
                    break;
                case "总需求量":
                    in = i.getMaterialDemand();
                    break;
                case "已供应量":
                    in = i.getHavaSupply();
                    break;
                case "本次供应量":
                    in = i.getMaterialSupply();
                    break;
                case "供应时间":
                    d = i.getSupplyTime();
                    break;
                case "单位":
                    a = i.getUnit();
                case "差额":
                    in = i.getMaterialBalance();
                    break;
                default:
                    break;
            }
            if (!a.equals("")){
                if(!a.equals(value)) {
                    it.remove();
                }
            } else if (in != 0) {
                if ( !String.valueOf(in).equals(value) ){
                    it.remove();
                }
            } else {
                if (!d.equals(value)){
                    it.remove();
                }
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
    public String insertNeed(Model model, Need need) {
        if (check(need)){
            NeedService.insert(need);
            return "redirect:/Need/allNeed";
        } else {
            model.addAttribute("message", "Input data error");
            return "insertNeed";
        }
    }

    public boolean check(Need need){
        project p = projectservice.queryProjectByID(need.getProjectId());
        Material m = mService.queryMaterialByID(need.getMaterialId());
        if (p  != null &&  m != null){
            m.setMaterial_storage(m.getMaterial_storage()-need.getMaterialSupply());
            mService.updateMaterial(m);
            return true;
        } else {
            return false;
        }
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
