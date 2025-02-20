package com.kristom.PlantDailyReportApp.helper;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.AccessDeniedException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

public class JwtHelper {

    private static final int EXPIRATION_MINUTES = 60;

    private static final String personalKey = "PgtVzehOPLnvUjVHTJqpO3WgfPedeh3uGwrnF4Fd7z4x";

    private static final byte[] secretKeyBytes = Base64.getDecoder().decode(personalKey.getBytes());

    private static final SecretKey secretKey = Keys.hmacShaKeyFor(secretKeyBytes);


    public static String extractUsername(String token) {
        return getTokenBody(token).getSubject();
    }

    public static Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public static String generateToken(String username) {
        Instant now = Instant.now();
        return Jwts.builder()
                .subject(username)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(EXPIRATION_MINUTES, ChronoUnit.MINUTES)))
                .signWith(secretKey, Jwts.SIG.HS256)
                .compact();
    }

    private static Claims getTokenBody(String token){
        try {
            return Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch ( SignatureException | ExpiredJwtException e) {
            try {
                throw new AccessDeniedException("Access denied: " + e.getMessage());
            } catch (AccessDeniedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private static boolean isTokenExpired(String token){
        Claims claims = getTokenBody(token);
        return  claims.getExpiration().before(new Date());
    }


}
