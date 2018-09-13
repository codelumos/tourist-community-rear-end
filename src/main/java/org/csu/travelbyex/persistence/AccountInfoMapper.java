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
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.csu.travelbyex.domain.AccountInfo;
import org.csu.travelbyex.domain.AccountInfoExample;

public interface AccountInfoMapper {
    @SelectProvider(type=AccountInfoSqlProvider.class, method="countByExample")
    int countByExample(AccountInfoExample example);

    @DeleteProvider(type=AccountInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(AccountInfoExample example);

    @Delete({
        "delete from account_info",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userId);

    @Insert({
        "insert into account_info (user_id, user_name, ",
        "image_path, sex, ",
        "homeLP, homeSP, ",
        "liveLP, liveSP, ",
        "birthday, tag1, tag2, ",
        "tag3, description)",
        "values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{imagePath,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR}, ",
        "#{homelp,jdbcType=VARCHAR}, #{homesp,jdbcType=VARCHAR}, ",
        "#{livelp,jdbcType=VARCHAR}, #{livesp,jdbcType=VARCHAR}, ",
        "#{birthday,jdbcType=DATE}, #{tag1,jdbcType=VARCHAR}, #{tag2,jdbcType=VARCHAR}, ",
        "#{tag3,jdbcType=VARCHAR}, #{description,jdbcType=LONGVARCHAR})"
    })
    int insert(AccountInfo record);

    @InsertProvider(type=AccountInfoSqlProvider.class, method="insertSelective")
    int insertSelective(AccountInfo record);

    @SelectProvider(type=AccountInfoSqlProvider.class, method="selectByExampleWithBLOBs")
    @ConstructorArgs({
        @Arg(column="user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="user_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="sex", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="homeLP", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="homeSP", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="liveLP", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="liveSP", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="birthday", javaType=Date.class, jdbcType=JdbcType.DATE),
        @Arg(column="tag1", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag2", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag3", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    List<AccountInfo> selectByExampleWithBLOBs(AccountInfoExample example);

    @SelectProvider(type=AccountInfoSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="user_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="sex", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="homeLP", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="homeSP", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="liveLP", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="liveSP", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="birthday", javaType=Date.class, jdbcType=JdbcType.DATE),
        @Arg(column="tag1", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag2", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag3", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<AccountInfo> selectByExample(AccountInfoExample example);

    @Select({
        "select",
        "user_id, user_name, image_path, sex, homeLP, homeSP, liveLP, liveSP, birthday, ",
        "tag1, tag2, tag3, description",
        "from account_info",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="user_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="sex", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="homeLP", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="homeSP", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="liveLP", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="liveSP", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="birthday", javaType=Date.class, jdbcType=JdbcType.DATE),
        @Arg(column="tag1", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag2", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag3", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    AccountInfo selectByPrimaryKey(String userId);

    @UpdateProvider(type=AccountInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AccountInfo record, @Param("example") AccountInfoExample example);

    @UpdateProvider(type=AccountInfoSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") AccountInfo record, @Param("example") AccountInfoExample example);

    @UpdateProvider(type=AccountInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AccountInfo record, @Param("example") AccountInfoExample example);

    @UpdateProvider(type=AccountInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AccountInfo record);

    @Update({
        "update account_info",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "image_path = #{imagePath,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "homeLP = #{homelp,jdbcType=VARCHAR},",
          "homeSP = #{homesp,jdbcType=VARCHAR},",
          "liveLP = #{livelp,jdbcType=VARCHAR},",
          "liveSP = #{livesp,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=DATE},",
          "tag1 = #{tag1,jdbcType=VARCHAR},",
          "tag2 = #{tag2,jdbcType=VARCHAR},",
          "tag3 = #{tag3,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(AccountInfo record);

    @Update({
        "update account_info",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "image_path = #{imagePath,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "homeLP = #{homelp,jdbcType=VARCHAR},",
          "homeSP = #{homesp,jdbcType=VARCHAR},",
          "liveLP = #{livelp,jdbcType=VARCHAR},",
          "liveSP = #{livesp,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=DATE},",
          "tag1 = #{tag1,jdbcType=VARCHAR},",
          "tag2 = #{tag2,jdbcType=VARCHAR},",
          "tag3 = #{tag3,jdbcType=VARCHAR}",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(AccountInfo record);
}