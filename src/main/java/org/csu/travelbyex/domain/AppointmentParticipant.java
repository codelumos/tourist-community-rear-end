package org.csu.travelbyex.domain;

public class AppointmentParticipant {
    private String userId;

    private Integer appointmentId;

    public AppointmentParticipant(String userId, Integer appointmentId) {
        this.userId = userId;
        this.appointmentId = appointmentId;
    }

    public AppointmentParticipant() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }
}