package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.model.Property;
import com.stepintoprofession.bank.model.User;
import com.stepintoprofession.bank.repository.PropertyRepository;
import com.stepintoprofession.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PropertyRepository propertyRepository;

    public User createUser(User user) {
        user = userRepository.save(user);
        if(user.getPropertyList() != null) {
            for(Property property : user.getPropertyList()) {
                property.setUser(user);
                propertyRepository.save(property);
            }
        }
        return user;
    }
}
