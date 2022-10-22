package com.lk.backend.dto;

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
public class PersonDTO implements Serializable {
    private String firstName;
    private String secondName;
    private String lastName;
    private PassportDTO passport;
}