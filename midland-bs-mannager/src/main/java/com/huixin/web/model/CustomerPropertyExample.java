package com.huixin.web.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerPropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerPropertyExample() {
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

        public Criteria andPropIdIsNull() {
            addCriterion("prop_id is null");
            return (Criteria) this;
        }

        public Criteria andPropIdIsNotNull() {
            addCriterion("prop_id is not null");
            return (Criteria) this;
        }

        public Criteria andPropIdEqualTo(Integer value) {
            addCriterion("prop_id =", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdNotEqualTo(Integer value) {
            addCriterion("prop_id <>", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdGreaterThan(Integer value) {
            addCriterion("prop_id >", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prop_id >=", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdLessThan(Integer value) {
            addCriterion("prop_id <", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdLessThanOrEqualTo(Integer value) {
            addCriterion("prop_id <=", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdIn(List<Integer> values) {
            addCriterion("prop_id in", values, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdNotIn(List<Integer> values) {
            addCriterion("prop_id not in", values, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdBetween(Integer value1, Integer value2) {
            addCriterion("prop_id between", value1, value2, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prop_id not between", value1, value2, "propId");
            return (Criteria) this;
        }

        public Criteria andPropTypeIsNull() {
            addCriterion("prop_type is null");
            return (Criteria) this;
        }

        public Criteria andPropTypeIsNotNull() {
            addCriterion("prop_type is not null");
            return (Criteria) this;
        }

        public Criteria andPropTypeEqualTo(Integer value) {
            addCriterion("prop_type =", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeNotEqualTo(Integer value) {
            addCriterion("prop_type <>", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeGreaterThan(Integer value) {
            addCriterion("prop_type >", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("prop_type >=", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeLessThan(Integer value) {
            addCriterion("prop_type <", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeLessThanOrEqualTo(Integer value) {
            addCriterion("prop_type <=", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeIn(List<Integer> values) {
            addCriterion("prop_type in", values, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeNotIn(List<Integer> values) {
            addCriterion("prop_type not in", values, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeBetween(Integer value1, Integer value2) {
            addCriterion("prop_type between", value1, value2, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("prop_type not between", value1, value2, "propType");
            return (Criteria) this;
        }

        public Criteria andPropNameIsNull() {
            addCriterion("prop_name is null");
            return (Criteria) this;
        }

        public Criteria andPropNameIsNotNull() {
            addCriterion("prop_name is not null");
            return (Criteria) this;
        }

        public Criteria andPropNameEqualTo(String value) {
            addCriterion("prop_name =", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotEqualTo(String value) {
            addCriterion("prop_name <>", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameGreaterThan(String value) {
            addCriterion("prop_name >", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameGreaterThanOrEqualTo(String value) {
            addCriterion("prop_name >=", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameLessThan(String value) {
            addCriterion("prop_name <", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameLessThanOrEqualTo(String value) {
            addCriterion("prop_name <=", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameLike(String value) {
            addCriterion("prop_name like", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotLike(String value) {
            addCriterion("prop_name not like", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameIn(List<String> values) {
            addCriterion("prop_name in", values, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotIn(List<String> values) {
            addCriterion("prop_name not in", values, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameBetween(String value1, String value2) {
            addCriterion("prop_name between", value1, value2, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotBetween(String value1, String value2) {
            addCriterion("prop_name not between", value1, value2, "propName");
            return (Criteria) this;
        }

        public Criteria andPropValuesIsNull() {
            addCriterion("prop_values is null");
            return (Criteria) this;
        }

        public Criteria andPropValuesIsNotNull() {
            addCriterion("prop_values is not null");
            return (Criteria) this;
        }

        public Criteria andPropValuesEqualTo(String value) {
            addCriterion("prop_values =", value, "propValues");
            return (Criteria) this;
        }

        public Criteria andPropValuesNotEqualTo(String value) {
            addCriterion("prop_values <>", value, "propValues");
            return (Criteria) this;
        }

        public Criteria andPropValuesGreaterThan(String value) {
            addCriterion("prop_values >", value, "propValues");
            return (Criteria) this;
        }

        public Criteria andPropValuesGreaterThanOrEqualTo(String value) {
            addCriterion("prop_values >=", value, "propValues");
            return (Criteria) this;
        }

        public Criteria andPropValuesLessThan(String value) {
            addCriterion("prop_values <", value, "propValues");
            return (Criteria) this;
        }

        public Criteria andPropValuesLessThanOrEqualTo(String value) {
            addCriterion("prop_values <=", value, "propValues");
            return (Criteria) this;
        }

        public Criteria andPropValuesLike(String value) {
            addCriterion("prop_values like", value, "propValues");
            return (Criteria) this;
        }

        public Criteria andPropValuesNotLike(String value) {
            addCriterion("prop_values not like", value, "propValues");
            return (Criteria) this;
        }

        public Criteria andPropValuesIn(List<String> values) {
            addCriterion("prop_values in", values, "propValues");
            return (Criteria) this;
        }

        public Criteria andPropValuesNotIn(List<String> values) {
            addCriterion("prop_values not in", values, "propValues");
            return (Criteria) this;
        }

        public Criteria andPropValuesBetween(String value1, String value2) {
            addCriterion("prop_values between", value1, value2, "propValues");
            return (Criteria) this;
        }

        public Criteria andPropValuesNotBetween(String value1, String value2) {
            addCriterion("prop_values not between", value1, value2, "propValues");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Integer value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Integer value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Integer value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Integer value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Integer value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Integer> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Integer> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Integer value1, Integer value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Integer value1, Integer value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
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