package com.jac.mvc.springmvcproject.repository;

import com.jac.mvc.springmvcproject.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
