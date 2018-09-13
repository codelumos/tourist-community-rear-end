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
import org.csu.travelbyex.domain.SmallPlace;
import org.csu.travelbyex.domain.SmallPlaceExample;

public interface SmallPlaceMapper {
    @SelectProvider(type=SmallPlaceSqlProvider.class, method="countByExample")
    int countByExample(SmallPlaceExample example);

    @DeleteProvider(type=SmallPlaceSqlProvider.class, method="deleteByExample")
    int deleteByExample(SmallPlaceExample example);

    @Delete({
        "delete from sp",
        "where sp_id = #{spId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer spId);

    @Insert({
        "insert into sp (sp_id, LP_id, ",
        "sp_name, image_path1, ",
        "image_path2, image_path3, ",
        "description)",
        "values (#{spId,jdbcType=INTEGER}, #{lpId,jdbcType=INTEGER}, ",
        "#{spName,jdbcType=VARCHAR}, #{imagePath1,jdbcType=VARCHAR}, ",
        "#{imagePath2,jdbcType=VARCHAR}, #{imagePath3,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=LONGVARCHAR})"
    })
    int insert(SmallPlace record);

    @InsertProvider(type=SmallPlaceSqlProvider.class, method="insertSelective")
    int insertSelective(SmallPlace record);

    @SelectProvider(type=SmallPlaceSqlProvider.class, method="selectByExampleWithBLOBs")
    @ConstructorArgs({
        @Arg(column="sp_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="LP_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="sp_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path1", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path2", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path3", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    List<SmallPlace> selectByExampleWithBLOBs(SmallPlaceExample example);

    @SelectProvider(type=SmallPlaceSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="sp_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="LP_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="sp_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path1", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path2", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path3", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<SmallPlace> selectByExample(SmallPlaceExample example);

    @Select({
        "select",
        "sp_id, LP_id, sp_name, image_path1, image_path2, image_path3, description",
        "from sp",
        "where sp_id = #{spId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="sp_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="LP_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="sp_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path1", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path2", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path3", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    SmallPlace selectByPrimaryKey(Integer spId);

    @UpdateProvider(type=SmallPlaceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SmallPlace record, @Param("example") SmallPlaceExample example);

    @UpdateProvider(type=SmallPlaceSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") SmallPlace record, @Param("example") SmallPlaceExample example);

    @UpdateProvider(type=SmallPlaceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SmallPlace record, @Param("example") SmallPlaceExample example);

    @UpdateProvider(type=SmallPlaceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SmallPlace record);

    @Update({
        "update sp",
        "set LP_id = #{lpId,jdbcType=INTEGER},",
          "sp_name = #{spName,jdbcType=VARCHAR},",
          "image_path1 = #{imagePath1,jdbcType=VARCHAR},",
          "image_path2 = #{imagePath2,jdbcType=VARCHAR},",
          "image_path3 = #{imagePath3,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where sp_id = #{spId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(SmallPlace record);

    @Update({
        "update sp",
        "set LP_id = #{lpId,jdbcType=INTEGER},",
          "sp_name = #{spName,jdbcType=VARCHAR},",
          "image_path1 = #{imagePath1,jdbcType=VARCHAR},",
          "image_path2 = #{imagePath2,jdbcType=VARCHAR},",
          "image_path3 = #{imagePath3,jdbcType=VARCHAR}",
        "where sp_id = #{spId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SmallPlace record);
}