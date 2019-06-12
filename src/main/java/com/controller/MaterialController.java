package com.controller;

import com.pojo.Material;
import com.service.materialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/material")
public class MaterialController{

    @Autowired
    private materialService mService;

    @RequestMapping("/allMaterial")
    public String listAll(Model model){
        List<Material> materials = mService.queryAllMaterial();
        model.addAttribute("materials",materials);
        return "material";
    }

    @RequestMapping("/oneMaterial/{materialID}")
    public String listOne(Model model,@PathVariable("materialID") String materialID){
        Material material = mService.queryMaterialByID(materialID);
        model.addAttribute("material",material);
        return "material";
    }

    @RequestMapping("/toInsertMaterial")
    public String toInsertmaterial(){
        return "insertMateriala";
    } //该return字符串代表某个jsp页面

    @RequestMapping("/addMaterial")
    public String addMaterial(Material mmaterial){
        mService.addMaterial(mmaterial);
        return "redirect:/material/allMaterial";
    }

    @RequestMapping("/deleteMaterial/{MaterialID}")
    public String deleteMaterial(@PathVariable("MaterialID") String materialID){
        mService.deleteMaterial(materialID);
        return "redirect:/material/allMaterial";
    }

    @RequestMapping("toUpdateMaterial/{MaterialID}")
    public String toUpdateMaterial(Model model,@PathVariable("MaterialID") String MaterialID) {
        model.addAttribute("material", mService.queryMaterialByID(MaterialID));
        return "updateMaterial"; //某个jsp页面
    }

    @RequestMapping("/updateMaterial")
    public String updateMaterial(Model model, Material mmterial){
        mService.updateMaterial(mmterial);
        Material m = mService.queryMaterialByID(mmterial.getMaterial_id());
        model.addAttribute("material",m);
        return "redirect:/material/allMaterial";
    }
}