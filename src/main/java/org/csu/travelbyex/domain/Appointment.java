package org.csu.travelbyex.domain;

import java.util.Date;

public class Appointment {
    private Integer appointmentId;

    private Integer spotId;

    private String authorId;

    private Date time;

    private String imagePath;

    private Short sum;

    private String title;

    private String tag1;

    private String tag2;

    private String tag3;

    private String contentEx;

    public Appointment(Integer appointmentId, Integer spotId, String authorId, Date time, String imagePath, Short sum, String title, String tag1, String tag2, String tag3, String contentEx) {
        this.appointmentId = appointmentId;
        this.spotId = spotId;
        this.authorId = authorId;
        this.time = time;
        this.imagePath = imagePath;
        this.sum = sum;
        this.title = title;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.contentEx = contentEx;
    }

    public Appointment() {
        super();
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getSpotId() {
        return spotId;
    }

    public void setSpotId(Integer spotId) {
        this.spotId = spotId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public Short getSum() {
        return sum;
    }

    public void setSum(Short sum) {
        this.sum = sum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public String getContentEx() {
        return contentEx;
    }

    public void setContentEx(String contentEx) {
        this.contentEx = contentEx == null ? null : contentEx.trim();
    }
}