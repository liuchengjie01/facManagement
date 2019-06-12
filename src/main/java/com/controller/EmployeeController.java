package com.controller;

import com.pojo.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/Employee")
    public String list(Model model) {
        List<Employee> list = employeeService.queryAllEmployee();
        model.addAttribute("list", list);
        return "employee";
    }
    
    @RequestMapping("toInsertEmployee")
    public String toInsertEmployee(){
        return "insertEmployee";
    }

    @RequestMapping("/insertEmployee")
    public String insertEmployee(Employee Employee) {
        employeeService.insert(Employee);
        return "redirect:/Employee/Employee";
    }

    @RequestMapping("/del/{employeeId}")
    public String deleteEmployeeByID(@PathVariable("employeeId") String employeeId) {
        employeeService.deleteByPrimaryKey(employeeId);
        return "redirect:/Employee/Employee";
    }

    @RequestMapping("toUpdateEmployee/{employeeId}")
    public String toUpdateEmployee(Model model, @PathVariable("employeeId") String employeeId) {
        model.addAttribute("Employee", employeeService.queryByID(employeeId));
        return "updateEmployee";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(Model model, Employee Employee) {
        System.out.println(Employee.toString());
        employeeService.updateByPrimaryKey(Employee);
        Employee = employeeService.queryByID(Employee. getEmployeeId());
        model.addAttribute("Employee", Employee);
        return "redirect:/Employee/Employee";
    }

}
