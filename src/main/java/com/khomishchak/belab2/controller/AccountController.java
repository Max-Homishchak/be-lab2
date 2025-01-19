package com.khomishchak.belab2.controller;

import com.khomishchak.belab2.model.Account;
import com.khomishchak.belab2.model.dot.CreateAccountDTO;
import com.khomishchak.belab2.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody CreateAccountDTO createAccountDTO) {
        Account account = accountService.createAccount(createAccountDTO.getUserId(), createAccountDTO.getInitialBalance());
        return ResponseEntity.ok(account);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Account>> getAccountsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(accountService.getAccountsByUserId(userId));
    }

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable Long accountId, @RequestParam double amount) {
        return ResponseEntity.ok(accountService.deposit(accountId, amount));
    }

    @PostMapping("/{accountId}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable Long accountId, @RequestParam double amount) {
        return ResponseEntity.ok(accountService.withdraw(accountId, amount));
    }
}
