package com.wisea.fbsapp1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(
        value = "fbs-app-2",
        fallback = AccountInfoFeignFallback.class
)
public interface AccountInfoFeign {

    /**
     * 银行转账
     *
     * @param accountNo 转账账户
     * @param amount    转账金额
     * @author isacc 2019/11/30 0:52
     */
    @GetMapping("/acc/{accountNo}")
    String transferAccount(@PathVariable("accountNo") String accountNo,
                           @RequestParam("amount") BigDecimal amount);
}
