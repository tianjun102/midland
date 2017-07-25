package com.huixin.web.model;

import java.util.ArrayList;
import java.util.List;

public class BannerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BannerExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBannerImg1IsNull() {
            addCriterion("banner_img1 is null");
            return (Criteria) this;
        }

        public Criteria andBannerImg1IsNotNull() {
            addCriterion("banner_img1 is not null");
            return (Criteria) this;
        }

        public Criteria andBannerImg1EqualTo(String value) {
            addCriterion("banner_img1 =", value, "bannerImg1");
            return (Criteria) this;
        }

        public Criteria andBannerImg1NotEqualTo(String value) {
            addCriterion("banner_img1 <>", value, "bannerImg1");
            return (Criteria) this;
        }

        public Criteria andBannerImg1GreaterThan(String value) {
            addCriterion("banner_img1 >", value, "bannerImg1");
            return (Criteria) this;
        }

        public Criteria andBannerImg1GreaterThanOrEqualTo(String value) {
            addCriterion("banner_img1 >=", value, "bannerImg1");
            return (Criteria) this;
        }

        public Criteria andBannerImg1LessThan(String value) {
            addCriterion("banner_img1 <", value, "bannerImg1");
            return (Criteria) this;
        }

        public Criteria andBannerImg1LessThanOrEqualTo(String value) {
            addCriterion("banner_img1 <=", value, "bannerImg1");
            return (Criteria) this;
        }

        public Criteria andBannerImg1Like(String value) {
            addCriterion("banner_img1 like", value, "bannerImg1");
            return (Criteria) this;
        }

        public Criteria andBannerImg1NotLike(String value) {
            addCriterion("banner_img1 not like", value, "bannerImg1");
            return (Criteria) this;
        }

        public Criteria andBannerImg1In(List<String> values) {
            addCriterion("banner_img1 in", values, "bannerImg1");
            return (Criteria) this;
        }

        public Criteria andBannerImg1NotIn(List<String> values) {
            addCriterion("banner_img1 not in", values, "bannerImg1");
            return (Criteria) this;
        }

        public Criteria andBannerImg1Between(String value1, String value2) {
            addCriterion("banner_img1 between", value1, value2, "bannerImg1");
            return (Criteria) this;
        }

        public Criteria andBannerImg1NotBetween(String value1, String value2) {
            addCriterion("banner_img1 not between", value1, value2, "bannerImg1");
            return (Criteria) this;
        }

        public Criteria andBannerImg2IsNull() {
            addCriterion("banner_img2 is null");
            return (Criteria) this;
        }

        public Criteria andBannerImg2IsNotNull() {
            addCriterion("banner_img2 is not null");
            return (Criteria) this;
        }

        public Criteria andBannerImg2EqualTo(String value) {
            addCriterion("banner_img2 =", value, "bannerImg2");
            return (Criteria) this;
        }

        public Criteria andBannerImg2NotEqualTo(String value) {
            addCriterion("banner_img2 <>", value, "bannerImg2");
            return (Criteria) this;
        }

        public Criteria andBannerImg2GreaterThan(String value) {
            addCriterion("banner_img2 >", value, "bannerImg2");
            return (Criteria) this;
        }

        public Criteria andBannerImg2GreaterThanOrEqualTo(String value) {
            addCriterion("banner_img2 >=", value, "bannerImg2");
            return (Criteria) this;
        }

        public Criteria andBannerImg2LessThan(String value) {
            addCriterion("banner_img2 <", value, "bannerImg2");
            return (Criteria) this;
        }

        public Criteria andBannerImg2LessThanOrEqualTo(String value) {
            addCriterion("banner_img2 <=", value, "bannerImg2");
            return (Criteria) this;
        }

        public Criteria andBannerImg2Like(String value) {
            addCriterion("banner_img2 like", value, "bannerImg2");
            return (Criteria) this;
        }

        public Criteria andBannerImg2NotLike(String value) {
            addCriterion("banner_img2 not like", value, "bannerImg2");
            return (Criteria) this;
        }

        public Criteria andBannerImg2In(List<String> values) {
            addCriterion("banner_img2 in", values, "bannerImg2");
            return (Criteria) this;
        }

        public Criteria andBannerImg2NotIn(List<String> values) {
            addCriterion("banner_img2 not in", values, "bannerImg2");
            return (Criteria) this;
        }

        public Criteria andBannerImg2Between(String value1, String value2) {
            addCriterion("banner_img2 between", value1, value2, "bannerImg2");
            return (Criteria) this;
        }

        public Criteria andBannerImg2NotBetween(String value1, String value2) {
            addCriterion("banner_img2 not between", value1, value2, "bannerImg2");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlIsNull() {
            addCriterion("banner_linkurl is null");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlIsNotNull() {
            addCriterion("banner_linkurl is not null");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlEqualTo(String value) {
            addCriterion("banner_linkurl =", value, "bannerLinkurl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlNotEqualTo(String value) {
            addCriterion("banner_linkurl <>", value, "bannerLinkurl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlGreaterThan(String value) {
            addCriterion("banner_linkurl >", value, "bannerLinkurl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlGreaterThanOrEqualTo(String value) {
            addCriterion("banner_linkurl >=", value, "bannerLinkurl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlLessThan(String value) {
            addCriterion("banner_linkurl <", value, "bannerLinkurl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlLessThanOrEqualTo(String value) {
            addCriterion("banner_linkurl <=", value, "bannerLinkurl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlLike(String value) {
            addCriterion("banner_linkurl like", value, "bannerLinkurl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlNotLike(String value) {
            addCriterion("banner_linkurl not like", value, "bannerLinkurl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlIn(List<String> values) {
            addCriterion("banner_linkurl in", values, "bannerLinkurl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlNotIn(List<String> values) {
            addCriterion("banner_linkurl not in", values, "bannerLinkurl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlBetween(String value1, String value2) {
            addCriterion("banner_linkurl between", value1, value2, "bannerLinkurl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkurlNotBetween(String value1, String value2) {
            addCriterion("banner_linkurl not between", value1, value2, "bannerLinkurl");
            return (Criteria) this;
        }

        public Criteria andImgDescIsNull() {
            addCriterion("img_desc is null");
            return (Criteria) this;
        }

        public Criteria andImgDescIsNotNull() {
            addCriterion("img_desc is not null");
            return (Criteria) this;
        }

        public Criteria andImgDescEqualTo(String value) {
            addCriterion("img_desc =", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescNotEqualTo(String value) {
            addCriterion("img_desc <>", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescGreaterThan(String value) {
            addCriterion("img_desc >", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescGreaterThanOrEqualTo(String value) {
            addCriterion("img_desc >=", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescLessThan(String value) {
            addCriterion("img_desc <", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescLessThanOrEqualTo(String value) {
            addCriterion("img_desc <=", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescLike(String value) {
            addCriterion("img_desc like", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescNotLike(String value) {
            addCriterion("img_desc not like", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescIn(List<String> values) {
            addCriterion("img_desc in", values, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescNotIn(List<String> values) {
            addCriterion("img_desc not in", values, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescBetween(String value1, String value2) {
            addCriterion("img_desc between", value1, value2, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescNotBetween(String value1, String value2) {
            addCriterion("img_desc not between", value1, value2, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andSortOrderIsNull() {
            addCriterion("sort_order is null");
            return (Criteria) this;
        }

        public Criteria andSortOrderIsNotNull() {
            addCriterion("sort_order is not null");
            return (Criteria) this;
        }

        public Criteria andSortOrderEqualTo(Byte value) {
            addCriterion("sort_order =", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotEqualTo(Byte value) {
            addCriterion("sort_order <>", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThan(Byte value) {
            addCriterion("sort_order >", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThanOrEqualTo(Byte value) {
            addCriterion("sort_order >=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThan(Byte value) {
            addCriterion("sort_order <", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThanOrEqualTo(Byte value) {
            addCriterion("sort_order <=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderIn(List<Byte> values) {
            addCriterion("sort_order in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotIn(List<Byte> values) {
            addCriterion("sort_order not in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderBetween(Byte value1, Byte value2) {
            addCriterion("sort_order between", value1, value2, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotBetween(Byte value1, Byte value2) {
            addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Boolean value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Boolean value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Boolean value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Boolean value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Boolean> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Boolean> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
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