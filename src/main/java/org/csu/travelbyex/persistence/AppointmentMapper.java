package org.csu.travelbyex.persistence;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.csu.travelbyex.domain.Appointment;
import org.csu.travelbyex.domain.AppointmentExample;

import java.util.Date;
import java.util.List;

public interface AppointmentMapper {
    @SelectProvider(type = AppointmentSqlProvider.class, method = "countByExample")
    int countByExample(AppointmentExample example);

    @DeleteProvider(type = AppointmentSqlProvider.class, method = "deleteByExample")
    int deleteByExample(AppointmentExample example);

    @Delete({
            "delete from appointment",
            "where appointment_id = #{appointmentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer appointmentId);

    @Insert({
            "insert into appointment (author_id, lp, ",
            "sp, spot_name, time, ",
            "image_path, sum, ",
            "title, tag_1, tag_2, ",
            "tag_3, content_ex)",
            "values (#{authorId,jdbcType=VARCHAR}, #{lp,jdbcType=VARCHAR}, ",
            "#{sp,jdbcType=VARCHAR}, #{spotName,jdbcType=VARCHAR}, #{time,jdbcType=DATE}, ",
            "#{imagePath,jdbcType=VARCHAR}, #{sum,jdbcType=SMALLINT}, ",
            "#{title,jdbcType=VARCHAR}, #{tag1,jdbcType=VARCHAR}, #{tag2,jdbcType=VARCHAR}, ",
            "#{tag3,jdbcType=VARCHAR}, #{contentEx,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "appointmentId", before = false, resultType = Integer.class)
    int insert(Appointment record);

    @InsertProvider(type = AppointmentSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "appointmentId", before = false, resultType = Integer.class)
    int insertSelective(Appointment record);

    @SelectProvider(type = AppointmentSqlProvider.class, method = "selectByExampleWithBLOBs")
    @ConstructorArgs({
            @Arg(column = "appointment_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "author_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "lp", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "sp", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "spot_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "time", javaType = Date.class, jdbcType = JdbcType.DATE),
            @Arg(column = "image_path", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "sum", javaType = Short.class, jdbcType = JdbcType.SMALLINT),
            @Arg(column = "title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag_1", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag_2", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag_3", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "content_ex", javaType = String.class, jdbcType = JdbcType.LONGVARCHAR)
    })
    List<Appointment> selectByExampleWithBLOBs(AppointmentExample example);

    @SelectProvider(type = AppointmentSqlProvider.class, method = "selectByExample")
    @ConstructorArgs({
            @Arg(column = "appointment_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "author_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "lp", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "sp", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "spot_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "time", javaType = Date.class, jdbcType = JdbcType.DATE),
            @Arg(column = "image_path", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "sum", javaType = Short.class, jdbcType = JdbcType.SMALLINT),
            @Arg(column = "title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag_1", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag_2", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag_3", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<Appointment> selectByExample(AppointmentExample example);

    @Select({
            "select",
            "appointment_id, author_id, lp, sp, spot_name, time, image_path, sum, title, ",
            "tag_1, tag_2, tag_3, content_ex",
            "from appointment",
            "where appointment_id = #{appointmentId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "appointment_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "author_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "lp", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "sp", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "spot_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "time", javaType = Date.class, jdbcType = JdbcType.DATE),
            @Arg(column = "image_path", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "sum", javaType = Short.class, jdbcType = JdbcType.SMALLINT),
            @Arg(column = "title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag_1", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag_2", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag_3", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "content_ex", javaType = String.class, jdbcType = JdbcType.LONGVARCHAR)
    })
    Appointment selectByPrimaryKey(Integer appointmentId);

    @UpdateProvider(type = AppointmentSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Appointment record, @Param("example") AppointmentExample example);

    @UpdateProvider(type = AppointmentSqlProvider.class, method = "updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Appointment record, @Param("example") AppointmentExample example);

    @UpdateProvider(type = AppointmentSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") Appointment record, @Param("example") AppointmentExample example);

    @UpdateProvider(type = AppointmentSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Appointment record);

    @Update({
            "update appointment",
            "set author_id = #{authorId,jdbcType=VARCHAR},",
            "lp = #{lp,jdbcType=VARCHAR},",
            "sp = #{sp,jdbcType=VARCHAR},",
            "spot_name = #{spotName,jdbcType=VARCHAR},",
            "time = #{time,jdbcType=DATE},",
            "image_path = #{imagePath,jdbcType=VARCHAR},",
            "sum = #{sum,jdbcType=SMALLINT},",
            "title = #{title,jdbcType=VARCHAR},",
            "tag_1 = #{tag1,jdbcType=VARCHAR},",
            "tag_2 = #{tag2,jdbcType=VARCHAR},",
            "tag_3 = #{tag3,jdbcType=VARCHAR},",
            "content_ex = #{contentEx,jdbcType=LONGVARCHAR}",
            "where appointment_id = #{appointmentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Appointment record);

    @Update({
            "update appointment",
            "set author_id = #{authorId,jdbcType=VARCHAR},",
            "lp = #{lp,jdbcType=VARCHAR},",
            "sp = #{sp,jdbcType=VARCHAR},",
            "spot_name = #{spotName,jdbcType=VARCHAR},",
            "time = #{time,jdbcType=DATE},",
            "image_path = #{imagePath,jdbcType=VARCHAR},",
            "sum = #{sum,jdbcType=SMALLINT},",
            "title = #{title,jdbcType=VARCHAR},",
            "tag_1 = #{tag1,jdbcType=VARCHAR},",
            "tag_2 = #{tag2,jdbcType=VARCHAR},",
            "tag_3 = #{tag3,jdbcType=VARCHAR}",
            "where appointment_id = #{appointmentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Appointment record);
}