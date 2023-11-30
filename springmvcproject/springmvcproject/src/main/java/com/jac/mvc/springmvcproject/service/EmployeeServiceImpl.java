package com.jac.mvc.springmvcproject.service;

import com.jac.mvc.springmvcproject.domain.Employee;
import com.jac.mvc.springmvcproject.entity.EmployeeEntity;
import com.jac.mvc.springmvcproject.exception.EmployeeNotFoundException;
import com.jac.mvc.springmvcproject.mapper.EmployeeMapperHelper;
import com.jac.mvc.springmvcproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapperHelper mapperHelper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapperHelper mapperHelper) {
        this.employeeRepository = employeeRepository;
        this.mapperHelper = mapperHelper;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> empEntities = employeeRepository.findAll();
        return mapperHelper.convertEmployeeEntityListToEmployeeList(empEntities);
    }

    @Override
    public Long saveEmployee(Employee employee) {
        EmployeeEntity employeeEntity = mapperHelper.convertEmployeeToEmployeeEntity(employee);
        EmployeeEntity savedEmp =  employeeRepository.save(employeeEntity);
        return savedEmp.getId();
    }

    @Override
    public Employee findEmployeeById(Long empId) {
        Optional<EmployeeEntity> byId = employeeRepository.findById(empId);
        if(byId.isPresent()){
            EmployeeEntity foundEmp = byId.get();
            return mapperHelper.convertEmployeeEntityToEmployee(foundEmp);
        }
        throw new EmployeeNotFoundException("There is no employee by id " + empId);
    }

    @Override
    public void deleteEmployeeById(Long empId) {
        employeeRepository.deleteById(empId);
    }

}
