package com.stepintoprofession.bank.mapper;

import com.stepintoprofession.bank.exception.ServiceException;
import com.stepintoprofession.bank.model.dto.DepositDto;
import com.stepintoprofession.bank.model.dto.TransactionDto;
import com.stepintoprofession.bank.model.entity.Account;
import com.stepintoprofession.bank.model.entity.Transaction;
import com.stepintoprofession.bank.repository.AccountRepository;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TransactionMapper {
    @Autowired
    private AccountRepository accountRepository;

    @IterableMapping(qualifiedByName = "entityToDto")
    public abstract List<TransactionDto> entityListToDtoList(List<Transaction> transactions);

    @Mapping(target = "toAccountId", source = "toAccount.id")
    @Mapping(target = "fromAccountId", source = "fromAccount.id")
    @Named("entityToDto")
    public abstract TransactionDto entityToDto(Transaction transaction);

    @Mapping(target = "toAccount", source = "toAccountId", qualifiedByName = "findAccount")
    @Mapping(target = "fromAccount", source = "fromAccountId", qualifiedByName = "findAccount")
    public abstract Transaction dtoToEntity(TransactionDto dto);

    @Mapping(target = "toAccount", source = "accountId", qualifiedByName = "findAccount")
    public abstract Transaction depositToTransaction(DepositDto dto);

    @Named("findAccount")
    Account findAccount(Integer accountId) {
        return accountRepository.findById(accountId).orElseThrow(() -> new ServiceException("Счет отсутствует", HttpStatus.NOT_FOUND));
    }
}