package com.lk.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.lk.backend.entity.Passport} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassportDto implements Serializable {
    @Size(min = 2, max = 2)
    private String series;
    @Size(min = 7, max = 7)
    private String number;
    @Size(min = 14, max = 14)
    private String identityNumber;
}