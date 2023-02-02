package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.NavigationDto;
import com.mafoya.oja.model.Navigation;
import com.mafoya.oja.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class NavigationController {

    @Autowired
    private NavigationService navigationService;

    @GetMapping("/navigations/all")
    public List<Navigation> findAll(@RequestHeader("authorization") String authorization) {
        return this.navigationService.getAll(authorization);
    }

    @GetMapping("/navigations/{id}")
    public Optional<Navigation> getNavigationById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.navigationService.getById(authorization, id);

    }

    @PostMapping("/navigations")
    public Navigation createNavigation(@RequestBody @Valid NavigationDto NavigationDto, @RequestHeader("authorization") String authorization) {
        return this.navigationService.create(authorization, NavigationDto);
    }

    @PutMapping("/navigations/{id}")
    public Navigation updateNavigation(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Navigation Navigation) {
        return this.navigationService.update(authorization, Navigation, id);


    }

    @DeleteMapping("/Navigations/{id}")
    public void deleteNavigation(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.navigationService.delete(authorization, id);
    }
}
