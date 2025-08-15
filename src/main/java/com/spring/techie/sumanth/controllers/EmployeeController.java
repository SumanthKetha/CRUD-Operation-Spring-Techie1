package com.spring.techie.sumanth.controllers;

import com.spring.techie.sumanth.model.Employee;
import com.spring.techie.sumanth.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/get/id/{id}")
    public Employee findEmployee(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody  Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/id/{id}")
    public String removeEmployee(@PathVariable Integer id) {
        return employeeService.deleteEmployeeById(id);
    }

    @PostMapping("/delete/employee")
    public String deleteEmployee(@RequestBody Employee employee){return employeeService.deleteEmployee(employee);}
}
