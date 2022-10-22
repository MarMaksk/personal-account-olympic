package com.lk.backend.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
