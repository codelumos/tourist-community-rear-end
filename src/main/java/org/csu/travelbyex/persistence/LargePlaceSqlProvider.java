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
import org.csu.travelbyex.domain.LargePlace;
import org.csu.travelbyex.domain.LargePlaceExample.Criteria;
import org.csu.travelbyex.domain.LargePlaceExample.Criterion;
import org.csu.travelbyex.domain.LargePlaceExample;

public class LargePlaceSqlProvider {

    public String countByExample(LargePlaceExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("lp");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(LargePlaceExample example) {
        BEGIN();
        DELETE_FROM("lp");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(LargePlace record) {
        BEGIN();
        INSERT_INTO("lp");
        
        if (record.getLpId() != null) {
            VALUES("LP_id", "#{lpId,jdbcType=INTEGER}");
        }
        
        if (record.getLpName() != null) {
            VALUES("LP_name", "#{lpName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsHome() != null) {
            VALUES("is_home", "#{isHome,jdbcType=BIT}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(LargePlaceExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("LP_id");
        } else {
            SELECT("LP_id");
        }
        SELECT("LP_name");
        SELECT("is_home");
        SELECT("description");
        FROM("lp");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(LargePlaceExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("LP_id");
        } else {
            SELECT("LP_id");
        }
        SELECT("LP_name");
        SELECT("is_home");
        FROM("lp");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        LargePlace record = (LargePlace) parameter.get("record");
        LargePlaceExample example = (LargePlaceExample) parameter.get("example");
        
        BEGIN();
        UPDATE("lp");
        
        if (record.getLpId() != null) {
            SET("LP_id = #{record.lpId,jdbcType=INTEGER}");
        }
        
        if (record.getLpName() != null) {
            SET("LP_name = #{record.lpName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsHome() != null) {
            SET("is_home = #{record.isHome,jdbcType=BIT}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("lp");
        
        SET("LP_id = #{record.lpId,jdbcType=INTEGER}");
        SET("LP_name = #{record.lpName,jdbcType=VARCHAR}");
        SET("is_home = #{record.isHome,jdbcType=BIT}");
        SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        
        LargePlaceExample example = (LargePlaceExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("lp");
        
        SET("LP_id = #{record.lpId,jdbcType=INTEGER}");
        SET("LP_name = #{record.lpName,jdbcType=VARCHAR}");
        SET("is_home = #{record.isHome,jdbcType=BIT}");
        
        LargePlaceExample example = (LargePlaceExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(LargePlace record) {
        BEGIN();
        UPDATE("lp");
        
        if (record.getLpName() != null) {
            SET("LP_name = #{lpName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsHome() != null) {
            SET("is_home = #{isHome,jdbcType=BIT}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("LP_id = #{lpId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(LargePlaceExample example, boolean includeExamplePhrase) {
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