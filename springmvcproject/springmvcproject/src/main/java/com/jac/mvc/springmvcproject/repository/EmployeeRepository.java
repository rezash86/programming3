package com.jac.mvc.springmvcproject.repository;

import com.jac.mvc.springmvcproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
