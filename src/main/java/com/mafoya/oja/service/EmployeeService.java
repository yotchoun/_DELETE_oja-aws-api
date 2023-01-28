package com.mafoya.oja.service;


import com.mafoya.oja.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    /**
     * create new employee
     *
     * @param employee entity
     * @return entity that created
     */
    Employee create(String authorization,Employee employee);

    /**
     * Update employee data
     *
     * @param employee entity
     * @return entity modified
     */
    Employee update(String authorization,Employee employee, String id);


    /**
     * get Employee by id
     *
     * @param id entity id
     * @return Optional entity Employee
     */
    Optional<Employee> getById(String authorization,String id);

    /**
     * Get all entities
     *
     * @return list of entity Employee
     */
    List<Employee> getAll(String authorization);

    void delete(String authorization,String id);

}
