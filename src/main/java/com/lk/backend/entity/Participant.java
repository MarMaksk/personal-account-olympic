package com.lk.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
public class Participant extends AbstractEntity {

    @OneToOne(cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Person person;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date birthday;

    @OneToOne(cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Address address;

    @Email
    @Column(unique = true)
    private String email;

    private String educationalInstitution;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "legalRepresentative_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Person legalRepresentative;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "participant_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Specialization> specializations = new LinkedHashSet<>();
}
