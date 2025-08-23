package com.spring.techie.sumanth.impl;

import com.spring.techie.sumanth.model.Employee;
import com.spring.techie.sumanth.repo.EmployeeRepository;
import com.spring.techie.sumanth.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    CacheManager cacheManager;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Cacheable(value = "employeeInfo" ,key = "#id",unless = "#result==null")
    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            employee.get().setSalary(null);
            return employee.get();
        }
        return null;
    }

    @CachePut(value = "employeeInfo",key = "#employee.id")
    @Override
    public Employee updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

   @CacheEvict(value = "employeeInfo", key = "#id")
    @Override
    public String deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
        return "Employee Object deleted Successfully with Id : " + id;
    }

    @Override
    public String deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
        return "Employee deleted successfully " ;
    }
    @Override
    public void removeCache(String name) {
        cacheManager.getCache(name).clear();

    }

}
