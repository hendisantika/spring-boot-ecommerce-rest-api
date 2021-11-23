package com.hendisantika.api.controller;

import com.hendisantika.api.assembler.CategoryResourceAssembler;
import com.hendisantika.entity.Category;
import com.hendisantika.exception.NotFoundException;
import com.hendisantika.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 06.44
 */
@RestController
@RequestMapping(path = "/categories/{parentid}/subcategories")
public class CategorySubcategoriesController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryResourceAssembler categoryResourceAssembler;

    @GetMapping
    public ResponseEntity<?> retrieveAllSubcategories(@PathVariable Long parentid) {
        // Getting the requiring category; or throwing exception if not found
        final Category parent = categoryService.getCategoryById(parentid)
                .orElseThrow(() -> new NotFoundException("parent category"));

        // Getting all categories in application...
        final Set<Category> subcategories = parent.getChildCategories();

        return ResponseEntity.ok(categoryResourceAssembler.toModel(subcategories));
    }

    @PostMapping(path = "/{childid}")
    public ResponseEntity<?> addSubcategory(@PathVariable Long parentid, @PathVariable Long childid) {
        // Getting the requiring category; or throwing exception if not found
        final Category parent = categoryService.getCategoryById(parentid)
                .orElseThrow(() -> new NotFoundException("parent category"));

        // Getting the requiring category; or throwing exception if not found
        final Category child = categoryService.getCategoryById(childid)
                .orElseThrow(() -> new NotFoundException("child category"));

        // Validating if association does not exist...
        if (categoryService.isChildCategory(child, parent)) {
            throw new IllegalArgumentException("category " + parent.getId() + " already contains subcategory " + child.getId());
        }

        // Associating parent with subcategory...
        categoryService.addChildCategory(child, parent);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResourceAssembler.toModel(parent));
    }

    @DeleteMapping(path = "/{childid}")
    public ResponseEntity<?> removeSubcategory(@PathVariable Long parentid, @PathVariable Long childid) {
        // Getting the requiring category; or throwing exception if not found
        final Category parent = categoryService.getCategoryById(parentid)
                .orElseThrow(() -> new NotFoundException("parent category"));

        // Getting the requiring category; or throwing exception if not found
        final Category child = categoryService.getCategoryById(childid)
                .orElseThrow(() -> new NotFoundException("child category"));

        // Validating if association exists...
        if (!categoryService.isChildCategory(child, parent)) {
            throw new IllegalArgumentException("category " + parent.getId() + " does not contain subcategory " + child.getId());
        }

        // Dis-associating parent with subcategory...
        categoryService.removeChildCategory(child, parent);

        return ResponseEntity.noContent().build();
    }
}
