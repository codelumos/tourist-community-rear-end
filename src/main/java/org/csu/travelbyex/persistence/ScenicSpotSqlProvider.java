package org.csu.travelbyex.persistence;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;
import java.util.Map;
import org.csu.travelbyex.domain.ScenicSpot;
import org.csu.travelbyex.domain.ScenicSpotExample.Criteria;
import org.csu.travelbyex.domain.ScenicSpotExample.Criterion;
import org.csu.travelbyex.domain.ScenicSpotExample;

public class ScenicSpotSqlProvider {

    public String countByExample(ScenicSpotExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("scenic_spot");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ScenicSpotExample example) {
        BEGIN();
        DELETE_FROM("scenic_spot");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ScenicSpot record) {
        BEGIN();
        INSERT_INTO("scenic_spot");
        
        if (record.getSpotId() != null) {
            VALUES("spot_id", "#{spotId,jdbcType=INTEGER}");
        }
        
        if (record.getPlaceId() != null) {
            VALUES("place_id", "#{placeId,jdbcType=INTEGER}");
        }
        
        if (record.getSpotName() != null) {
            VALUES("spot_name", "#{spotName,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath1() != null) {
            VALUES("image_path_1", "#{imagePath1,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath2() != null) {
            VALUES("image_path_2", "#{imagePath2,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath3() != null) {
            VALUES("image_path_3", "#{imagePath3,jdbcType=VARCHAR}");
        }
        
        if (record.getTag1() != null) {
            VALUES("tag_1", "#{tag1,jdbcType=VARCHAR}");
        }
        
        if (record.getTag2() != null) {
            VALUES("tag_2", "#{tag2,jdbcType=VARCHAR}");
        }
        
        if (record.getTag3() != null) {
            VALUES("tag_3", "#{tag3,jdbcType=VARCHAR}");
        }
        
        if (record.getTag4() != null) {
            VALUES("tag_4", "#{tag4,jdbcType=VARCHAR}");
        }
        
        if (record.getTag5() != null) {
            VALUES("tag_5", "#{tag5,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(ScenicSpotExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("spot_id");
        } else {
            SELECT("spot_id");
        }
        SELECT("place_id");
        SELECT("spot_name");
        SELECT("image_path_1");
        SELECT("image_path_2");
        SELECT("image_path_3");
        SELECT("tag_1");
        SELECT("tag_2");
        SELECT("tag_3");
        SELECT("tag_4");
        SELECT("tag_5");
        SELECT("description");
        FROM("scenic_spot");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(ScenicSpotExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("spot_id");
        } else {
            SELECT("spot_id");
        }
        SELECT("place_id");
        SELECT("spot_name");
        SELECT("image_path_1");
        SELECT("image_path_2");
        SELECT("image_path_3");
        SELECT("tag_1");
        SELECT("tag_2");
        SELECT("tag_3");
        SELECT("tag_4");
        SELECT("tag_5");
        FROM("scenic_spot");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ScenicSpot record = (ScenicSpot) parameter.get("record");
        ScenicSpotExample example = (ScenicSpotExample) parameter.get("example");
        
        BEGIN();
        UPDATE("scenic_spot");
        
        if (record.getSpotId() != null) {
            SET("spot_id = #{record.spotId,jdbcType=INTEGER}");
        }
        
        if (record.getPlaceId() != null) {
            SET("place_id = #{record.placeId,jdbcType=INTEGER}");
        }
        
        if (record.getSpotName() != null) {
            SET("spot_name = #{record.spotName,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath1() != null) {
            SET("image_path_1 = #{record.imagePath1,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath2() != null) {
            SET("image_path_2 = #{record.imagePath2,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath3() != null) {
            SET("image_path_3 = #{record.imagePath3,jdbcType=VARCHAR}");
        }
        
        if (record.getTag1() != null) {
            SET("tag_1 = #{record.tag1,jdbcType=VARCHAR}");
        }
        
        if (record.getTag2() != null) {
            SET("tag_2 = #{record.tag2,jdbcType=VARCHAR}");
        }
        
        if (record.getTag3() != null) {
            SET("tag_3 = #{record.tag3,jdbcType=VARCHAR}");
        }
        
        if (record.getTag4() != null) {
            SET("tag_4 = #{record.tag4,jdbcType=VARCHAR}");
        }
        
        if (record.getTag5() != null) {
            SET("tag_5 = #{record.tag5,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("scenic_spot");
        
        SET("spot_id = #{record.spotId,jdbcType=INTEGER}");
        SET("place_id = #{record.placeId,jdbcType=INTEGER}");
        SET("spot_name = #{record.spotName,jdbcType=VARCHAR}");
        SET("image_path_1 = #{record.imagePath1,jdbcType=VARCHAR}");
        SET("image_path_2 = #{record.imagePath2,jdbcType=VARCHAR}");
        SET("image_path_3 = #{record.imagePath3,jdbcType=VARCHAR}");
        SET("tag_1 = #{record.tag1,jdbcType=VARCHAR}");
        SET("tag_2 = #{record.tag2,jdbcType=VARCHAR}");
        SET("tag_3 = #{record.tag3,jdbcType=VARCHAR}");
        SET("tag_4 = #{record.tag4,jdbcType=VARCHAR}");
        SET("tag_5 = #{record.tag5,jdbcType=VARCHAR}");
        SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        
        ScenicSpotExample example = (ScenicSpotExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("scenic_spot");
        
        SET("spot_id = #{record.spotId,jdbcType=INTEGER}");
        SET("place_id = #{record.placeId,jdbcType=INTEGER}");
        SET("spot_name = #{record.spotName,jdbcType=VARCHAR}");
        SET("image_path_1 = #{record.imagePath1,jdbcType=VARCHAR}");
        SET("image_path_2 = #{record.imagePath2,jdbcType=VARCHAR}");
        SET("image_path_3 = #{record.imagePath3,jdbcType=VARCHAR}");
        SET("tag_1 = #{record.tag1,jdbcType=VARCHAR}");
        SET("tag_2 = #{record.tag2,jdbcType=VARCHAR}");
        SET("tag_3 = #{record.tag3,jdbcType=VARCHAR}");
        SET("tag_4 = #{record.tag4,jdbcType=VARCHAR}");
        SET("tag_5 = #{record.tag5,jdbcType=VARCHAR}");
        
        ScenicSpotExample example = (ScenicSpotExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ScenicSpot record) {
        BEGIN();
        UPDATE("scenic_spot");
        
        if (record.getPlaceId() != null) {
            SET("place_id = #{placeId,jdbcType=INTEGER}");
        }
        
        if (record.getSpotName() != null) {
            SET("spot_name = #{spotName,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath1() != null) {
            SET("image_path_1 = #{imagePath1,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath2() != null) {
            SET("image_path_2 = #{imagePath2,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath3() != null) {
            SET("image_path_3 = #{imagePath3,jdbcType=VARCHAR}");
        }
        
        if (record.getTag1() != null) {
            SET("tag_1 = #{tag1,jdbcType=VARCHAR}");
        }
        
        if (record.getTag2() != null) {
            SET("tag_2 = #{tag2,jdbcType=VARCHAR}");
        }
        
        if (record.getTag3() != null) {
            SET("tag_3 = #{tag3,jdbcType=VARCHAR}");
        }
        
        if (record.getTag4() != null) {
            SET("tag_4 = #{tag4,jdbcType=VARCHAR}");
        }
        
        if (record.getTag5() != null) {
            SET("tag_5 = #{tag5,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("spot_id = #{spotId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(ScenicSpotExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}