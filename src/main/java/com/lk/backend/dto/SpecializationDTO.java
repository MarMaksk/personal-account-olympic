package com.lk.backend.dto;

import com.lk.backend.entity.Specialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Specialization} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecializationDTO implements Serializable {
    private String code;
    private String name;
    private String subject;
    private int countOfPlaces;
}