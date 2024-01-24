package com.tasks.provider.demo.config;

import com.tasks.provider.demo.dao.EmployeeDAO;
import com.tasks.provider.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeServiceConfig {


    @Autowired
    private EmployeeDAO employeeDAO;


    @Bean(name = "explicitEmployeeServiceBeanOriginal")
    //Default bean id = the method name
    public EmployeeService employeeService()
    {
        EmployeeService employeeService=new EmployeeService(employeeDAO);
        employeeService.setBeanType("Original");
        return employeeService;
    }


    @Bean(name = "explicitEmployeeServiceBeanTest")
    //Default bean id = the method name
    public EmployeeService employeeServiceTest()
    {
        EmployeeService employeeService=new EmployeeService(employeeDAO);
        employeeService.setBeanType("Test");
        return employeeService;
    }


}
