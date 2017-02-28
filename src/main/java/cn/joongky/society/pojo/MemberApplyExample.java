package cn.joongky.society.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberApplyExample() {
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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(String value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(String value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(String value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(String value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(String value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLike(String value) {
            addCriterion("apply_id like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotLike(String value) {
            addCriterion("apply_id not like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<String> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<String> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(String value1, String value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(String value1, String value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplerIdIsNull() {
            addCriterion("appler_id is null");
            return (Criteria) this;
        }

        public Criteria andApplerIdIsNotNull() {
            addCriterion("appler_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplerIdEqualTo(String value) {
            addCriterion("appler_id =", value, "applerId");
            return (Criteria) this;
        }

        public Criteria andApplerIdNotEqualTo(String value) {
            addCriterion("appler_id <>", value, "applerId");
            return (Criteria) this;
        }

        public Criteria andApplerIdGreaterThan(String value) {
            addCriterion("appler_id >", value, "applerId");
            return (Criteria) this;
        }

        public Criteria andApplerIdGreaterThanOrEqualTo(String value) {
            addCriterion("appler_id >=", value, "applerId");
            return (Criteria) this;
        }

        public Criteria andApplerIdLessThan(String value) {
            addCriterion("appler_id <", value, "applerId");
            return (Criteria) this;
        }

        public Criteria andApplerIdLessThanOrEqualTo(String value) {
            addCriterion("appler_id <=", value, "applerId");
            return (Criteria) this;
        }

        public Criteria andApplerIdLike(String value) {
            addCriterion("appler_id like", value, "applerId");
            return (Criteria) this;
        }

        public Criteria andApplerIdNotLike(String value) {
            addCriterion("appler_id not like", value, "applerId");
            return (Criteria) this;
        }

        public Criteria andApplerIdIn(List<String> values) {
            addCriterion("appler_id in", values, "applerId");
            return (Criteria) this;
        }

        public Criteria andApplerIdNotIn(List<String> values) {
            addCriterion("appler_id not in", values, "applerId");
            return (Criteria) this;
        }

        public Criteria andApplerIdBetween(String value1, String value2) {
            addCriterion("appler_id between", value1, value2, "applerId");
            return (Criteria) this;
        }

        public Criteria andApplerIdNotBetween(String value1, String value2) {
            addCriterion("appler_id not between", value1, value2, "applerId");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeIsNull() {
            addCriterion("applied_time is null");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeIsNotNull() {
            addCriterion("applied_time is not null");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeEqualTo(Date value) {
            addCriterion("applied_time =", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeNotEqualTo(Date value) {
            addCriterion("applied_time <>", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeGreaterThan(Date value) {
            addCriterion("applied_time >", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("applied_time >=", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeLessThan(Date value) {
            addCriterion("applied_time <", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeLessThanOrEqualTo(Date value) {
            addCriterion("applied_time <=", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeIn(List<Date> values) {
            addCriterion("applied_time in", values, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeNotIn(List<Date> values) {
            addCriterion("applied_time not in", values, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeBetween(Date value1, Date value2) {
            addCriterion("applied_time between", value1, value2, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeNotBetween(Date value1, Date value2) {
            addCriterion("applied_time not between", value1, value2, "appliedTime");
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