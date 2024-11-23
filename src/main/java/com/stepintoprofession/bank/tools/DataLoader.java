package com.stepintoprofession.bank.tools;

import com.stepintoprofession.bank.model.Product;
import com.stepintoprofession.bank.model.ProductCategory;
import com.stepintoprofession.bank.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        long count = productRepository.count();
        if(count == 0) {
            productRepository.save(Product.CREATE_ACCOUNT);
        }
    }
}
