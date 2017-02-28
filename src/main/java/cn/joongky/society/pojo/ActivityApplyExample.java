package cn.joongky.society.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityApplyExample() {
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(String value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(String value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(String value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(String value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(String value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(String value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLike(String value) {
            addCriterion("activity_id like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotLike(String value) {
            addCriterion("activity_id not like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<String> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<String> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(String value1, String value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(String value1, String value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdIsNull() {
            addCriterion("society_id is null");
            return (Criteria) this;
        }

        public Criteria andSocietyIdIsNotNull() {
            addCriterion("society_id is not null");
            return (Criteria) this;
        }

        public Criteria andSocietyIdEqualTo(String value) {
            addCriterion("society_id =", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdNotEqualTo(String value) {
            addCriterion("society_id <>", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdGreaterThan(String value) {
            addCriterion("society_id >", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdGreaterThanOrEqualTo(String value) {
            addCriterion("society_id >=", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdLessThan(String value) {
            addCriterion("society_id <", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdLessThanOrEqualTo(String value) {
            addCriterion("society_id <=", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdLike(String value) {
            addCriterion("society_id like", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdNotLike(String value) {
            addCriterion("society_id not like", value, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdIn(List<String> values) {
            addCriterion("society_id in", values, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdNotIn(List<String> values) {
            addCriterion("society_id not in", values, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdBetween(String value1, String value2) {
            addCriterion("society_id between", value1, value2, "societyId");
            return (Criteria) this;
        }

        public Criteria andSocietyIdNotBetween(String value1, String value2) {
            addCriterion("society_id not between", value1, value2, "societyId");
            return (Criteria) this;
        }

        public Criteria andThemeIsNull() {
            addCriterion("theme is null");
            return (Criteria) this;
        }

        public Criteria andThemeIsNotNull() {
            addCriterion("theme is not null");
            return (Criteria) this;
        }

        public Criteria andThemeEqualTo(String value) {
            addCriterion("theme =", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotEqualTo(String value) {
            addCriterion("theme <>", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThan(String value) {
            addCriterion("theme >", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThanOrEqualTo(String value) {
            addCriterion("theme >=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThan(String value) {
            addCriterion("theme <", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThanOrEqualTo(String value) {
            addCriterion("theme <=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLike(String value) {
            addCriterion("theme like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotLike(String value) {
            addCriterion("theme not like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeIn(List<String> values) {
            addCriterion("theme in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotIn(List<String> values) {
            addCriterion("theme not in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeBetween(String value1, String value2) {
            addCriterion("theme between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotBetween(String value1, String value2) {
            addCriterion("theme not between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceIsNull() {
            addCriterion("activity_place is null");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceIsNotNull() {
            addCriterion("activity_place is not null");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceEqualTo(String value) {
            addCriterion("activity_place =", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceNotEqualTo(String value) {
            addCriterion("activity_place <>", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceGreaterThan(String value) {
            addCriterion("activity_place >", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("activity_place >=", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceLessThan(String value) {
            addCriterion("activity_place <", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceLessThanOrEqualTo(String value) {
            addCriterion("activity_place <=", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceLike(String value) {
            addCriterion("activity_place like", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceNotLike(String value) {
            addCriterion("activity_place not like", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceIn(List<String> values) {
            addCriterion("activity_place in", values, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceNotIn(List<String> values) {
            addCriterion("activity_place not in", values, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceBetween(String value1, String value2) {
            addCriterion("activity_place between", value1, value2, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceNotBetween(String value1, String value2) {
            addCriterion("activity_place not between", value1, value2, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andHoldTimeIsNull() {
            addCriterion("hold_time is null");
            return (Criteria) this;
        }

        public Criteria andHoldTimeIsNotNull() {
            addCriterion("hold_time is not null");
            return (Criteria) this;
        }

        public Criteria andHoldTimeEqualTo(Date value) {
            addCriterion("hold_time =", value, "holdTime");
            return (Criteria) this;
        }

        public Criteria andHoldTimeNotEqualTo(Date value) {
            addCriterion("hold_time <>", value, "holdTime");
            return (Criteria) this;
        }

        public Criteria andHoldTimeGreaterThan(Date value) {
            addCriterion("hold_time >", value, "holdTime");
            return (Criteria) this;
        }

        public Criteria andHoldTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("hold_time >=", value, "holdTime");
            return (Criteria) this;
        }

        public Criteria andHoldTimeLessThan(Date value) {
            addCriterion("hold_time <", value, "holdTime");
            return (Criteria) this;
        }

        public Criteria andHoldTimeLessThanOrEqualTo(Date value) {
            addCriterion("hold_time <=", value, "holdTime");
            return (Criteria) this;
        }

        public Criteria andHoldTimeIn(List<Date> values) {
            addCriterion("hold_time in", values, "holdTime");
            return (Criteria) this;
        }

        public Criteria andHoldTimeNotIn(List<Date> values) {
            addCriterion("hold_time not in", values, "holdTime");
            return (Criteria) this;
        }

        public Criteria andHoldTimeBetween(Date value1, Date value2) {
            addCriterion("hold_time between", value1, value2, "holdTime");
            return (Criteria) this;
        }

        public Criteria andHoldTimeNotBetween(Date value1, Date value2) {
            addCriterion("hold_time not between", value1, value2, "holdTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("apply_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_time not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyerIdIsNull() {
            addCriterion("applyer_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyerIdIsNotNull() {
            addCriterion("applyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyerIdEqualTo(String value) {
            addCriterion("applyer_id =", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdNotEqualTo(String value) {
            addCriterion("applyer_id <>", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdGreaterThan(String value) {
            addCriterion("applyer_id >", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdGreaterThanOrEqualTo(String value) {
            addCriterion("applyer_id >=", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdLessThan(String value) {
            addCriterion("applyer_id <", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdLessThanOrEqualTo(String value) {
            addCriterion("applyer_id <=", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdLike(String value) {
            addCriterion("applyer_id like", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdNotLike(String value) {
            addCriterion("applyer_id not like", value, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdIn(List<String> values) {
            addCriterion("applyer_id in", values, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdNotIn(List<String> values) {
            addCriterion("applyer_id not in", values, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdBetween(String value1, String value2) {
            addCriterion("applyer_id between", value1, value2, "applyerId");
            return (Criteria) this;
        }

        public Criteria andApplyerIdNotBetween(String value1, String value2) {
            addCriterion("applyer_id not between", value1, value2, "applyerId");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeIsNull() {
            addCriterion("checked_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeIsNotNull() {
            addCriterion("checked_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeEqualTo(Date value) {
            addCriterion("checked_time =", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeNotEqualTo(Date value) {
            addCriterion("checked_time <>", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeGreaterThan(Date value) {
            addCriterion("checked_time >", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("checked_time >=", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeLessThan(Date value) {
            addCriterion("checked_time <", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeLessThanOrEqualTo(Date value) {
            addCriterion("checked_time <=", value, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeIn(List<Date> values) {
            addCriterion("checked_time in", values, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeNotIn(List<Date> values) {
            addCriterion("checked_time not in", values, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeBetween(Date value1, Date value2) {
            addCriterion("checked_time between", value1, value2, "checkedTime");
            return (Criteria) this;
        }

        public Criteria andCheckedTimeNotBetween(Date value1, Date value2) {
            addCriterion("checked_time not between", value1, value2, "checkedTime");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIsNull() {
            addCriterion("feedback_id is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIsNotNull() {
            addCriterion("feedback_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdEqualTo(String value) {
            addCriterion("feedback_id =", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotEqualTo(String value) {
            addCriterion("feedback_id <>", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThan(String value) {
            addCriterion("feedback_id >", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_id >=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThan(String value) {
            addCriterion("feedback_id <", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThanOrEqualTo(String value) {
            addCriterion("feedback_id <=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLike(String value) {
            addCriterion("feedback_id like", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotLike(String value) {
            addCriterion("feedback_id not like", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIn(List<String> values) {
            addCriterion("feedback_id in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotIn(List<String> values) {
            addCriterion("feedback_id not in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdBetween(String value1, String value2) {
            addCriterion("feedback_id between", value1, value2, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotBetween(String value1, String value2) {
            addCriterion("feedback_id not between", value1, value2, "feedbackId");
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