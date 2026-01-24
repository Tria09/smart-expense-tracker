package in.codingstreams.etuserauthservice.utils;

import in.codingstreams.etuserauthservice.constant.LoggingConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class JwtUtils {

    public static final String ISSUER = "ET_USER_AUTH_SERVICE";
    private static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();

    public String generateAccessToken(String email) {
        var issuedAt = new Date();
        var expiration = DateUtils.addMinutes(issuedAt, 15);

        return Jwts.builder()
                .issuer(ISSUER)
                .subject(email)
                .id(UUID.randomUUID().toString())
                .issuedAt(issuedAt)
                .expiration(expiration)
                .signWith(SECRET_KEY)
                .compact();
    }

    public Optional<String> getUsernameFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(SECRET_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return Optional.ofNullable(claims.getSubject());
        } catch (JwtException | IllegalArgumentException e) {
            log.error("Invalid JWT Token");
            return Optional.empty();
        }
    }

    public boolean validateToken(String token, String username) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(SECRET_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            return claims.getSubject().equals(username) && claims.getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
