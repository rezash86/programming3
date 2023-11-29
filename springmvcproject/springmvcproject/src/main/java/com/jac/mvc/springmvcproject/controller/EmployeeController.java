package com.jac.mvc.springmvcproject.controller;

import com.jac.mvc.springmvcproject.domain.Employee;
import com.jac.mvc.springmvcproject.dto.EmployeeDTO;
import com.jac.mvc.springmvcproject.mapper.EmployeeMapperHelper;
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

    private final EmployeeMapperHelper employeeMapperHelper;
    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeMapperHelper employeeMapperHelper) {
        this.employeeService = employeeService;
        this.employeeMapperHelper = employeeMapperHelper;
    }

    @GetMapping("/list")
    public String listEmployee(Model theEmployees){
        // call the service to bring the employees
        List<Employee> allEmployees = employeeService.getAllEmployees();
        //convert employees to employeeDTOS
        List<EmployeeDTO> employeeDTOS = employeeMapperHelper.convertEmployeeListToEmployeeDTOList(allEmployees);
        // Add the data (employeeList) to the model
        theEmployees.addAttribute("employees", employeeDTOS);
        //return the thymeleaf
        return "list-employees";

    }
}
