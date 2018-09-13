package org.csu.travelbyex.domain;

import java.util.ArrayList;
import java.util.List;

public class LargePlaceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LargePlaceExample() {
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

        public Criteria andLpNameIsNull() {
            addCriterion("LP_name is null");
            return (Criteria) this;
        }

        public Criteria andLpNameIsNotNull() {
            addCriterion("LP_name is not null");
            return (Criteria) this;
        }

        public Criteria andLpNameEqualTo(String value) {
            addCriterion("LP_name =", value, "lpName");
            return (Criteria) this;
        }

        public Criteria andLpNameNotEqualTo(String value) {
            addCriterion("LP_name <>", value, "lpName");
            return (Criteria) this;
        }

        public Criteria andLpNameGreaterThan(String value) {
            addCriterion("LP_name >", value, "lpName");
            return (Criteria) this;
        }

        public Criteria andLpNameGreaterThanOrEqualTo(String value) {
            addCriterion("LP_name >=", value, "lpName");
            return (Criteria) this;
        }

        public Criteria andLpNameLessThan(String value) {
            addCriterion("LP_name <", value, "lpName");
            return (Criteria) this;
        }

        public Criteria andLpNameLessThanOrEqualTo(String value) {
            addCriterion("LP_name <=", value, "lpName");
            return (Criteria) this;
        }

        public Criteria andLpNameLike(String value) {
            addCriterion("LP_name like", value, "lpName");
            return (Criteria) this;
        }

        public Criteria andLpNameNotLike(String value) {
            addCriterion("LP_name not like", value, "lpName");
            return (Criteria) this;
        }

        public Criteria andLpNameIn(List<String> values) {
            addCriterion("LP_name in", values, "lpName");
            return (Criteria) this;
        }

        public Criteria andLpNameNotIn(List<String> values) {
            addCriterion("LP_name not in", values, "lpName");
            return (Criteria) this;
        }

        public Criteria andLpNameBetween(String value1, String value2) {
            addCriterion("LP_name between", value1, value2, "lpName");
            return (Criteria) this;
        }

        public Criteria andLpNameNotBetween(String value1, String value2) {
            addCriterion("LP_name not between", value1, value2, "lpName");
            return (Criteria) this;
        }

        public Criteria andIsHomeIsNull() {
            addCriterion("is_home is null");
            return (Criteria) this;
        }

        public Criteria andIsHomeIsNotNull() {
            addCriterion("is_home is not null");
            return (Criteria) this;
        }

        public Criteria andIsHomeEqualTo(Boolean value) {
            addCriterion("is_home =", value, "isHome");
            return (Criteria) this;
        }

        public Criteria andIsHomeNotEqualTo(Boolean value) {
            addCriterion("is_home <>", value, "isHome");
            return (Criteria) this;
        }

        public Criteria andIsHomeGreaterThan(Boolean value) {
            addCriterion("is_home >", value, "isHome");
            return (Criteria) this;
        }

        public Criteria andIsHomeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_home >=", value, "isHome");
            return (Criteria) this;
        }

        public Criteria andIsHomeLessThan(Boolean value) {
            addCriterion("is_home <", value, "isHome");
            return (Criteria) this;
        }

        public Criteria andIsHomeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_home <=", value, "isHome");
            return (Criteria) this;
        }

        public Criteria andIsHomeIn(List<Boolean> values) {
            addCriterion("is_home in", values, "isHome");
            return (Criteria) this;
        }

        public Criteria andIsHomeNotIn(List<Boolean> values) {
            addCriterion("is_home not in", values, "isHome");
            return (Criteria) this;
        }

        public Criteria andIsHomeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_home between", value1, value2, "isHome");
            return (Criteria) this;
        }

        public Criteria andIsHomeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_home not between", value1, value2, "isHome");
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