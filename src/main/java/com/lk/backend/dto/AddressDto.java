package com.lk.backend.dto;

import com.lk.backend.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Address} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto implements Serializable {
    private String area;
    private String district;
    private String locality;
    private String street;
    private int house;
    private int corps;
    private int flat;
}