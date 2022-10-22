package com.lk.backend.security;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PUBLIC)
public class SecurityConstants {

    static String SIGN_UP_URLS = "/avia/auth/**";

    static String SECRET = "%AVIATION%PROJECT%AVIATION%PROJECT%";

    public final static String TOKEN_PREFIX = "Bearer ";
    static String HEADER_STRING = "Authorization";
    static String CONTENT_TYPE = "application/json";
    static long EXPIRATION_TIME = 97200_000;

}
