package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.exception.ServiceException;
import com.stepintoprofession.bank.mapper.TransactionMapper;
import com.stepintoprofession.bank.model.dto.DepositDto;
import com.stepintoprofession.bank.model.dto.TransactionDto;
import com.stepintoprofession.bank.model.entity.Account;
import com.stepintoprofession.bank.model.entity.Transaction;
import com.stepintoprofession.bank.repository.AccountRepository;
import com.stepintoprofession.bank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public TransactionDto getTransaction(Integer id) {
        return transactionMapper.entityToDto(transactionRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Транзакция отсутствует", HttpStatus.NOT_FOUND)));
    }

    public List<TransactionDto> listTransactions(Integer accountId) {
        return transactionMapper.entityListToDtoList(transactionRepository.findAllByAccount(accountId));
    }

    public void deposit(DepositDto dto) {
        Transaction transaction = transactionMapper.depositToTransaction(dto);
        transaction.setDate(new Date());
        Account account = transaction.getToAccount();
        account.setBalance(account.getBalance() + transaction.getSum());
        accountRepository.save(account);
        transactionRepository.save(transaction);
    }

    public TransactionDto createTransaction(TransactionDto dto) {
        Transaction transaction = transactionMapper.dtoToEntity(dto);
        if (transaction.getFromAccount().getBalance() < transaction.getSum()) {
            throw new ServiceException("Недостаточно средств", HttpStatus.BAD_REQUEST);
        }
        Account toAccount = transaction.getToAccount();
        toAccount.setBalance(toAccount.getBalance() + transaction.getSum());
        Account fromAccount = transaction.getFromAccount();
        fromAccount.setBalance(fromAccount.getBalance() - transaction.getSum());
        transaction.setDate(new Date());
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        return transactionMapper.entityToDto(transactionRepository.save(transaction));
    }
}
