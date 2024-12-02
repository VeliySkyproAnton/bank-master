package com.stepintoprofession.bank.mapper;

import com.stepintoprofession.bank.model.dto.ProductDto;
import com.stepintoprofession.bank.model.entity.Product;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    @IterableMapping(qualifiedByName = "entityToDto")
    public abstract List<ProductDto> entityListToDtoList(List<Product> products);
    @Mapping(target = "durationInSeconds", source = "duration", qualifiedByName = "durationToSeconds")
    @Named("entityToDto")
    public abstract ProductDto entityToDto(Product product);
    @Mapping(target = "duration", source = "durationInSeconds", qualifiedByName = "secondsToDuration")
    public abstract Product dtoToEntity(ProductDto dto);

    @Named("durationToSeconds")
    public Long durationToSeconds(Duration duration) {
        return duration != null ? duration.toSeconds() : null;
    }

    @Named("secondsToDuration")
    public Duration secondsToDuration(Long seconds) {
        return seconds != null ? Duration.ofSeconds(seconds) : null;
    }
}
