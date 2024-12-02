package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.exception.ServiceException;
import com.stepintoprofession.bank.mapper.ProductMapper;
import com.stepintoprofession.bank.model.dto.AccountDto;
import com.stepintoprofession.bank.model.dto.ProductDto;
import com.stepintoprofession.bank.model.dto.UserDto;
import com.stepintoprofession.bank.model.entity.Product;
import com.stepintoprofession.bank.model.entity.Property;
import com.stepintoprofession.bank.model.entity.User;
import com.stepintoprofession.bank.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
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

    public ProductDto createProduct(ProductDto productDto) {
        return productMapper.entityToDto(productRepository.save(productMapper.dtoToEntity(productDto)));
    }

    public ProductDto getProduct(Integer id) {
        return productMapper.entityToDto(productRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Продукт отсутствует", HttpStatus.NOT_FOUND)));
    }

    public ProductDto deleteProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Продукт отсутствует", HttpStatus.NOT_FOUND));
        if(product.isDeleted()) {
            throw new ServiceException("Продукт был удален ранее", HttpStatus.BAD_REQUEST);
        }
        product.setDeleted(true);
        return productMapper.entityToDto(productRepository.save(product));
    }
}
