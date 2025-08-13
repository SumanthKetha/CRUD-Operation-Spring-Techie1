package com.spring.techie.sumanth.impl;

import com.spring.techie.sumanth.model.Employee;
import com.spring.techie.sumanth.repo.EmployeeRepository;
import com.spring.techie.sumanth.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public String updateEmployee(Employee employee) {

        employeeRepository.save(employee);
        return "updated Successfully";
    }

    @Override
    public String deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
        return "Employee Object deleted Successfully with Id : " + id;
    }

}
