package com.wisea.fbsapp2.service;

import com.wisea.fbsapp2.dao.AccountInfoDao;
import com.wisea.fbsapp2.entity.AccountInfo;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountInfoService {

    @Autowired
    AccountInfoDao accountInfoDao;

    /**
     * 银行转账
     *
     * @param accountNo 转账账户
     * @param amount    转账金额
     * @return String
     */
    @Transactional
    public String transferAccount(String accountNo, BigDecimal amount){
        // bank1 账户余额减
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountNo(accountNo);
        accountInfo.setAccountBalance(amount);
        if (accountInfoDao.updateAccountBalanceById(accountInfo) > 0) {
            if (amount.doubleValue() == 3D) {
                throw new RuntimeException("人为制造异常,XID:"+ RootContext.getXID());
            }
            return "success";
        }
        return "failure";
    }
}
