package com.hendisantika.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/21
 * Time: 08.36
 */
@Data
public class CredentialsDto {
    @NotNull(message = "username is required")
    @Size(message = "username must be equal to or lower than 50", min = 1, max = 50)
    private String username;

    @NotNull(message = "password is required")
    @Size(message = "password must be equal to or lower than 50", min = 1, max = 50)
    private String password;

}
