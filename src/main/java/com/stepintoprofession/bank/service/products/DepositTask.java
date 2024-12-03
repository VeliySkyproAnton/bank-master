package com.stepintoprofession.bank.service.products;

import com.stepintoprofession.bank.model.entity.Account;
import com.stepintoprofession.bank.model.entity.Request;
import com.stepintoprofession.bank.model.entity.RequestStatus;
import com.stepintoprofession.bank.repository.AccountRepository;
import com.stepintoprofession.bank.repository.RequestRepository;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class DepositTask implements Runnable {
    private final RequestRepository requestRepository;
    private final AccountRepository accountRepository;
    private final Request request;

    @Override
    public void run() {
        int finalSum = (int) (request.getSum() * (1 + request.getProduct().getInterestRate() / 100));
        Account account = request.getAccount();
        account.setBalance(account.getBalance() + finalSum);
        request.setStatus(RequestStatus.CLOSED);
        request.setCloseDate(new Date());
        accountRepository.save(account);
        requestRepository.save(request);
    }
}
