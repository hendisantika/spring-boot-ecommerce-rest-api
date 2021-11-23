package com.hendisantika.api.controller;

import com.hendisantika.api.assembler.ProductResourceAssembler;
import com.hendisantika.entity.Product;
import com.hendisantika.entity.User;
import com.hendisantika.exception.NotFoundException;
import com.hendisantika.service.ProductService;
import com.hendisantika.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 06.19
 */
@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ProductResourceAssembler productResourceAssembler;

    @Autowired
    private PagedResourcesAssembler<Product> pagedResourcesAssembler;

    @GetMapping
    public ResponseEntity<?> retrieveAllProducts(Pageable pageable) {
        // Getting all products in application...
        final Page<Product> products = productService.getAllProducts(pageable);

        return ResponseEntity.ok(pagedResourcesAssembler.toResource(products, productResourceAssembler));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> retrieveProduct(@PathVariable Long id) {
        // Getting the requiring product; or throwing exception if not found
        final Product product = productService.getProductById(id)
                .orElseThrow(() -> new NotFoundException("product"));

        return ResponseEntity.ok(productResourceAssembler.toResource(product));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductDto request) {
        // Gets the current logged-in User...
        final User user = securityService.getCurrentUser();
        // Creating a new product in the application...
        final Product product = productService.createProduct(request.getName(), request.getCurrency(),
                request.getPrice(), user);

        return ResponseEntity.status(HttpStatus.CREATED).body(productResourceAssembler.toResource(product));
    }
}
