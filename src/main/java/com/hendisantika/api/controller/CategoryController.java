package com.hendisantika.api.controller;

import com.hendisantika.api.assembler.CategoryResourceAssembler;
import com.hendisantika.dto.CategoryDto;
import com.hendisantika.entity.Category;
import com.hendisantika.exception.NotFoundException;
import com.hendisantika.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> retrieveCategory(@PathVariable Long id) {
        // Getting the requiring category; or throwing exception if not found
        final Category category = categoryService.getCategoryById(id)
                .orElseThrow(() -> new NotFoundException("category"));

        return ResponseEntity.ok(categoryResourceAssembler.toResource(category));
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryDto request) {
        // Creating a new category in the application...
        final Category category = categoryService.createCategory(request.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResourceAssembler.toResource(category));
    }
}
