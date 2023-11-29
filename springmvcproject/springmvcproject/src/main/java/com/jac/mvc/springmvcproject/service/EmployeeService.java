package com.jac.mvc.springmvcproject.service;

import com.jac.mvc.springmvcproject.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployees();
}
