package org.csu.travelbyex.domain;

import java.util.Date;

public class Appointment implements Comparable<Appointment>{
    private Integer appointmentId;

    private String authorId;

    private String lp;

    private String sp;

    private String spotName;

    private Date time;

    private String imagePath;

    private Short sum;

    private String title;

    private String tag1;

    private String tag2;

    private String tag3;

    private String contentEx;

    public Appointment(Integer appointmentId, String authorId, String lp, String sp, String spotName, Date time, String imagePath, Short sum, String title, String tag1, String tag2, String tag3, String contentEx) {
        this.appointmentId = appointmentId;
        this.authorId = authorId;
        this.lp = lp;
        this.sp = sp;
        this.spotName = spotName;
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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

    public String getLp() {
        return lp;
    }

    public void setLp(String lp) {
        this.lp = lp == null ? null : lp.trim();
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp == null ? null : sp.trim();
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName == null ? null : spotName.trim();
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

    // 为了使用hashset去重
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (obj instanceof Appointment) {
            Appointment vo = (Appointment) obj;

            // 比较每个属性的值 一致时才返回true
            if (vo.appointmentId.equals(this.appointmentId))
                return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return appointmentId.hashCode();
    }


    // 为了使用arrayList排序
    @Override
    public int compareTo(Appointment o) {
        int a = this.getTime().compareTo(o.getTime());
        // list添加值时如果compareTo返回值为0就不添加了。
        if (a == 0)
            return 1;
        else
            return this.getTime().compareTo(o.getTime());
    }

}
