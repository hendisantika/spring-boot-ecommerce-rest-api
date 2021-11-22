package com.hendisantika.service;

import com.hendisantika.entity.Category;
import com.hendisantika.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/21
 * Time: 04.00
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @PreAuthorize("hasRole('ROLE_USER')")
    @Transactional
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @Transactional
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);

        return categoryRepository.save(category);
    }
}
