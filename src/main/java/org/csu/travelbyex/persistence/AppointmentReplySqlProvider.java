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
import org.csu.travelbyex.domain.AppointmentReply;
import org.csu.travelbyex.domain.AppointmentReplyExample.Criteria;
import org.csu.travelbyex.domain.AppointmentReplyExample.Criterion;
import org.csu.travelbyex.domain.AppointmentReplyExample;

public class AppointmentReplySqlProvider {

    public String countByExample(AppointmentReplyExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("appointment_reply");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(AppointmentReplyExample example) {
        BEGIN();
        DELETE_FROM("appointment_reply");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(AppointmentReply record) {
        BEGIN();
        INSERT_INTO("appointment_reply");
        
        if (record.getAppointmentId() != null) {
            VALUES("appointment_id", "#{appointmentId,jdbcType=INTEGER}");
        }
        
        if (record.getAuthorId() != null) {
            VALUES("author_id", "#{authorId,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            VALUES("time", "#{time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContentEx() != null) {
            VALUES("content_ex", "#{contentEx,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(AppointmentReplyExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("reply_id");
        } else {
            SELECT("reply_id");
        }
        SELECT("appointment_id");
        SELECT("author_id");
        SELECT("time");
        SELECT("content_ex");
        FROM("appointment_reply");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(AppointmentReplyExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("reply_id");
        } else {
            SELECT("reply_id");
        }
        SELECT("appointment_id");
        SELECT("author_id");
        SELECT("time");
        FROM("appointment_reply");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        AppointmentReply record = (AppointmentReply) parameter.get("record");
        AppointmentReplyExample example = (AppointmentReplyExample) parameter.get("example");
        
        BEGIN();
        UPDATE("appointment_reply");
        
        if (record.getReplyId() != null) {
            SET("reply_id = #{record.replyId,jdbcType=INTEGER}");
        }
        
        if (record.getAppointmentId() != null) {
            SET("appointment_id = #{record.appointmentId,jdbcType=INTEGER}");
        }
        
        if (record.getAuthorId() != null) {
            SET("author_id = #{record.authorId,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{record.time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContentEx() != null) {
            SET("content_ex = #{record.contentEx,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("appointment_reply");
        
        SET("reply_id = #{record.replyId,jdbcType=INTEGER}");
        SET("appointment_id = #{record.appointmentId,jdbcType=INTEGER}");
        SET("author_id = #{record.authorId,jdbcType=VARCHAR}");
        SET("time = #{record.time,jdbcType=TIMESTAMP}");
        SET("content_ex = #{record.contentEx,jdbcType=LONGVARCHAR}");
        
        AppointmentReplyExample example = (AppointmentReplyExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("appointment_reply");
        
        SET("reply_id = #{record.replyId,jdbcType=INTEGER}");
        SET("appointment_id = #{record.appointmentId,jdbcType=INTEGER}");
        SET("author_id = #{record.authorId,jdbcType=VARCHAR}");
        SET("time = #{record.time,jdbcType=TIMESTAMP}");
        
        AppointmentReplyExample example = (AppointmentReplyExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(AppointmentReply record) {
        BEGIN();
        UPDATE("appointment_reply");
        
        if (record.getAppointmentId() != null) {
            SET("appointment_id = #{appointmentId,jdbcType=INTEGER}");
        }
        
        if (record.getAuthorId() != null) {
            SET("author_id = #{authorId,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContentEx() != null) {
            SET("content_ex = #{contentEx,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("reply_id = #{replyId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(AppointmentReplyExample example, boolean includeExamplePhrase) {
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