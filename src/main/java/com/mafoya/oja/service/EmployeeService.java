package com.mafoya.oja.service;


import com.mafoya.oja.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee create(String authorization,Employee employee);
    Employee update(String authorization,Employee employee, String id);
    Optional<Employee> getById(String authorization,String id);
    List<Employee> getAll(String authorization);
    void delete(String authorization,String id);

}
