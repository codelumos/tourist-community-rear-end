package org.csu.travelbyex.service;

import org.csu.travelbyex.domain.Account;
import org.csu.travelbyex.domain.AccountInfo;

public interface AccountService {

    Account getAccountByUserId(String userId);

    Account getAccountByUserIdAndPassword(String userId, String password);

    void insertAccount(Account account);

    void updateAccount(Account account);

    void deleteAccountByUserId(String userId);

    AccountInfo getAccountInfoByUserId(String userId);

    void insertAccountInfo(AccountInfo account);

    void updateAccountInfo(AccountInfo accountInfo);

    void deleteAccountInfoByUserId(String userId);

}
