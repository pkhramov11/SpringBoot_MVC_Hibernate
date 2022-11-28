package com.khramov.springboot_mvc_data.dao;

import com.khramov.springboot_mvc_data.model.Employee;


import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {


    public EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> allEmployee() {
        List <Employee> listEmp = entityManager.createQuery("from Employee", Employee.class).getResultList();
        return listEmp;
    }

    @Override
    public void addEmployee(Employee employee) {
        entityManager.merge(employee);


    }

    @Override
    public Employee getEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        entityManager.remove(employee);
    }
}
