package org.csu.travelbyex.core;

import java.util.Date;
import java.util.List;

public class AccountUp {

    private String userId;

    private String password;

    private String userName;

    private String imagePath;

    private String sex;

    private List<Integer> home;

    private List<Integer> live;

    private Date birthday;

    private String tag1;

    private String tag2;

    private String tag3;

    private String description;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Integer> getHome() {
        return home;
    }

    public void setHome(List<Integer> home) {
        this.home = home;
    }

    public List<Integer> getLive() {
        return live;
    }

    public void setLive(List<Integer> live) {
        this.live = live;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
