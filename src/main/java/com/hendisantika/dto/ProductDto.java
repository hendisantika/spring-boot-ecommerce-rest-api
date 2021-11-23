package com.hendisantika.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 06.21
 */
@Data
public class ProductDto {
    @NotNull(message = "name is required")
    @Size(message = "name must be equal to or lower than 300", min = 1, max = 300)
    private String name;

    @NotNull
    @Size(message = "Currency must be in ISO 4217 format", min = 3, max = 3)
    private String currency;

    @NotNull(message = "name is required")
    @Min(0)
    private Double price;

}
