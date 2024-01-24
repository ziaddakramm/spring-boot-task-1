package com.tasks.consumer.config;


import com.tasks.provider.demo.dao.EmployeeDAO;
import com.tasks.provider.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {



    @Autowired
    private EmployeeDAO employeeDAO;


    @Bean(name = "explicitEmployeeServiceBeanConsumer")
    //Default bean id = the method name
    public EmployeeService employeeService()
    {
        EmployeeService employeeService=new EmployeeService(employeeDAO);
        employeeService.setBeanType("Consumer");
        return employeeService;
    }
}
