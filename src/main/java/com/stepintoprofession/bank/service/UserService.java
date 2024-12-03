package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.exception.ServiceException;
import com.stepintoprofession.bank.mapper.UserMapper;
import com.stepintoprofession.bank.model.dto.UserDto;
import com.stepintoprofession.bank.model.entity.Property;
import com.stepintoprofession.bank.model.entity.User;
import com.stepintoprofession.bank.repository.PropertyRepository;
import com.stepintoprofession.bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PropertyRepository propertyRepository;
    private final UserMapper userMapper;

    public UserDto createUser(UserDto userDto) {
        User user = userRepository.save(userMapper.dtoToEntity(userDto));
        if (user.getPropertyList() != null) {
            for (Property property : user.getPropertyList()) {
                property.setUser(user);
                propertyRepository.save(property);
            }
        }
        return userMapper.entityToDto(user);
    }

    public List<UserDto> listUsers() {
        return userMapper.entityListToDtoList(userRepository.findAll());
    }

    public UserDto getUser(Integer id) {
        return userMapper.entityToDto(userRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Пользователь отсутствует", HttpStatus.NOT_FOUND)));
    }

    public UserDto deleteUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Пользователь отсутствует", HttpStatus.NOT_FOUND));
        if (user.isDeleted()) {
            throw new ServiceException("Пользователь был удален ранее", HttpStatus.BAD_REQUEST);
        }
        user.setDeleted(true);
        return userMapper.entityToDto(userRepository.save(user));
    }
}