package com.hendisantika.api.controller;

import com.hendisantika.api.assembler.ProductResourceAssembler;
import com.hendisantika.entity.Category;
import com.hendisantika.entity.Product;
import com.hendisantika.exception.NotFoundException;
import com.hendisantika.service.CategoryService;
import com.hendisantika.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 06.14
 */
@RestController
@RequestMapping(path = "/categories/{categoryid}/products")
public class CategoryProductsController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductResourceAssembler productResourceAssembler;

    @Autowired
    private PagedResourcesAssembler<Product> pagedResourcesAssembler;

    @GetMapping
    public ResponseEntity<?> retrieveAllProducts(@PathVariable Long categoryid, Pageable pageable) {
        // Getting the requiring category; or throwing exception if not found
        final Category category = categoryService.getCategoryById(categoryid)
                .orElseThrow(() -> new NotFoundException("category"));

        // Getting all products in application...
        final Page<Product> products = productService.getAllProducts(category, pageable);

        return ResponseEntity.ok(pagedResourcesAssembler.toEmptyModel(products, productResourceAssembler));
    }

    @PostMapping(path = "/{productid}")
    public ResponseEntity<?> addProduct(@PathVariable Long categoryid, @PathVariable Long productid) {
        // Getting the requiring category; or throwing exception if not found
        final Category category = categoryService.getCategoryById(categoryid)
                .orElseThrow(() -> new NotFoundException("category"));

        // Getting the requiring product; or throwing exception if not found
        final Product product = productService.getProductById(productid)
                .orElseThrow(() -> new NotFoundException("product"));

        // Validating if association does not exist...
        if (productService.hasCategory(product, category)) {
            throw new IllegalArgumentException("product " + product.getId() + " already contains category " + category.getId());
        }

        // Associating product with category...
        productService.addCategory(product, category);

        return ResponseEntity.status(HttpStatus.CREATED).body(productResourceAssembler.toModel(product));
    }

    @DeleteMapping(path = "/{productid}")
    public ResponseEntity<?> removeProduct(@PathVariable Long categoryid, @PathVariable Long productid) {
        // Getting the requiring category; or throwing exception if not found
        final Category category = categoryService.getCategoryById(categoryid)
                .orElseThrow(() -> new NotFoundException("category"));

        // Getting the requiring product; or throwing exception if not found
        final Product product = productService.getProductById(productid)
                .orElseThrow(() -> new NotFoundException("product"));

        // Validating if association does not exist...
        if (!productService.hasCategory(product, category)) {
            throw new IllegalArgumentException("product " + product.getId() + " does not contain category " + category.getId());
        }

        // Dis-associating product with category...
        productService.removeCategory(product, category);

        return ResponseEntity.noContent().build();
    }
}
