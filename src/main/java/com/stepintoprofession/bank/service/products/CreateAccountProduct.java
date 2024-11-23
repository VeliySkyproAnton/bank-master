package com.stepintoprofession.bank.service.products;

import com.stepintoprofession.bank.model.Account;
import com.stepintoprofession.bank.model.AccountStatus;
import com.stepintoprofession.bank.model.Request;
import com.stepintoprofession.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class CreateAccountProduct implements RequestHandler {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean check(Request request) {
        // В случае наличия судимости не создавать счет
        return !request.getUser().getCriminal();
    }

    @Override
    public void preExecute(Request request) {

    }

    @Override
    public void postExecute(Request request) {
        Account account = new Account();
        account.setBalance(0);
        account.setCreateDate(new Date());
        account.setUser(request.getUser());
        account.setStatus(AccountStatus.OPEN);
        accountRepository.save(account);
    }

    @Override
    public boolean ready(Request request) {
        return true;
    }
}
