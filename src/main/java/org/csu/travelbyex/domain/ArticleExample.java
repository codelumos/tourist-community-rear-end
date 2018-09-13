package org.csu.travelbyex.domain;

import java.util.ArrayList;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Integer value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Integer value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Integer value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Integer> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(String value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(String value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(String value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(String value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(String value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(String value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLike(String value) {
            addCriterion("author_id like", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotLike(String value) {
            addCriterion("author_id not like", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<String> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<String> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(String value1, String value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(String value1, String value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCoverPathIsNull() {
            addCriterion("cover_path is null");
            return (Criteria) this;
        }

        public Criteria andCoverPathIsNotNull() {
            addCriterion("cover_path is not null");
            return (Criteria) this;
        }

        public Criteria andCoverPathEqualTo(String value) {
            addCriterion("cover_path =", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotEqualTo(String value) {
            addCriterion("cover_path <>", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathGreaterThan(String value) {
            addCriterion("cover_path >", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathGreaterThanOrEqualTo(String value) {
            addCriterion("cover_path >=", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathLessThan(String value) {
            addCriterion("cover_path <", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathLessThanOrEqualTo(String value) {
            addCriterion("cover_path <=", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathLike(String value) {
            addCriterion("cover_path like", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotLike(String value) {
            addCriterion("cover_path not like", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathIn(List<String> values) {
            addCriterion("cover_path in", values, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotIn(List<String> values) {
            addCriterion("cover_path not in", values, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathBetween(String value1, String value2) {
            addCriterion("cover_path between", value1, value2, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotBetween(String value1, String value2) {
            addCriterion("cover_path not between", value1, value2, "coverPath");
            return (Criteria) this;
        }

        public Criteria andLikesIsNull() {
            addCriterion("likes is null");
            return (Criteria) this;
        }

        public Criteria andLikesIsNotNull() {
            addCriterion("likes is not null");
            return (Criteria) this;
        }

        public Criteria andLikesEqualTo(Integer value) {
            addCriterion("likes =", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotEqualTo(Integer value) {
            addCriterion("likes <>", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesGreaterThan(Integer value) {
            addCriterion("likes >", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesGreaterThanOrEqualTo(Integer value) {
            addCriterion("likes >=", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesLessThan(Integer value) {
            addCriterion("likes <", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesLessThanOrEqualTo(Integer value) {
            addCriterion("likes <=", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesIn(List<Integer> values) {
            addCriterion("likes in", values, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotIn(List<Integer> values) {
            addCriterion("likes not in", values, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesBetween(Integer value1, Integer value2) {
            addCriterion("likes between", value1, value2, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotBetween(Integer value1, Integer value2) {
            addCriterion("likes not between", value1, value2, "likes");
            return (Criteria) this;
        }

        public Criteria andReadersIsNull() {
            addCriterion("readers is null");
            return (Criteria) this;
        }

        public Criteria andReadersIsNotNull() {
            addCriterion("readers is not null");
            return (Criteria) this;
        }

        public Criteria andReadersEqualTo(Integer value) {
            addCriterion("readers =", value, "readers");
            return (Criteria) this;
        }

        public Criteria andReadersNotEqualTo(Integer value) {
            addCriterion("readers <>", value, "readers");
            return (Criteria) this;
        }

        public Criteria andReadersGreaterThan(Integer value) {
            addCriterion("readers >", value, "readers");
            return (Criteria) this;
        }

        public Criteria andReadersGreaterThanOrEqualTo(Integer value) {
            addCriterion("readers >=", value, "readers");
            return (Criteria) this;
        }

        public Criteria andReadersLessThan(Integer value) {
            addCriterion("readers <", value, "readers");
            return (Criteria) this;
        }

        public Criteria andReadersLessThanOrEqualTo(Integer value) {
            addCriterion("readers <=", value, "readers");
            return (Criteria) this;
        }

        public Criteria andReadersIn(List<Integer> values) {
            addCriterion("readers in", values, "readers");
            return (Criteria) this;
        }

        public Criteria andReadersNotIn(List<Integer> values) {
            addCriterion("readers not in", values, "readers");
            return (Criteria) this;
        }

        public Criteria andReadersBetween(Integer value1, Integer value2) {
            addCriterion("readers between", value1, value2, "readers");
            return (Criteria) this;
        }

        public Criteria andReadersNotBetween(Integer value1, Integer value2) {
            addCriterion("readers not between", value1, value2, "readers");
            return (Criteria) this;
        }

        public Criteria andLpIsNull() {
            addCriterion("LP is null");
            return (Criteria) this;
        }

        public Criteria andLpIsNotNull() {
            addCriterion("LP is not null");
            return (Criteria) this;
        }

        public Criteria andLpEqualTo(String value) {
            addCriterion("LP =", value, "lp");
            return (Criteria) this;
        }

        public Criteria andLpNotEqualTo(String value) {
            addCriterion("LP <>", value, "lp");
            return (Criteria) this;
        }

        public Criteria andLpGreaterThan(String value) {
            addCriterion("LP >", value, "lp");
            return (Criteria) this;
        }

        public Criteria andLpGreaterThanOrEqualTo(String value) {
            addCriterion("LP >=", value, "lp");
            return (Criteria) this;
        }

        public Criteria andLpLessThan(String value) {
            addCriterion("LP <", value, "lp");
            return (Criteria) this;
        }

        public Criteria andLpLessThanOrEqualTo(String value) {
            addCriterion("LP <=", value, "lp");
            return (Criteria) this;
        }

        public Criteria andLpLike(String value) {
            addCriterion("LP like", value, "lp");
            return (Criteria) this;
        }

        public Criteria andLpNotLike(String value) {
            addCriterion("LP not like", value, "lp");
            return (Criteria) this;
        }

        public Criteria andLpIn(List<String> values) {
            addCriterion("LP in", values, "lp");
            return (Criteria) this;
        }

        public Criteria andLpNotIn(List<String> values) {
            addCriterion("LP not in", values, "lp");
            return (Criteria) this;
        }

        public Criteria andLpBetween(String value1, String value2) {
            addCriterion("LP between", value1, value2, "lp");
            return (Criteria) this;
        }

        public Criteria andLpNotBetween(String value1, String value2) {
            addCriterion("LP not between", value1, value2, "lp");
            return (Criteria) this;
        }

        public Criteria andSpIsNull() {
            addCriterion("SP is null");
            return (Criteria) this;
        }

        public Criteria andSpIsNotNull() {
            addCriterion("SP is not null");
            return (Criteria) this;
        }

        public Criteria andSpEqualTo(String value) {
            addCriterion("SP =", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpNotEqualTo(String value) {
            addCriterion("SP <>", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpGreaterThan(String value) {
            addCriterion("SP >", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpGreaterThanOrEqualTo(String value) {
            addCriterion("SP >=", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpLessThan(String value) {
            addCriterion("SP <", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpLessThanOrEqualTo(String value) {
            addCriterion("SP <=", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpLike(String value) {
            addCriterion("SP like", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpNotLike(String value) {
            addCriterion("SP not like", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpIn(List<String> values) {
            addCriterion("SP in", values, "sp");
            return (Criteria) this;
        }

        public Criteria andSpNotIn(List<String> values) {
            addCriterion("SP not in", values, "sp");
            return (Criteria) this;
        }

        public Criteria andSpBetween(String value1, String value2) {
            addCriterion("SP between", value1, value2, "sp");
            return (Criteria) this;
        }

        public Criteria andSpNotBetween(String value1, String value2) {
            addCriterion("SP not between", value1, value2, "sp");
            return (Criteria) this;
        }

        public Criteria andSpotNameIsNull() {
            addCriterion("spot_name is null");
            return (Criteria) this;
        }

        public Criteria andSpotNameIsNotNull() {
            addCriterion("spot_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpotNameEqualTo(String value) {
            addCriterion("spot_name =", value, "spotName");
            return (Criteria) this;
        }

        public Criteria andSpotNameNotEqualTo(String value) {
            addCriterion("spot_name <>", value, "spotName");
            return (Criteria) this;
        }

        public Criteria andSpotNameGreaterThan(String value) {
            addCriterion("spot_name >", value, "spotName");
            return (Criteria) this;
        }

        public Criteria andSpotNameGreaterThanOrEqualTo(String value) {
            addCriterion("spot_name >=", value, "spotName");
            return (Criteria) this;
        }

        public Criteria andSpotNameLessThan(String value) {
            addCriterion("spot_name <", value, "spotName");
            return (Criteria) this;
        }

        public Criteria andSpotNameLessThanOrEqualTo(String value) {
            addCriterion("spot_name <=", value, "spotName");
            return (Criteria) this;
        }

        public Criteria andSpotNameLike(String value) {
            addCriterion("spot_name like", value, "spotName");
            return (Criteria) this;
        }

        public Criteria andSpotNameNotLike(String value) {
            addCriterion("spot_name not like", value, "spotName");
            return (Criteria) this;
        }

        public Criteria andSpotNameIn(List<String> values) {
            addCriterion("spot_name in", values, "spotName");
            return (Criteria) this;
        }

        public Criteria andSpotNameNotIn(List<String> values) {
            addCriterion("spot_name not in", values, "spotName");
            return (Criteria) this;
        }

        public Criteria andSpotNameBetween(String value1, String value2) {
            addCriterion("spot_name between", value1, value2, "spotName");
            return (Criteria) this;
        }

        public Criteria andSpotNameNotBetween(String value1, String value2) {
            addCriterion("spot_name not between", value1, value2, "spotName");
            return (Criteria) this;
        }

        public Criteria andTag1IsNull() {
            addCriterion("tag1 is null");
            return (Criteria) this;
        }

        public Criteria andTag1IsNotNull() {
            addCriterion("tag1 is not null");
            return (Criteria) this;
        }

        public Criteria andTag1EqualTo(String value) {
            addCriterion("tag1 =", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1NotEqualTo(String value) {
            addCriterion("tag1 <>", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1GreaterThan(String value) {
            addCriterion("tag1 >", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1GreaterThanOrEqualTo(String value) {
            addCriterion("tag1 >=", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1LessThan(String value) {
            addCriterion("tag1 <", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1LessThanOrEqualTo(String value) {
            addCriterion("tag1 <=", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1Like(String value) {
            addCriterion("tag1 like", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1NotLike(String value) {
            addCriterion("tag1 not like", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1In(List<String> values) {
            addCriterion("tag1 in", values, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1NotIn(List<String> values) {
            addCriterion("tag1 not in", values, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1Between(String value1, String value2) {
            addCriterion("tag1 between", value1, value2, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1NotBetween(String value1, String value2) {
            addCriterion("tag1 not between", value1, value2, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag2IsNull() {
            addCriterion("tag2 is null");
            return (Criteria) this;
        }

        public Criteria andTag2IsNotNull() {
            addCriterion("tag2 is not null");
            return (Criteria) this;
        }

        public Criteria andTag2EqualTo(String value) {
            addCriterion("tag2 =", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2NotEqualTo(String value) {
            addCriterion("tag2 <>", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2GreaterThan(String value) {
            addCriterion("tag2 >", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2GreaterThanOrEqualTo(String value) {
            addCriterion("tag2 >=", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2LessThan(String value) {
            addCriterion("tag2 <", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2LessThanOrEqualTo(String value) {
            addCriterion("tag2 <=", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2Like(String value) {
            addCriterion("tag2 like", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2NotLike(String value) {
            addCriterion("tag2 not like", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2In(List<String> values) {
            addCriterion("tag2 in", values, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2NotIn(List<String> values) {
            addCriterion("tag2 not in", values, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2Between(String value1, String value2) {
            addCriterion("tag2 between", value1, value2, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2NotBetween(String value1, String value2) {
            addCriterion("tag2 not between", value1, value2, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag3IsNull() {
            addCriterion("tag3 is null");
            return (Criteria) this;
        }

        public Criteria andTag3IsNotNull() {
            addCriterion("tag3 is not null");
            return (Criteria) this;
        }

        public Criteria andTag3EqualTo(String value) {
            addCriterion("tag3 =", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3NotEqualTo(String value) {
            addCriterion("tag3 <>", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3GreaterThan(String value) {
            addCriterion("tag3 >", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3GreaterThanOrEqualTo(String value) {
            addCriterion("tag3 >=", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3LessThan(String value) {
            addCriterion("tag3 <", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3LessThanOrEqualTo(String value) {
            addCriterion("tag3 <=", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3Like(String value) {
            addCriterion("tag3 like", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3NotLike(String value) {
            addCriterion("tag3 not like", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3In(List<String> values) {
            addCriterion("tag3 in", values, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3NotIn(List<String> values) {
            addCriterion("tag3 not in", values, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3Between(String value1, String value2) {
            addCriterion("tag3 between", value1, value2, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3NotBetween(String value1, String value2) {
            addCriterion("tag3 not between", value1, value2, "tag3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}