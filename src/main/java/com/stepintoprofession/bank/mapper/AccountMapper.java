package com.stepintoprofession.bank.mapper;

import com.stepintoprofession.bank.model.dto.AccountDto;
import com.stepintoprofession.bank.model.entity.Account;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AccountMapper {
    @IterableMapping(qualifiedByName = "entityToDto")
    public abstract List<AccountDto> entityListToDtoList(List<Account> accounts);

    @Mapping(target = "userId", source = "user.id")
    @Named("entityToDto")
    public abstract AccountDto entityToDto(Account account);

    public abstract Account dtoToEntity(AccountDto dto);
}
