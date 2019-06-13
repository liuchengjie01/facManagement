package com.controller;

import com.pojo.BuMen;
import com.pojo.Employee;
import com.pojo.Incumbency;
import com.service.BuMenService;
import com.service.EmployeeService;
import com.service.IncumbencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BuMenService bumenService;

    @Autowired
    private IncumbencyService incumbencyService;

    @RequestMapping("/Employee")
    public String list(Model model) {
        List<Employee> list = employeeService.queryAllEmployee();
        model.addAttribute("list", list);
        return "employee";
    }

    @RequestMapping("/searchEmployee")
    public String search(Model model, Employee iv){
        List<Employee> list = employeeService.queryAllEmployee();
        Iterator<Employee> it = list.iterator();
        String attribute = iv.getEmployeeId();
        if (attribute.equals("")){
            return "redirect:/Employee/Employee";
        }
        String value = iv.getCurDepartmentid();
        while (it.hasNext()){
            Employee i = it.next();
            String a = "";
            long l = 0;
            Date d = null;
            switch (attribute){
                case "员工号":
                    a = i.getEmployeeId();
                    break;
                case "现在部门编号":
                    a = i.getCurDepartmentid();
                    break;
                case "部门职位":
                    a = i.getEmployPosition();
                    break;
                case "姓名":
                    a = i.getEmployeeName();
                    break;
                case "性别":
                    a = i.getEmployeeSex();
                    break;
                case "出生日期":
                    d = i.getEmployeeBirthday();
                    break;
                case "电话":
                    a = i.getEmployeeTel();
                    break;
                case "地址":
                    a = i.getEmployeeAdd();
                    break;
                case "qq":
                    a = i.getEmployeeQq();
                    break;
                case "邮箱":
                    a = i.getEmployeeMail();
                    break;
                case "身份证号":
                    a = i.getEmployeeIdnumber();
                    break;
                case "社会保险号":
                    a = i.getEmployeeSsnumber();
                    break;
                case "工资":
                    l = i.getEmployeeSalary();
                    break;
                case "入公司时间":
                    d = i.getEmployeeEtime();
                    break;
                case "离开公司时间":
                    d = i.getEmployeeLtime();
                    break;
                default:
                    break;
            }
            if (!a.equals("")){
                if(!a.equals(value)) {
                    it.remove();
                }
            } else if (!d.equals(null)){
                if (!d.equals(value)){
                    it.remove();
                }
            } else if (l != 0){
                if (l != Integer.parseInt(value)){
                    it.remove();
                }
            }
        }
        model.addAttribute("list", list);
        return "employee";
    }

    @RequestMapping("toInsertEmployee")
    public String toInsertEmployee(){
        return "insertEmployee";
    }

    @RequestMapping("/insertEmployee")
    public String insertEmployee(Model model,Employee employee) {
        BuMen b = bumenService.queryByID(employee.getCurDepartmentid());
        if (b != null){
            SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd");
            try{
                Date dtBeg = simFormat.parse("1111-11-12");
                incumbencyService.insert(new Incumbency(employee.getEmployeeId(),b.getDepartmentID(),new Date(),employee.getEmployPosition(),dtBeg));
            } catch (Exception e){
                e.printStackTrace();
            }

            employeeService.insert(employee);
            return "redirect:/Employee/Employee";
        } else{
            model.addAttribute("message","Input data error!");
            return "insertEmployee";
        }

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
