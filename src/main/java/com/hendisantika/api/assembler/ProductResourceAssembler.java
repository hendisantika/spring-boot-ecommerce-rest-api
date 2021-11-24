package com.hendisantika.api.assembler;

import com.hendisantika.api.controller.ProductController;
import com.hendisantika.api.resource.CategoryResource;
import com.hendisantika.api.resource.ProductResource;
import com.hendisantika.entity.Product;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 06.15
 */
@Component
public class ProductResourceAssembler extends RepresentationModelAssemblerSupport<Product, ProductResource> {

    @Autowired
    private CategoryResourceAssembler categoryResourceAssembler;

    public ProductResourceAssembler() {
        super(ProductController.class, ProductResource.class);
    }

    @Override
    protected ProductResource instantiateModel(Product entity) {
        return new ProductResource(
                entity.getName(),
                Product.CURRENCY,
                entity.getPrice(),
                !Collections.isEmpty(entity.getCategories()) ?
                        (List<CategoryResource>) categoryResourceAssembler.toCollectionModel(entity.getCategories())
                        : null,
                entity.getUser().getUsername()
        );
    }

    @Override
    public ProductResource toModel(Product entity) {
        return createModelWithId(entity.getId(), entity);
    }
}
