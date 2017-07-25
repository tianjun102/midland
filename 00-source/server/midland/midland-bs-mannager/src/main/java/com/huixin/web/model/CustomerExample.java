package com.huixin.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Integer value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Integer value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Integer value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Integer value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Integer value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Integer> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Integer> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Integer value1, Integer value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustCodeIsNull() {
            addCriterion("cust_code is null");
            return (Criteria) this;
        }

        public Criteria andCustCodeIsNotNull() {
            addCriterion("cust_code is not null");
            return (Criteria) this;
        }

        public Criteria andCustCodeEqualTo(String value) {
            addCriterion("cust_code =", value, "custCode");
            return (Criteria) this;
        }

        public Criteria andCustCodeNotEqualTo(String value) {
            addCriterion("cust_code <>", value, "custCode");
            return (Criteria) this;
        }

        public Criteria andCustCodeGreaterThan(String value) {
            addCriterion("cust_code >", value, "custCode");
            return (Criteria) this;
        }

        public Criteria andCustCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cust_code >=", value, "custCode");
            return (Criteria) this;
        }

        public Criteria andCustCodeLessThan(String value) {
            addCriterion("cust_code <", value, "custCode");
            return (Criteria) this;
        }

        public Criteria andCustCodeLessThanOrEqualTo(String value) {
            addCriterion("cust_code <=", value, "custCode");
            return (Criteria) this;
        }

        public Criteria andCustCodeLike(String value) {
            addCriterion("cust_code like", value, "custCode");
            return (Criteria) this;
        }

        public Criteria andCustCodeNotLike(String value) {
            addCriterion("cust_code not like", value, "custCode");
            return (Criteria) this;
        }

        public Criteria andCustCodeIn(List<String> values) {
            addCriterion("cust_code in", values, "custCode");
            return (Criteria) this;
        }

        public Criteria andCustCodeNotIn(List<String> values) {
            addCriterion("cust_code not in", values, "custCode");
            return (Criteria) this;
        }

        public Criteria andCustCodeBetween(String value1, String value2) {
            addCriterion("cust_code between", value1, value2, "custCode");
            return (Criteria) this;
        }

        public Criteria andCustCodeNotBetween(String value1, String value2) {
            addCriterion("cust_code not between", value1, value2, "custCode");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("cust_name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("cust_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("cust_name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("cust_name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("cust_name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("cust_name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("cust_name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("cust_name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("cust_name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("cust_name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("cust_name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("cust_name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("cust_name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustTypeIsNull() {
            addCriterion("cust_type is null");
            return (Criteria) this;
        }

        public Criteria andCustTypeIsNotNull() {
            addCriterion("cust_type is not null");
            return (Criteria) this;
        }

        public Criteria andCustTypeEqualTo(Integer value) {
            addCriterion("cust_type =", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeNotEqualTo(Integer value) {
            addCriterion("cust_type <>", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeGreaterThan(Integer value) {
            addCriterion("cust_type >", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_type >=", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeLessThan(Integer value) {
            addCriterion("cust_type <", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeLessThanOrEqualTo(Integer value) {
            addCriterion("cust_type <=", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeIn(List<Integer> values) {
            addCriterion("cust_type in", values, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeNotIn(List<Integer> values) {
            addCriterion("cust_type not in", values, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeBetween(Integer value1, Integer value2) {
            addCriterion("cust_type between", value1, value2, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_type not between", value1, value2, "custType");
            return (Criteria) this;
        }

        public Criteria andCustFullNameIsNull() {
            addCriterion("cust_full_name is null");
            return (Criteria) this;
        }

        public Criteria andCustFullNameIsNotNull() {
            addCriterion("cust_full_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustFullNameEqualTo(String value) {
            addCriterion("cust_full_name =", value, "custFullName");
            return (Criteria) this;
        }

        public Criteria andCustFullNameNotEqualTo(String value) {
            addCriterion("cust_full_name <>", value, "custFullName");
            return (Criteria) this;
        }

        public Criteria andCustFullNameGreaterThan(String value) {
            addCriterion("cust_full_name >", value, "custFullName");
            return (Criteria) this;
        }

        public Criteria andCustFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_full_name >=", value, "custFullName");
            return (Criteria) this;
        }

        public Criteria andCustFullNameLessThan(String value) {
            addCriterion("cust_full_name <", value, "custFullName");
            return (Criteria) this;
        }

        public Criteria andCustFullNameLessThanOrEqualTo(String value) {
            addCriterion("cust_full_name <=", value, "custFullName");
            return (Criteria) this;
        }

        public Criteria andCustFullNameLike(String value) {
            addCriterion("cust_full_name like", value, "custFullName");
            return (Criteria) this;
        }

        public Criteria andCustFullNameNotLike(String value) {
            addCriterion("cust_full_name not like", value, "custFullName");
            return (Criteria) this;
        }

        public Criteria andCustFullNameIn(List<String> values) {
            addCriterion("cust_full_name in", values, "custFullName");
            return (Criteria) this;
        }

        public Criteria andCustFullNameNotIn(List<String> values) {
            addCriterion("cust_full_name not in", values, "custFullName");
            return (Criteria) this;
        }

        public Criteria andCustFullNameBetween(String value1, String value2) {
            addCriterion("cust_full_name between", value1, value2, "custFullName");
            return (Criteria) this;
        }

        public Criteria andCustFullNameNotBetween(String value1, String value2) {
            addCriterion("cust_full_name not between", value1, value2, "custFullName");
            return (Criteria) this;
        }

        public Criteria andCustParentIdIsNull() {
            addCriterion("cust_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andCustParentIdIsNotNull() {
            addCriterion("cust_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustParentIdEqualTo(Integer value) {
            addCriterion("cust_parent_id =", value, "custParentId");
            return (Criteria) this;
        }

        public Criteria andCustParentIdNotEqualTo(Integer value) {
            addCriterion("cust_parent_id <>", value, "custParentId");
            return (Criteria) this;
        }

        public Criteria andCustParentIdGreaterThan(Integer value) {
            addCriterion("cust_parent_id >", value, "custParentId");
            return (Criteria) this;
        }

        public Criteria andCustParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_parent_id >=", value, "custParentId");
            return (Criteria) this;
        }

        public Criteria andCustParentIdLessThan(Integer value) {
            addCriterion("cust_parent_id <", value, "custParentId");
            return (Criteria) this;
        }

        public Criteria andCustParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("cust_parent_id <=", value, "custParentId");
            return (Criteria) this;
        }

        public Criteria andCustParentIdIn(List<Integer> values) {
            addCriterion("cust_parent_id in", values, "custParentId");
            return (Criteria) this;
        }

        public Criteria andCustParentIdNotIn(List<Integer> values) {
            addCriterion("cust_parent_id not in", values, "custParentId");
            return (Criteria) this;
        }

        public Criteria andCustParentIdBetween(Integer value1, Integer value2) {
            addCriterion("cust_parent_id between", value1, value2, "custParentId");
            return (Criteria) this;
        }

        public Criteria andCustParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_parent_id not between", value1, value2, "custParentId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andCustNoteIsNull() {
            addCriterion("cust_note is null");
            return (Criteria) this;
        }

        public Criteria andCustNoteIsNotNull() {
            addCriterion("cust_note is not null");
            return (Criteria) this;
        }

        public Criteria andCustNoteEqualTo(String value) {
            addCriterion("cust_note =", value, "custNote");
            return (Criteria) this;
        }

        public Criteria andCustNoteNotEqualTo(String value) {
            addCriterion("cust_note <>", value, "custNote");
            return (Criteria) this;
        }

        public Criteria andCustNoteGreaterThan(String value) {
            addCriterion("cust_note >", value, "custNote");
            return (Criteria) this;
        }

        public Criteria andCustNoteGreaterThanOrEqualTo(String value) {
            addCriterion("cust_note >=", value, "custNote");
            return (Criteria) this;
        }

        public Criteria andCustNoteLessThan(String value) {
            addCriterion("cust_note <", value, "custNote");
            return (Criteria) this;
        }

        public Criteria andCustNoteLessThanOrEqualTo(String value) {
            addCriterion("cust_note <=", value, "custNote");
            return (Criteria) this;
        }

        public Criteria andCustNoteLike(String value) {
            addCriterion("cust_note like", value, "custNote");
            return (Criteria) this;
        }

        public Criteria andCustNoteNotLike(String value) {
            addCriterion("cust_note not like", value, "custNote");
            return (Criteria) this;
        }

        public Criteria andCustNoteIn(List<String> values) {
            addCriterion("cust_note in", values, "custNote");
            return (Criteria) this;
        }

        public Criteria andCustNoteNotIn(List<String> values) {
            addCriterion("cust_note not in", values, "custNote");
            return (Criteria) this;
        }

        public Criteria andCustNoteBetween(String value1, String value2) {
            addCriterion("cust_note between", value1, value2, "custNote");
            return (Criteria) this;
        }

        public Criteria andCustNoteNotBetween(String value1, String value2) {
            addCriterion("cust_note not between", value1, value2, "custNote");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNull() {
            addCriterion("cust_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNotNull() {
            addCriterion("cust_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneEqualTo(String value) {
            addCriterion("cust_phone =", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotEqualTo(String value) {
            addCriterion("cust_phone <>", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThan(String value) {
            addCriterion("cust_phone >", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("cust_phone >=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThan(String value) {
            addCriterion("cust_phone <", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThanOrEqualTo(String value) {
            addCriterion("cust_phone <=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLike(String value) {
            addCriterion("cust_phone like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotLike(String value) {
            addCriterion("cust_phone not like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIn(List<String> values) {
            addCriterion("cust_phone in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotIn(List<String> values) {
            addCriterion("cust_phone not in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneBetween(String value1, String value2) {
            addCriterion("cust_phone between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotBetween(String value1, String value2) {
            addCriterion("cust_phone not between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustTelIsNull() {
            addCriterion("cust_tel is null");
            return (Criteria) this;
        }

        public Criteria andCustTelIsNotNull() {
            addCriterion("cust_tel is not null");
            return (Criteria) this;
        }

        public Criteria andCustTelEqualTo(String value) {
            addCriterion("cust_tel =", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelNotEqualTo(String value) {
            addCriterion("cust_tel <>", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelGreaterThan(String value) {
            addCriterion("cust_tel >", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelGreaterThanOrEqualTo(String value) {
            addCriterion("cust_tel >=", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelLessThan(String value) {
            addCriterion("cust_tel <", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelLessThanOrEqualTo(String value) {
            addCriterion("cust_tel <=", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelLike(String value) {
            addCriterion("cust_tel like", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelNotLike(String value) {
            addCriterion("cust_tel not like", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelIn(List<String> values) {
            addCriterion("cust_tel in", values, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelNotIn(List<String> values) {
            addCriterion("cust_tel not in", values, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelBetween(String value1, String value2) {
            addCriterion("cust_tel between", value1, value2, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelNotBetween(String value1, String value2) {
            addCriterion("cust_tel not between", value1, value2, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustEmailIsNull() {
            addCriterion("cust_email is null");
            return (Criteria) this;
        }

        public Criteria andCustEmailIsNotNull() {
            addCriterion("cust_email is not null");
            return (Criteria) this;
        }

        public Criteria andCustEmailEqualTo(String value) {
            addCriterion("cust_email =", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotEqualTo(String value) {
            addCriterion("cust_email <>", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailGreaterThan(String value) {
            addCriterion("cust_email >", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailGreaterThanOrEqualTo(String value) {
            addCriterion("cust_email >=", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLessThan(String value) {
            addCriterion("cust_email <", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLessThanOrEqualTo(String value) {
            addCriterion("cust_email <=", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLike(String value) {
            addCriterion("cust_email like", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotLike(String value) {
            addCriterion("cust_email not like", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailIn(List<String> values) {
            addCriterion("cust_email in", values, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotIn(List<String> values) {
            addCriterion("cust_email not in", values, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailBetween(String value1, String value2) {
            addCriterion("cust_email between", value1, value2, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotBetween(String value1, String value2) {
            addCriterion("cust_email not between", value1, value2, "custEmail");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicIsNull() {
            addCriterion("business_license_pic is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicIsNotNull() {
            addCriterion("business_license_pic is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicEqualTo(String value) {
            addCriterion("business_license_pic =", value, "businessLicensePic");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicNotEqualTo(String value) {
            addCriterion("business_license_pic <>", value, "businessLicensePic");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicGreaterThan(String value) {
            addCriterion("business_license_pic >", value, "businessLicensePic");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_pic >=", value, "businessLicensePic");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicLessThan(String value) {
            addCriterion("business_license_pic <", value, "businessLicensePic");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicLessThanOrEqualTo(String value) {
            addCriterion("business_license_pic <=", value, "businessLicensePic");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicLike(String value) {
            addCriterion("business_license_pic like", value, "businessLicensePic");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicNotLike(String value) {
            addCriterion("business_license_pic not like", value, "businessLicensePic");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicIn(List<String> values) {
            addCriterion("business_license_pic in", values, "businessLicensePic");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicNotIn(List<String> values) {
            addCriterion("business_license_pic not in", values, "businessLicensePic");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicBetween(String value1, String value2) {
            addCriterion("business_license_pic between", value1, value2, "businessLicensePic");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePicNotBetween(String value1, String value2) {
            addCriterion("business_license_pic not between", value1, value2, "businessLicensePic");
            return (Criteria) this;
        }

        public Criteria andRegistAddressIsNull() {
            addCriterion("regist_address is null");
            return (Criteria) this;
        }

        public Criteria andRegistAddressIsNotNull() {
            addCriterion("regist_address is not null");
            return (Criteria) this;
        }

        public Criteria andRegistAddressEqualTo(String value) {
            addCriterion("regist_address =", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressNotEqualTo(String value) {
            addCriterion("regist_address <>", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressGreaterThan(String value) {
            addCriterion("regist_address >", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressGreaterThanOrEqualTo(String value) {
            addCriterion("regist_address >=", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressLessThan(String value) {
            addCriterion("regist_address <", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressLessThanOrEqualTo(String value) {
            addCriterion("regist_address <=", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressLike(String value) {
            addCriterion("regist_address like", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressNotLike(String value) {
            addCriterion("regist_address not like", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressIn(List<String> values) {
            addCriterion("regist_address in", values, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressNotIn(List<String> values) {
            addCriterion("regist_address not in", values, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressBetween(String value1, String value2) {
            addCriterion("regist_address between", value1, value2, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressNotBetween(String value1, String value2) {
            addCriterion("regist_address not between", value1, value2, "registAddress");
            return (Criteria) this;
        }

        public Criteria andEnterAttrIsNull() {
            addCriterion("enter_attr is null");
            return (Criteria) this;
        }

        public Criteria andEnterAttrIsNotNull() {
            addCriterion("enter_attr is not null");
            return (Criteria) this;
        }

        public Criteria andEnterAttrEqualTo(Integer value) {
            addCriterion("enter_attr =", value, "enterAttr");
            return (Criteria) this;
        }

        public Criteria andEnterAttrNotEqualTo(Integer value) {
            addCriterion("enter_attr <>", value, "enterAttr");
            return (Criteria) this;
        }

        public Criteria andEnterAttrGreaterThan(Integer value) {
            addCriterion("enter_attr >", value, "enterAttr");
            return (Criteria) this;
        }

        public Criteria andEnterAttrGreaterThanOrEqualTo(Integer value) {
            addCriterion("enter_attr >=", value, "enterAttr");
            return (Criteria) this;
        }

        public Criteria andEnterAttrLessThan(Integer value) {
            addCriterion("enter_attr <", value, "enterAttr");
            return (Criteria) this;
        }

        public Criteria andEnterAttrLessThanOrEqualTo(Integer value) {
            addCriterion("enter_attr <=", value, "enterAttr");
            return (Criteria) this;
        }

        public Criteria andEnterAttrIn(List<Integer> values) {
            addCriterion("enter_attr in", values, "enterAttr");
            return (Criteria) this;
        }

        public Criteria andEnterAttrNotIn(List<Integer> values) {
            addCriterion("enter_attr not in", values, "enterAttr");
            return (Criteria) this;
        }

        public Criteria andEnterAttrBetween(Integer value1, Integer value2) {
            addCriterion("enter_attr between", value1, value2, "enterAttr");
            return (Criteria) this;
        }

        public Criteria andEnterAttrNotBetween(Integer value1, Integer value2) {
            addCriterion("enter_attr not between", value1, value2, "enterAttr");
            return (Criteria) this;
        }

        public Criteria andEnterProdIsNull() {
            addCriterion("enter_prod is null");
            return (Criteria) this;
        }

        public Criteria andEnterProdIsNotNull() {
            addCriterion("enter_prod is not null");
            return (Criteria) this;
        }

        public Criteria andEnterProdEqualTo(String value) {
            addCriterion("enter_prod =", value, "enterProd");
            return (Criteria) this;
        }

        public Criteria andEnterProdNotEqualTo(String value) {
            addCriterion("enter_prod <>", value, "enterProd");
            return (Criteria) this;
        }

        public Criteria andEnterProdGreaterThan(String value) {
            addCriterion("enter_prod >", value, "enterProd");
            return (Criteria) this;
        }

        public Criteria andEnterProdGreaterThanOrEqualTo(String value) {
            addCriterion("enter_prod >=", value, "enterProd");
            return (Criteria) this;
        }

        public Criteria andEnterProdLessThan(String value) {
            addCriterion("enter_prod <", value, "enterProd");
            return (Criteria) this;
        }

        public Criteria andEnterProdLessThanOrEqualTo(String value) {
            addCriterion("enter_prod <=", value, "enterProd");
            return (Criteria) this;
        }

        public Criteria andEnterProdLike(String value) {
            addCriterion("enter_prod like", value, "enterProd");
            return (Criteria) this;
        }

        public Criteria andEnterProdNotLike(String value) {
            addCriterion("enter_prod not like", value, "enterProd");
            return (Criteria) this;
        }

        public Criteria andEnterProdIn(List<String> values) {
            addCriterion("enter_prod in", values, "enterProd");
            return (Criteria) this;
        }

        public Criteria andEnterProdNotIn(List<String> values) {
            addCriterion("enter_prod not in", values, "enterProd");
            return (Criteria) this;
        }

        public Criteria andEnterProdBetween(String value1, String value2) {
            addCriterion("enter_prod between", value1, value2, "enterProd");
            return (Criteria) this;
        }

        public Criteria andEnterProdNotBetween(String value1, String value2) {
            addCriterion("enter_prod not between", value1, value2, "enterProd");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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