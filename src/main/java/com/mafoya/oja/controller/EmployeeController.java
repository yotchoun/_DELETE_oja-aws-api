package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Employee;
import com.mafoya.oja.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/all")
    public List<Employee> findAll(@RequestHeader("authorization") String authorization) {
        return this.employeeService.getAll(authorization);
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.employeeService.getById(authorization, id);

    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestHeader("authorization") String authorization, @RequestBody Employee employee) {
        return this.employeeService.create(authorization, employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Employee employee) {
        return this.employeeService.update(authorization, employee, id);


    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.employeeService.delete(authorization, id);
    }
}
