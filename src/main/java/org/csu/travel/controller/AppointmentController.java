package org.csu.travel.controller;

import io.swagger.annotations.ApiOperation;
import org.csu.travel.core.*;
import org.csu.travel.domain.*;
import org.csu.travel.service.AccountService;
import org.csu.travel.service.AppointmentService;
import org.csu.travel.service.SpotService;
import org.csu.travel.service.TagService;
import org.csu.travel.util.AccountUtil;
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
    @Autowired
    TagService tagService;

    @ApiOperation(value = "发布拼途")
    @PostMapping("/appointments")
    public Result insertAppointment(@RequestBody Appointment appointment) {
        try {
            if (appointment.getTime() == null)
                appointment.setTime(new Date());

            // 如果输入的景点名不在数据库中，就插入数据库。
            ensureSpotExists(appointment);

            // 如果输入的标签不在数据库中，就插入数据库；
            ensureTagExists(appointment);

            // 返回拼途的主键，用于查询具体的拼途
            int appointmentId = appointmentService.insertAppointment(appointment);

            // 在拼途参与人员列表中加入拼途作者
            AppointmentParticipant appointmentParticipant = new AppointmentParticipant();
            appointmentParticipant.setUserId(appointment.getAuthorId());
            appointmentParticipant.setAppointmentId(appointment.getAppointmentId());
            appointmentService.insertAppointmentParticipant(appointmentParticipant);

            return ResultGenerator.success(appointmentId);
        } catch (Exception e) {
            return ResultGenerator.fail("发布拼途失败！");
        }
    }


    @ApiOperation(value = "根据appointmentId更新拼途")
    @PutMapping("/appointments")
    public Result updateAppointment(@RequestBody Appointment appointment) {
        try {
            // 如果输入的景点名不在数据库中，就插入数据库。
            ensureSpotExists(appointment);

            // 如果输入的标签不在数据库中，就插入数据库；
            ensureTagExists(appointment);

            appointmentService.updateAppointmentById(appointment);
            return ResultGenerator.success("修改成功");
        } catch (Exception e) {
            return ResultGenerator.fail("修改失败");
        }

    }


    @ApiOperation(value = "根据appointmentId查询拼途")
    @GetMapping("/appointments")
    public Result getAppointment(@RequestParam(value = "appointmentId") Integer appointmentId) {
        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        if (appointment == null)
            return ResultGenerator.fail("拼途不存在");

        List<AppointmentReply> appointmentReplies = appointmentService.getAppointmentRepliesByAppointmentId(appointmentId);
        List<AppointmentParticipant> appointmentParticipants = appointmentService.getAppointmentParticipantsByAppointmentId(appointmentId);

        // 加入参与者头像路径，便于前端显示
        List<AppointmentParticipantUp> appointmentParticipantUps = new ArrayList<>();
        appointmentParticipantsToAppointmentParticipantUps(appointmentParticipants, appointmentParticipantUps);

        // 加入作者信息
        AccountUp accountUp = addAccountUp(appointment.getAuthorId());

        // 加入评论者信息
        List<AppointmentReplyUp> appointmentReplyUps = new ArrayList<>();
        appointmentRepliesToAppointmentReplyUps(appointmentReplies, appointmentReplyUps);

        Map message = new LinkedHashMap();
        message.put("appointment", appointment);
        message.put("accountUp", accountUp);
        message.put("appointmentReplyUps", appointmentReplyUps);
        message.put("appointmentParticipantUps", appointmentParticipantUps);
        return ResultGenerator.success(message);
    }


    @ApiOperation(value = "根据appointmentId删除拼途")
    @DeleteMapping("/appointments")
    public Result deleteAppoint(@RequestParam(value = "appointmentId") Integer appointmentId) {
        try {
            appointmentService.deleteAppointment(appointmentId);
            return ResultGenerator.success("删除成功");
        } catch (Exception e) {
            return ResultGenerator.fail("删除失败");
        }
    }


    @ApiOperation(value = "返回全部拼途")
    @GetMapping("/appointmentsAll")
    public Result getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        Map map = getAppointmentsAndAccountUps(appointments);
        return ResultGenerator.success(map);
    }


    @ApiOperation(value = "发布拼途回复")
    @PostMapping("/appointmentReplies")
    public Result insertAppointmentReply(@RequestBody AppointmentReply appointmentReply) {
        try {
            if (appointmentReply.getTime() == null)
                appointmentReply.setTime(new Date());
            appointmentService.insertAppointmentReply(appointmentReply);
            AppointmentReplyUp appointmentReplyUp = new AppointmentReplyUp();
            upAppointmentReplyUp(appointmentReply, appointmentReplyUp);
            return ResultGenerator.success(appointmentReplyUp);
        } catch (Exception e) {
            return ResultGenerator.fail("回复失败！");
        }
    }


    @ApiOperation(value = "加入拼途")
    @PostMapping("/appointmentParticipants")
    public Result insertAppointmentParticipant(@RequestBody AppointmentParticipant appointmentParticipant) {
        try {
            List<AppointmentParticipant> appointmentParticipants = appointmentService.getAppointmentParticipantsByAppointmentId(appointmentParticipant.getAppointmentId());
            Appointment appointment = appointmentService.getAppointmentById(appointmentParticipant.getAppointmentId());
            if (appointmentParticipants.size() >= appointment.getSum())
                return ResultGenerator.fail("该拼途人数已满，加入失败");

            appointmentService.insertAppointmentParticipant(appointmentParticipant);
            AppointmentParticipantUp appointmentParticipantUp = new AppointmentParticipantUp();
            upAppointmentParticipantUp(appointmentParticipant, appointmentParticipantUp);
            return ResultGenerator.success(appointmentParticipantUp);
        } catch (Exception e) {
            return ResultGenerator.fail("加入失败");
        }
    }


    @ApiOperation(value = "退出拼途")
    @DeleteMapping("/appointmentParticipants")
    public Result deleteAppointmentParticipant(@RequestBody AppointmentParticipant appointmentParticipant) {
        try {
            appointmentService.deleteAppointmentParticipant(appointmentParticipant);
            return ResultGenerator.success("退出成功！");
        } catch (Exception e) {
            return ResultGenerator.fail("退出失败！");
        }
    }


    @ApiOperation(value = "查询我创建的拼途")
    @GetMapping("/appointmentsByAuthor")
    public Result getAppointment(@RequestParam(value = "authorId") String authorId) {
        if (authorId.equals("0")) {// authorId为0返回全部
            List<Appointment> appointments = appointmentService.getAllAppointments();
            Map map = getAppointmentsAndAccountUps(appointments);
            return ResultGenerator.success(map);
        } else {// authorId为其他值返回作者的拼途
            List<Appointment> appointments = appointmentService.getAppointmentsByAuthorId(authorId);
            Map map = getAppointmentsAndAccountUps(appointments);
            return ResultGenerator.success(map);
        }
    }


    @ApiOperation(value = "根据keyword查询拼途")
    @GetMapping("/appointmentsByKeyword")
    public Result getAppointmentsByKeyword(@RequestParam(value = "keyword") String keyword) {
        Set<Appointment> appointments = new HashSet<>();
        try {
            int appointmentId = Integer.parseInt(keyword);
            Appointment appointment = appointmentService.getAppointmentById(appointmentId);
            if (appointment != null) appointments.add(appointment);
        } catch (Exception e) {
        } finally {
            keyword = "%" + keyword + "%"; //模糊查询
            List<Appointment> appointments1 = appointmentService.getAppointmentsByTag(keyword);
            if (appointments1 != null) appointments.addAll(appointments1);
            appointments1 = appointmentService.getAppointmentsByAuthorId(keyword);
            if (appointments1 != null) appointments.addAll(appointments1);
            appointments1 = appointmentService.getAppointmentByLPName(keyword);
            if (appointments1 != null) appointments.addAll(appointments1);
            appointments1 = appointmentService.getAppointmentBySPName(keyword);
            if (appointments1 != null) appointments.addAll(appointments1);
            appointments1 = appointmentService.getAppointmentsBySpotName(keyword);
            if (appointments1 != null) appointments.addAll(appointments1);
            appointments1 = appointmentService.getAppointmentByTitle(keyword);
            if (appointments1 != null) appointments.addAll(appointments1);

            // 排序
            List<Appointment> appointments2 = new ArrayList<>();
            appointments2.addAll(appointments);
            Collections.sort(appointments2);

            Map map = getAppointmentsAndAccountUps(appointments2);
            return ResultGenerator.success(map);
        }
    }


    @ApiOperation(value = "根据地点名查询拼途")
    @GetMapping("/appointmentsByPlaceName")
    public Result getAppointmentsByPlace(@RequestParam(value = "placeName") String placeName) {
        Set<Appointment> appointments = new HashSet<>();

        placeName = "%" + placeName + "%";
        List<Appointment> appointments1 = appointmentService.getAppointmentByLPName(placeName);
        if (appointments1 != null) appointments.addAll(appointments1);
        appointments1 = appointmentService.getAppointmentBySPName(placeName);
        if (appointments1 != null) appointments.addAll(appointments1);
        appointments1 = appointmentService.getAppointmentsBySpotName(placeName);
        if (appointments1 != null) appointments.addAll(appointments1);

        appointments1.clear();
        appointments1.addAll(appointments);
        Collections.sort(appointments1);

        Map map = getAppointmentsAndAccountUps(appointments1);

        return ResultGenerator.success(map);
    }


    @ApiOperation(value = "根据标签查询拼途")
    @GetMapping("/appointmentsByTag")
    public Result getAppointmentsByTag(@RequestParam(value = "tag") String tag) {
        List<Appointment> appointments = appointmentService.getAppointmentsByTag(tag);
        Map map = getAppointmentsAndAccountUps(appointments);
        return ResultGenerator.success(map);
    }


    @ApiOperation(value = "根据日期查询拼途", notes = "目前是根据月份查询本年拼途，输入本年月份即可(int)")
    @GetMapping("/appointmentsByTime")
    public Result getAppointmentsByTime(@RequestParam(value = "time") Integer time) {
        Date date1 = null, date2 = null;

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.set(Calendar.MONTH, time - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        date1 = calendar.getTime();

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        date2 = calendar.getTime();

        List<Appointment> appointments = appointmentService.getAppointmentsByTime(date1, date2);

        Map map = getAppointmentsAndAccountUps(appointments);
        return ResultGenerator.success(map);
    }


    @ApiOperation(value = "查询我参与的拼途")
    @GetMapping("/appointmentsByParticipantId")
    public Result getAppointmentsByParticipantId(@RequestParam(value = "participantId") String participantId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByParticipantId(participantId);

        Map map = getAppointmentsAndAccountUps(appointments);
        return ResultGenerator.success(map);
    }


    // 参与者
    private void upAppointmentParticipantUp(AppointmentParticipant appointmentParticipant, AppointmentParticipantUp appointmentParticipantUp) {
        appointmentParticipantUp.setAppointmentId(appointmentParticipant.getAppointmentId());
        appointmentParticipantUp.setUserId(appointmentParticipant.getUserId());
        String appointmentImagePath = accountService.getAccountInfoByUserId(appointmentParticipant.getUserId()).getImagePath();
        appointmentParticipantUp.setAppointmentImagePath(appointmentImagePath);
    }

    private void appointmentParticipantsToAppointmentParticipantUps(List<AppointmentParticipant> appointmentParticipants,
                                                                    List<AppointmentParticipantUp> appointmentParticipantUps) {
        for (AppointmentParticipant appointmentParticipant :
                appointmentParticipants) {
            AppointmentParticipantUp appointmentParticipantUp = new AppointmentParticipantUp();
            upAppointmentParticipantUp(appointmentParticipant, appointmentParticipantUp);
            appointmentParticipantUps.add(appointmentParticipantUp);
        }

    }


    // 评论
    private void upAppointmentReplyUp(AppointmentReply appointmentReply, AppointmentReplyUp appointmentReplyUp) {
        appointmentReplyUp.setAppointmentId(appointmentReply.getAppointmentId());
        appointmentReplyUp.setAuthorId(appointmentReply.getAuthorId());
        appointmentReplyUp.setContentEx(appointmentReply.getContentEx());
        appointmentReplyUp.setReplyId(appointmentReply.getReplyId());
        appointmentReplyUp.setTime(appointmentReply.getTime());
        AccountInfo accountInfo = accountService.getAccountInfoByUserId(appointmentReply.getAuthorId());
        appointmentReplyUp.setUserName(accountInfo.getUserName());
        appointmentReplyUp.setImagePath(accountInfo.getImagePath());

    }

    private void appointmentRepliesToAppointmentReplyUps(List<AppointmentReply> appointmentReplies,
                                                         List<AppointmentReplyUp> appointmentReplyUps) {

        for (AppointmentReply appointmentReply :
                appointmentReplies) {
            AppointmentReplyUp appointmentReplyUp = new AppointmentReplyUp();
            upAppointmentReplyUp(appointmentReply, appointmentReplyUp);
            appointmentReplyUps.add(appointmentReplyUp);
        }
    }


    // 如果数据库中没有用户输入的景点，就将景点插入数据库
    private void ensureSpotExists(Appointment appointment) {
        String spotName = appointment.getSpotName();
        if (spotName == null)
            return;
        ScenicSpot scenicSpot = spotService.getScenicSpotByName(spotName);
        if (scenicSpot == null) {
            scenicSpot = new ScenicSpot();
            scenicSpot.setPlaceId(1);
            scenicSpot.setSpotName(spotName);
            spotService.insertSpot(scenicSpot);
        }
    }

    // 如果数据库中没有用户输入的标签，就将标签插入数据库
    private void ensureTagExists(Appointment appointment) {

        Tag tag = tagService.selectTagByTagName(appointment.getTag1());
        if (tag == null && appointment.getTag1() != null) tagService.insertTag(new Tag(appointment.getTag1()));
        tag = tagService.selectTagByTagName(appointment.getTag2());
        if (tag == null && appointment.getTag2() != null) tagService.insertTag(new Tag(appointment.getTag2()));
        tag = tagService.selectTagByTagName(appointment.getTag3());
        if (tag == null && appointment.getTag3() != null) tagService.insertTag(new Tag(appointment.getTag3()));
    }


    // 加入作者信息
    private AccountUp addAccountUp(String accountId) {
        Account account = accountService.getAccountByUserId(accountId);
        AccountInfo accountInfo = accountService.getAccountInfoByUserId(accountId);
        AccountUp accountUp = new AccountUp();
        AccountUtil.upAccountUp(accountUp, account, accountInfo);
        return accountUp;
    }

    // 返回拼途及其对应的作者列表
    private Map getAppointmentsAndAccountUps(Collection<Appointment> appointments) {
//        if (appointments.size() == 0) return new HashMap();
        Map map = new LinkedHashMap();
        List<AccountUp> accountUps = new ArrayList<>();
        for (Appointment appointment :
                appointments) {
            accountUps.add(addAccountUp(appointment.getAuthorId()));
        }
        map.put("appointments", appointments);
        map.put("accountUps", accountUps);
        return map;
    }

}
