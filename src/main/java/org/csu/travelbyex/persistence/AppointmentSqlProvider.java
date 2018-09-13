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
import org.csu.travelbyex.domain.Appointment;
import org.csu.travelbyex.domain.AppointmentExample.Criteria;
import org.csu.travelbyex.domain.AppointmentExample.Criterion;
import org.csu.travelbyex.domain.AppointmentExample;

public class AppointmentSqlProvider {

    public String countByExample(AppointmentExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("appointment");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(AppointmentExample example) {
        BEGIN();
        DELETE_FROM("appointment");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Appointment record) {
        BEGIN();
        INSERT_INTO("appointment");
        
        if (record.getSpotId() != null) {
            VALUES("spot_id", "#{spotId,jdbcType=INTEGER}");
        }
        
        if (record.getAuthorId() != null) {
            VALUES("author_id", "#{authorId,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            VALUES("time", "#{time,jdbcType=DATE}");
        }
        
        if (record.getImagePath() != null) {
            VALUES("image_path", "#{imagePath,jdbcType=VARCHAR}");
        }
        
        if (record.getSum() != null) {
            VALUES("sum", "#{sum,jdbcType=SMALLINT}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
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
        
        if (record.getContentEx() != null) {
            VALUES("content_ex", "#{contentEx,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(AppointmentExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("appointment_id");
        } else {
            SELECT("appointment_id");
        }
        SELECT("spot_id");
        SELECT("author_id");
        SELECT("time");
        SELECT("image_path");
        SELECT("sum");
        SELECT("title");
        SELECT("tag_1");
        SELECT("tag_2");
        SELECT("tag_3");
        SELECT("content_ex");
        FROM("appointment");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(AppointmentExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("appointment_id");
        } else {
            SELECT("appointment_id");
        }
        SELECT("spot_id");
        SELECT("author_id");
        SELECT("time");
        SELECT("image_path");
        SELECT("sum");
        SELECT("title");
        SELECT("tag_1");
        SELECT("tag_2");
        SELECT("tag_3");
        FROM("appointment");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Appointment record = (Appointment) parameter.get("record");
        AppointmentExample example = (AppointmentExample) parameter.get("example");
        
        BEGIN();
        UPDATE("appointment");
        
        if (record.getAppointmentId() != null) {
            SET("appointment_id = #{record.appointmentId,jdbcType=INTEGER}");
        }
        
        if (record.getSpotId() != null) {
            SET("spot_id = #{record.spotId,jdbcType=INTEGER}");
        }
        
        if (record.getAuthorId() != null) {
            SET("author_id = #{record.authorId,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{record.time,jdbcType=DATE}");
        }
        
        if (record.getImagePath() != null) {
            SET("image_path = #{record.imagePath,jdbcType=VARCHAR}");
        }
        
        if (record.getSum() != null) {
            SET("sum = #{record.sum,jdbcType=SMALLINT}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{record.title,jdbcType=VARCHAR}");
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
        
        if (record.getContentEx() != null) {
            SET("content_ex = #{record.contentEx,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("appointment");
        
        SET("appointment_id = #{record.appointmentId,jdbcType=INTEGER}");
        SET("spot_id = #{record.spotId,jdbcType=INTEGER}");
        SET("author_id = #{record.authorId,jdbcType=VARCHAR}");
        SET("time = #{record.time,jdbcType=DATE}");
        SET("image_path = #{record.imagePath,jdbcType=VARCHAR}");
        SET("sum = #{record.sum,jdbcType=SMALLINT}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("tag_1 = #{record.tag1,jdbcType=VARCHAR}");
        SET("tag_2 = #{record.tag2,jdbcType=VARCHAR}");
        SET("tag_3 = #{record.tag3,jdbcType=VARCHAR}");
        SET("content_ex = #{record.contentEx,jdbcType=LONGVARCHAR}");
        
        AppointmentExample example = (AppointmentExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("appointment");
        
        SET("appointment_id = #{record.appointmentId,jdbcType=INTEGER}");
        SET("spot_id = #{record.spotId,jdbcType=INTEGER}");
        SET("author_id = #{record.authorId,jdbcType=VARCHAR}");
        SET("time = #{record.time,jdbcType=DATE}");
        SET("image_path = #{record.imagePath,jdbcType=VARCHAR}");
        SET("sum = #{record.sum,jdbcType=SMALLINT}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("tag_1 = #{record.tag1,jdbcType=VARCHAR}");
        SET("tag_2 = #{record.tag2,jdbcType=VARCHAR}");
        SET("tag_3 = #{record.tag3,jdbcType=VARCHAR}");
        
        AppointmentExample example = (AppointmentExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Appointment record) {
        BEGIN();
        UPDATE("appointment");
        
        if (record.getSpotId() != null) {
            SET("spot_id = #{spotId,jdbcType=INTEGER}");
        }
        
        if (record.getAuthorId() != null) {
            SET("author_id = #{authorId,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{time,jdbcType=DATE}");
        }
        
        if (record.getImagePath() != null) {
            SET("image_path = #{imagePath,jdbcType=VARCHAR}");
        }
        
        if (record.getSum() != null) {
            SET("sum = #{sum,jdbcType=SMALLINT}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
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
        
        if (record.getContentEx() != null) {
            SET("content_ex = #{contentEx,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("appointment_id = #{appointmentId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(AppointmentExample example, boolean includeExamplePhrase) {
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