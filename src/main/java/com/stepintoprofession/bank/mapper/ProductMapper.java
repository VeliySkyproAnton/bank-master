package com.stepintoprofession.bank.mapper;

import com.stepintoprofession.bank.model.dto.ProductDto;
import com.stepintoprofession.bank.model.entity.Product;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    @IterableMapping(qualifiedByName = "entityToDto")
    public abstract List<ProductDto> entityListToDtoList(List<Product> products);

    @Named("entityToDto")
    public abstract ProductDto entityToDto(Product product);

    public abstract Product dtoToEntity(ProductDto dto);
}
