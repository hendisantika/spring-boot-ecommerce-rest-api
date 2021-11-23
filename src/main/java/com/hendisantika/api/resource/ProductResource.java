package com.hendisantika.api.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/21
 * Time: 08.29
 */
@Getter
@AllArgsConstructor
public class ProductResource extends RepresentationModel<ProductResource> {

    private final String name;
    private final String currency;
    private final double price;
    private final List<CategoryResource> categories;
    private final String owner;
}
