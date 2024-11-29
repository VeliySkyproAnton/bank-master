package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.model.entity.Account;
import com.stepintoprofession.bank.model.entity.AccountStatus;
import com.stepintoprofession.bank.model.entity.User;
import com.stepintoprofession.bank.repository.AccountRepository;
import com.stepintoprofession.bank.repository.RequestRepository;
import com.stepintoprofession.bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final RequestRepository requestRepository;

    public Account createAccount(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new RuntimeException("Пользователь не найден");
        }
        Account account = new Account();
        account.setStatus(AccountStatus.OPEN);
        account.setCreateDate(new Date());
        account.setUser(userOptional.get());
        accountRepository.save(account);
        return account;
    }
}
