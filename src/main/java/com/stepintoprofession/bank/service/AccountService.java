package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.exception.ServiceException;
import com.stepintoprofession.bank.mapper.AccountMapper;
import com.stepintoprofession.bank.model.dto.AccountDto;
import com.stepintoprofession.bank.model.dto.CreateAccountDto;
import com.stepintoprofession.bank.model.entity.Account;
import com.stepintoprofession.bank.model.entity.AccountStatus;
import com.stepintoprofession.bank.repository.AccountRepository;
import com.stepintoprofession.bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountMapper accountMapper;

    public AccountDto createAccount(CreateAccountDto accountDto) {
        Account account = new Account();
        account.setStatus(AccountStatus.OPEN);
        account.setCreateDate(new Date());
        account.setBalance(0);
        account.setUser(userRepository.findById(accountDto.getUserId())
                .orElseThrow(() -> new ServiceException("Пользователь отсутствует", HttpStatus.NOT_FOUND)));
        return accountMapper.entityToDto(accountRepository.save(account));
    }

    public AccountDto getAccount(Integer id) {
        return accountMapper.entityToDto(accountRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Счет отсутствует", HttpStatus.NOT_FOUND)));
    }

    public List<AccountDto> listAccount(Integer userId) {
        return accountMapper.entityListToDtoList(accountRepository.findAllByUser(userId));
    }

    public AccountDto deleteAccount(Integer id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Счет отсутствует", HttpStatus.NOT_FOUND));
        account.setStatus(AccountStatus.CLOSED);
        account.setCloseDate(new Date());
        return accountMapper.entityToDto(accountRepository.save(account));
    }
}
