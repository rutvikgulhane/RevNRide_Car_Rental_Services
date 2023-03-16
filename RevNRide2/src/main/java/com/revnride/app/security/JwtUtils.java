package com.revnride.app.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.revnride.app.service.impl.UserDetailsimpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

// Class security use to Generate Token JWT.
@Component
public class JwtUtils {
    /**Logger use to logger on server.*/
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${jwtSecret}")
    /**SecretKey*/
    private String jwtSecret;
    /**Time experience token JWT.*/
    @Value("${jwtExpirationMs}")
    private int jwtExpirationMs;

    /**Method used to generate token JWT.*/
    public String generateJwtToken(Authentication authentication) {
        UserDetailsimpl userDetails = (UserDetailsimpl) authentication.getPrincipal();
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
    /** Method to get username*/
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    /**Method validate /token JWT.*/
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (ExpiredJwtException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("Invalid token: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Token is expired: {}", e.getMessage());
        } catch (SignatureException e) {
            logger.error("Token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT string is empty : {}", e.getMessage());
        }
        return false;
    }

}
