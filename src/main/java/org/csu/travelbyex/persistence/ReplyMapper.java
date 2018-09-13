package org.csu.travelbyex.persistence;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.csu.travelbyex.domain.Reply;
import org.csu.travelbyex.domain.ReplyExample;

public interface ReplyMapper {
    @SelectProvider(type=ReplySqlProvider.class, method="countByExample")
    int countByExample(ReplyExample example);

    @DeleteProvider(type=ReplySqlProvider.class, method="deleteByExample")
    int deleteByExample(ReplyExample example);

    @Delete({
        "delete from reply",
        "where reply_id = #{replyId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer replyId);

    @Insert({
        "insert into reply (author_id, comment_id, ",
        "to_user_id, reply_time, ",
        "content_ex)",
        "values (#{authorId,jdbcType=VARCHAR}, #{commentId,jdbcType=INTEGER}, ",
        "#{toUserId,jdbcType=VARCHAR}, #{replyTime,jdbcType=TIMESTAMP}, ",
        "#{contentEx,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="replyId", before=false, resultType=Integer.class)
    int insert(Reply record);

    @InsertProvider(type=ReplySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="replyId", before=false, resultType=Integer.class)
    int insertSelective(Reply record);

    @SelectProvider(type=ReplySqlProvider.class, method="selectByExampleWithBLOBs")
    @ConstructorArgs({
        @Arg(column="reply_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="author_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="comment_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="to_user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="reply_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="content_ex", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Reply> selectByExampleWithBLOBs(ReplyExample example);

    @SelectProvider(type=ReplySqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="reply_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="author_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="comment_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="to_user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="reply_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<Reply> selectByExample(ReplyExample example);

    @Select({
        "select",
        "reply_id, author_id, comment_id, to_user_id, reply_time, content_ex",
        "from reply",
        "where reply_id = #{replyId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="reply_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="author_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="comment_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="to_user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="reply_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="content_ex", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    Reply selectByPrimaryKey(Integer replyId);

    @UpdateProvider(type=ReplySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Reply record, @Param("example") ReplyExample example);

    @UpdateProvider(type=ReplySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Reply record, @Param("example") ReplyExample example);

    @UpdateProvider(type=ReplySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Reply record, @Param("example") ReplyExample example);

    @UpdateProvider(type=ReplySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Reply record);

    @Update({
        "update reply",
        "set author_id = #{authorId,jdbcType=VARCHAR},",
          "comment_id = #{commentId,jdbcType=INTEGER},",
          "to_user_id = #{toUserId,jdbcType=VARCHAR},",
          "reply_time = #{replyTime,jdbcType=TIMESTAMP},",
          "content_ex = #{contentEx,jdbcType=LONGVARCHAR}",
        "where reply_id = #{replyId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Reply record);

    @Update({
        "update reply",
        "set author_id = #{authorId,jdbcType=VARCHAR},",
          "comment_id = #{commentId,jdbcType=INTEGER},",
          "to_user_id = #{toUserId,jdbcType=VARCHAR},",
          "reply_time = #{replyTime,jdbcType=TIMESTAMP}",
        "where reply_id = #{replyId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Reply record);
}