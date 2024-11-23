package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.model.Product;
import com.stepintoprofession.bank.model.Request;
import com.stepintoprofession.bank.model.RequestStatus;
import com.stepintoprofession.bank.model.User;
import com.stepintoprofession.bank.repository.AccountRepository;
import com.stepintoprofession.bank.repository.RequestRepository;
import com.stepintoprofession.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RequestRepository requestRepository;

    public Integer createAccountRequest(Integer userId) {
        Request request = new Request();
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new RuntimeException("Пользователь не найден");
        }
        request.setUser(userOptional.get());
        request.setCreateDate(new Date());
        request.setProduct(Product.CREATE_ACCOUNT);
        request.setStatus(RequestStatus.WAITING);
        requestRepository.save(request);
        return request.getId();
    }
}
