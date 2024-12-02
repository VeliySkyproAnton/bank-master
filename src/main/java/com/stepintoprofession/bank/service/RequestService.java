package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.exception.ServiceException;
import com.stepintoprofession.bank.mapper.RequestMapper;
import com.stepintoprofession.bank.model.dto.*;
import com.stepintoprofession.bank.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;

    public RequestDto getRequest(Integer id) {
        return requestMapper.entityToDto(requestRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Заявка отсутствует", HttpStatus.NOT_FOUND)));    }

    public List<RequestDto> listRequests(Integer userId) {
        return requestMapper.entityListToDtoList(requestRepository.findAllByUser(userId));
    }

    public RequestDto createRequest(RequestDto request) {
        return null;
    }

    public void closeRequest(CloseRequestDto dto) {
        ;
    }

    public void processRequest(ProcessRequestDto dto) {
        ;
    }
}
