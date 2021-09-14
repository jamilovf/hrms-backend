package com.jamilovf.hrms.core.utils;

import com.jamilovf.hrms.security.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class Utils {
    public static boolean hasTokenExpired(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.TOKEN_SECRET)
                .parseClaimsJws(token).getBody();

        Date tokenExpirationDate = claims.getExpiration();
        Date todayDate = new Date();


        return tokenExpirationDate.before(todayDate);
    }

    public static String generateEmailVerificationToken() {
        String token = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET)
                .compact();
        return token;
    }

    public static String generatePasswordResetToken() {
        String token = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.PASSWORD_RESET_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET)
                .compact();
        return token;
    }
}
