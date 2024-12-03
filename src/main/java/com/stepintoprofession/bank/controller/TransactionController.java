package com.stepintoprofession.bank.controller;

import com.stepintoprofession.bank.model.dto.DepositDto;
import com.stepintoprofession.bank.model.dto.TransactionDto;
import com.stepintoprofession.bank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getTransaction(@PathVariable Integer id) {
        return ResponseEntity.ok(transactionService.getTransaction(id));
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> listTransactions(@RequestParam Integer accountId) {
        return ResponseEntity.ok(transactionService.listTransactions(accountId));
    }

    @PostMapping
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody @Validated TransactionDto transaction) {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @PostMapping("/deposit")
    public ResponseEntity<Void> deposit(@RequestBody @Validated DepositDto depositDto) {
        transactionService.deposit(depositDto);
        return ResponseEntity.ok().build();
    }
}
