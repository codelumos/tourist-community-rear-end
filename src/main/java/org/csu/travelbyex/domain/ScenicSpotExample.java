package org.csu.travelbyex.domain;

import java.util.ArrayList;
import java.util.List;

public class ScenicSpotExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScenicSpotExample() {
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

        public Criteria andSpotIdIsNull() {
            addCriterion("spot_id is null");
            return (Criteria) this;
        }

        public Criteria andSpotIdIsNotNull() {
            addCriterion("spot_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpotIdEqualTo(Integer value) {
            addCriterion("spot_id =", value, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdNotEqualTo(Integer value) {
            addCriterion("spot_id <>", value, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdGreaterThan(Integer value) {
            addCriterion("spot_id >", value, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("spot_id >=", value, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdLessThan(Integer value) {
            addCriterion("spot_id <", value, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdLessThanOrEqualTo(Integer value) {
            addCriterion("spot_id <=", value, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdIn(List<Integer> values) {
            addCriterion("spot_id in", values, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdNotIn(List<Integer> values) {
            addCriterion("spot_id not in", values, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdBetween(Integer value1, Integer value2) {
            addCriterion("spot_id between", value1, value2, "spotId");
            return (Criteria) this;
        }

        public Criteria andSpotIdNotBetween(Integer value1, Integer value2) {
            addCriterion("spot_id not between", value1, value2, "spotId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdIsNull() {
            addCriterion("place_id is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIdIsNotNull() {
            addCriterion("place_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceIdEqualTo(Integer value) {
            addCriterion("place_id =", value, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdNotEqualTo(Integer value) {
            addCriterion("place_id <>", value, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdGreaterThan(Integer value) {
            addCriterion("place_id >", value, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("place_id >=", value, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdLessThan(Integer value) {
            addCriterion("place_id <", value, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdLessThanOrEqualTo(Integer value) {
            addCriterion("place_id <=", value, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdIn(List<Integer> values) {
            addCriterion("place_id in", values, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdNotIn(List<Integer> values) {
            addCriterion("place_id not in", values, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdBetween(Integer value1, Integer value2) {
            addCriterion("place_id between", value1, value2, "placeId");
            return (Criteria) this;
        }

        public Criteria andPlaceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("place_id not between", value1, value2, "placeId");
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

        public Criteria andImagePath1IsNull() {
            addCriterion("image_path_1 is null");
            return (Criteria) this;
        }

        public Criteria andImagePath1IsNotNull() {
            addCriterion("image_path_1 is not null");
            return (Criteria) this;
        }

        public Criteria andImagePath1EqualTo(String value) {
            addCriterion("image_path_1 =", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1NotEqualTo(String value) {
            addCriterion("image_path_1 <>", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1GreaterThan(String value) {
            addCriterion("image_path_1 >", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1GreaterThanOrEqualTo(String value) {
            addCriterion("image_path_1 >=", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1LessThan(String value) {
            addCriterion("image_path_1 <", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1LessThanOrEqualTo(String value) {
            addCriterion("image_path_1 <=", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1Like(String value) {
            addCriterion("image_path_1 like", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1NotLike(String value) {
            addCriterion("image_path_1 not like", value, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1In(List<String> values) {
            addCriterion("image_path_1 in", values, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1NotIn(List<String> values) {
            addCriterion("image_path_1 not in", values, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1Between(String value1, String value2) {
            addCriterion("image_path_1 between", value1, value2, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath1NotBetween(String value1, String value2) {
            addCriterion("image_path_1 not between", value1, value2, "imagePath1");
            return (Criteria) this;
        }

        public Criteria andImagePath2IsNull() {
            addCriterion("image_path_2 is null");
            return (Criteria) this;
        }

        public Criteria andImagePath2IsNotNull() {
            addCriterion("image_path_2 is not null");
            return (Criteria) this;
        }

        public Criteria andImagePath2EqualTo(String value) {
            addCriterion("image_path_2 =", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2NotEqualTo(String value) {
            addCriterion("image_path_2 <>", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2GreaterThan(String value) {
            addCriterion("image_path_2 >", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2GreaterThanOrEqualTo(String value) {
            addCriterion("image_path_2 >=", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2LessThan(String value) {
            addCriterion("image_path_2 <", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2LessThanOrEqualTo(String value) {
            addCriterion("image_path_2 <=", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2Like(String value) {
            addCriterion("image_path_2 like", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2NotLike(String value) {
            addCriterion("image_path_2 not like", value, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2In(List<String> values) {
            addCriterion("image_path_2 in", values, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2NotIn(List<String> values) {
            addCriterion("image_path_2 not in", values, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2Between(String value1, String value2) {
            addCriterion("image_path_2 between", value1, value2, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath2NotBetween(String value1, String value2) {
            addCriterion("image_path_2 not between", value1, value2, "imagePath2");
            return (Criteria) this;
        }

        public Criteria andImagePath3IsNull() {
            addCriterion("image_path_3 is null");
            return (Criteria) this;
        }

        public Criteria andImagePath3IsNotNull() {
            addCriterion("image_path_3 is not null");
            return (Criteria) this;
        }

        public Criteria andImagePath3EqualTo(String value) {
            addCriterion("image_path_3 =", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3NotEqualTo(String value) {
            addCriterion("image_path_3 <>", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3GreaterThan(String value) {
            addCriterion("image_path_3 >", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3GreaterThanOrEqualTo(String value) {
            addCriterion("image_path_3 >=", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3LessThan(String value) {
            addCriterion("image_path_3 <", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3LessThanOrEqualTo(String value) {
            addCriterion("image_path_3 <=", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3Like(String value) {
            addCriterion("image_path_3 like", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3NotLike(String value) {
            addCriterion("image_path_3 not like", value, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3In(List<String> values) {
            addCriterion("image_path_3 in", values, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3NotIn(List<String> values) {
            addCriterion("image_path_3 not in", values, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3Between(String value1, String value2) {
            addCriterion("image_path_3 between", value1, value2, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andImagePath3NotBetween(String value1, String value2) {
            addCriterion("image_path_3 not between", value1, value2, "imagePath3");
            return (Criteria) this;
        }

        public Criteria andTag1IsNull() {
            addCriterion("tag_1 is null");
            return (Criteria) this;
        }

        public Criteria andTag1IsNotNull() {
            addCriterion("tag_1 is not null");
            return (Criteria) this;
        }

        public Criteria andTag1EqualTo(String value) {
            addCriterion("tag_1 =", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1NotEqualTo(String value) {
            addCriterion("tag_1 <>", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1GreaterThan(String value) {
            addCriterion("tag_1 >", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1GreaterThanOrEqualTo(String value) {
            addCriterion("tag_1 >=", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1LessThan(String value) {
            addCriterion("tag_1 <", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1LessThanOrEqualTo(String value) {
            addCriterion("tag_1 <=", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1Like(String value) {
            addCriterion("tag_1 like", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1NotLike(String value) {
            addCriterion("tag_1 not like", value, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1In(List<String> values) {
            addCriterion("tag_1 in", values, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1NotIn(List<String> values) {
            addCriterion("tag_1 not in", values, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1Between(String value1, String value2) {
            addCriterion("tag_1 between", value1, value2, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag1NotBetween(String value1, String value2) {
            addCriterion("tag_1 not between", value1, value2, "tag1");
            return (Criteria) this;
        }

        public Criteria andTag2IsNull() {
            addCriterion("tag_2 is null");
            return (Criteria) this;
        }

        public Criteria andTag2IsNotNull() {
            addCriterion("tag_2 is not null");
            return (Criteria) this;
        }

        public Criteria andTag2EqualTo(String value) {
            addCriterion("tag_2 =", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2NotEqualTo(String value) {
            addCriterion("tag_2 <>", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2GreaterThan(String value) {
            addCriterion("tag_2 >", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2GreaterThanOrEqualTo(String value) {
            addCriterion("tag_2 >=", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2LessThan(String value) {
            addCriterion("tag_2 <", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2LessThanOrEqualTo(String value) {
            addCriterion("tag_2 <=", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2Like(String value) {
            addCriterion("tag_2 like", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2NotLike(String value) {
            addCriterion("tag_2 not like", value, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2In(List<String> values) {
            addCriterion("tag_2 in", values, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2NotIn(List<String> values) {
            addCriterion("tag_2 not in", values, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2Between(String value1, String value2) {
            addCriterion("tag_2 between", value1, value2, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag2NotBetween(String value1, String value2) {
            addCriterion("tag_2 not between", value1, value2, "tag2");
            return (Criteria) this;
        }

        public Criteria andTag3IsNull() {
            addCriterion("tag_3 is null");
            return (Criteria) this;
        }

        public Criteria andTag3IsNotNull() {
            addCriterion("tag_3 is not null");
            return (Criteria) this;
        }

        public Criteria andTag3EqualTo(String value) {
            addCriterion("tag_3 =", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3NotEqualTo(String value) {
            addCriterion("tag_3 <>", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3GreaterThan(String value) {
            addCriterion("tag_3 >", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3GreaterThanOrEqualTo(String value) {
            addCriterion("tag_3 >=", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3LessThan(String value) {
            addCriterion("tag_3 <", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3LessThanOrEqualTo(String value) {
            addCriterion("tag_3 <=", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3Like(String value) {
            addCriterion("tag_3 like", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3NotLike(String value) {
            addCriterion("tag_3 not like", value, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3In(List<String> values) {
            addCriterion("tag_3 in", values, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3NotIn(List<String> values) {
            addCriterion("tag_3 not in", values, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3Between(String value1, String value2) {
            addCriterion("tag_3 between", value1, value2, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag3NotBetween(String value1, String value2) {
            addCriterion("tag_3 not between", value1, value2, "tag3");
            return (Criteria) this;
        }

        public Criteria andTag4IsNull() {
            addCriterion("tag_4 is null");
            return (Criteria) this;
        }

        public Criteria andTag4IsNotNull() {
            addCriterion("tag_4 is not null");
            return (Criteria) this;
        }

        public Criteria andTag4EqualTo(String value) {
            addCriterion("tag_4 =", value, "tag4");
            return (Criteria) this;
        }

        public Criteria andTag4NotEqualTo(String value) {
            addCriterion("tag_4 <>", value, "tag4");
            return (Criteria) this;
        }

        public Criteria andTag4GreaterThan(String value) {
            addCriterion("tag_4 >", value, "tag4");
            return (Criteria) this;
        }

        public Criteria andTag4GreaterThanOrEqualTo(String value) {
            addCriterion("tag_4 >=", value, "tag4");
            return (Criteria) this;
        }

        public Criteria andTag4LessThan(String value) {
            addCriterion("tag_4 <", value, "tag4");
            return (Criteria) this;
        }

        public Criteria andTag4LessThanOrEqualTo(String value) {
            addCriterion("tag_4 <=", value, "tag4");
            return (Criteria) this;
        }

        public Criteria andTag4Like(String value) {
            addCriterion("tag_4 like", value, "tag4");
            return (Criteria) this;
        }

        public Criteria andTag4NotLike(String value) {
            addCriterion("tag_4 not like", value, "tag4");
            return (Criteria) this;
        }

        public Criteria andTag4In(List<String> values) {
            addCriterion("tag_4 in", values, "tag4");
            return (Criteria) this;
        }

        public Criteria andTag4NotIn(List<String> values) {
            addCriterion("tag_4 not in", values, "tag4");
            return (Criteria) this;
        }

        public Criteria andTag4Between(String value1, String value2) {
            addCriterion("tag_4 between", value1, value2, "tag4");
            return (Criteria) this;
        }

        public Criteria andTag4NotBetween(String value1, String value2) {
            addCriterion("tag_4 not between", value1, value2, "tag4");
            return (Criteria) this;
        }

        public Criteria andTag5IsNull() {
            addCriterion("tag_5 is null");
            return (Criteria) this;
        }

        public Criteria andTag5IsNotNull() {
            addCriterion("tag_5 is not null");
            return (Criteria) this;
        }

        public Criteria andTag5EqualTo(String value) {
            addCriterion("tag_5 =", value, "tag5");
            return (Criteria) this;
        }

        public Criteria andTag5NotEqualTo(String value) {
            addCriterion("tag_5 <>", value, "tag5");
            return (Criteria) this;
        }

        public Criteria andTag5GreaterThan(String value) {
            addCriterion("tag_5 >", value, "tag5");
            return (Criteria) this;
        }

        public Criteria andTag5GreaterThanOrEqualTo(String value) {
            addCriterion("tag_5 >=", value, "tag5");
            return (Criteria) this;
        }

        public Criteria andTag5LessThan(String value) {
            addCriterion("tag_5 <", value, "tag5");
            return (Criteria) this;
        }

        public Criteria andTag5LessThanOrEqualTo(String value) {
            addCriterion("tag_5 <=", value, "tag5");
            return (Criteria) this;
        }

        public Criteria andTag5Like(String value) {
            addCriterion("tag_5 like", value, "tag5");
            return (Criteria) this;
        }

        public Criteria andTag5NotLike(String value) {
            addCriterion("tag_5 not like", value, "tag5");
            return (Criteria) this;
        }

        public Criteria andTag5In(List<String> values) {
            addCriterion("tag_5 in", values, "tag5");
            return (Criteria) this;
        }

        public Criteria andTag5NotIn(List<String> values) {
            addCriterion("tag_5 not in", values, "tag5");
            return (Criteria) this;
        }

        public Criteria andTag5Between(String value1, String value2) {
            addCriterion("tag_5 between", value1, value2, "tag5");
            return (Criteria) this;
        }

        public Criteria andTag5NotBetween(String value1, String value2) {
            addCriterion("tag_5 not between", value1, value2, "tag5");
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