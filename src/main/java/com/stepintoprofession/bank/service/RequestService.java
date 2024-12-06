package com.stepintoprofession.bank.service;

import com.stepintoprofession.bank.exception.ServiceException;
import com.stepintoprofession.bank.mapper.RequestMapper;
import com.stepintoprofession.bank.model.dto.CloseRequestDto;
import com.stepintoprofession.bank.model.dto.ProcessRequestDto;
import com.stepintoprofession.bank.model.dto.RequestDto;
import com.stepintoprofession.bank.model.entity.Account;
import com.stepintoprofession.bank.model.entity.ProductCategory;
import com.stepintoprofession.bank.model.entity.Request;
import com.stepintoprofession.bank.model.entity.RequestStatus;
import com.stepintoprofession.bank.repository.AccountRepository;
import com.stepintoprofession.bank.repository.RequestRepository;
import com.stepintoprofession.bank.service.products.CreditTask;
import com.stepintoprofession.bank.service.products.DepositTask;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;
    private final AccountRepository accountRepository;
    private final TaskScheduler taskScheduler;

    public RequestDto getRequest(Integer id) {
        return requestMapper.entityToDto(requestRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Заявка отсутствует", HttpStatus.NOT_FOUND)));
    }

    public List<RequestDto> listRequests(Integer userId) {
        return requestMapper.entityListToDtoList(requestRepository.findAllByUser(userId));
    }

    public RequestDto createRequest(RequestDto dto) {
        Request request = requestMapper.dtoToEntity(dto);
        if (request.getSum() < request.getProduct().getMinSum() || request.getSum() > request.getProduct().getMaxSum()) {
            throw new ServiceException("Сумма заявки не соответствует выбранному услуге", HttpStatus.BAD_REQUEST);
        }
        request.setStatus(RequestStatus.OPEN);
        request.setCreateDate(new Date());
        return requestMapper.entityToDto(requestRepository.save(request));
    }

    public void closeRequest(CloseRequestDto dto) {
        Request request = requestRepository.findById(dto.getRequestId())
                .orElseThrow(() -> new ServiceException("Заявка отсутствует", HttpStatus.NOT_FOUND));
        if (request.getStatus() != RequestStatus.IN_PROGRESS) {
            throw new ServiceException("Неправильный статус заявки", HttpStatus.BAD_REQUEST);
        }
        if (request.getProduct().getCategory() != ProductCategory.CREDIT) {
            throw new ServiceException("Нельзя закрыть заявку", HttpStatus.BAD_REQUEST);
        }
        int finalSum = (int) (request.getSum() * (1 + request.getProduct().getInterestRate() / 100));
        if (request.getAccount().getBalance() < finalSum) {
            throw new ServiceException("Недостаточно средств", HttpStatus.BAD_REQUEST);
        }
        Account account = request.getAccount();
        account.setBalance(account.getBalance() - finalSum);
        request.setStatus(RequestStatus.CLOSED);
        request.setCloseDate(new Date());
        accountRepository.save(account);
        requestRepository.save(request);
    }

    public void processRequest(ProcessRequestDto dto) {
        Request request = requestRepository.findById(dto.getRequestId())
                .orElseThrow(() -> new ServiceException("Заявка отсутствует", HttpStatus.NOT_FOUND));
        if (request.getStatus() != RequestStatus.OPEN) {
            throw new ServiceException("Неправильный статус заявки", HttpStatus.BAD_REQUEST);
        }
        if (dto.getApprove()) {
            Account account = request.getAccount();
            if (request.getProduct().getCategory() == ProductCategory.CREDIT) {
                account.setBalance(account.getBalance() + request.getSum());
                taskScheduler.schedule(new CreditTask(requestRepository, request),
                        new Date().toInstant().plus(request.getProduct().getDuration()));
            } else if (request.getProduct().getCategory() == ProductCategory.DEPOSIT) {
                if (account.getBalance() < request.getSum()) {
                    throw new ServiceException("Недостаточно средств", HttpStatus.BAD_REQUEST);
                }
                account.setBalance(account.getBalance() - request.getSum());
                taskScheduler.schedule(new DepositTask(requestRepository, accountRepository, request),
                        new Date().toInstant().plus(request.getProduct().getDuration()));
            }
            accountRepository.save(account);
            request.setStatus(RequestStatus.IN_PROGRESS);
        } else {
            request.setStatus(RequestStatus.REJECTED);
        }
        requestRepository.save(request);
    }
}
