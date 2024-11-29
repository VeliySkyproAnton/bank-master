package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.model.entity.Product;
import com.stepintoprofession.bank.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> viewProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
