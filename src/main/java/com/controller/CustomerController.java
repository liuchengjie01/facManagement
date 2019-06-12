package com.controller;

import com.pojo.Assignment;
import com.pojo.Customer;
import com.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private customerService pService;

    @RequestMapping("/allCustomer")
    public String list(Model model){
        List<Customer> list = pService.queryAllCustomer();
        model.addAttribute("list", list);
        return "customer";
    }

    @RequestMapping("/searchCustomer")
    public String search(Model model, Customer iv){
        System.out.println("**********"+iv.toString());
        List<Customer> list = pService.queryAllCustomer();
        Iterator<Customer> it = list.iterator();
        String attribute = iv.getCustomer_id();
        if (attribute.equals("")){
            return "redirect:/customer/allCustomer";
        }
        String value = iv.getCustomer_cname();
        while (it.hasNext()){
            Customer i = it.next();
            String a = "";
            System.out.println("attribute is " + attribute);
            switch (attribute){
                case "顾客编号":
                    a = i.getCustomer_id();
                    break;
                case "顾客名字":
                    a = i.getCustomer_cname();
                    break;
                case "顾客联系人":
                    a = i.getCustomer_contact();
                    break;
                case "联系方式":
                    a = i.getCustomer_tel();
                    break;
                default:
                    break;
            }
            if(!a.equals(value)) {
                it.remove();
            }
        }
        model.addAttribute("list", list);
        return "customer";
    }


    @RequestMapping("toInsertCustomer")
    public String toInsertCustomer(){
        return "insertCustomer";
    }

    @RequestMapping("/insertCustomer")
    public String insertCustomer(Customer pj) {
        pService.addCustomer(pj);
        return "redirect:/customer/allCustomer";
    }

    @RequestMapping("/del/{Customer_id}")
    public String deleteCustomerByID(@PathVariable("Customer_id") String Customer_id) {
        pService.deleteCustomerByID(Customer_id);
        return "redirect:/customer/allCustomer";
    }

    @RequestMapping("toUpdateCustomer/{Customer_id}")
    public String toUpdateCustomer(Model model,@PathVariable("Customer_id") String Customer_id) {
        model.addAttribute("Customer", pService.queryCustomerByID(Customer_id));
        System.out.println(pService.queryCustomerByID(Customer_id).toString());
        return "updateCustomer";
    }

    @RequestMapping("/updateCustomer")
    public String updateCustomer(Model model, Customer pj) {

        pService.updateCustomer(pj);
        Customer CST = pService.queryCustomerByID(pj.getCustomer_id());
        model.addAttribute("customer", CST);
        return "redirect:/customer/allCustomer";
    }

}
