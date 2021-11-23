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
 * Time: 08.42
 */
@Data
public class CategoryDto {
    @NotNull(message = "name is required")
    @Size(message = "name must be equal to or lower than 100", min = 1, max = 100)
    private String name;
}
