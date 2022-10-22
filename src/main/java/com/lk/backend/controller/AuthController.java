package com.lk.backend.controller;

import com.lk.backend.dto.UserDTO;
import com.lk.backend.entity.enums.ERole;
import com.lk.backend.payload.request.LoginRequest;
import com.lk.backend.payload.request.SignupRequest;
import com.lk.backend.payload.response.JWTTokenSuccessResponse;
import com.lk.backend.security.JWTTokenProvider;
import com.lk.backend.security.SecurityConstants;
import com.lk.backend.service.UserService;
import com.lk.backend.validations.ResponseErrorValidation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/avia/auth")
@CrossOrigin(origins = "*")
@PreAuthorize("permitAll()")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AuthController {

    static Logger LOG = LoggerFactory.getLogger(AuthController.class);
    ResponseErrorValidation responseErrorValidation;
    UserService userService;
    AuthenticationManager authenticationManager;
    JWTTokenProvider jwtTokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<Object> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult bindingResult) {
        LOG.info("Authenticating user: {}", loginRequest.getUsername());
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors))
            return errors;
        String jwt = auth(loginRequest.getUsername(), loginRequest.getPassword());
        LOG.info("Authentication successful for user: {}", loginRequest.getUsername());
        return ResponseEntity.ok(new JWTTokenSuccessResponse(true, jwt, loadRoles(loginRequest.getUsername())));
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody SignupRequest signupRequest, BindingResult bindingResult) {
        LOG.info("Registering user: {}", signupRequest.getUsername());
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors))
            return errors;
        userService.createUser(signupRequest);
        String jwt = auth(signupRequest.getUsername(), signupRequest.getPassword());
        LOG.info("Registration successful for user: {}", signupRequest.getUsername());
        return ResponseEntity.ok(new JWTTokenSuccessResponse(true, jwt, loadRoles(signupRequest.getUsername())));
    }

    private String auth(String username, String password) {
        LOG.info("Authenticating user: {}", username);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        LOG.info("Authentication successful for user: {}", username);
        return SecurityConstants.TOKEN_PREFIX + jwtTokenProvider.generateToken(authentication);
    }

    private Set<ERole> loadRoles(String username) {
        LOG.info("Loading roles for user: {}", username);
        UserDTO currentUser = userService.getCurrentUser(username);
        LOG.info("Roles loaded for user: {}", username);
        return currentUser.getRoles();
    }
}
