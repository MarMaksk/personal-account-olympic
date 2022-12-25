package com.lk.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@Entity
public class Person extends AbstractEntity {

    private String firstName;

    private String secondName;

    private String lastName;

    private String number;
    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Passport passport;

}
