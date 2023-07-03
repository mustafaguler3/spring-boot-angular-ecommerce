package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
    private BigDecimal unitPrice;
    private int quantity;
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
























