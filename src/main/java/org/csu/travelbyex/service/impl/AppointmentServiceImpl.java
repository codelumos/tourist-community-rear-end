package org.csu.travelbyex.service.impl;

import org.csu.travelbyex.domain.*;
import org.csu.travelbyex.persistence.AppointmentMapper;
import org.csu.travelbyex.persistence.AppointmentParticipantMapper;
import org.csu.travelbyex.persistence.AppointmentReplyMapper;
import org.csu.travelbyex.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        criteria.andTag1EqualTo(tag);
        List appointments = appointmentMapper.selectByExampleWithBLOBs(appointmentExample);

        criteria.andTag1IsNotNull();
        criteria.andTag2EqualTo(tag);
        appointments.addAll( appointmentMapper.selectByExampleWithBLOBs(appointmentExample) );

        criteria.andTag2IsNotNull();
        criteria.andTag3EqualTo(tag);
        appointments.addAll( appointmentMapper.selectByExampleWithBLOBs(appointmentExample) );

        return appointments;
    }

    @Override
    public List getAllAppointments(){
        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andTimeGreaterThan(new Date());
        return appointmentMapper.selectByExampleWithBLOBs(appointmentExample);
    }

    @Override
    public List getAppointmentsByAuthorId(String authorId){
        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andAuthorIdEqualTo(authorId);
        return appointmentMapper.selectByExampleWithBLOBs(appointmentExample);
    }

    @Override
    public List getAppointmentsBySpotName(String spotName){
        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andSpotNameEqualTo(spotName);
        return appointmentMapper.selectByExampleWithBLOBs(appointmentExample);
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
        return appointmentReplyMapper.selectByExampleWithBLOBs(appointmentReplyExample);
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


}
