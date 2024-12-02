package com.stepintoprofession.bank.controller;

import com.stepintoprofession.bank.model.dto.*;
import com.stepintoprofession.bank.model.entity.RequestStatus;
import com.stepintoprofession.bank.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/request")
public class RequestController {
    private final RequestService requestService;

    @GetMapping("/{id}")
    public ResponseEntity<RequestDto> getRequest(@PathVariable Integer id) {
        return ResponseEntity.ok(requestService.getRequest(id));
    }

    @GetMapping
    public ResponseEntity<List<RequestDto>> listRequests(@RequestParam Integer userId) {
        return ResponseEntity.ok(requestService.listRequests(userId));
    }

    @PostMapping("/process")
    public ResponseEntity<Void> processRequest(@RequestBody @Validated ProcessRequestDto dto) {
        requestService.processRequest(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/close")
    public ResponseEntity<Void> closeRequest(@RequestBody @Validated CloseRequestDto dto) {
        requestService.closeRequest(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<RequestDto> createRequest(@RequestBody @Validated RequestDto request) {
        return  ResponseEntity.ok(requestService.createRequest(request));
    }
}
