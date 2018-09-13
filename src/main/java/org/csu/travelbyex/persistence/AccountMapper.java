package org.csu.travelbyex.persistence;

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
import org.csu.travelbyex.domain.Account;
import org.csu.travelbyex.domain.AccountExample;

public interface AccountMapper {
    @SelectProvider(type=AccountSqlProvider.class, method="countByExample")
    int countByExample(AccountExample example);

    @DeleteProvider(type=AccountSqlProvider.class, method="deleteByExample")
    int deleteByExample(AccountExample example);

    @Delete({
        "delete from account",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userId);

    @Insert({
        "insert into account (user_id, password)",
        "values (#{userId,jdbcType=VARCHAR}, #{password,jdbcType=CHAR})"
    })
    int insert(Account record);

    @InsertProvider(type=AccountSqlProvider.class, method="insertSelective")
    int insertSelective(Account record);

    @SelectProvider(type=AccountSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.CHAR)
    })
    List<Account> selectByExample(AccountExample example);

    @Select({
        "select",
        "user_id, password",
        "from account",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.CHAR)
    })
    Account selectByPrimaryKey(String userId);

    @UpdateProvider(type=AccountSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    @UpdateProvider(type=AccountSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    @UpdateProvider(type=AccountSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Account record);

    @Update({
        "update account",
        "set password = #{password,jdbcType=CHAR}",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Account record);
}