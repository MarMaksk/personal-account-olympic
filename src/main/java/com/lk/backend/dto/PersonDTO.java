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
    private Long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private PassportDTO passport;

    private String number;

    public PersonDTO(String firstName, String secondName, String lastName, PassportDTO passport, String number) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.passport = passport;
        this.number = number;
    }

    public PersonDTO(String firstName, String secondName, String lastName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    public PersonDTO(Long id, String firstName, String secondName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }
}