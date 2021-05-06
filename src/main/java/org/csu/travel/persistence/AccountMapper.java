package org.csu.travel.persistence;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.csu.travel.domain.Account;
import org.csu.travel.domain.AccountExample;

import java.util.List;

public interface AccountMapper {
    @SelectProvider(type = AccountSqlProvider.class, method = "countByExample")
    int countByExample(AccountExample example);

    @DeleteProvider(type = AccountSqlProvider.class, method = "deleteByExample")
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

    @InsertProvider(type = AccountSqlProvider.class, method = "insertSelective")
    int insertSelective(Account record);

    @SelectProvider(type = AccountSqlProvider.class, method = "selectByExample")
    @ConstructorArgs({
            @Arg(column = "user_id", javaType = String.class, jdbcType = JdbcType.VARCHAR, id = true),
            @Arg(column = "password", javaType = String.class, jdbcType = JdbcType.CHAR)
    })
    List<Account> selectByExample(AccountExample example);

    @Select({
            "select",
            "user_id, password",
            "from account",
            "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
            @Arg(column = "user_id", javaType = String.class, jdbcType = JdbcType.VARCHAR, id = true),
            @Arg(column = "password", javaType = String.class, jdbcType = JdbcType.CHAR)
    })
    Account selectByPrimaryKey(String userId);

    @UpdateProvider(type = AccountSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    @UpdateProvider(type = AccountSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    @UpdateProvider(type = AccountSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Account record);

    @Update({
            "update account",
            "set password = #{password,jdbcType=CHAR}",
            "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Account record);
}