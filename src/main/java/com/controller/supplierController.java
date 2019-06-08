package com.controller;


import com.pojo.supplier;
import com.service.supplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String updateProject(Model model, supplier pj) {
        sService.updateSupplier(pj);
        pj = sService.querySupplierByID(pj.getSupplier_id());
        model.addAttribute("supplier", pj);
        return "redirect:/supplier/allsupplier";
    }

}
