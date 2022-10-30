package com.lk.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.lk.backend.entity.Passport} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassportDTO implements Serializable {

    private Long id;
    @Size(min = 2, max = 2)
    private String series;
    @Size(min = 7, max = 7)
    private String number;
    @Size(min = 14, max = 14)
    private String identityNumber;
}