package com.hendisantika.api.controller;

import com.hendisantika.api.assembler.CategoryResourceAssembler;
import com.hendisantika.entity.Category;
import com.hendisantika.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/21
 * Time: 08.39
 */
@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryResourceAssembler categoryResourceAssembler;

    @GetMapping
    public ResponseEntity<?> retrieveAllCategories() {
        // Getting all categories in application...
        final List<Category> categories = categoryService.getAllCategories();

        return ResponseEntity.ok(categoryResourceAssembler.toResources(categories));
    }
}
