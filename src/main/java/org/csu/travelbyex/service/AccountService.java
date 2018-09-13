package org.csu.travelbyex.service;

import org.csu.travelbyex.domain.Account;
import org.csu.travelbyex.domain.AccountInfo;

public interface AccountService {

    public Account getAccountByUserId(String userId);

    public Account getAccountByUserIdAndPassword(String userId, String password);

    public void insertAccount(Account account);

    public void updateAccount(Account account);

    public void deleteAccountByUserId(String userId);


    public AccountInfo getAccountInfoByUserId(String userId);

    public void insertAccountInfo(AccountInfo account);

    public void updateAccountInfo(AccountInfo accountInfo);

    public void deleteAccountInfoByUserId(String userId);

}
