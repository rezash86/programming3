package com.jac.mvc.controller;

import com.jac.mvc.entity.Employee;
import com.jac.mvc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employee")
    public Long createEmployee(){
        Employee employee = Employee.builder().firstName("Keanue").lastName("Reeves").build();
        Employee savedEmp = employeeRepository.save(employee);
        return savedEmp.getId();
    }

    @GetMapping("/employee/findAll")
    public List<Employee> getAllEmployee(){
        List<Employee> allEmps = employeeRepository.findAll();
        return allEmps;
    }
}
