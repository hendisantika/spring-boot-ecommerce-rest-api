package com.hendisantika.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/21
 * Time: 03.58
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String entity) {
        super(entity + " not found");
    }
}
