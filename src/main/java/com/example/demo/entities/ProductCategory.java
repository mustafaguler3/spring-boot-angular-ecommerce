package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private Set<Product> products;
}






















