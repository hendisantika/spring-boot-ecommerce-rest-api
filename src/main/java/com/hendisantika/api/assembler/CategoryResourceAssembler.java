package com.hendisantika.api.assembler;

import com.hendisantika.api.controller.CategoryController;
import com.hendisantika.api.resource.CategoryResource;
import com.hendisantika.entity.Category;
import com.hendisantika.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/21
 * Time: 08.31
 */
@Component
public class CategoryResourceAssembler extends RepresentationModelAssemblerSupport<Category, CategoryResource> {

    @Autowired
    private ProductService productService;

    public CategoryResourceAssembler() {
        super(CategoryController.class, CategoryResource.class);
    }

    @Override
    protected CategoryResource instantiateResource(Category entity) {
        return new CategoryResource(entity.getName());
    }

    @Override
    public CategoryResource toResource(Category entity) {
        CategoryResource resource = createResourceWithId(entity.getId(), entity);
        if (entity.getParent() != null) {
            resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryController.class).retrieveCategory(entity.getParent().getId())).withRel("parent"));
        }
        if (entity.getChildCategories() != null) {
            resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategorySubcategoriesController.class).retrieveAllSubcategories(entity.getId())).withRel("subcategories"));
        }
        if (productService.hasProductsAssociated(entity)) {
            resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryProductsController.class).retrieveAllProducts(entity.getId(), null)).withRel("products"));
        }

        return resource;
    }
}
