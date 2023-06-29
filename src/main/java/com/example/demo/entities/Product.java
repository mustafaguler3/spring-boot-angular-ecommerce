package com.example.demo.entities;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "product")
public class Product {
    private long id;
    private String sku;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private ProductCategory productCategory;
    private BigDecimal unitPrice;
    private String imageUrl;
    private boolean active;
    private int unitsInStock;
    private Date dateCreated;
    @UpdateTimestamp
    private Date lastUpdated;
}























