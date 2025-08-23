package com.spring.techie.sumanth.service;


import com.spring.techie.sumanth.model.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    Employee updateEmployee(Employee employee);

    String deleteEmployeeById(Integer id);

    String deleteEmployee(Employee employee);

    void removeCache(String name);
    // TO-DO
    // implement these methods using cache manager.
    Employee storeInCache(Integer id);
    Employee updateCache(Employee employee);
    String deleteCache(Integer id);
}
