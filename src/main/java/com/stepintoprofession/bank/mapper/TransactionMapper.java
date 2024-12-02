package com.stepintoprofession.bank.mapper;

import com.stepintoprofession.bank.model.dto.TransactionDto;
import com.stepintoprofession.bank.model.dto.UserDto;
import com.stepintoprofession.bank.model.entity.Transaction;
import com.stepintoprofession.bank.model.entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TransactionMapper {
    @IterableMapping(qualifiedByName = "entityToDto")
    public abstract List<TransactionDto> entityListToDtoList(List<Transaction> transactions);

    @Named("entityToDto")
    public abstract TransactionDto entityToDto(Transaction transaction);

    public abstract Transaction dtoToEntity(TransactionDto dto);
}