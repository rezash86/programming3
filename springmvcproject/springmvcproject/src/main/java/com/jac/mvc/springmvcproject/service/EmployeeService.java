package com.jac.mvc.springmvcproject.service;

import com.jac.mvc.springmvcproject.domain.Employee;
import com.jac.mvc.springmvcproject.dto.EmployeeDTO;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployees();

    Long saveEmployee(Employee employee);
}
