package com.lk.backend.controller;

import com.lk.backend.dto.SpecializationDTO;
import com.lk.backend.service.SpecializationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/specialization")
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

    @GetMapping
    public List<SpecializationDTO> findAll() {
        return service.findAll();
    }

    @PutMapping
    public SpecializationDTO update(@Valid @RequestBody SpecializationDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
