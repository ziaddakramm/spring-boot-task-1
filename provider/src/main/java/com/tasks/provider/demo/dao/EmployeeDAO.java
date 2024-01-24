package com.tasks.provider.demo.dao;

import com.tasks.provider.demo.entity.Employee;

import java.util.List;


public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);


}