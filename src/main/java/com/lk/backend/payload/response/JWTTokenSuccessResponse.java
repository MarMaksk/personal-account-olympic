package com.lk.backend.payload.response;

import com.lk.backend.entity.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class JWTTokenSuccessResponse {

    private boolean success;
    private String token;
    private Set<ERole> roles;

}
