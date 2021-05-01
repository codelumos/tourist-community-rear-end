package org.csu.travelbyex.persistence;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.csu.travelbyex.domain.AppointmentReply;
import org.csu.travelbyex.domain.AppointmentReplyExample;

import java.util.Date;
import java.util.List;

public interface AppointmentReplyMapper {
    @SelectProvider(type = AppointmentReplySqlProvider.class, method = "countByExample")
    int countByExample(AppointmentReplyExample example);

    @DeleteProvider(type = AppointmentReplySqlProvider.class, method = "deleteByExample")
    int deleteByExample(AppointmentReplyExample example);

    @Delete({
            "delete from appointment_reply",
            "where reply_id = #{replyId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer replyId);

    @Insert({
            "insert into appointment_reply (appointment_id, author_id, ",
            "time, content_ex)",
            "values (#{appointmentId,jdbcType=INTEGER}, #{authorId,jdbcType=VARCHAR}, ",
            "#{time,jdbcType=TIMESTAMP}, #{contentEx,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "replyId", before = false, resultType = Integer.class)
    int insert(AppointmentReply record);

    @InsertProvider(type = AppointmentReplySqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "replyId", before = false, resultType = Integer.class)
    int insertSelective(AppointmentReply record);

    @SelectProvider(type = AppointmentReplySqlProvider.class, method = "selectByExampleWithBLOBs")
    @ConstructorArgs({
            @Arg(column = "reply_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "appointment_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "author_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "content_ex", javaType = String.class, jdbcType = JdbcType.LONGVARCHAR)
    })
    List<AppointmentReply> selectByExampleWithBLOBs(AppointmentReplyExample example);

    @SelectProvider(type = AppointmentReplySqlProvider.class, method = "selectByExample")
    @ConstructorArgs({
            @Arg(column = "reply_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "appointment_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "author_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP)
    })
    List<AppointmentReply> selectByExample(AppointmentReplyExample example);

    @Select({
            "select",
            "reply_id, appointment_id, author_id, time, content_ex",
            "from appointment_reply",
            "where reply_id = #{replyId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "reply_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "appointment_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "author_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "content_ex", javaType = String.class, jdbcType = JdbcType.LONGVARCHAR)
    })
    AppointmentReply selectByPrimaryKey(Integer replyId);

    @UpdateProvider(type = AppointmentReplySqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AppointmentReply record, @Param("example") AppointmentReplyExample example);

    @UpdateProvider(type = AppointmentReplySqlProvider.class, method = "updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") AppointmentReply record, @Param("example") AppointmentReplyExample example);

    @UpdateProvider(type = AppointmentReplySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") AppointmentReply record, @Param("example") AppointmentReplyExample example);

    @UpdateProvider(type = AppointmentReplySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AppointmentReply record);

    @Update({
            "update appointment_reply",
            "set appointment_id = #{appointmentId,jdbcType=INTEGER},",
            "author_id = #{authorId,jdbcType=VARCHAR},",
            "time = #{time,jdbcType=TIMESTAMP},",
            "content_ex = #{contentEx,jdbcType=LONGVARCHAR}",
            "where reply_id = #{replyId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(AppointmentReply record);

    @Update({
            "update appointment_reply",
            "set appointment_id = #{appointmentId,jdbcType=INTEGER},",
            "author_id = #{authorId,jdbcType=VARCHAR},",
            "time = #{time,jdbcType=TIMESTAMP}",
            "where reply_id = #{replyId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AppointmentReply record);
}