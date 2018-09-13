package org.csu.travelbyex.domain;

public class Account {
    private String userId;

    private String password;

    public Account(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public Account() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}