package com.lk.backend.controller;

import com.lk.backend.dto.AddressDTO;
import com.lk.backend.service.AddressService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("address")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AddressController {

    AddressService service;

    @PostMapping
    public void create(@RequestBody @Valid AddressDTO dto) {
        service.create(dto);
    }

    @GetMapping("/{id}")
    public AddressDTO find(@PathVariable String id) {
        return service.find(id);
    }

    @PutMapping
    public AddressDTO update(@RequestBody @Valid AddressDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }

}
