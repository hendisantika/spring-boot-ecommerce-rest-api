package com.hendisantika.api.resource;

import org.springframework.hateoas.RepresentationModel;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/21
 * Time: 08.26
 */
public class CategoryResource extends RepresentationModel {

    private final String name;

    public CategoryResource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
