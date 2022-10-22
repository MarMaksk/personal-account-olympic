package com.lk.backend.dto;

import com.lk.backend.dto.PassportDto;
import com.lk.backend.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Person} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto implements Serializable {
    private String firstName;
    private String secondName;
    private String lastName;
    private PassportDto passport;
}