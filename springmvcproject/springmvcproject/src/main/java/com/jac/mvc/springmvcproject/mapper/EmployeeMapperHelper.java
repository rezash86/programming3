package com.jac.mvc.springmvcproject.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.mvc.springmvcproject.domain.Employee;
import com.jac.mvc.springmvcproject.dto.EmployeeDTO;
import com.jac.mvc.springmvcproject.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapperHelper {

    private final ObjectMapper mapper;

    @Autowired
    public EmployeeMapperHelper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Employee> convertEmployeeEntityListToEmployeeList(List<EmployeeEntity> employeeEntities){
        List<Employee> employees = new ArrayList<>();
        for(EmployeeEntity emp: employeeEntities){
            employees.add(mapper.convertValue(emp, Employee.class));
        }

        return employees;
    }

    public List<EmployeeDTO> convertEmployeeListToEmployeeDTOList(List<Employee> employees){
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for(Employee emp: employees){
            employeeDTOs.add(mapper.convertValue(emp, EmployeeDTO.class));
        }

        return employeeDTOs;
    }
}
