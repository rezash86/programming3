package com.jac.mvc.springmvcproject.service;

import com.jac.mvc.springmvcproject.domain.Employee;
import com.jac.mvc.springmvcproject.entity.EmployeeEntity;
import com.jac.mvc.springmvcproject.mapper.EmployeeMapperHelper;
import com.jac.mvc.springmvcproject.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl underTest;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapperHelper employeeMapperHelper;

    @Test
    void test_getAllEmployees_returnList(){
        //arrange
        // when I call method (findAll) in the employeeRepository, I expect to have
        // a list of Employee => MY EXPECTATION of calling a mock dependency
        List<EmployeeEntity> employeeEntityList =
                List.of(EmployeeEntity.builder().id(1L).firstName("A").lastName("AA").email("a@gm.com").build(),
                        EmployeeEntity.builder().id(1L).firstName("B").lastName("BB").email("b@gm.com").build());

        List<Employee> employeeList =
                List.of(Employee.builder().id(1L).firstName("A").lastName("AA").email("a@gm.com").build(),
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
        ///TODO
    }

    @Test
    void test_saveEmployee_returnLong(){
        ///TODO
    }
}
