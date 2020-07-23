package com.wisea.fbsapp2.entity;

import java.math.BigDecimal;

/**
 * create table account_info
 * (
 * 	id bigint not null,
 * 	account_name varchar(50) null,
 * 	account_no varchar(50) null,
 * 	account_password varchar(50) null,
 * 	account_balance double null,
 * 	constraint account_info_pk
 * 		primary key (id)
 * );
 */
public class AccountInfo {
    private Long id;

    private String accountName;

    private String accountNo;

    private String accountPassword;

    private BigDecimal accountBalance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
