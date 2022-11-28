package com.khramov.springboot_mvc_data.service;

import com.khramov.springboot_mvc_data.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> allEmployee();
    public void addEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(Employee employee);
}
