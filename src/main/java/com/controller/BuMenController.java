package com.controller;

import com.pojo.BuMen;
import com.pojo.Employee;
import com.pojo.Incumbency;
import com.pojo.RecordsOfManagers;
import com.service.EmployeeService;
import com.service.IncumbencyService;
import com.service.RMService;
import com.utils.ID_manag;
import com.service.BuMenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/BuMen")
public class BuMenController {

    @Autowired
    private BuMenService buMenService;

    @Autowired
    private EmployeeService employeeservice;

    @Autowired
    private IncumbencyService incumbencyservice;

    @Autowired
    private RMService rm;

    @RequestMapping("/allBumen")
    public String list(Model model) {
        List<BuMen> list = buMenService.queryAllBuMen();
        model.addAttribute("list", list);
        return "department";
    }

    @RequestMapping("/searchBumen")
    public String search(Model model, BuMen iv){
        List<BuMen> list = buMenService.queryAllBuMen();
        Iterator<BuMen> it = list.iterator();
        String attribute = iv.getDepartmentID();
        if (attribute.equals("")){
            return "redirect:/BuMen/allBumen";
        }
        String value = iv.getDepartmentName();
        while (it.hasNext()){
            BuMen i = it.next();
            String a = "";
            switch (attribute){
                case "部门编号":
                    a = i.getDepartmentID();
                    break;
                case "部门名字":
                    a = i.getDepartmentName();
                    break;
                case "部门经理":
                    a = i.getManagerID();
                    break;
                default:
                    break;
            }
            if(!a.equals(value)) {
                it.remove();
            }
        }
        model.addAttribute("list", list);
        return "department";
    }

    @RequestMapping("toInsertBumen")
    public String toInsertBumen(Model model){
        BuMen bw = buMenService.queryMAXID();
        int id = Integer.parseInt(bw.getDepartmentID());
        id = id + 1;
        bw.setDepartmentID(String.valueOf(id));
        model.addAttribute("Bumen",bw);
        return "insertDepartment";
    }

    @RequestMapping("/insertBumen")
    public String insertBumen(BuMen buMen) {
        buMenService.addBumen(buMen);
        return "redirect:/BuMen/allBumen";
    }

  @RequestMapping("/del/{departmentID}")
  public String deleteBumenByID(@PathVariable("departmentID") String departmentID) {
    buMenService.deleteBumenByID(departmentID);
    return "redirect:/BuMen/allBumen";
  }

  @RequestMapping("toUpdateBuMen/{departmentID}")
  public String toUpdateBuMen(Model model, @PathVariable("departmentID") String departmentID) {
      model.addAttribute("Bumen", buMenService.queryByID(departmentID));
    return "updateDepartment";
  }

  @RequestMapping("/updateBuMen")
  public String updateBuMen(Model model, BuMen Bumen) {
        System.out.println("Bumen ManagerID is "+Bumen.getManagerID());
       Employee e = employeeservice.queryByID(Bumen.getManagerID());
       if (e != null){
           System.out.println(e.getEmployeeId());
           System.out.println("----------");
           System.out.println(e.getCurDepartmentid());
           System.out.println("----------");
       }
       BuMen b = buMenService.queryByID(Bumen.getDepartmentID());
       System.out.println(b.getManagerID());
       if (e != null && e.getCurDepartmentid().equals(Bumen.getDepartmentID()) && (b.getManagerID()==null || b.getManagerID().equals(""))){
           buMenService.updateBumen(Bumen);
           e.setEmployPosition("经理");
           employeeservice.updateByPrimaryKey(e);
           SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd");
           try {
               Date dtBeg = simFormat.parse("1111-11-12");
               incumbencyservice.insert(new Incumbency(e.getEmployeeId(),Bumen.getDepartmentID(),new Date(),"经理",dtBeg));
           } catch(Exception e1){
               System.out.println(e1);
           }
           rm.insert(new RecordsOfManagers(b.getDepartmentID(),e.getEmployeeId(),new Date(),""));
           Bumen = buMenService.queryByID(Bumen.getDepartmentID());
           model.addAttribute("BuMen", Bumen);
           return "redirect:/BuMen/allBumen";
       } else {
           model.addAttribute("message", "Input data error!");
           return "updateDepartment";
       }
  }
}
