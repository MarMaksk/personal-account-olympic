package com.lk.backend.payload.request;

import com.lk.backend.annotation.PasswordMatches;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class SignupRequest {

    @NotBlank(message = "Please enter your username")
    private String username;
    @NotBlank(message = "Please enter your password")
    @Size(min = 6)
    private String password;
    @NotBlank(message = "Please confirm your password")
    private String confirmPassword;

}
