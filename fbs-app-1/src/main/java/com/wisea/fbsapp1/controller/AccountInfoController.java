package com.wisea.fbsapp1.controller;

import com.wisea.fbsapp1.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountInfoController {

    @Autowired
    AccountInfoService accountInfoService;

    @GetMapping("/acc/{accountNo}")
    public String transferAccount(@PathVariable String accountNo, BigDecimal amount) {
        return accountInfoService.transferAccount(accountNo, amount);
    }
}
