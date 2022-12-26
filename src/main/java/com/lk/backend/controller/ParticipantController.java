package com.lk.backend.controller;

import com.lk.backend.dto.ParticipantDTO;
import com.lk.backend.dto.PersonDTO;
import com.lk.backend.entity.Person;
import com.lk.backend.service.ParticipantService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("v1/participant")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ParticipantController {
    ParticipantService service;

    @PostMapping
    public void create(@RequestBody @Valid ParticipantDTO dto) {
        service.create(dto);
    }

    @PostMapping("{email}")
    public void addLegalRepresentative(HttpServletRequest request, @RequestBody PersonDTO personDTO, @PathVariable String email) throws IOException {
        log.info("A request for the addLegalRepresentative method was received");
//        log.info(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
//        PersonDTO person = new PersonDTO();
        log.info("Received: " + personDTO + email);
        service.addLegalRepresentative(personDTO, email);
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
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
