package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.repository.PropertyRepository;
import com.stepintoprofession.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PropertyRepository propertyRepository;
}
