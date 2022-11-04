package com.lk.backend.controller;

import com.lk.backend.dto.AddressDTO;
import com.lk.backend.entity.SDOUser;
import com.lk.backend.service.AddressService;
import com.lk.backend.service.SDOUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("sdouser")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SDOUserController {
    SDOUserService service;

    @PostMapping("/{username}/{specializationCode}/{birthdayYear}/{passportNumber}")
    public void create(@PathVariable String username,
                       @PathVariable String specializationCode,
                       @PathVariable String birthdayYear,
                       @PathVariable String passportNumber) throws Exception {
        service.create(username, specializationCode, birthdayYear, passportNumber);
    }

    @GetMapping("/{login}")
    public SDOUser find(@PathVariable String login) {
        return service.find(login);
    }

    @PutMapping
    public SDOUser update(@RequestBody @Valid SDOUser user) {
        return service.update(user);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
