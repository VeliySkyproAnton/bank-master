package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.exception.ServiceException;
import com.stepintoprofession.bank.mapper.TransactionMapper;
import com.stepintoprofession.bank.model.dto.*;
import com.stepintoprofession.bank.repository.TransactionRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public TransactionDto getTransaction(Integer id) {
        return transactionMapper.entityToDto(transactionRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Транзакция отсутствует", HttpStatus.NOT_FOUND)));
    }

    public List<TransactionDto> listTransactions(Integer accountId) {
        return transactionMapper.entityListToDtoList(transactionRepository.findAllByAccount(accountId));
    }

    public TransactionDto deposit(DepositDto transaction) {
        return null;
    }

    public TransactionDto createTransaction(TransactionDto transaction) {
        return null;
    }
}
