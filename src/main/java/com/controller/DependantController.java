package com.controller;

import com.pojo.Dependant;
import com.service.dependantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/dependant")
public class DependantController {

    @Autowired
    private dependantService dService;

    @RequestMapping("/alldependant")
    public String list(Model model) {
        List<Dependant> list = dService.queryAllDependant();
        model.addAttribute("list", list);
        return "dependant";
    }

    @RequestMapping("/searchDependant")
    public String search(Model model, Dependant iv){
        System.out.println("**********"+iv.toString());
        List<Dependant> list = dService.queryAllDependant();
        Iterator<Dependant> it = list.iterator();
        String attribute = iv.getDependant_id();
        if (attribute.equals("")){
            return "redirect:/dependant/alldependant";
        }
        String value = iv.getEmployee_id();
        while (it.hasNext()){
            Dependant i = it.next();
            String a = "";
            System.out.println("attribute is " + attribute);
            switch (attribute){
                case "受赡养人编号":
                    a = i.getDependant_id();
                    break;
                case "雇员编号":
                    a = i.getEmployee_id();
                    break;
                case "受赡养人姓名":
                    a = i.getDependant_name();
                    break;
                case "受赡养人性别":
                    a = i.getDependant_sex();
                    break;
                case "受赡养人生日":
                    a = i.getDependant_birthday();
                    break;
                case "两人关系":
                    a = i.getRelationship();
                    break;
                case "受赡养人ID号":
                    a = i.getDependant_IDnumber();
                    break;
                case "受赡养人SS号":
                    a = i.getDependant_SSnumber();
                default:
                    break;
            }
            if(!a.equals(value)) {
                it.remove();
            }
        }
        model.addAttribute("list", list);
        return "dependant";
    }

    @RequestMapping("/onedependant/{dependantID}/{employeeID}")
    public String thelist(Model model,@PathVariable("dependantID") String dependantID, @PathVariable("employeeID") String employeeID) {
        Dependant dependant = dService.queryDependantByID(dependantID,employeeID);
        model.addAttribute("dependant", dependant);
        return "dependant";
    }
    @RequestMapping("toInsertdependant")
    public String toInsertdependant(){
        return "insertDependant";
    }

    @RequestMapping("/insertDependant")
    public String insertDependant(Dependant dp) {
        dService.addDependant(dp);
        return "redirect:/dependant/alldependant";
    }

    @RequestMapping("/del/{dependantID}/{employeeID}")
    public String deleteDependantByID(@PathVariable("dependantID") String dependantID,@PathVariable("employeeID") String employeeID) {
        dService.deleteDependantByID(dependantID,employeeID);
        return "redirect:/dependant/alldependant";
    }

    @RequestMapping("toUpdatedependant/{dependantID}/{employeeID}")
    public String toUpdatedependant(Model model,@PathVariable("dependantID") String dependantID,@PathVariable("employeeID") String employeeID) {
        model.addAttribute("dependant", dService.queryDependantByID(dependantID,employeeID));
        return "updateDependant";
    }

    @RequestMapping("/updateDependant")
    public String updateDependant(Model model, Dependant dp) {
        dService.updateDependant(dp);
        Dependant DP = dService.queryDependantByID(dp.getDependant_id(),dp.getEmployee_id());
        model.addAttribute("dependant", DP);
        return "redirect:/dependant/alldependant";
    }

}
