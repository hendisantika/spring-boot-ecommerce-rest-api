package com.hendisantika.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/21
 * Time: 08.38
 */
@Getter
@AllArgsConstructor
public class AuthenticationResponse {
    private final String token;
}
