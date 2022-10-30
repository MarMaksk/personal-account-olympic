package com.lk.backend.controller;

import com.lk.backend.dto.AddressDTO;
import com.lk.backend.dto.ParticipantDTO;
import com.lk.backend.service.AddressService;
import com.lk.backend.service.ParticipantService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@RestController
@RequestMapping("participant")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ParticipantController {
    ParticipantService service;

    @PostMapping
    public void create(@RequestBody @Valid ParticipantDTO dto) {
        service.create(dto);
    }

    @GetMapping("/{email}")
    public ParticipantDTO find(@PathVariable @Email String email) {
        return service.find(email);
    }

    @GetMapping("/{series}/{number}")
    public ParticipantDTO findByPassportNumber(@PathVariable String series, @PathVariable String number) {
        return service.findByPassportNumber(series, number);
    }

    @GetMapping("/{identityNumber}")
    public ParticipantDTO findByPassportIdentityNumber(@PathVariable String identityNumber) {
        return service.findByPassportIdentityNumber(identityNumber);
    }


    @PutMapping
    public ParticipantDTO update(@RequestBody @Valid ParticipantDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping
    public void delete(@RequestBody ParticipantDTO dto) {
        service.delete(dto);
    }
}
