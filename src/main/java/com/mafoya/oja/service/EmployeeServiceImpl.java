package com.mafoya.oja.service;

import com.mafoya.oja.dto.EmployeeDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.mapper.OjaMapper;
import com.mafoya.oja.model.Employee;
import com.mafoya.oja.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(String authorization, EmployeeDto employeeDto) {
        return employeeRepository.save(OjaMapper.mapEmployeeToDo(employeeDto));
    }

    @Override
    public Employee update(String authorization, Employee employee, String id) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            employeeOptional.get().setFirstName(employee.getFirstName());
            employeeOptional.get().setLastName(employee.getLastName());
            employeeOptional.get().setEmail(employee.getEmail());
            employeeOptional.get().setNumber(employee.getNumber());
            employeeOptional.get().setDepartment(employee.getDepartment());

            return employeeRepository.save(employeeOptional.get());
        }
        throw new DataNotFoundException("Employee Id not found");
    }

    @Override
    public Optional<Employee> getById(String authorization, String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAll(String authorization) {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        employeeRepository.deleteById(id);
    }

}