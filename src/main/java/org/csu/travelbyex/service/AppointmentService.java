package org.csu.travelbyex.service;

import org.csu.travelbyex.domain.Appointment;
import org.csu.travelbyex.domain.AppointmentParticipant;
import org.csu.travelbyex.domain.AppointmentReply;

import java.util.Date;
import java.util.List;

public interface AppointmentService {

    // 约
    int insertAppointment(Appointment appointment);

    void deleteAppointment(Integer appointmentId);

    Appointment getAppointmentById(Integer appointmentId);

    List getAppointmentsByTag(String tag);

    List getAllAppointments();

    List getAppointmentsByAuthorId(String authorId);

    List getAppointmentByLPName(String lpName);

    List getAppointmentBySPName(String spName);

    List getAppointmentByTitle(String title);

    List getAppointmentsBySpotName(String spotName);

    List getAppointmentsByTime(Date date1, Date date2);

    List getAppointmentsByParticipantId(String participantId);

    void updateAppointmentById(Appointment appointment);

    // 回复
    void insertAppointmentReply(AppointmentReply appointmentReply);

    List getAppointmentRepliesByAppointmentId(Integer appointmentId);

    // 队友信息
    void insertAppointmentParticipant(AppointmentParticipant appointmentParticipant);

    List getAppointmentParticipantsByAppointmentId(Integer appointmentId);

    void deleteAppointmentParticipant(AppointmentParticipant appointmentParticipant);
}
