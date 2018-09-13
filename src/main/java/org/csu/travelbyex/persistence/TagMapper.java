package org.csu.travelbyex.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.csu.travelbyex.domain.Tag;
import org.csu.travelbyex.domain.TagExample;

public interface TagMapper {
    @SelectProvider(type=TagSqlProvider.class, method="countByExample")
    int countByExample(TagExample example);

    @DeleteProvider(type=TagSqlProvider.class, method="deleteByExample")
    int deleteByExample(TagExample example);

    @Delete({
        "delete from tag",
        "where tag_name = #{tagName,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String tagName);

    @Insert({
        "insert into tag (tag_name)",
        "values (#{tagName,jdbcType=VARCHAR})"
    })
    int insert(Tag record);

    @InsertProvider(type=TagSqlProvider.class, method="insertSelective")
    int insertSelective(Tag record);

    @SelectProvider(type=TagSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="tag_name", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<Tag> selectByExample(TagExample example);

    @UpdateProvider(type=TagSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    @UpdateProvider(type=TagSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);
}