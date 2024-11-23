package com.stepintoprofession.bank.controller;

import com.stepintoprofession.bank.repository.ProductRepository;
import com.stepintoprofession.bank.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> viewProducts() {
        return ResponseEntity.ok(productService.viewProducts());
    }
}
