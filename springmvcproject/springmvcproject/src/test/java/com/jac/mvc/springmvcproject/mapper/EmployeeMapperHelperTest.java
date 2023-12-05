package com.jac.mvc.springmvcproject.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.mvc.springmvcproject.domain.Employee;
import com.jac.mvc.springmvcproject.entity.EmployeeEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EmployeeMapperHelperTest {

    @InjectMocks
    private EmployeeMapperHelper underTest;

    @Mock
    private ObjectMapper objectMapper;

    @Test
    void test_convertEmployeeEntityListToEmployeeList_returnsEmployeeList(){
        //arrange
        EmployeeEntity empEnt1 = EmployeeEntity.builder().id(1L).firstName("A").lastName("AA").email("AA@g.com").build();
        EmployeeEntity empEnt2 = EmployeeEntity.builder().id(1L).firstName("B").lastName("BB").email("BB@g.com").build();
        List<EmployeeEntity> employeeEntities = List.of(empEnt1,empEnt2);

        Employee emp1 = Employee.builder().id(1L).firstName("A").lastName("AA").email("AA@g.com").build();
        Employee emp2 = Employee.builder().id(1L).firstName("B").lastName("BB").email("BB@g.com").build();

        Mockito.when(objectMapper.convertValue(empEnt1, Employee.class)).thenReturn(emp1);
        Mockito.when(objectMapper.convertValue(empEnt2, Employee.class)).thenReturn(emp2);

        var expected = List.of(emp1, emp2);

        //real
        var actual = underTest.convertEmployeeEntityListToEmployeeList(employeeEntities);
        //verification

        assertEquals(expected, actual);
        verify(objectMapper, times(2)).convertValue(any(EmployeeEntity.class), eq(Employee.class));
    }

    @Test
    void test_convertEmployeeToEmployeeEntity_returnsEmpEntity(){
        //arrange
        Employee emp = Employee.builder().id(1L).firstName("A").lastName("AA").email("AA@g.com").build();
        EmployeeEntity empEnt = EmployeeEntity.builder().id(1L).firstName("A").lastName("AA").email("AA@g.com").build();

        Mockito.when(objectMapper.convertValue(emp, EmployeeEntity.class)).thenReturn(empEnt);
        //real
        var actual = underTest.convertEmployeeToEmployeeEntity(emp);
        //verify

        assertEquals(empEnt, actual);

    }
}
