package com.stepintoprofession.bank.controller;

import com.stepintoprofession.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
}
