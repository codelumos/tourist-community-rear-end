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
import org.csu.travelbyex.domain.SmallPlace;
import org.csu.travelbyex.domain.SmallPlaceExample.Criteria;
import org.csu.travelbyex.domain.SmallPlaceExample.Criterion;
import org.csu.travelbyex.domain.SmallPlaceExample;

public class SmallPlaceSqlProvider {

    public String countByExample(SmallPlaceExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sp");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(SmallPlaceExample example) {
        BEGIN();
        DELETE_FROM("sp");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(SmallPlace record) {
        BEGIN();
        INSERT_INTO("sp");
        
        if (record.getSpId() != null) {
            VALUES("sp_id", "#{spId,jdbcType=INTEGER}");
        }
        
        if (record.getLpId() != null) {
            VALUES("LP_id", "#{lpId,jdbcType=INTEGER}");
        }
        
        if (record.getSpName() != null) {
            VALUES("sp_name", "#{spName,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath1() != null) {
            VALUES("image_path1", "#{imagePath1,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath2() != null) {
            VALUES("image_path2", "#{imagePath2,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath3() != null) {
            VALUES("image_path3", "#{imagePath3,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(SmallPlaceExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("sp_id");
        } else {
            SELECT("sp_id");
        }
        SELECT("LP_id");
        SELECT("sp_name");
        SELECT("image_path1");
        SELECT("image_path2");
        SELECT("image_path3");
        SELECT("description");
        FROM("sp");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(SmallPlaceExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("sp_id");
        } else {
            SELECT("sp_id");
        }
        SELECT("LP_id");
        SELECT("sp_name");
        SELECT("image_path1");
        SELECT("image_path2");
        SELECT("image_path3");
        FROM("sp");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SmallPlace record = (SmallPlace) parameter.get("record");
        SmallPlaceExample example = (SmallPlaceExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sp");
        
        if (record.getSpId() != null) {
            SET("sp_id = #{record.spId,jdbcType=INTEGER}");
        }
        
        if (record.getLpId() != null) {
            SET("LP_id = #{record.lpId,jdbcType=INTEGER}");
        }
        
        if (record.getSpName() != null) {
            SET("sp_name = #{record.spName,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath1() != null) {
            SET("image_path1 = #{record.imagePath1,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath2() != null) {
            SET("image_path2 = #{record.imagePath2,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath3() != null) {
            SET("image_path3 = #{record.imagePath3,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sp");
        
        SET("sp_id = #{record.spId,jdbcType=INTEGER}");
        SET("LP_id = #{record.lpId,jdbcType=INTEGER}");
        SET("sp_name = #{record.spName,jdbcType=VARCHAR}");
        SET("image_path1 = #{record.imagePath1,jdbcType=VARCHAR}");
        SET("image_path2 = #{record.imagePath2,jdbcType=VARCHAR}");
        SET("image_path3 = #{record.imagePath3,jdbcType=VARCHAR}");
        SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        
        SmallPlaceExample example = (SmallPlaceExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sp");
        
        SET("sp_id = #{record.spId,jdbcType=INTEGER}");
        SET("LP_id = #{record.lpId,jdbcType=INTEGER}");
        SET("sp_name = #{record.spName,jdbcType=VARCHAR}");
        SET("image_path1 = #{record.imagePath1,jdbcType=VARCHAR}");
        SET("image_path2 = #{record.imagePath2,jdbcType=VARCHAR}");
        SET("image_path3 = #{record.imagePath3,jdbcType=VARCHAR}");
        
        SmallPlaceExample example = (SmallPlaceExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(SmallPlace record) {
        BEGIN();
        UPDATE("sp");
        
        if (record.getLpId() != null) {
            SET("LP_id = #{lpId,jdbcType=INTEGER}");
        }
        
        if (record.getSpName() != null) {
            SET("sp_name = #{spName,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath1() != null) {
            SET("image_path1 = #{imagePath1,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath2() != null) {
            SET("image_path2 = #{imagePath2,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath3() != null) {
            SET("image_path3 = #{imagePath3,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("sp_id = #{spId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(SmallPlaceExample example, boolean includeExamplePhrase) {
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