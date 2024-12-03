package com.stepintoprofession.bank.mapper;

import com.stepintoprofession.bank.exception.ServiceException;
import com.stepintoprofession.bank.model.dto.RequestDto;
import com.stepintoprofession.bank.model.entity.Account;
import com.stepintoprofession.bank.model.entity.Product;
import com.stepintoprofession.bank.model.entity.Request;
import com.stepintoprofession.bank.repository.AccountRepository;
import com.stepintoprofession.bank.repository.ProductRepository;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RequestMapper {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AccountRepository accountRepository;

    @IterableMapping(qualifiedByName = "entityToDto")
    public abstract List<RequestDto> entityListToDtoList(List<Request> requests);

    @Named("entityToDto")
    @Mapping(target = "accountId", source = "account.id")
    @Mapping(target = "productId", source = "product.id")
    public abstract RequestDto entityToDto(Request request);

    @Mapping(target = "account", source = "accountId", qualifiedByName = "findAccount")
    @Mapping(target = "product", source = "productId", qualifiedByName = "findProduct")
    public abstract Request dtoToEntity(RequestDto dto);

    @Named("findAccount")
    Account findAccount(Integer accountId) {
        return accountRepository.findById(accountId).orElseThrow(() -> new ServiceException("Счет отсутствует", HttpStatus.NOT_FOUND));
    }

    @Named("findProduct")
    Product findProduct(Integer productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ServiceException("Продукт отсутствует", HttpStatus.NOT_FOUND));
    }
}
