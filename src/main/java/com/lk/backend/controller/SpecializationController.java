package com.lk.backend.controller;

import com.lk.backend.dto.AddressDTO;
import com.lk.backend.dto.SpecializationDTO;
import com.lk.backend.service.AddressService;
import com.lk.backend.service.SpecializationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("specialization")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SpecializationController {
    SpecializationService service;

    @PostMapping
    public void create(@Valid @RequestBody SpecializationDTO dto) {
        service.create(dto);
    }

    @GetMapping("/{code}")
    public SpecializationDTO find(@PathVariable String code) {
        return service.find(code);
    }

    @PutMapping
    public SpecializationDTO update(@Valid @RequestBody SpecializationDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping
    public void delete(SpecializationDTO dto) {
        service.delete(dto);
    }
}
