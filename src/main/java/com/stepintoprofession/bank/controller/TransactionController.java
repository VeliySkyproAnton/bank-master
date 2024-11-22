package com.stepintoprofession.bank.controller;

import com.stepintoprofession.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
}
