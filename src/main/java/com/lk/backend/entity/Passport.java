package com.lk.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "Passport", indexes = {
        @Index(name = "idx_passport_identitynumber", columnList = "identityNumber")
})
@Data
@NoArgsConstructor
public class Passport extends AbstractEntity {

    @Column(nullable = false, length = 2)
    private String series;
    @Column(nullable = false, unique = true, length = 7)
    private String number;
    @Column(nullable = false, length = 14)
    private String identityNumber;

}
