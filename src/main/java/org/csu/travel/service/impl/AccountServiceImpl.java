package org.csu.travel.service.impl;

import org.csu.travel.domain.Account;
import org.csu.travel.domain.AccountExample;
import org.csu.travel.domain.AccountInfo;
import org.csu.travel.persistence.AccountInfoMapper;
import org.csu.travel.persistence.AccountMapper;
import org.csu.travel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountInfoMapper accountInfoMapper;

    @Override
    public Account getAccountByUserId(String userId) {
        return accountMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Account getAccountByUserIdAndPassword(String userId, String password) {
        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        criteria.andPasswordEqualTo(password);
        criteria.andUserIdEqualTo(userId);
        List accounts = accountMapper.selectByExample(accountExample);
        return accounts.size() > 0 ? (Account) accounts.get(0) : null;
    }

    @Override
    public void insertAccount(Account account) {
        accountMapper.insert(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountMapper.updateByPrimaryKey(account);
    }

    @Override
    public void deleteAccountByUserId(String userId) {
        accountMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public AccountInfo getAccountInfoByUserId(String userId) {
        return accountInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void insertAccountInfo(AccountInfo accountInfo) {
        accountInfoMapper.insert(accountInfo);
    }

    @Override
    public void updateAccountInfo(AccountInfo accountInfo) {
        accountInfoMapper.updateByPrimaryKey(accountInfo);
    }

    @Override
    public void deleteAccountInfoByUserId(String userId) {
        accountInfoMapper.deleteByPrimaryKey(userId);
    }
}
