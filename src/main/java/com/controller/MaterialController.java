package com.controller;

import com.pojo.Material;
import com.service.materialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
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

    @RequestMapping("/searchMaterial")
    public String search(Model model, Material iv){
        List<Material> list = mService.queryAllMaterial();
        Iterator<Material> it = list.iterator();
        String attribute = iv.getMaterial_id();
        if (attribute.equals("")){
            return "redirect:/material/allMaterial";
        }
        String value = iv.getMaterial_name();
        System.out.println("value is " + value);
        while (it.hasNext()){
            Material i = it.next();
            String a = "";
            int in = -1;
            switch (attribute){
                case "材料编号":
                    a = i.getMaterial_id();
                    break;
                case "材料名称":
                    a = i.getMaterial_name();
                    break;
                case "材料储量":
                    in = i.getMaterial_storage();
                    break;
                default:
                    break;
            }
            if (!a.equals("")){
                if(!a.equals(value)) {
                    it.remove();
                }
            } else if (in != -1){
                if (Integer.toString(in) != value){
                    it.remove();
                }
            }
        }
        model.addAttribute("materials", list);
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
        return "insertMaterial";
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