package com.lk.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Specialization", indexes = {
        @Index(name = "idx_specialization_code", columnList = "code")
})
@NoArgsConstructor
public class Specialization extends AbstractEntity {

    @Column(unique = true)
    private String code;

    @Column(unique = true)
    private String name;

    private String subject;

    private int countOfPlaces;

}
