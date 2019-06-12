package com.controller;


import com.pojo.supplier;
import com.service.supplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/supplier")
public class supplierController {

    @Autowired
    private supplierService sService;

    @RequestMapping("/allsupplier")
    public String list(Model model){
        List<supplier> list = sService.queryAllSupplier();
        model.addAttribute("list", list);
        return "supplier";
    }

    @RequestMapping("/searchSupplier")
    public String search(Model model, supplier iv){
        List<supplier> list = sService.queryAllSupplier();
        Iterator<supplier> it = list.iterator();
        String attribute = iv.getSupplier_id();
        if (attribute.equals("")){
            return "redirect:/supplier/allsupplier";
        }
        String value = iv.getSupplier_name();
        while (it.hasNext()){
            supplier i = it.next();
            String a = "";
            System.out.println("attribute is " + attribute);
            switch (attribute){
                case "供应商编号":
                    a = i.getSupplier_id();
                    break;
                case "供应商名称":
                    a = i.getSupplier_name();
                    break;
                case "供应商代表":
                    a = i.getSupplier_contact();
                    break;
                case "联系电话":
                    a = i.getSupplier_list();
                    break;
                default:
                    break;
            }
            if(!a.equals(value)) {
                it.remove();
            }
        }
        model.addAttribute("list", list);
        return "supplier";
    }


    @RequestMapping("toInsertsupplier")
    public String toInsertsupplier(){
        return "insertSupplier";
    }

    @RequestMapping("/insertsupplier")
    public String insertsupplier(supplier pj) {
        sService.addSupplier(pj);
        return "redirect:/supplier/allsupplier";
    }

    @RequestMapping("/del/{supplier_id}")
    public String deletesupplierByID(@PathVariable("supplier_id") String supplier_id) {
        sService.deleteSupplierByID(supplier_id);
        return "redirect:/supplier/allsupplier";
    }

    @RequestMapping("toUpdatesupplier/{supplier_id}")
    public String toUpdatesupplier(Model model,@PathVariable("supplier_id") String supplier_id) {
        model.addAttribute("supplier", sService.querySupplierByID(supplier_id));
        return "updateSupplier";
    }

    @RequestMapping("/updatesupplier")
    public String updateSupply(Model model, supplier pj) {
        sService.updateSupplier(pj);
        pj = sService.querySupplierByID(pj.getSupplier_id());
        model.addAttribute("supplier", pj);
        return "redirect:/supplier/allsupplier";
    }

}
