package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;
}
