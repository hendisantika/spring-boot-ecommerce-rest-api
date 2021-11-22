package com.hendisantika.service;

import com.hendisantika.entity.Category;
import com.hendisantika.entity.Product;
import com.hendisantika.repository.ProductRepository;
import com.hendisantika.util.CurrencyExchangeCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/21
 * Time: 04.03
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CurrencyExchangeCommand currencyExchangeCommand;

    @PreAuthorize("hasRole('ROLE_USER')")
    @Transactional
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @Transactional
    public Page<Product> getAllProducts(Category category, Pageable page) {
        return productRepository.findByAssociatedWithCategory(category.getId(), page);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @Transactional
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
