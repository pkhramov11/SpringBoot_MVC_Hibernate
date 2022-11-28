package com.khramov.springboot_mvc_data.dao;

import com.khramov.springboot_mvc_data.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> allEmployee();

    public void addEmployee(Employee employee);
}
