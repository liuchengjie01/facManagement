package com.controller;

import com.pojo.Pay;
import com.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;
import java.util.regex.PatternSyntaxException;

@Controller
@RequestMapping("/Pay")
public class PayController {

    @Autowired
    private PayService PayService;

    @RequestMapping("/allPay")
    public String list(Model model) {
        List<Pay> list = PayService.queryAllPay();
        model.addAttribute("list", list);
        return "Pay";
    }

    @RequestMapping("/searchPay")
    public String search(Model model, Pay iv){
        List<Pay> list = PayService.queryAllPay();
        Iterator<Pay> it = list.iterator();
        String attribute = iv.getCustomerId();
        if (attribute.equals("")){
            return "redirect:/Pay/allPay";
        }
        String value = iv.getProjectId();
        while (it.hasNext()){
            Pay i = it.next();
            String a = "";
            long l = 0;
            switch (attribute){
                case "顾客编号":
                    a = i.getCustomerId();
                    break;
                case "项目编号":
                    a = i.getProjectId();
                    break;
                case "应付款":
                    l = i.getProjectPayable();
                    break;
                case "实际付款":
                    l = i.getProjectRealpayment();
                    break;
                case "尾款":
                    l = i.getProjectRestpayment();
                    break;
                default:
                    break;
            }
            if (!a.equals("")){
                if(!a.equals(value)) {
                    it.remove();
                }
            } else if (l != 0){
                if (!String.valueOf(l).equals(value)){
                    it.remove();
                }
            }
        }
        model.addAttribute("list", list);
        return "Pay";
    }

    @RequestMapping("toInsertPay")
    public String toInsertPay(){
        return "insertPay";
    }

    @RequestMapping("/insertPay")
    public String insertPay(Pay Pay) {
        PayService.insert(Pay);
        return "redirect:/Pay/allPay";
    }

    @RequestMapping("/del/ci/{customerId}/pi/{projectId}")
    public String deletePayByID(@PathVariable("customerId") String customerId,@PathVariable("projectId") String  projectId) {
        PayService.deleteByPrimaryKey(customerId,projectId);
        return "redirect:/Pay/allPay";
    }

    @RequestMapping("toUpdatePay/ci/{customerId}/pi/{projectId}")
    public String toUpdatePay(Model model,@PathVariable("customerId") String customerId,@PathVariable("projectId") String  projectId) {
        model.addAttribute("Pay", PayService.selectByPrimaryKey(customerId,projectId));
        return "updatePay";
    }

    @RequestMapping("/updatePay")
    public String updatePay(Model model, Pay Pay) {
        System.out.println(Pay.toString());
        PayService.updateByPrimaryKey(Pay);
        Pay = PayService.selectByPrimaryKey(Pay. getCustomerId(),Pay. getProjectId());
        model.addAttribute("Pay", Pay);
        return "redirect:/Pay/allPay";
    }



}
