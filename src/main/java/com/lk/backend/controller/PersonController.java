package com.lk.backend.controller;

import com.lk.backend.dto.AddressDTO;
import com.lk.backend.dto.PersonDTO;
import com.lk.backend.service.AddressService;
import com.lk.backend.service.PersonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/person")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PersonController {
    PersonService service;

    @PostMapping
    public void create(@RequestBody @Valid PersonDTO dto) {
        service.create(dto);
    }

    @GetMapping("/{id}")
    public PersonDTO find(@PathVariable String id) {
        return service.find(id);
    }

    @GetMapping("/{firstName}/{secondName}/{lastName}")
    public PersonDTO findByFio(@PathVariable String firstName,
                               @PathVariable String secondName,
                               @PathVariable String lastName) {
        return service.findByFio(firstName, secondName, lastName);
    }

    @PutMapping
    public PersonDTO update(@RequestBody @Valid PersonDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
