package com.lk.backend.controller;

import com.lk.backend.dto.AddressDTO;
import com.lk.backend.dto.PassportDTO;
import com.lk.backend.entity.Passport;
import com.lk.backend.service.AddressService;
import com.lk.backend.service.ParticipantService;
import com.lk.backend.service.PassportService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/passport")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PassportController {
    PassportService service;

    @PostMapping
    public void create(@RequestBody @Valid PassportDTO dto) {
        service.create(dto);
    }

    @GetMapping("/{identityNumber}")
    public PassportDTO findByIdentityNumber(@PathVariable String identityNumber) {
        return service.find(identityNumber);
    }

    @GetMapping("/{series}/{number}")
    public PassportDTO findBySeriesAndNumber(@PathVariable String series, @PathVariable String number) {
        return service.findBySeriesAndNumber(series, number);
    }

    @PutMapping
    public PassportDTO update(@RequestBody @Valid PassportDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
