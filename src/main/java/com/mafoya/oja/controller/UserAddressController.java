package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.UserAddressDto;
import com.mafoya.oja.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/userAddresss/all")
    public List<UserAddressDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.userAddressService.getAll(authorization);
    }

    @GetMapping("/userAddresss/{id}")
    public UserAddressDto getUserAddressById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.userAddressService.getById(authorization, id);

    }

    @PostMapping("/userAddresss")
    public UserAddressDto createUserAddress(@RequestBody @Valid UserAddressDto userAddressDto, @RequestHeader("authorization") String authorization) {
        return this.userAddressService.create(authorization, userAddressDto);
    }

    @PutMapping("/userAddresss/{id}")
    public UserAddressDto updateUserAddress(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody UserAddressDto userAddress) {
        return this.userAddressService.update(authorization, userAddress, id);


    }

    @DeleteMapping("/userAddresss/{id}")
    public void deleteUserAddress(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.userAddressService.delete(authorization, id);
    }
}

