package com.wisea.fbsapp1.service;

import com.wisea.fbsapp1.dao.AccountInfoDao;
import com.wisea.fbsapp1.entity.AccountInfo;
import com.wisea.fbsapp1.feign.AccountInfoFeign;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountInfoService {

    @Autowired
    AccountInfoDao accountInfoDao;
    @Autowired
    AccountInfoFeign accountInfoFeign;

    /**
     * 银行转账
     *
     * @param accountNo 转账账户
     * @param amount    转账金额
     * @return String
     */
    @GlobalTransactional // 全局事务
    @Transactional
    public String transferAccount(String accountNo, BigDecimal amount){
        // bank1 账户余额减
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountNo(accountNo);
        accountInfo.setAccountBalance(amount.multiply(new BigDecimal("-1")));
        if (accountInfoDao.updateAccountBalanceById(accountInfo) > 0) {
            // bank2 账户余额加
            String rst = accountInfoFeign.transferAccount(accountNo, amount);
            if ("fallback".equals(rst)) {
                throw new RuntimeException("调用远程应用fbs-app-2失败,XID:" + RootContext.getXID());
            }
        }
        if (amount.doubleValue() == 4D) {
            throw new RuntimeException("人为制造异常,XID:"+ RootContext.getXID());
        }
        return "success";
    }
}
