package org.csu.travel.core;

public class AppointmentParticipantUp {

    private String userId;

    private Integer appointmentId;

    private String appointmentImagePath;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentImagePath() {
        return appointmentImagePath;
    }

    public void setAppointmentImagePath(String appointmentImagePath) {
        this.appointmentImagePath = appointmentImagePath;
    }
}
