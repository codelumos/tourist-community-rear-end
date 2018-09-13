package org.csu.travelbyex.controller;

import io.swagger.annotations.ApiOperation;
import org.csu.travelbyex.core.Result;
import org.csu.travelbyex.core.ResultGenerator;
import org.csu.travelbyex.domain.Appointment;
import org.csu.travelbyex.domain.AppointmentParticipant;
import org.csu.travelbyex.domain.AppointmentReply;
import org.csu.travelbyex.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @ApiOperation(value = "发布拼途", notes = "景点从数据库选")
    @PostMapping("/appointments")
    public Result insertAppointment(@RequestBody Appointment appointment)
    {
        try
        {
            appointmentService.insertAppointment(appointment);
            return ResultGenerator.success("发布成功");
        }catch (Exception e)
        {
            return ResultGenerator.fail("发布失败");
        }
    }


    @ApiOperation(value = "根据appointmentId更新拼途")
    @PutMapping("/appointments")
    public Result updateAppointment(@RequestBody Appointment appointment)
    {
        try
        {
            appointmentService.updateAppointmentById(appointment);
            return ResultGenerator.success("修改成功");
        } catch (Exception e)
        {
            return ResultGenerator.fail("修改失败");
        }

    }


    @ApiOperation(value = "根据appointmentId查询拼途")
    @GetMapping("/appointments")
    public Result getAppointment(@RequestParam (value = "appointmentId") Integer appointmentId)
    {
        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        if (appointment == null) return ResultGenerator.fail("拼途不存在");
        List<AppointmentReply> appointmentReplies = appointmentService.getAppointmentRepliesByAppointmentId(appointmentId);
        List<AppointmentParticipant> appointmentParticipants = appointmentService.getAppointmentParticipantsByAppointmentId(appointmentId);
        Map message = new LinkedHashMap();
        message.put("appointment",appointment);
        message.put("appointmentReplies",appointmentReplies);
        message.put("appointmentParticipants", appointmentParticipants);
        return ResultGenerator.success(message);
    }


    @ApiOperation(value = "根据appointmentId删除拼途")
    @DeleteMapping("/appointments")
    public Result deleteAppoint(@RequestParam (value = "appointmentId") Integer appointmentId)
    {
        try
        {
            appointmentService.deleteAppointment(appointmentId);
            return ResultGenerator.success("删除成功");
        } catch (Exception e)
        {
            return ResultGenerator.fail("删除失败");
        }

    }

    @ApiOperation(value = "根据userId搜索拼途")
    @GetMapping("/appointments/author")
    public Result getAppointment(@RequestParam(value = "authorId") String authorId)
    {
        List<Appointment> appointments = appointmentService.getAppointmentsByAuthorId(authorId);
        if (appointments.size() == 0)
            return ResultGenerator.success("该用户暂未发布拼途！");
        return ResultGenerator.fail(appointments);
    }


    @ApiOperation(value = "拼途回复")
    @PostMapping("/appointmentReplies")
    private Result insertAppointmentReply(@RequestBody AppointmentReply appointmentReply)
    {
        try
        {
            appointmentService.insertAppointmentReply(appointmentReply);
            return ResultGenerator.success("回复成功！");
        }catch (Exception e)
        {
            return ResultGenerator.fail("回复失败！");
        }

    }


}
