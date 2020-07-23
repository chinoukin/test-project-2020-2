package com.wisea.fbsapp1.feign;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountInfoFeignFallback implements AccountInfoFeign{
    @Override
    public String transferAccount(String accountNo, BigDecimal amount) {
        return "fallback";
    }
}
