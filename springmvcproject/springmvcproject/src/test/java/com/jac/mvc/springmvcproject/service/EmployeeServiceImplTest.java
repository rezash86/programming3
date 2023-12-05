package com.jac.mvc.springmvcproject.service;

import com.jac.mvc.springmvcproject.domain.Employee;
import com.jac.mvc.springmvcproject.dto.EmployeeDTO;
import com.jac.mvc.springmvcproject.entity.EmployeeEntity;
import com.jac.mvc.springmvcproject.exception.EmployeeNotFoundException;
import com.jac.mvc.springmvcproject.mapper.EmployeeMapperHelper;
import com.jac.mvc.springmvcproject.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl underTest;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapperHelper employeeMapperHelper;

    private final static String FIRST_NAME = "A";

    private final static String LAST_NAME = "AA";

    private final static String EMAIL = "A@g.com";


    @Test
    void test_getAllEmployees_returnList(){
        //arrange
        // when I call method (findAll) in the employeeRepository, I expect to have
        // a list of Employee => MY EXPECTATION of calling a mock dependency
        List<EmployeeEntity> employeeEntityList =
                List.of(EmployeeEntity.builder().id(1L).firstName(FIRST_NAME).lastName(LAST_NAME).email(EMAIL).build(),
                        EmployeeEntity.builder().id(1L).firstName("B").lastName("BB").email("b@gm.com").build());

        List<Employee> employeeList =
                List.of(Employee.builder().id(1L).firstName(FIRST_NAME).lastName(LAST_NAME).email(EMAIL).build(),
                        Employee.builder().id(1L).firstName("B").lastName("BB").email("b@gm.com").build());



        Mockito.when(employeeRepository.findAll()).thenReturn(employeeEntityList);
        Mockito.when(employeeMapperHelper.convertEmployeeEntityListToEmployeeList(employeeEntityList)).thenReturn(employeeList);

        //real call
        var actual = underTest.getAllEmployees();

        //verification

        assertEquals(2, actual.size());
        assertEquals(employeeList, actual);
    }

    @Test
    void test_test_getAllEmployees_returnEmptyList(){
        //arrange
        Mockito.when(employeeRepository.findAll()).thenReturn(Collections.emptyList());
        Mockito.when(employeeMapperHelper.convertEmployeeEntityListToEmployeeList(Collections.emptyList())).thenReturn(Collections.emptyList());

        //real call
        var actual = underTest.getAllEmployees();
        //verification
        assertEquals(0, actual.size());
        assertEquals(Collections.emptyList(), actual);
    }

    @Test
    void test_saveEmployee_returnLong(){
        //arrange
        Long empId = 1L;
        Employee employee = Employee.builder().firstName("A").lastName("AA").email("AAA@g.com").build();
        EmployeeEntity employeeEntity =  EmployeeEntity.builder().id(empId).firstName("A").lastName("AA").email("AAA@g.com").build();

        Mockito.when(employeeMapperHelper.convertEmployeeToEmployeeEntity(employee)).thenReturn(employeeEntity);
        Mockito.when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);
        //real call
        var actual = underTest.saveEmployee(employee);
        //verification

        assertEquals(empId, actual);
    }

    @Test
    void test_findEmployeeById_returnEmp(){
        Long empId = 1L;
        EmployeeEntity empEntity = EmployeeEntity.builder().id(empId).firstName("A").lastName("AA").email("AA@g.com").build();
        Employee expectedEmployee = Employee.builder().firstName("A").lastName("AA").email("AAA@g.com").build();

        when(employeeRepository.findById(empId)).thenReturn(Optional.of(empEntity));
        when(employeeMapperHelper.convertEmployeeEntityToEmployee(empEntity)).thenReturn(expectedEmployee);

        var actual = underTest.findEmployeeById(empId);

        assertNotNull(actual);
        assertEquals(expectedEmployee, actual);
        assertEquals("A", expectedEmployee.getFirstName());
        assertEquals("AA", expectedEmployee.getLastName());

        verify(employeeMapperHelper).convertEmployeeEntityToEmployee(eq(empEntity)); // the exact object of type EmployeeEntity that I provide
        verify(employeeMapperHelper, times(1)).convertEmployeeEntityToEmployee(any(EmployeeEntity.class)); // Any object of type EmployeeEntity

    }

    @Test
    void test_findEmployeeById_throwsException(){
        Long empId = 1L;
        when(employeeRepository.findById(empId)).thenReturn(Optional.empty());


        assertThrows(
                EmployeeNotFoundException.class,
                () -> underTest.findEmployeeById(empId),
                "There is no employee by id " + empId
        );

        verify(employeeMapperHelper, never()).convertEmployeeEntityToEmployee(any(EmployeeEntity.class));
    }
}
