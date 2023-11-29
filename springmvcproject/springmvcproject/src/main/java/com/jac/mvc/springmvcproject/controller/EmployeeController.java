package com.jac.mvc.springmvcproject.controller;

import com.jac.mvc.springmvcproject.entity.Employee;
import com.jac.mvc.springmvcproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployee(Model theEmployees){
        // call the service to bring the employees
        List<Employee> allEmployees = employeeService.getAllEmployees();
        // Add the data (employeeList) to the model
        theEmployees.addAttribute("employees", allEmployees);
        //return the thymeleaf
        return "list-employees";

    }
}
