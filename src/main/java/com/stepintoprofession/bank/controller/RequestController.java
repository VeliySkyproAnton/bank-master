package com.stepintoprofession.bank.controller;

import com.stepintoprofession.bank.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RequestController {
    @Autowired
    private RequestService requestService;
}