package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.model.Product;
import com.stepintoprofession.bank.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> viewProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
