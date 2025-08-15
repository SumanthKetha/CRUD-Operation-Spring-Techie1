package com.spring.techie.sumanth.service;


import com.spring.techie.sumanth.model.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    String updateEmployee(Employee employee);

    String deleteEmployeeById(Integer id);

    String deleteEmployee(Employee employee);
}
