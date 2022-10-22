package com.lk.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A DTO for the {@link com.lk.backend.entity.Participant} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto implements Serializable {
    private PersonDto person;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date birthday;
    private AddressDto address;
    @Email
    private String email;
    private String educationalInstitution;
    private PersonDto legalRepresentative;
    private Set<SpecializationDto> specializations = new LinkedHashSet<>();
}