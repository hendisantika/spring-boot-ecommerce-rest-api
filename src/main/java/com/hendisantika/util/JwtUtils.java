package com.hendisantika.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/21
 * Time: 04.10
 */
public class JwtUtils {
    private static final String TOKEN_SECRET_KEY = "ECommerceAppSecretKey";
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String TOKEN_CLAIM_USERNAME = "username";
    private static final String TOKEN_CLAIM_ROLES = "roles";
    private static final long TOKEN_EXPIRATION = 3_600_000; // 1 hour

    private static String generateToken(final Long userId, final String username, final String userRole) {
        final Date now = new Date();
        final Date exp = new Date(now.getTime() + TOKEN_EXPIRATION);

        String jwtToken =
                Jwts.builder()
                        .setSubject(userId.toString())
                        .claim(TOKEN_CLAIM_USERNAME, username)
                        .claim(TOKEN_CLAIM_ROLES, userRole)
                        .setIssuedAt(now)
                        .setNotBefore(now)
                        .setExpiration(exp)
                        .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET_KEY)
                        .compact();

        return TOKEN_PREFIX + " " + jwtToken;
    }

    private static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(TOKEN_SECRET_KEY)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody();
    }
}
