package org.csu.travelbyex.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AccountInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountInfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNull() {
            addCriterion("image_path is null");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNotNull() {
            addCriterion("image_path is not null");
            return (Criteria) this;
        }

        public Criteria andImagePathEqualTo(String value) {
            addCriterion("image_path =", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotEqualTo(String value) {
            addCriterion("image_path <>", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThan(String value) {
            addCriterion("image_path >", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("image_path >=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThan(String value) {
            addCriterion("image_path <", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThanOrEqualTo(String value) {
            addCriterion("image_path <=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLike(String value) {
            addCriterion("image_path like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotLike(String value) {
            addCriterion("image_path not like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathIn(List<String> values) {
            addCriterion("image_path in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotIn(List<String> values) {
            addCriterion("image_path not in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathBetween(String value1, String value2) {
            addCriterion("image_path between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotBetween(String value1, String value2) {
            addCriterion("image_path not between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andHomelpIsNull() {
            addCriterion("homeLP is null");
            return (Criteria) this;
        }

        public Criteria andHomelpIsNotNull() {
            addCriterion("homeLP is not null");
            return (Criteria) this;
        }

        public Criteria andHomelpEqualTo(String value) {
            addCriterion("homeLP =", value, "homelp");
            return (Criteria) this;
        }

        public Criteria andHomelpNotEqualTo(String value) {
            addCriterion("homeLP <>", value, "homelp");
            return (Criteria) this;
        }

        public Criteria andHomelpGreaterThan(String value) {
            addCriterion("homeLP >", value, "homelp");
            return (Criteria) this;
        }

        public Criteria andHomelpGreaterThanOrEqualTo(String value) {
            addCriterion("homeLP >=", value, "homelp");
            return (Criteria) this;
        }

        public Criteria andHomelpLessThan(String value) {
            addCriterion("homeLP <", value, "homelp");
            return (Criteria) this;
        }

        public Criteria andHomelpLessThanOrEqualTo(String value) {
            addCriterion("homeLP <=", value, "homelp");
            return (Criteria) this;
        }

        public Criteria andHomelpLike(String value) {
            addCriterion("homeLP like", value, "homelp");
            return (Criteria) this;
        }

        public Criteria andHomelpNotLike(String value) {
            addCriterion("homeLP not like", value, "homelp");
            return (Criteria) this;
        }

        public Criteria andHomelpIn(List<String> values) {
            addCriterion("homeLP in", values, "homelp");
            return (Criteria) this;
        }

        public Criteria andHomelpNotIn(List<String> values) {
            addCriterion("homeLP not in", values, "homelp");
            return (Criteria) this;
        }

        public Criteria andHomelpBetween(String value1, String value2) {
            addCriterion("homeLP between", value1, value2, "homelp");
            return (Criteria) this;
        }

        public Criteria andHomelpNotBetween(String value1, String value2) {
            addCriterion("homeLP not between", value1, value2, "homelp");
            return (Criteria) this;
        }

        public Criteria andHomespIsNull() {
            addCriterion("homeSP is null");
            return (Criteria) this;
        }

        public Criteria andHomespIsNotNull() {
            addCriterion("homeSP is not null");
            return (Criteria) this;
        }

        public Criteria andHomespEqualTo(String value) {
            addCriterion("homeSP =", value, "homesp");
            return (Criteria) this;
        }

        public Criteria andHomespNotEqualTo(String value) {
            addCriterion("homeSP <>", value, "homesp");
            return (Criteria) this;
        }

        public Criteria andHomespGreaterThan(String value) {
            addCriterion("homeSP >", value, "homesp");
            return (Criteria) this;
        }

        public Criteria andHomespGreaterThanOrEqualTo(String value) {
            addCriterion("homeSP >=", value, "homesp");
            return (Criteria) this;
        }

        public Criteria andHomespLessThan(String value) {
            addCriterion("homeSP <", value, "homesp");
            return (Criteria) this;
        }

        public Criteria andHomespLessThanOrEqualTo(String value) {
            addCriterion("homeSP <=", value, "homesp");
            return (Criteria) this;
        }

        public Criteria andHomespLike(String value) {
            addCriterion("homeSP like", value, "homesp");
            return (Criteria) this;
        }

        public Criteria andHomespNotLike(String value) {
            addCriterion("homeSP not like", value, "homesp");
            return (Criteria) this;
        }

        public Criteria andHomespIn(List<String> values) {
            addCriterion("homeSP in", values, "homesp");
            return (Criteria) this;
        }

        public Criteria andHomespNotIn(List<String> values) {
            addCriterion("homeSP not in", values, "homesp");
            return (Criteria) this;
        }

        public Criteria andHomespBetween(String value1, String value2) {
            addCriterion("homeSP between", value1, value2, "homesp");
            return (Criteria) this;
        }

        public Criteria andHomespNotBetween(String value1, String value2) {
            addCriterion("homeSP not between", value1, value2, "homesp");
            return (Criteria) this;
        }

        public Criteria andLivelpIsNull() {
            addCriterion("liveLP is null");
            return (Criteria) this;
        }

        public Criteria andLivelpIsNotNull() {
            addCriterion("liveLP is not null");
            return (Criteria) this;
        }

        public Criteria andLivelpEqualTo(String value) {
            addCriterion("liveLP =", value, "livelp");
            return (Criteria) this;
        }

        public Criteria andLivelpNotEqualTo(String value) {
            addCriterion("liveLP <>", value, "livelp");
            return (Criteria) this;
        }

        public Criteria andLivelpGreaterThan(String value) {
            addCriterion("liveLP >", value, "livelp");
            return (Criteria) this;
        }

        public Criteria andLivelpGreaterThanOrEqualTo(String value) {
            addCriterion("liveLP >=", value, "livelp");
            return (Criteria) this;
        }

        public Criteria andLivelpLessThan(String value) {
            addCriterion("liveLP <", value, "livelp");
            return (Criteria) this;
        }

        public Criteria andLivelpLessThanOrEqualTo(String value) {
            addCriterion("liveLP <=", value, "livelp");
            return (Criteria) this;
        }

        public Criteria andLivelpLike(String value) {
            addCriterion("liveLP like", value, "livelp");
            return (Criteria) this;
        }

        public Criteria andLivelpNotLike(String value) {
            addCriterion("liveLP not like", value, "livelp");
            return (Criteria) this;
        }

        public Criteria andLivelpIn(List<String> values) {
            addCriterion("liveLP in", values, "livelp");
            return (Criteria) this;
        }

        public Criteria andLivelpNotIn(List<String> values) {
            addCriterion("liveLP not in", values, "livelp");
            return (Criteria) this;
        }

        public Criteria andLivelpBetween(String value1, String value2) {
            addCriterion("liveLP between", value1, value2, "livelp");
            return (Criteria) this;
        }

        public Criteria andLivelpNotBetween(String value1, String value2) {
            addCriterion("liveLP not between", value1, value2, "livelp");
            return (Criteria) this;
        }

        public Criteria andLivespIsNull() {
            addCriterion("liveSP is null");
            return (Criteria) this;
        }

        public Criteria andLivespIsNotNull() {
            addCriterion("liveSP is not null");
            return (Criteria) this;
        }

        public Criteria andLivespEqualTo(String value) {
            addCriterion("liveSP =", value, "livesp");
            return (Criteria) this;
        }

        public Criteria andLivespNotEqualTo(String value) {
            addCriterion("liveSP <>", value, "livesp");
            return (Criteria) this;
        }

        public Criteria andLivespGreaterThan(String value) {
            addCriterion("liveSP >", value, "livesp");
            return (Criteria) this;
        }

        public Criteria andLivespGreaterThanOrEqualTo(String value) {
            addCriterion("liveSP >=", value, "livesp");
            return (Criteria) this;
        }

        public Criteria andLivespLessThan(String value) {
            addCriterion("liveSP <", value, "livesp");
            return (Criteria) this;
        }

        public Criteria andLivespLessThanOrEqualTo(String value) {
            addCriterion("liveSP <=", value, "livesp");
            return (Criteria) this;
        }

        public Criteria andLivespLike(String value) {
            addCriterion("liveSP like", value, "livesp");
            return (Criteria) this;
        }

        public Criteria andLivespNotLike(String value) {
            addCriterion("liveSP not like", value, "livesp");
            return (Criteria) this;
        }

        public Criteria andLivespIn(List<String> values) {
            addCriterion("liveSP in", values, "livesp");
            return (Criteria) this;
        }

        public Criteria andLivespNotIn(List<String> values) {
            addCriterion("liveSP not in", values, "livesp");
            return (Criteria) this;
        }

        public Criteria andLivespBetween(String value1, String value2) {
            addCriterion("liveSP between", value1, value2, "livesp");
            return (Criteria) this;
        }

        public Criteria andLivespNotBetween(String value1, String value2) {
            addCriterion("liveSP not between", value1, value2, "livesp");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
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