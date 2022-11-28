package com.khramov.springboot_mvc_data.controller;


import com.khramov.springboot_mvc_data.model.Employee;
import com.khramov.springboot_mvc_data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    private EmployeeService employeeService;

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

    @RequestMapping("/add")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        employeeService.addEmployee(employee);
        model.addAttribute("emp", employee);
        return "addEmp";
    }


}
