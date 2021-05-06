package org.csu.travel.persistence;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.csu.travel.domain.AppointmentParticipant;
import org.csu.travel.domain.AppointmentParticipantExample;

import java.util.List;

public interface AppointmentParticipantMapper {
    @SelectProvider(type = AppointmentParticipantSqlProvider.class, method = "countByExample")
    int countByExample(AppointmentParticipantExample example);

    @DeleteProvider(type = AppointmentParticipantSqlProvider.class, method = "deleteByExample")
    int deleteByExample(AppointmentParticipantExample example);

    @Delete({
            "delete from appointment_participant",
            "where user_id = #{userId,jdbcType=VARCHAR}",
            "and appointment_id = #{appointmentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(@Param("userId") String userId, @Param("appointmentId") Integer appointmentId);

    @Insert({
            "insert into appointment_participant (user_id, appointment_id)",
            "values (#{userId,jdbcType=VARCHAR}, #{appointmentId,jdbcType=INTEGER})"
    })
    int insert(AppointmentParticipant record);

    @InsertProvider(type = AppointmentParticipantSqlProvider.class, method = "insertSelective")
    int insertSelective(AppointmentParticipant record);

    @SelectProvider(type = AppointmentParticipantSqlProvider.class, method = "selectByExample")
    @ConstructorArgs({
            @Arg(column = "user_id", javaType = String.class, jdbcType = JdbcType.VARCHAR, id = true),
            @Arg(column = "appointment_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true)
    })
    List<AppointmentParticipant> selectByExample(AppointmentParticipantExample example);

    @UpdateProvider(type = AppointmentParticipantSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AppointmentParticipant record, @Param("example") AppointmentParticipantExample example);

    @UpdateProvider(type = AppointmentParticipantSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") AppointmentParticipant record, @Param("example") AppointmentParticipantExample example);
}