package com.tasks.consumer.rest;


//import service

import com.tasks.provider.demo.entity.Employee;
import com.tasks.provider.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //Service field

    private EmployeeService employeeService;


    //Constructor injection for
    @Autowired
    public EmployeeRestController( @Qualifier("explicitEmployeeServiceBeanTest")EmployeeService employeeService) {
        this.employeeService = employeeService;
        System.out.println("Bean: "+employeeService.getBeanType());
        //System.out.println("Is this the orignal bean? " + this.employeeService);
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {

        return employeeService.findAll();
    }


    //expose GET "/employees" and return a list of employees/{id}
    // Path variable and function parameter should be named the same
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {
        //Find employee
        Employee employee = employeeService.findById(id);

        //if not found throw exception
        if (employee == null) {
            throw new RuntimeException("Employee id not found");
        }

        //Return employee if found
        return employee;
    }




    @PostMapping("employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        //In case the id is passed in json
        employee.setId(0);

        Employee dbEmployee=employeeService.save(employee);

        return dbEmployee;
    }


    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        Employee dbEmployee=employeeService.save(employee);

        return dbEmployee;
    }

    @DeleteMapping("employees/{id}")
    public String updateEmployee(@PathVariable int id)
    {
        Employee tempEmployee= employeeService.findById(id);

        if(tempEmployee==null)
        {
            throw new RuntimeException("Employee id: "+id+ " not found" );
        }


        employeeService.deleteById(id);

        return "Deleted employee with id: " + id;
    }





}
