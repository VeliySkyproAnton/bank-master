package com.stepintoprofession.bank.mapper;

import com.stepintoprofession.bank.model.dto.RequestDto;
import com.stepintoprofession.bank.model.dto.UserDto;
import com.stepintoprofession.bank.model.entity.Request;
import com.stepintoprofession.bank.model.entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RequestMapper {
    @IterableMapping(qualifiedByName = "entityToDto")
    public abstract List<RequestDto> entityListToDtoList(List<Request> requests);

    @Named("entityToDto")
    public abstract RequestDto entityToDto(Request request);

    public abstract Request dtoToEntity(RequestDto dto);
}
