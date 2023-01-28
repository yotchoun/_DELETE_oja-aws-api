package com.mafoya.oja.mapper;

import com.mafoya.oja.dto.EmployeeDto;
import com.mafoya.oja.model.Employee;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;

import static org.slf4j.LoggerFactory.getLogger;

public class OjaMapper {

    private static final Logger LOGGER = getLogger(OjaMapper.class);

    public static EmployeeDto mapEmployeeToDto(Employee employeeDo) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employeeDo, employeeDto);
        return employeeDto;
    }

    public static Employee mapEmployeeToDo(EmployeeDto employeeDto) {
        Employee employeeDo = new Employee();
        BeanUtils.copyProperties(employeeDto, employeeDo);
        return employeeDo;
    }
}
