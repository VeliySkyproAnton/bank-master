package com.stepintoprofession.bank.controller;

import com.stepintoprofession.bank.model.dto.AccountDto;
import com.stepintoprofession.bank.model.dto.CreateAccountDto;
import com.stepintoprofession.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody @Validated CreateAccountDto accountDto) {
        return ResponseEntity.ok(accountService.createAccount(accountDto));
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> listAccount(@RequestParam Integer userId) {
        return ResponseEntity.ok(accountService.listAccount(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Integer id) {
        return ResponseEntity.ok(accountService.getAccount(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDto> deleteAccount(@PathVariable Integer id) {
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }
}
