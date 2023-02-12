package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.CustomerDto;
import com.mafoya.oja.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/all")
    public List<CustomerDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.customerService.getAll(authorization);
    }

    @GetMapping("/customers/{id}")
    public CustomerDto getCustomerById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.customerService.getById(authorization, id);

    }

    @PostMapping("/customers")
    public CustomerDto createCustomer(@RequestBody @Valid CustomerDto customerDto, @RequestHeader("authorization") String authorization) {
        return this.customerService.create(authorization, customerDto);
    }

    @PutMapping("/customers/{id}")
    public CustomerDto updateCustomer(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody CustomerDto customerDto) {
        return this.customerService.update(authorization, customerDto, id);


    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.customerService.delete(authorization, id);
    }
}

