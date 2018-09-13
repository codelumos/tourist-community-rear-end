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
import org.csu.travelbyex.domain.Article;
import org.csu.travelbyex.domain.ArticleExample.Criteria;
import org.csu.travelbyex.domain.ArticleExample.Criterion;
import org.csu.travelbyex.domain.ArticleExample;

public class ArticleSqlProvider {

    public String countByExample(ArticleExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("article");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ArticleExample example) {
        BEGIN();
        DELETE_FROM("article");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Article record) {
        BEGIN();
        INSERT_INTO("article");
        
        if (record.getAuthorId() != null) {
            VALUES("author_id", "#{authorId,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getCoverPath() != null) {
            VALUES("cover_path", "#{coverPath,jdbcType=VARCHAR}");
        }
        
        if (record.getLikes() != null) {
            VALUES("likes", "#{likes,jdbcType=INTEGER}");
        }
        
        if (record.getReaders() != null) {
            VALUES("readers", "#{readers,jdbcType=INTEGER}");
        }
        
        if (record.getLp() != null) {
            VALUES("LP", "#{lp,jdbcType=CHAR}");
        }
        
        if (record.getSp() != null) {
            VALUES("SP", "#{sp,jdbcType=CHAR}");
        }
        
        if (record.getSpotName() != null) {
            VALUES("spot_name", "#{spotName,jdbcType=VARCHAR}");
        }
        
        if (record.getTag1() != null) {
            VALUES("tag1", "#{tag1,jdbcType=VARCHAR}");
        }
        
        if (record.getTag2() != null) {
            VALUES("tag2", "#{tag2,jdbcType=VARCHAR}");
        }
        
        if (record.getTag3() != null) {
            VALUES("tag3", "#{tag3,jdbcType=VARCHAR}");
        }
        
        if (record.getContentEx() != null) {
            VALUES("content_ex", "#{contentEx,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(ArticleExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("article_id");
        } else {
            SELECT("article_id");
        }
        SELECT("author_id");
        SELECT("title");
        SELECT("cover_path");
        SELECT("likes");
        SELECT("readers");
        SELECT("LP");
        SELECT("SP");
        SELECT("spot_name");
        SELECT("tag1");
        SELECT("tag2");
        SELECT("tag3");
        SELECT("content_ex");
        FROM("article");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(ArticleExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("article_id");
        } else {
            SELECT("article_id");
        }
        SELECT("author_id");
        SELECT("title");
        SELECT("cover_path");
        SELECT("likes");
        SELECT("readers");
        SELECT("LP");
        SELECT("SP");
        SELECT("spot_name");
        SELECT("tag1");
        SELECT("tag2");
        SELECT("tag3");
        SELECT("content_ex");
        FROM("article");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Article record = (Article) parameter.get("record");
        ArticleExample example = (ArticleExample) parameter.get("example");
        
        BEGIN();
        UPDATE("article");
        
        if (record.getArticleId() != null) {
            SET("article_id = #{record.articleId,jdbcType=INTEGER}");
        }
        
        if (record.getAuthorId() != null) {
            SET("author_id = #{record.authorId,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getCoverPath() != null) {
            SET("cover_path = #{record.coverPath,jdbcType=VARCHAR}");
        }
        
        if (record.getLikes() != null) {
            SET("likes = #{record.likes,jdbcType=INTEGER}");
        }
        
        if (record.getReaders() != null) {
            SET("readers = #{record.readers,jdbcType=INTEGER}");
        }
        
        if (record.getLp() != null) {
            SET("LP = #{record.lp,jdbcType=CHAR}");
        }
        
        if (record.getSp() != null) {
            SET("SP = #{record.sp,jdbcType=CHAR}");
        }
        
        if (record.getSpotName() != null) {
            SET("spot_name = #{record.spotName,jdbcType=VARCHAR}");
        }
        
        if (record.getTag1() != null) {
            SET("tag1 = #{record.tag1,jdbcType=VARCHAR}");
        }
        
        if (record.getTag2() != null) {
            SET("tag2 = #{record.tag2,jdbcType=VARCHAR}");
        }
        
        if (record.getTag3() != null) {
            SET("tag3 = #{record.tag3,jdbcType=VARCHAR}");
        }
        
        if (record.getContentEx() != null) {
            SET("content_ex = #{record.contentEx,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("article");
        
        SET("article_id = #{record.articleId,jdbcType=INTEGER}");
        SET("author_id = #{record.authorId,jdbcType=VARCHAR}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("cover_path = #{record.coverPath,jdbcType=VARCHAR}");
        SET("likes = #{record.likes,jdbcType=INTEGER}");
        SET("readers = #{record.readers,jdbcType=INTEGER}");
        SET("LP = #{record.lp,jdbcType=CHAR}");
        SET("SP = #{record.sp,jdbcType=CHAR}");
        SET("spot_name = #{record.spotName,jdbcType=VARCHAR}");
        SET("tag1 = #{record.tag1,jdbcType=VARCHAR}");
        SET("tag2 = #{record.tag2,jdbcType=VARCHAR}");
        SET("tag3 = #{record.tag3,jdbcType=VARCHAR}");
        SET("content_ex = #{record.contentEx,jdbcType=LONGVARCHAR}");
        
        ArticleExample example = (ArticleExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("article");
        
        SET("article_id = #{record.articleId,jdbcType=INTEGER}");
        SET("author_id = #{record.authorId,jdbcType=VARCHAR}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("cover_path = #{record.coverPath,jdbcType=VARCHAR}");
        SET("likes = #{record.likes,jdbcType=INTEGER}");
        SET("readers = #{record.readers,jdbcType=INTEGER}");
        SET("LP = #{record.lp,jdbcType=CHAR}");
        SET("SP = #{record.sp,jdbcType=CHAR}");
        SET("spot_name = #{record.spotName,jdbcType=VARCHAR}");
        SET("tag1 = #{record.tag1,jdbcType=VARCHAR}");
        SET("tag2 = #{record.tag2,jdbcType=VARCHAR}");
        SET("tag3 = #{record.tag3,jdbcType=VARCHAR}");
        SET("content_ex = #{record.contentEx,jdbcType=LONGVARCHAR}");
        
        ArticleExample example = (ArticleExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Article record) {
        BEGIN();
        UPDATE("article");
        
        if (record.getAuthorId() != null) {
            SET("author_id = #{authorId,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getCoverPath() != null) {
            SET("cover_path = #{coverPath,jdbcType=VARCHAR}");
        }
        
        if (record.getLikes() != null) {
            SET("likes = #{likes,jdbcType=INTEGER}");
        }
        
        if (record.getReaders() != null) {
            SET("readers = #{readers,jdbcType=INTEGER}");
        }
        
        if (record.getLp() != null) {
            SET("LP = #{lp,jdbcType=CHAR}");
        }
        
        if (record.getSp() != null) {
            SET("SP = #{sp,jdbcType=CHAR}");
        }
        
        if (record.getSpotName() != null) {
            SET("spot_name = #{spotName,jdbcType=VARCHAR}");
        }
        
        if (record.getTag1() != null) {
            SET("tag1 = #{tag1,jdbcType=VARCHAR}");
        }
        
        if (record.getTag2() != null) {
            SET("tag2 = #{tag2,jdbcType=VARCHAR}");
        }
        
        if (record.getTag3() != null) {
            SET("tag3 = #{tag3,jdbcType=VARCHAR}");
        }
        
        if (record.getContentEx() != null) {
            SET("content_ex = #{contentEx,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("article_id = #{articleId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(ArticleExample example, boolean includeExamplePhrase) {
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