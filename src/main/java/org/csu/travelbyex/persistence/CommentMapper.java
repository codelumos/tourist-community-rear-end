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
import org.csu.travelbyex.domain.Comment;
import org.csu.travelbyex.domain.CommentExample;

public interface CommentMapper {
    @SelectProvider(type=CommentSqlProvider.class, method="countByExample")
    int countByExample(CommentExample example);

    @DeleteProvider(type=CommentSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommentExample example);

    @Delete({
        "delete from comment_ex",
        "where comment_id = #{commentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer commentId);

    @Insert({
        "insert into comment_ex (article_id, author_id, ",
        "time, content_ex)",
        "values (#{articleId,jdbcType=INTEGER}, #{authorId,jdbcType=VARCHAR}, ",
        "#{time,jdbcType=TIMESTAMP}, #{contentEx,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="commentId", before=false, resultType=Integer.class)
    int insert(Comment record);

    @InsertProvider(type=CommentSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="commentId", before=false, resultType=Integer.class)
    int insertSelective(Comment record);

    @SelectProvider(type=CommentSqlProvider.class, method="selectByExampleWithBLOBs")
    @ConstructorArgs({
        @Arg(column="comment_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="article_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="author_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="content_ex", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Comment> selectByExampleWithBLOBs(CommentExample example);

    @SelectProvider(type=CommentSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="comment_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="article_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="author_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<Comment> selectByExample(CommentExample example);

    @Select({
        "select",
        "comment_id, article_id, author_id, time, content_ex",
        "from comment_ex",
        "where comment_id = #{commentId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="comment_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="article_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="author_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="content_ex", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    Comment selectByPrimaryKey(Integer commentId);

    @UpdateProvider(type=CommentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    @UpdateProvider(type=CommentSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Comment record, @Param("example") CommentExample example);

    @UpdateProvider(type=CommentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    @UpdateProvider(type=CommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Comment record);

    @Update({
        "update comment_ex",
        "set article_id = #{articleId,jdbcType=INTEGER},",
          "author_id = #{authorId,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "content_ex = #{contentEx,jdbcType=LONGVARCHAR}",
        "where comment_id = #{commentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Comment record);

    @Update({
        "update comment_ex",
        "set article_id = #{articleId,jdbcType=INTEGER},",
          "author_id = #{authorId,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=TIMESTAMP}",
        "where comment_id = #{commentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Comment record);
}