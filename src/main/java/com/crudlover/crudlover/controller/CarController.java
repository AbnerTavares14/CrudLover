package com.crudlover.crudlover.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudlover.crudlover.dto.CarDTO;
import com.crudlover.crudlover.model.Car;
import com.crudlover.crudlover.service.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class CarController {
    @Autowired
    private CarService service;

    @GetMapping
    public List<Car> findAll() {
        return service.findAll();
    }

    @PostMapping
    public void create(@RequestBody @Valid CarDTO req) {
        service.create(req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req) {
        service.update(id, req);
    }

}
