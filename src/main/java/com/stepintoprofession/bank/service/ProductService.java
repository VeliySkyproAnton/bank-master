package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.mapper.ProductMapper;
import com.stepintoprofession.bank.model.dto.ProductDto;
import com.stepintoprofession.bank.model.entity.Product;
import com.stepintoprofession.bank.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public List<ProductDto> listProducts() {
        return productMapper.entityListToDtoList(productRepository.findAll());
    }
}
