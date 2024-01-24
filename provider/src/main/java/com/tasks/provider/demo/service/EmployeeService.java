package com.tasks.provider.demo.service;

import com.tasks.provider.demo.dao.EmployeeDAO;
import com.tasks.provider.demo.entity.Employee;
import jakarta.transaction.Transactional;

import java.util.List;


//@Service
public class EmployeeService {

    //DAO field
    private EmployeeDAO employeeDAO;

    private String beanType ;

    public String getBeanType() {
        return beanType;
    }

    public void setBeanType(String beanType) {
        this.beanType = beanType;
    }

    //@Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }




    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }




}
