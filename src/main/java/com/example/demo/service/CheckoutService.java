package com.example.demo.service;

import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseDto;

public interface CheckoutService {
    PurchaseDto placeOrder(Purchase purchase);
}
