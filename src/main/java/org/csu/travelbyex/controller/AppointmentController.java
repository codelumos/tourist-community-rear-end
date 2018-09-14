package org.csu.travelbyex.controller;

import io.swagger.annotations.ApiOperation;
import org.csu.travelbyex.core.AppointmentParticipantUp;
import org.csu.travelbyex.core.Result;
import org.csu.travelbyex.core.ResultGenerator;
import org.csu.travelbyex.domain.Appointment;
import org.csu.travelbyex.domain.AppointmentParticipant;
import org.csu.travelbyex.domain.AppointmentReply;
import org.csu.travelbyex.domain.ScenicSpot;
import org.csu.travelbyex.service.AccountService;
import org.csu.travelbyex.service.AppointmentService;
import org.csu.travelbyex.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    @Autowired
    AccountService accountService;
    @Autowired
    SpotService spotService;


    @ApiOperation(value = "发布拼途", notes = "景点从数据库选")
    @PostMapping("/appointments")
    public Result insertAppointment(@RequestBody Appointment appointment)
    {
        try
        {
            // 如果输入的景点名不在数据库中，就插入数据库。
            String spotName = appointment.getSpotName();
            ScenicSpot scenicSpot = spotService.getScenicSpotByName(spotName);
            if (scenicSpot == null)
            {
                scenicSpot = new ScenicSpot();
                scenicSpot.setPlaceId(1);
                scenicSpot.setSpotName(spotName);
                spotService.insertSpot(scenicSpot);
            }

            // 返回拼途的主键，用于查询具体的拼途
            int appointmentId = appointmentService.insertAppointment(appointment);
            return ResultGenerator.success(appointmentId);
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
        if (appointment == null) return ResultGenerator.success("拼途不存在");
        List<AppointmentReply> appointmentReplies = appointmentService.getAppointmentRepliesByAppointmentId(appointmentId);
        List<AppointmentParticipant> appointmentParticipants = appointmentService.getAppointmentParticipantsByAppointmentId(appointmentId);
        List<AppointmentParticipantUp> appointmentParticipantUps = new ArrayList<>();
        appointmentPaticipantsToAppointmentParticipantUps(appointmentParticipants, appointmentParticipantUps);
        Map message = new LinkedHashMap();
        message.put("appointment",appointment);
        message.put("appointmentReplies",appointmentReplies);
        message.put("appointmentParticipantUps", appointmentParticipantUps);
        return ResultGenerator.fail(message);
    }
    private void appointmentPaticipantsToAppointmentParticipantUps(List<AppointmentParticipant> appointmentParticipants,
                                                                   List<AppointmentParticipantUp> appointmentParticipantUps)
    {
        for (AppointmentParticipant appointmentParticipant :
                appointmentParticipants) {
            AppointmentParticipantUp appointmentParticipantUp = new AppointmentParticipantUp();
            appointmentParticipantUp.setAppointmentId(appointmentParticipant.getAppointmentId());
            appointmentParticipantUp.setUserId(appointmentParticipant.getUserId());
            String appointmentImagePath = accountService.getAccountInfoByUserId(appointmentParticipant.getUserId()).getImagePath();
            appointmentParticipantUp.setAppointmentImagePath(appointmentImagePath);
            appointmentParticipantUps.add(appointmentParticipantUp);
        }

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
    public Result insertAppointmentReply(@RequestBody AppointmentReply appointmentReply)
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

    @ApiOperation(value = "根据keyword查询拼途")
    @GetMapping("/search/appointments")
    public Result getAppointmentsByKeyword(@RequestParam(value = "keyword") String keyword)
    {
        Set<Appointment> appointments = new HashSet<>();
        try
        {
            int appointmentId = Integer.parseInt(keyword);
            Appointment appointment = appointmentService.getAppointmentById(appointmentId);
            if (appointment != null) appointments.add(appointment);
        } catch (Exception e){}
        finally {
            List<Appointment> appointments1 = appointmentService.getAppointmentsByTag(keyword);
            if (appointments1 != null) appointments.addAll(appointments1);
            appointments1 = appointmentService.getAppointmentsByAuthorId(keyword);
            if (appointments1 != null) appointments.addAll(appointments1);

            if (appointments.size() == 0) return ResultGenerator.success("无此类拼途！");
            return ResultGenerator.fail(appointments);
        }


    }



}
