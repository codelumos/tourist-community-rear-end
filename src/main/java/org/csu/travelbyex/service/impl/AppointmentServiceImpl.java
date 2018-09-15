package org.csu.travelbyex.service.impl;

import org.csu.travelbyex.domain.*;
import org.csu.travelbyex.persistence.AppointmentMapper;
import org.csu.travelbyex.persistence.AppointmentParticipantMapper;
import org.csu.travelbyex.persistence.AppointmentReplyMapper;
import org.csu.travelbyex.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentMapper appointmentMapper;
    @Autowired
    AppointmentParticipantMapper appointmentParticipantMapper;
    @Autowired
    AppointmentReplyMapper appointmentReplyMapper;

    //约
    @Override
    public int insertAppointment(Appointment appointment){
        appointmentMapper.insert(appointment);
        return appointment.getAppointmentId();
    }

    @Override
    public void deleteAppointment(Integer appointmentId){
        deleteAppointmentRepliesAndAppointmentParticipants(appointmentId);
        appointmentMapper.deleteByPrimaryKey(appointmentId);
    }
    private void deleteAppointmentRepliesAndAppointmentParticipants(Integer appointmentId)
    {
        AppointmentReplyExample appointmentReplyExample = new AppointmentReplyExample();
        appointmentReplyExample.createCriteria().andAppointmentIdEqualTo(appointmentId);
        appointmentReplyMapper.deleteByExample(appointmentReplyExample);

        AppointmentParticipantExample appointmentParticipantExample = new AppointmentParticipantExample();
        appointmentParticipantExample.createCriteria().andAppointmentIdEqualTo(appointmentId);
        appointmentParticipantMapper.deleteByExample(appointmentParticipantExample);

    }

    @Override
    public Appointment getAppointmentById(Integer appointmentId) {
        return appointmentMapper.selectByPrimaryKey(appointmentId);
    }

    @Override
    public List getAppointmentsByTag(String tag) {

        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andTimeGreaterThanOrEqualTo(new Date());
        criteria.andTag1Like(tag);
        List<Appointment> appointments = appointmentMapper.selectByExampleWithBLOBs(appointmentExample);

        appointmentExample.clear();
        criteria = appointmentExample.createCriteria();
        criteria.andTimeGreaterThanOrEqualTo(new Date());
        criteria.andTag2Like(tag);
        appointments.addAll( appointmentMapper.selectByExampleWithBLOBs(appointmentExample) );

        appointmentExample.clear();
        criteria = appointmentExample.createCriteria();
        criteria.andTimeGreaterThanOrEqualTo(new Date());
        criteria.andTag3Like(tag);
        appointments.addAll( appointmentMapper.selectByExampleWithBLOBs(appointmentExample) );

        Collections.sort(appointments);
        return appointments;
    }

    @Override
    public List getAllAppointments(){
        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andTimeGreaterThanOrEqualTo(new Date());
        List<Appointment> appointments = appointmentMapper.selectByExampleWithBLOBs(appointmentExample);
        Collections.sort(appointments);
        return appointments;
    }

    @Override
    public List getAppointmentsByAuthorId(String authorId){
        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andTimeGreaterThanOrEqualTo(new Date());
        criteria.andAuthorIdLike(authorId);
        List<Appointment> appointments = appointmentMapper.selectByExampleWithBLOBs(appointmentExample);
        Collections.sort(appointments);
        return appointments;
    }

    @Override
    public List getAppointmentByLPName(String lpName) {
        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andTimeGreaterThanOrEqualTo(new Date());
        criteria.andLpLike(lpName);
        List<Appointment> appointments = appointmentMapper.selectByExampleWithBLOBs(appointmentExample);
        Collections.sort(appointments);
        return appointments;
    }

    @Override
    public List getAppointmentBySPName(String spName) {
        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andTimeGreaterThanOrEqualTo(new Date());
        criteria.andSpLike(spName);
        List<Appointment> appointments = appointmentMapper.selectByExampleWithBLOBs(appointmentExample);
        Collections.sort(appointments);
        return appointments;
    }

    @Override
    public List getAppointmentByTitle(String title) {
        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andTitleLike(title);
        criteria.andTimeGreaterThanOrEqualTo(new Date());
        List<Appointment> appointments = appointmentMapper.selectByExampleWithBLOBs(appointmentExample);
        Collections.sort(appointments);
        return appointments;
    }

    @Override
    public List getAppointmentsBySpotName(String spotName){
        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andSpotNameLike(spotName);
        criteria.andTimeGreaterThanOrEqualTo(new Date());
        List<Appointment> appointments = appointmentMapper.selectByExampleWithBLOBs(appointmentExample);
        Collections.sort(appointments);
        return appointments;
    }

    @Override
    public List getAppointmentsByTime(Date date1, Date date2) {

        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andTimeGreaterThanOrEqualTo(date1);
        criteria.andTimeLessThanOrEqualTo(date2);
        List<Appointment> appointments = appointmentMapper.selectByExampleWithBLOBs(appointmentExample);
        Collections.sort(appointments);
        return appointments;

    }

    @Override
    public List getAppointmentsByParticipantId(String participantId) {

        AppointmentParticipantExample appointmentParticipantExample = new AppointmentParticipantExample();
        AppointmentParticipantExample.Criteria criteria = appointmentParticipantExample.createCriteria();
        criteria.andUserIdEqualTo(participantId);
        List<AppointmentParticipant> appointmentParticipants = appointmentParticipantMapper.selectByExample(appointmentParticipantExample);

        List<Appointment> appointments = new ArrayList<>();
        for (AppointmentParticipant appointmentParticipant :
                appointmentParticipants) {
            Appointment appointment = appointmentMapper.selectByPrimaryKey(appointmentParticipant.getAppointmentId());
            appointments.add(appointment);
        }

        Collections.sort(appointments);
        return appointments;
    }

    @Override
    public void updateAppointmentById(Appointment appointment) {
        appointmentMapper.updateByPrimaryKey(appointment);
    }


    //回复
    @Override
    public void insertAppointmentReply(AppointmentReply appointmentReply){
        appointmentReplyMapper.insert(appointmentReply);
    }

    @Override
    public List getAppointmentRepliesByAppointmentId(Integer appointmentId){
        AppointmentReplyExample appointmentReplyExample = new AppointmentReplyExample();
        AppointmentReplyExample.Criteria criteria = appointmentReplyExample.createCriteria();
        criteria.andAppointmentIdEqualTo(appointmentId);
        List<AppointmentReply> appointmentReplies = appointmentReplyMapper.selectByExampleWithBLOBs(appointmentReplyExample);
        Collections.sort(appointmentReplies);
        return appointmentReplies;
    }

    //队友信息
    @Override
    public void insertAppointmentParticipant(AppointmentParticipant appointmentParticipant){
        appointmentParticipantMapper.insert(appointmentParticipant);
    }

    @Override
    public List getAppointmentParticipantsByAppointmentId(Integer appointmentId){
        AppointmentParticipantExample appointmentParticipantExample = new AppointmentParticipantExample();
        AppointmentParticipantExample.Criteria criteria = appointmentParticipantExample.createCriteria();
        criteria.andAppointmentIdEqualTo(appointmentId);
        return appointmentParticipantMapper.selectByExample(appointmentParticipantExample);
    }

    @Override
    public void deleteAppointmentParticipant(AppointmentParticipant appointmentParticipant) {
        appointmentParticipantMapper.deleteByPrimaryKey(appointmentParticipant.getUserId(), appointmentParticipant.getAppointmentId());
    }


}
