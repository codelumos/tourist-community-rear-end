package org.csu.travelbyex.core;

import org.csu.travelbyex.domain.Account;
import org.csu.travelbyex.domain.AccountInfo;
import org.csu.travelbyex.domain.Article;

public class RequestEx {

    private Account account;

    private AccountInfo accountInfo;

    private Article article;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
