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
import org.csu.travelbyex.domain.LargePlace;
import org.csu.travelbyex.domain.LargePlaceExample;

public interface LargePlaceMapper {
    @SelectProvider(type=LargePlaceSqlProvider.class, method="countByExample")
    int countByExample(LargePlaceExample example);

    @DeleteProvider(type=LargePlaceSqlProvider.class, method="deleteByExample")
    int deleteByExample(LargePlaceExample example);

    @Delete({
        "delete from lp",
        "where LP_id = #{lpId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer lpId);

    @Insert({
        "insert into lp (LP_id, LP_name, ",
        "is_home, description)",
        "values (#{lpId,jdbcType=INTEGER}, #{lpName,jdbcType=VARCHAR}, ",
        "#{isHome,jdbcType=BIT}, #{description,jdbcType=LONGVARCHAR})"
    })
    int insert(LargePlace record);

    @InsertProvider(type=LargePlaceSqlProvider.class, method="insertSelective")
    int insertSelective(LargePlace record);

    @SelectProvider(type=LargePlaceSqlProvider.class, method="selectByExampleWithBLOBs")
    @ConstructorArgs({
        @Arg(column="LP_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="LP_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_home", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    List<LargePlace> selectByExampleWithBLOBs(LargePlaceExample example);

    @SelectProvider(type=LargePlaceSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="LP_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="LP_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_home", javaType=Boolean.class, jdbcType=JdbcType.BIT)
    })
    List<LargePlace> selectByExample(LargePlaceExample example);

    @Select({
        "select",
        "LP_id, LP_name, is_home, description",
        "from lp",
        "where LP_id = #{lpId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="LP_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="LP_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_home", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    LargePlace selectByPrimaryKey(Integer lpId);

    @UpdateProvider(type=LargePlaceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") LargePlace record, @Param("example") LargePlaceExample example);

    @UpdateProvider(type=LargePlaceSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") LargePlace record, @Param("example") LargePlaceExample example);

    @UpdateProvider(type=LargePlaceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") LargePlace record, @Param("example") LargePlaceExample example);

    @UpdateProvider(type=LargePlaceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LargePlace record);

    @Update({
        "update lp",
        "set LP_name = #{lpName,jdbcType=VARCHAR},",
          "is_home = #{isHome,jdbcType=BIT},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where LP_id = #{lpId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(LargePlace record);

    @Update({
        "update lp",
        "set LP_name = #{lpName,jdbcType=VARCHAR},",
          "is_home = #{isHome,jdbcType=BIT}",
        "where LP_id = #{lpId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(LargePlace record);
}