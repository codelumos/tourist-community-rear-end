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
import org.csu.travelbyex.domain.ScenicSpot;
import org.csu.travelbyex.domain.ScenicSpotExample;

public interface ScenicSpotMapper {
    @SelectProvider(type=ScenicSpotSqlProvider.class, method="countByExample")
    int countByExample(ScenicSpotExample example);

    @DeleteProvider(type=ScenicSpotSqlProvider.class, method="deleteByExample")
    int deleteByExample(ScenicSpotExample example);

    @Delete({
        "delete from scenic_spot",
        "where spot_id = #{spotId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer spotId);

    @Insert({
        "insert into scenic_spot (spot_id, place_id, ",
        "spot_name, image_path_1, ",
        "image_path_2, image_path_3, ",
        "tag_1, tag_2, tag_3, ",
        "tag_4, tag_5, description)",
        "values (#{spotId,jdbcType=INTEGER}, #{placeId,jdbcType=INTEGER}, ",
        "#{spotName,jdbcType=VARCHAR}, #{imagePath1,jdbcType=VARCHAR}, ",
        "#{imagePath2,jdbcType=VARCHAR}, #{imagePath3,jdbcType=VARCHAR}, ",
        "#{tag1,jdbcType=VARCHAR}, #{tag2,jdbcType=VARCHAR}, #{tag3,jdbcType=VARCHAR}, ",
        "#{tag4,jdbcType=VARCHAR}, #{tag5,jdbcType=VARCHAR}, #{description,jdbcType=LONGVARCHAR})"
    })
    int insert(ScenicSpot record);

    @InsertProvider(type=ScenicSpotSqlProvider.class, method="insertSelective")
    int insertSelective(ScenicSpot record);

    @SelectProvider(type=ScenicSpotSqlProvider.class, method="selectByExampleWithBLOBs")
    @ConstructorArgs({
        @Arg(column="spot_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="place_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="spot_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path_1", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path_2", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path_3", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_1", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_2", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_3", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_4", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_5", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ScenicSpot> selectByExampleWithBLOBs(ScenicSpotExample example);

    @SelectProvider(type=ScenicSpotSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="spot_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="place_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="spot_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path_1", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path_2", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path_3", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_1", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_2", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_3", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_4", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_5", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<ScenicSpot> selectByExample(ScenicSpotExample example);

    @Select({
        "select",
        "spot_id, place_id, spot_name, image_path_1, image_path_2, image_path_3, tag_1, ",
        "tag_2, tag_3, tag_4, tag_5, description",
        "from scenic_spot",
        "where spot_id = #{spotId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="spot_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="place_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="spot_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path_1", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path_2", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="image_path_3", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_1", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_2", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_3", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_4", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="tag_5", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    ScenicSpot selectByPrimaryKey(Integer spotId);

    @UpdateProvider(type=ScenicSpotSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ScenicSpot record, @Param("example") ScenicSpotExample example);

    @UpdateProvider(type=ScenicSpotSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ScenicSpot record, @Param("example") ScenicSpotExample example);

    @UpdateProvider(type=ScenicSpotSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ScenicSpot record, @Param("example") ScenicSpotExample example);

    @UpdateProvider(type=ScenicSpotSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ScenicSpot record);

    @Update({
        "update scenic_spot",
        "set place_id = #{placeId,jdbcType=INTEGER},",
          "spot_name = #{spotName,jdbcType=VARCHAR},",
          "image_path_1 = #{imagePath1,jdbcType=VARCHAR},",
          "image_path_2 = #{imagePath2,jdbcType=VARCHAR},",
          "image_path_3 = #{imagePath3,jdbcType=VARCHAR},",
          "tag_1 = #{tag1,jdbcType=VARCHAR},",
          "tag_2 = #{tag2,jdbcType=VARCHAR},",
          "tag_3 = #{tag3,jdbcType=VARCHAR},",
          "tag_4 = #{tag4,jdbcType=VARCHAR},",
          "tag_5 = #{tag5,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where spot_id = #{spotId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(ScenicSpot record);

    @Update({
        "update scenic_spot",
        "set place_id = #{placeId,jdbcType=INTEGER},",
          "spot_name = #{spotName,jdbcType=VARCHAR},",
          "image_path_1 = #{imagePath1,jdbcType=VARCHAR},",
          "image_path_2 = #{imagePath2,jdbcType=VARCHAR},",
          "image_path_3 = #{imagePath3,jdbcType=VARCHAR},",
          "tag_1 = #{tag1,jdbcType=VARCHAR},",
          "tag_2 = #{tag2,jdbcType=VARCHAR},",
          "tag_3 = #{tag3,jdbcType=VARCHAR},",
          "tag_4 = #{tag4,jdbcType=VARCHAR},",
          "tag_5 = #{tag5,jdbcType=VARCHAR}",
        "where spot_id = #{spotId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ScenicSpot record);
}