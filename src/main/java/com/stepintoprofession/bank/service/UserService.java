package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.model.entity.Property;
import com.stepintoprofession.bank.model.entity.User;
import com.stepintoprofession.bank.repository.PropertyRepository;
import com.stepintoprofession.bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PropertyRepository propertyRepository;

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
