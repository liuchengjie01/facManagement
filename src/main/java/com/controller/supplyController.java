package com.controller;


import com.pojo.supply;
import com.service.supplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/supply")
public class supplyController {

    @Autowired
    private supplyService sService;

    @RequestMapping("/allsupply")
    public String list(Model model){
        List<supply> list = sService.queryAllSupply();
        model.addAttribute("list", list);
        return "supply";
    }

    @RequestMapping("/searchSupply")
    public String search(Model model, supply iv){
        List<supply> list = sService.queryAllSupply();
        Iterator<supply> it = list.iterator();
        String attribute = iv.getSupplier_id();
        if (attribute.equals("")){
            return "redirect:/supply/allsupply";
        }
        String value = iv.getMaterial_id();
        while (it.hasNext()){
            supply i = it.next();
            String a = "";
            System.out.println("attribute is " + attribute);
            switch (attribute){
                case "供应商编号":
                    a = i.getSupplier_id();
                    break;
                case "材料编号":
                    a = i.getMaterial_id();
                    break;
                case "价格":
                    a = i.getPrice();
                    break;
                case "数量":
                    a = i.getAmount();
                    break;
                case "单位":
                    a = i.getUnit();
                    break;
                case "日期":
                    a = i.getStarttime();
                    break;
                default:
                    break;
            }
            if(!a.equals(value)) {
                it.remove();
            }
        }
        model.addAttribute("list", list);
        return "supply";
    }

    @RequestMapping("toInsertsupply")
    public String toInsertsupply(){
        return "insertSupply";
    }

    @RequestMapping("/insertsupply")
    public String insertsupplier(supply pj) {
        sService.addSupply(pj);
        return "redirect:/supply/allsupply";
    }

    @RequestMapping("/del/supply/{supply_id}/material/{material_id}")
    public String deletesupplyByID(@PathVariable("supply_id") String supply_id,@PathVariable("material_id") String material_id) {
        sService.deleteSupplyByID(supply_id,material_id);
        return "redirect:/supply/allsupply";
    }

    @RequestMapping("toUpdatesupply/supply/{supply_id}/material/{material_id}")
    public String toUpdatesupply(Model model,@PathVariable("supply_id") String supply_id,@PathVariable("material_id") String material_id) {
        model.addAttribute("supply", sService.querySupplyByID(supply_id,material_id));
        return "updateSupply";
    }

    @RequestMapping("/updatesupply")
    public String updateSupply(Model model, supply pj) {
        sService.updateSupply(pj);
        pj = sService.querySupplyByID(pj.getSupplier_id(),pj.getMaterial_id());
        model.addAttribute("supply", pj);
        return "redirect:/supply/allsupply";
    }
}
