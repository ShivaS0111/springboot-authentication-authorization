package biz.craftline.server.domain.service;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;


public interface JWTService {

    public String extractUsername(String token);

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    public String generateToken(UserDetails userDetails) ;

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    public long getExpirationTime();

    String buildToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            long expiration
    ) ;

    public boolean isTokenValid(String token, UserDetails userDetails) ;

    boolean isTokenExpired(String token);

    Date extractExpiration(String token) ;

    Claims extractAllClaims(String token) ;
}

