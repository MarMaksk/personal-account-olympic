package com.lk.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Person extends AbstractEntity {

    private String firstName;

    private String secondName;

    private String lastName;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Passport passport;

}
