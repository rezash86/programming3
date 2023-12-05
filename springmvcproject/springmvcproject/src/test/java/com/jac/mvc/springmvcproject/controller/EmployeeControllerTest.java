package com.jac.mvc.springmvcproject.controller;

import com.jac.mvc.springmvcproject.domain.Employee;
import com.jac.mvc.springmvcproject.dto.EmployeeDTO;
import com.jac.mvc.springmvcproject.mapper.EmployeeMapperHelper;
import com.jac.mvc.springmvcproject.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = EmployeeController.class )
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private EmployeeMapperHelper employeeMapperHelper;

    @Test
    void test_whenCallGetAllEmployees_return200_withData() throws Exception {
        //arrange
        Employee emp1 = Employee.builder().id(1L).firstName("A").lastName("B").email("a.b@g.com").build();
        var expectedEmpList = List.of(emp1);

        EmployeeDTO empDTO1 = EmployeeDTO.builder().id(1L).firstName("A").lastName("B").email("a.b@g.com").build();
        var expectedEmpDTOList = List.of(empDTO1);

        Mockito.when(employeeService.getAllEmployees()).thenReturn(expectedEmpList);
        Mockito.when(employeeMapperHelper.convertEmployeeListToEmployeeDTOList(expectedEmpList)).thenReturn(expectedEmpDTOList);

        mockMvc.perform(get("/employee/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("list-employees"))
                .andExpect(model().attribute("employees", expectedEmpDTOList))
                .andDo(print());
    }

}
