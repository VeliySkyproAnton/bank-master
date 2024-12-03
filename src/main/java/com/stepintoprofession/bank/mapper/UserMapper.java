package com.stepintoprofession.bank.mapper;

import com.stepintoprofession.bank.model.dto.UserDto;
import com.stepintoprofession.bank.model.entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @IterableMapping(qualifiedByName = "entityToDto")
    public abstract List<UserDto> entityListToDtoList(List<User> users);

    @Named("entityToDto")
    public abstract UserDto entityToDto(User user);

    public abstract User dtoToEntity(UserDto dto);
}


