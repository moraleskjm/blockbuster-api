package com.morales.blockbuster.controllers;

import com.morales.blockbuster.dto.RenteeDto;
import com.morales.blockbuster.service.RenteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RenteeController {

    @Autowired
    private RenteeService renteeService;

    @PostMapping("/createrentee")
    public RenteeDto createRentee(@RequestBody RenteeDto dto) {
        return renteeService.createRentee(dto);
    }

    @GetMapping("/rentees")
    public List<RenteeDto> getAllRentees() {
        return renteeService.getAllRentees();
    }

    @GetMapping("/rentees/{id}")
    public RenteeDto getRenteeById(@PathVariable Integer id) {
        return renteeService.getRenteeById(id);
    }

    @DeleteMapping("/rentees/{id}")
    public String deleteRentee(@PathVariable Integer id) {
        return renteeService.deleteRentee(id);
    }
}
