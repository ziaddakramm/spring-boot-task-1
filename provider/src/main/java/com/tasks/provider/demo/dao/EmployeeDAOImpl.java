package com.tasks.provider.demo.dao;

import com.tasks.provider.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    // define field for entityManager
    private EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }



    @Override
    public List<Employee> findAll() {
        // create a query
        //Employee.class = result type of the query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
        // execute query and get result list
        List<Employee> employeesList= theQuery.getResultList();
        // return the results
        return employeesList;
    }


    @Override
    public Employee findById(int id) {
        //get employee
        Employee dbEmployee= entityManager.find(Employee.class,id);

        //return the employee
        return dbEmployee;
    }

    @Override
    public Employee save(Employee employee)
    {

       //save/update employee
       Employee dbEmployee=entityManager.merge(employee);

       //return saved/updated employee
       return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        //get employee
        Employee dbEmployee= entityManager.find(Employee.class,id);

        //remove the employee
        entityManager.remove(dbEmployee);
    }

}
