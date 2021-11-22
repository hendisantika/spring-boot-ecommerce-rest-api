package com.hendisantika.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/21
 * Time: 03.53
 */
@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AbstractEntity {

    public static final String CURRENCY = "EUR";

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "app_product_category", joinColumns = @JoinColumn(name = "productid"), inverseJoinColumns =
    @JoinColumn(name = "categoryid"))
    private Set<Category> categories;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false, updatable = false)
    private User user;
}
