package com.stepintoprofession.bank.service.products;

import com.stepintoprofession.bank.model.entity.Request;
import com.stepintoprofession.bank.model.entity.RequestStatus;
import com.stepintoprofession.bank.repository.RequestRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreditTask implements Runnable {
    private final RequestRepository requestRepository;
    private final Request request;

    @Override
    public void run() {
        if (request.getStatus() != RequestStatus.CLOSED) {
            request.setStatus(RequestStatus.NOT_PAID);
            requestRepository.save(request);
        }
    }
}
