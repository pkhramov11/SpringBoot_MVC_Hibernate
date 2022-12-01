package com.khramov.springboot_mvc_data.controller;


import com.khramov.springboot_mvc_data.model.Employee;
import com.khramov.springboot_mvc_data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {

    private final EmployeeService employeeService;

    @Autowired
    public MyController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

     @RequestMapping("/")
     public String viewAllEmployees(Model model){
         List<Employee> list = employeeService.allEmployee();
         model.addAttribute("allEmp", list);
         return "viewEmp";
     }

    @RequestMapping("/addNewEmployee")
    public String addEmployee(Model model){

        Employee employee = new Employee();;
        model.addAttribute("employee", employee);
        return "addEmp";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "addEmp";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) {
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(employee);
        return "redirect:/";
    }




}
