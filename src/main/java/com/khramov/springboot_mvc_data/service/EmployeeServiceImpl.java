package com.khramov.springboot_mvc_data.service;

import com.khramov.springboot_mvc_data.dao.EmployeeDAO;
import com.khramov.springboot_mvc_data.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> allEmployee() {
        return employeeDAO.allEmployee();
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
       employeeDAO.addEmployee(employee);
    }
}
