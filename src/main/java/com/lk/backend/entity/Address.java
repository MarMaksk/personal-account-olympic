package com.lk.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Address extends AbstractEntity {

    @Column(nullable = false)
    private String area;
    @Column(nullable = false)
    private String district;
    @Column(nullable = false)
    private String locality;

    private String street;

    private int house;

    private int corps;

    private int flat;

}
