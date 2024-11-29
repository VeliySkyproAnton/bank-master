package com.stepintoprofession.bank.tools;

import com.stepintoprofession.bank.model.entity.Product;
import com.stepintoprofession.bank.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        long count = productRepository.count();
        if(count == 0) {
            productRepository.save(Product.CREATE_ACCOUNT);
        }
    }
}
