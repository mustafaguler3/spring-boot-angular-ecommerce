package com.example.demo.controller;

import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseDto;
import com.example.demo.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseDto placeOrder(@RequestBody Purchase purchase){

        PurchaseDto purchaseDto = checkoutService.placeOrder(purchase);

        return purchaseDto;
    }
}

















