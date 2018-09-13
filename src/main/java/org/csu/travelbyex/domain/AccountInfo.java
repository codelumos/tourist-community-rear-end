package org.csu.travelbyex.domain;

import java.util.Date;

public class AccountInfo {
    private String userId;

    private String userName;

    private String imagePath;

    private String sex;

    private String homelp;

    private String homesp;

    private String livelp;

    private String livesp;

    private Date birthday;

    private String tag1;

    private String tag2;

    private String tag3;

    private String description;

    public AccountInfo(String userId, String userName, String imagePath, String sex, String homelp, String homesp, String livelp, String livesp, Date birthday, String tag1, String tag2, String tag3, String description) {
        this.userId = userId;
        this.userName = userName;
        this.imagePath = imagePath;
        this.sex = sex;
        this.homelp = homelp;
        this.homesp = homesp;
        this.livelp = livelp;
        this.livesp = livesp;
        this.birthday = birthday;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.description = description;
    }

    public AccountInfo() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getHomelp() {
        return homelp;
    }

    public void setHomelp(String homelp) {
        this.homelp = homelp == null ? null : homelp.trim();
    }

    public String getHomesp() {
        return homesp;
    }

    public void setHomesp(String homesp) {
        this.homesp = homesp == null ? null : homesp.trim();
    }

    public String getLivelp() {
        return livelp;
    }

    public void setLivelp(String livelp) {
        this.livelp = livelp == null ? null : livelp.trim();
    }

    public String getLivesp() {
        return livesp;
    }

    public void setLivesp(String livesp) {
        this.livesp = livesp == null ? null : livesp.trim();
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
        this.tag1 = tag1 == null ? null : tag1.trim();
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2 == null ? null : tag2.trim();
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3 == null ? null : tag3.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}