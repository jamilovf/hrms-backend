package com.jamilovf.hrms.security;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 86400000; // 1 day
    public static final long PASSWORD_RESET_EXPIRATION_TIME = 3600000; // 1 hour
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String TOKEN_SECRET = "xh27grfvrbwto9g8wsd13zl";
}
