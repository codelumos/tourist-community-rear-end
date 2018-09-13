package org.csu.travelbyex.domain;

import java.util.ArrayList;
import java.util.List;

public class SmallPlaceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmallPlaceExample() {
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

        public Criteria andSpIdIsNull() {
            addCriterion("sp_id is null");
            return (Criteria) this;
        }

        public Criteria andSpIdIsNotNull() {
            addCriterion("sp_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpIdEqualTo(Integer value) {
            addCriterion("sp_id =", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotEqualTo(Integer value) {
            addCriterion("sp_id <>", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdGreaterThan(Integer value) {
            addCriterion("sp_id >", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_id >=", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdLessThan(Integer value) {
            addCriterion("sp_id <", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdLessThanOrEqualTo(Integer value) {
            addCriterion("sp_id <=", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdIn(List<Integer> values) {
            addCriterion("sp_id in", values, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotIn(List<Integer> values) {
            addCriterion("sp_id not in", values, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdBetween(Integer value1, Integer value2) {
            addCriterion("sp_id between", value1, value2, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_id not between", value1, value2, "spId");
            return (Criteria) this;
        }

        public Criteria andLpIdIsNull() {
            addCriterion("LP_id is null");
            return (Criteria) this;
        }

        public Criteria andLpIdIsNotNull() {
            addCriterion("LP_id is not null");
            return (Criteria) this;
        }

        public Criteria andLpIdEqualTo(Integer value) {
            addCriterion("LP_id =", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdNotEqualTo(Integer value) {
            addCriterion("LP_id <>", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdGreaterThan(Integer value) {
            addCriterion("LP_id >", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("LP_id >=", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdLessThan(Integer value) {
            addCriterion("LP_id <", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdLessThanOrEqualTo(Integer value) {
            addCriterion("LP_id <=", value, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdIn(List<Integer> values) {
            addCriterion("LP_id in", values, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdNotIn(List<Integer> values) {
            addCriterion("LP_id not in", values, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdBetween(Integer value1, Integer value2) {
            addCriterion("LP_id between", value1, value2, "lpId");
            return (Criteria) this;
        }

        public Criteria andLpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("LP_id not between", value1, value2, "lpId");
            return (Criteria) this;
        }

        public Criteria andSpNameIsNull() {
            addCriterion("sp_name is null");
            return (Criteria) this;
        }

        public Criteria andSpNameIsNotNull() {
            addCriterion("sp_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpNameEqualTo(String value) {
            addCriterion("sp_name =", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotEqualTo(String value) {
            addCriterion("sp_name <>", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameGreaterThan(String value) {
            addCriterion("sp_name >", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameGreaterThanOrEqualTo(String value) {
            addCriterion("sp_name >=", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameLessThan(String value) {
            addCriterion("sp_name <", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameLessThanOrEqualTo(String value) {
            addCriterion("sp_name <=", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameLike(String value) {
            addCriterion("sp_name like", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotLike(String value) {
            addCriterion("sp_name not like", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameIn(List<String> values) {
            addCriterion("sp_name in", values, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotIn(List<String> values) {
            addCriterion("sp_name not in", values, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameBetween(String value1, String value2) {
            addCriterion("sp_name between", value1, value2, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotBetween(String value1, String value2) {
            addCriterion("sp_name not between", value1, value2, "spName");
            return (Criteria) this;
        }

        public Criteria andImagePath1IsNull() {
            addCriterion("image_path1 is null");
            return (Criteria) this;
        }

        public Criteria andImagePath1IsNotNull() {
            addCriterion("image_path1 is not null");
            return (Criteria) this;
        }

        public Criteria andImagePath1EqualTo(String value) {
            addCriterion("image_path1 =", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1NotEqualTo(String value) {
            addCriterion("image_path1 <>", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1GreaterThan(String value) {
            addCriterion("image_path1 >", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1GreaterThanOrEqualTo(String value) {
            addCriterion("image_path1 >=", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1LessThan(String value) {
            addCriterion("image_path1 <", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1LessThanOrEqualTo(String value) {
            addCriterion("image_path1 <=", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1Like(String value) {
            addCriterion("image_path1 like", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1NotLike(String value) {
            addCriterion("image_path1 not like", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1In(List<String> values) {
            addCriterion("image_path1 in", values, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1NotIn(List<String> values) {
            addCriterion("image_path1 not in", values, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1Between(String value1, String value2) {
            addCriterion("image_path1 between", value1, value2, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1NotBetween(String value1, String value2) {
            addCriterion("image_path1 not between", value1, value2, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath2IsNull() {
            addCriterion("image_path2 is null");
            return (Criteria) this;
        }

        public Criteria andImagePath2IsNotNull() {
            addCriterion("image_path2 is not null");
            return (Criteria) this;
        }

        public Criteria andImagePath2EqualTo(String value) {
            addCriterion("image_path2 =", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2NotEqualTo(String value) {
            addCriterion("image_path2 <>", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2GreaterThan(String value) {
            addCriterion("image_path2 >", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2GreaterThanOrEqualTo(String value) {
            addCriterion("image_path2 >=", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2LessThan(String value) {
            addCriterion("image_path2 <", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2LessThanOrEqualTo(String value) {
            addCriterion("image_path2 <=", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2Like(String value) {
            addCriterion("image_path2 like", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2NotLike(String value) {
            addCriterion("image_path2 not like", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2In(List<String> values) {
            addCriterion("image_path2 in", values, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2NotIn(List<String> values) {
            addCriterion("image_path2 not in", values, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2Between(String value1, String value2) {
            addCriterion("image_path2 between", value1, value2, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2NotBetween(String value1, String value2) {
            addCriterion("image_path2 not between", value1, value2, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath3IsNull() {
            addCriterion("image_path3 is null");
            return (Criteria) this;
        }

        public Criteria andImagePath3IsNotNull() {
            addCriterion("image_path3 is not null");
            return (Criteria) this;
        }

        public Criteria andImagePath3EqualTo(String value) {
            addCriterion("image_path3 =", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3NotEqualTo(String value) {
            addCriterion("image_path3 <>", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3GreaterThan(String value) {
            addCriterion("image_path3 >", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3GreaterThanOrEqualTo(String value) {
            addCriterion("image_path3 >=", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3LessThan(String value) {
            addCriterion("image_path3 <", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3LessThanOrEqualTo(String value) {
            addCriterion("image_path3 <=", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3Like(String value) {
            addCriterion("image_path3 like", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3NotLike(String value) {
            addCriterion("image_path3 not like", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3In(List<String> values) {
            addCriterion("image_path3 in", values, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3NotIn(List<String> values) {
            addCriterion("image_path3 not in", values, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3Between(String value1, String value2) {
            addCriterion("image_path3 between", value1, value2, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3NotBetween(String value1, String value2) {
            addCriterion("image_path3 not between", value1, value2, "imagePath3");
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