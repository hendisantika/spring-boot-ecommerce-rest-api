package com.hendisantika.util;

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
}
